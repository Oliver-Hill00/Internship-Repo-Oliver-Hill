let timerId = null;

window.addEventListener("DOMContentLoaded", function () {
   document.addEventListener("click", startAnimation);
});

function startAnimation(e) {
   // Stop any previous animation if it's running
   if (timerId !== null) {
      clearInterval(timerId);
   }

   // Get the clicked position
   let clickPoint_x = e.clientX;
   let clickPoint_y = e.clientY;

   const img = document.querySelector("img");

   // Get image dimensions for centering
   let imgWidth = img.offsetWidth;
   let imgHeight = img.offsetHeight;

   // Set target position (centered on click)
   let targetX = clickPoint_x - imgWidth / 2;
   let targetY = clickPoint_y - imgHeight / 2;

   // Start a new animation timer
   timerId = setInterval(() => moveImage(targetX, targetY), 10);
}

function moveImage(targetX, targetY) {
   const img = document.querySelector("img");

   // Determine current position
   let imgX = parseInt(img.style.left);
   let imgY = parseInt(img.style.top);

   // Determine movement direction
   let movement_X = targetX > imgX ? 1 : targetX < imgX ? -1 : 0;
   let movement_Y = targetY > imgY ? 1 : targetY < imgY ? -1 : 0;

   // Move image by 1 pixel per step
   img.style.left = (imgX + movement_X) + "px";
   img.style.top = (imgY + movement_Y) + "px";

   // Stop animation when image reaches target
   if (imgX === targetX && imgY === targetY) {
      clearInterval(timerId);
      timerId = null;
   }
}