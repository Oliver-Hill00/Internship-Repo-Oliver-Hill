# Part 1 : To be done before you start your project

## Program Overview

1. In your own words, explain the purpose of this program in at most
   three sentences.  (What does it do? What input will it need? What
   output does it produce?)

  This project demostrates the ability to be able to make a social media based interface, where menu options displayed
  output different subcategories which help the user make a selection. I will use skills such as implementing different methods, encapsulation, and
  created classes with predetermined API that test the instances before the interface can be fully set up.

2. List each source file in the project and explain its purpose.  You
   don't have to use complete sentences.

  Post.java - represents a users' single post for the interface displayed
  TextBook.java - Manages a collection of posts that the user has provided, which also allows for adding, deleting, and retrieving older posts    TextBookDriver.java - Main driver class, responsible for implementing the overall console interface for user interaction
   

# Program Requirements

In your own words, identify the programming concepts/skills from
current and prior modules that must be applied to achieve this
project's requirements.


The skills needing to be shown in this project inlcude encapsulation, File I/O, error handling, JavaDoc commenting, 
and being able to recongize java API interface and design from the given predifined API for the test programs



# Concept References

Identify the slides (module and slide numbers) that introduce and
demonstrate each of the following concepts:

* Encapsulation - Module 6 Slides 28-30, Module 3 Slide 10
* Instance Variables - Module 6 Slides 14,15
* ArrayLists - Module 5 Slides 5-11
* Interfaces - Module 6 Slides 83-87
* Reading files - Module 5 Slides 48-50
* Writing files - Module 6 Slide 90
* Writing vs. appending to files - Module 6 Slides 89-93
* Purpose of constructor - Module 3 Slide 19
* Exception handling - Module 5 Slide 52
* Aggregation - Module 6 Slides 105-107
* Tokenizing Strings/Handling CSV data - Module 5 Slides 56,57

 




# Activity Connections

This project requires writing different classes for specific jobs in
the project and getting them all to interact correctly.  You will also
need to frequently read and write files.

Reflecting on the Task activity and ToDoList activities, answer the following questions:

* Why did you need getters and setters in your classes?  What access
  modifier should be used for instance variables?  What access
  modifier should be used for methods that other classes need to call?

  Getters and Setters are essential for controlled access to private instance variables, maintaining encapsulation. To support encapsulation,
  instance variables should use the private access modifier, whereas the public access modifier should be used to enable cross-class communication.

* What is the relationship between Task and ToDoList (using the class
  relationships defined in part 5 of module 6 slides)?

  In terms of class relationships, Task and ToDoList follow a composition relationship, where ToDoList has a collection of
  Task objects and is responsible for managing them. This gives structure so the ToDoList can add, remove, or find specific tasks.

* How did you find specific Tasks in the ToDoList?  How can you find
  specific Posts in the Textbook?

  I found specific tasks in the ToDoList by setting priorities on the tasks, and then noting if they had passed the task test given by the
  TaskMaster driver class when compliled in the end program.

* How were Interfaces used in the activities?  What is the purpose of
  the Interfaces provided in this project?

  In this project, PostInterface and TextBookInterface are essential methods for managing posts, interacting with files, and supporting testing and integration. Interfaces were
  used in the previous activities by making sure the structure stayed consistent and also made sure the classes were defined under the standard method design.

* In ToDoList, one constructor took a File object. How is this
  constructor similar to the TextBook constructor?  How can the file
  be used to populate the Textbook (think how it was used to populate
  the ToDoList)?

  The ToDoList constructor that accepted a File object likely read from the file to initialize the list of tasks. Similarly, the TextBook constructor reads from a file of post IDs to restore posts from previous sessions. This file helps the TextBook constructor recover the last known state

# Testing Plan

How will you test this program during development to ensure it meets
all requirements? How will you know your program has met all
requirements?

Test each class and its methods independently as I implement them to catch errors early. I will also make sure that TextBook and Post
pass its individual tests, and meet the requirements in order to compile the entire project as one passed unit in the end. After completing individual class testing, I will begin testing interactions between Post, TextBook, and the main driver class. I will do this by making sure the TextBook program can add, delete, and retrieve posts for the user, while also making sure that 
TextBookDriver correctly handles the required user input the program needs to successfully compile. In the end, after all tests have passed, I will check the final result and make sure the 
end component successfully compiles and runs with all given data the user has provided.

# Compile and Run Instructions

From the directory containing all source code (.java) files, what is the command-line command that compiles the program?

javac *.java

From the directory containing the compiled class (.class) files, what is the command-line command that runs the program?

java TextBookDriver

Provide any additional instructions the user needs beyond the run command to run the program.

Make sure an previously noted Post Files are found in the same directory as the TextBookDriver class is found in.
Enter a one word username when the prompt opens for the program.
User the given menu navigation system to choose between the given options, depending on what the user wants to accomplish.


# Part 2: To be done after your program is done

## Sources

List all outside sources you used to help you on this project.  You do
not need to list slides, the book, or other class assignments.

Stack Overflow - I used this site to cross reference any bugs I had, especially when I couldn't compile any of my java files using javac *.java, and when I reset my program I was able to 
compile class files and then run my testers for both Post and TextBook

## Reflection

1. Discuss one bug you encountered while programming.  How did you
   find the bug?  What process did you use to fix the bug?  What did
   you learn from this bug that might help you in the future?

I could not compile any of my code to open class files, which in turn wouldn't let me pass all 9 of my tests in the Post and TextBook tester files. I am not sure exactly what fixed it,
but I recieved help from a forum that told me to restart my program, make sure to attempt to use rm *.class, and when I compiled my code the second time, I was able to open class files.
This let me pass all 9 of the tests on both testers, and now I am confident I have passed the assingment and shown my ability to program effectively. There are parts I am sure I could work on and simplify, but as I am still learning, this is a great start to what could be used as a future GUI program.

2. What, if anything, are you going to do differently on the next
   assignment?  (Consider things like: What other sources did you
   need?  Did you spend too much time debugging that could have been
   avoided by planning? How early/late did you start the project too
   late? How often did you go to the Kount Learning Center to get
   help? What processes did you use that were useful that you intend
   to use in the future?)

I try ti stick to notes, as well as writing my program out in my notebook before debugging. Usually when I have a bug, I will write down the error code, and then cross reference it with either
any existing code I have, or stack overflow. I do not like to use AI websites to check, as they are not a reliable source of information, which could diverge myself from the goal I have. I like to
use other peoples opinions with their past code, and see why my bugs are happening. In this case I got lucky, but there are times I have just had to buckle down and try to figure it out. I spend a little too much time on this bug than I would have liked to, but I find this is a great learning lesson for future assingments.