# Retrospective

- name: Oliver Hill
- email: oliverhill@u.boisestate.edu

## Experience
This project was a great experience in using JavaScript to move an image dynamically with mouse clicks. Compared to previous projects, 
this one was more challenging due to the reduced guidance, but that made it more rewarding. It was exciting to apply the ZyBooks material into real code 
and get a better understanding of how JavaScript can be used for interactive web design.

One of the biggest challenges I faced was retrieving the image's current position. Initially, I attempted to use window.getComputedStyle(), 
but this caused my image to freeze or behave unpredictably. After some trial and error, I decided to trust my initial approach, and I’m happy with the final result.

Although the movement logic works as intended, I feel like the pixel-by-pixel animation could be smoother. 
That said, the functionality meets the project’s requirements, and I’m satisfied with the outcome.

## Known issues or Bugs
 - The movement could be smoother
 - There is a slight delay in stopping at the target because the image moves 1 pixel per interval
 - When clicking very close to the image’s current position, it may appear to shake briefly before stopping
 - There is no boundary safeguard to prevent the image from moving off of the screen

## Sources used

- Stack Overflow – Referenced a discussion on resolving issues with window.getComputedStyle() while trying to retrieve the image’s position. Although the suggested solution didn’t work as expected, I      experimented with different approaches before reverting to my original code.
- ZyBooks – Used as a reference for JavaScript syntax, variable handling, and event listeners, which helped in structuring the code effectively.
