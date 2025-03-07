let timerId = null;
let moving = false;

window.addEventListener("DOMContentLoaded", function() {
   document.addEventListener("click", startAnimation);
});

function startAnimation(e)
{
   if(timerId == null)
   {
      clearInterval(timerId);
   }

    //clicked position
   let clickPoint_x = e.clientX;
   let clickPoint_y = e.clientY;
   
   const img = document.querySelector("img");

   let imgWidth = img.offsetWidth;
   let imgHeight = img.offsetHeight;

   let targetX = clickPoint_x - imgWidth / 2;
   let targetY = clickPoint_y - imgHeight / 2;

   //start new timer
   timerId = setInterval(() => moveImage(targetX, targetY), 10);

}

function moveImage(targetX, targetY)
{
   const img = document.querySelector("img");

   // Determine location of image
   let imgX = parseInt(img.style.left);
   let imgY = parseInt(img.style.top);

   //determine movement direction of image when activated
   let movement_X = targetX > imgX ? 1 : targetX < imgX ? -1 : 0;
   let movement_Y = targetY > imgY ? 1 : targetY < imgY ? -1 : 0;

   //move image by 1 pixel per call
   img.style.left - (imgX + movement_X) + "px";
   img.style.top = (imgY + movement_Y) + "px";


   if(imgX  === targetX && imgY === targetY)
   {
      //stop animation when image reaches designated position
      clearInterval(timerId);
      timerId = null;
   }


}