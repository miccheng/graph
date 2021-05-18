# Project Name
> Here goes your awesome project description!

# Requirement
* Command 		    Description
* "C w h"           Should create a new canvas of width w and height h.
* "L x1 y1 x2 y2"   Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.
* "R x1 y1 x2 y2"   Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.
* "B x y c"         Should fill the entire area connected to (x,y) with "colour" c. The behavior of this is the same as that of the "bucket fill" tool in paint programs.
* "Q"               Should quit the program.

## Table of contents
* [Assumptions](#Assumptions)
* [Design intention && Implementation](#Design intention)
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
* Wrong input from user, or Error in input args are already checked and handled by UI.


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
  
* Visitor design pattern
  With the introduction of abstract class, polymorphism can be leveraged. 
  However, code tends to be more like (X instanceof Y) when implemented. Soon I realise it's ugly. Therefore, I adopted visitor design pattern to get rid of the code listed below.
  
    >    private void mapShortcut2Command() {
    >        if (shortcut instanceof CShortcut) {
    >            this.command = new CanvasCommand(shortcut.getCoordinates());
    >        } else if (shortcut instanceof LShortcut) {
    >            this.command = new LineCommand(shortcut.getCoordinates());
    >        } else if (shortcut instanceof RShortcut) {
    >            this.command = new RectangleCommand(shortcut.getCoordinates());
    >        } else if (shortcut instanceof BShortcut) {
    >            this.command = new BucketFillCommand(shortcut.getCoordinates(), ((BShortcut) shortcut).getFillShape());
    >        } else if (shortcut instanceof QShortcut) {
    >            this.command = new QuitCommand();
    >        } else {
    >            System.out.println("Unknown operation: I'm confused.Don't know what to do...");
    >            return;
    >        }
    >    }

## Test
* Run 1 Test class once.
  
* Each test cases in ExtremeTest class is independent of each other as canvas is reset after every test is run.

* GraphDrawTestSuite is a complete use case of all draw shape actions. Test case builds on test case. Drawings are accumulated.
  The sequence of running is predefined. Hence, it is meant to be run as a whole.

## How to run
* Run GraphApplication class

