Assumptions:
 1. This is an APP. It consisted UI and server. 
    We assume the UI provides the function of mapping user input to a object. An like CShortcut(20, 4) is received as an input to our server here.
    e.g, "C 20 4" --> CShortcut(20, 4),
         "L 1 2 6 2" -->LShortcut(1, 2, 6, 2),
         "R 14 1 18 3" --> RShortcut(14, 1, 18, 3)
         "B 10 3 o" -->BShortcut(10, 3, o)
    
2. Draw action is idempotent. A drawn area can't be drawn again.
3. Line here can only be vertical or horizontal.
 
  
Design intention && Implementation:
1. Command design pattern
   To turn a operation into a stand-alone object and method call.
   Invoker is the shortcut, receiver is the 2D array. Through command.execute(), 2D array got drawn with sketch.
   
   Thoughts: Opens up for more comprehensive requirements in future. eg, queuing operations, and reversible operations. 

2. Bridge design pattern
    Extract dimensions of an object. 
    The sketch used to fill the 2D array is extracted as interface and implemented by multiple classes.
    In future, if besides a sketch, colour can be extracted just as the way sketch is and composition can be used for the assembling of objects.

3. Singleton design pattern
   A complete use case would be: draw canvas,draw Rectangle/line, and then bucket fill.
   All the actions are done on 1 single canvas, hence canvas is singleton,initialized only once and shared across all the actions.

4. Open/close principle
   Adoption of Interface and abstract class.
   The symbol to draw with ("x", "-","|", "o") can be extended and swapped in case of future change.
   So are the design of command classes.
   
5. Separation of concern
    Shortcut interacts with UI, Command is where execution is executed. All the actions fall on 2D array.
    

Test:
1. GraphDrawTestSuite is a complete use case of all draw shape actions.
   The sequence of running is predefined. Hence, it is meant to be run as a whole.
   
2. Extreme class
    
   


