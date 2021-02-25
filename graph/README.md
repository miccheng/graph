# Project Name
> Here goes your awesome project description!

## Table of contents
* [Assumptions](#Assumptions)
* [Design intention && Implementation](#Design intention && Implementation)
* [Test](#Test)


## Assumptions:
* This is an APP. It consisted UI and server. 
    We assume the UI provides the function of mapping user input to a object. An like CShortcut(20, 4) is received as an input to our server here.
    e.g, "C 20 4" --> CShortcut(20, 4),
         "L 1 2 6 2" -->LShortcut(1, 2, 6, 2),
         "R 14 1 18 3" --> RShortcut(14, 1, 18, 3)
         "B 10 3 o" -->BShortcut(10, 3, o)

* Draw action is idempotent. A drawn area can't be drawn again.
* Line here can only be vertical or horizontal.
* Bucket fill is 4way.

## Design intention && Implementation:
* Command design pattern
   To turn a operation into a stand-alone object and method call.
   Invoker is the shortcut, receiver is the 2D array. Through command.execute(), 2D array got drawn with sketch.
   
   Thoughts: Opens up for more comprehensive requirements in future. eg, queuing operations, and reversible operations. 

* Bridge design pattern
    Extract dimensions of an object. 
    The sketch used to fill the 2D array is extracted as interface and implemented by multiple classes.
    In future, if besides a sketch, colour can be extracted just as the way sketch is and composition can be used for the assembling of objects.

* Singleton design pattern
   A complete use case would be: draw canvas,draw Rectangle/line, and then bucket fill.
   All the actions are done on 1 single canvas, hence canvas is singleton,initialized only once and shared across all the actions.

* Open/close principle
   Adoption of Interface and abstract class.
   The symbol to draw with ("x", "-","|", "o") can be extended and swapped in case of future change.
   So are the design of command classes.

* Separation of concern
    Shortcut interacts with UI, Command is where execution is executed. All the actions fall on 2D array.
  

## Test:
* GraphDrawTestSuite is a complete use case of all draw shape actions. Test builds on test.
   The sequence of running is predefined. Hence, it is meant to be run as a whole.

* Extreme class


## How to run
* Run GraphApplication class

