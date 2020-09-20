import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.lang.Exception;
import java.util.Arrays;
import java.util.Collections;

/* ICS4U1
 * Nicky Lam
 * 4/22/2020
 * A program where a user can draw different shapes onto a screen
 */

class GeometryDrawingProgram {
       static JFrame frame;
       static ArrayList<Shape> shapes = new ArrayList<Shape>();
       
       public static void main(String[] args) {  
              GeometryScreen gs = new GeometryScreen();
              Scanner input = new Scanner(System.in);
              
              int choice = 0;
              do {
                     //menu options: Add shape, Remove shape, Modify Shape, Translate Drawing, Save Drawing, Load Drawing, Quit.
                     System.out.println("1. Display all Shapes' Relevant Data");
                     System.out.println("2. Add Shape");
                     System.out.println("3. Remove Shape");
                     System.out.println("4. Modify Shape");
                     System.out.println("5. Translate Drawing");
                     System.out.println("6. Save drawing");
                     System.out.println("7. Load Drawing");
                     System.out.println("8. Quit");                        
                     choice = input.nextInt();
                     input.nextLine();
                     
                     // Display relevant data
                     if (choice == 1){
                            Collections.sort(shapes); 
                            for (Shape shape : shapes){
                                   System.out.println(shape.getClass().getSimpleName() + ": ");    //name of shape 
                                   System.out.println("     x: "+(shape.getX()-250) + "  y: "+(250-shape.getY()));       //x y values according to x and y axis
                                   System.out.println("     Area: "+Math.round(shape.area()*100)/100.0);                       
                                   System.out.println("     Perimeter: "+Math.round(shape.perimeter()*100)/100.0);
                            }     
                     
                     // Add shape
                     }else if (choice == 2){
                            try{
                                   System.out.println("Which shape would you like to add?");
                                   String selectedShape = input.nextLine();
                                   checkValid(selectedShape);
                                   
                                   System.out.println("Enter the x coordinate:");
                                   int x = input.nextInt();
                                   x = 250 + x;
                                   
                                   System.out.println("Enter the y coordinate:");
                                   int y = input.nextInt();          
                                   y = 250 - y;
                                   
                                   System.out.println("Enter the width: ");
                                   int w = input.nextInt();
                                   
                                   if (selectedShape.toLowerCase().equals("parallelogram")){
                                          System.out.println("Enter the height:");
                                          int h = input.nextInt();                            
                                          System.out.println("Enter the tilt:");
                                          int tilt = input.nextInt();
                                          shapes.add(new Parallelogram(x,y,w,h, tilt));
                                   }else if (selectedShape.toLowerCase().equals("rhombus")){
                                          System.out.println("Enter the tilt:");
                                          int tilt = input.nextInt();
                                          shapes.add(new Rhombus(x,y,w, tilt));
                                   }else if (selectedShape.toLowerCase().equals("rectangle")){
                                          System.out.println("Enter the height:");
                                          int h = input.nextInt();                            
                                          shapes.add(new Rectangle(x,y,w,h));
                                   }else if (selectedShape.toLowerCase().equals("square")){
                                          shapes.add(new Square(x,y,w));
                                   }else if (selectedShape.toLowerCase().equals("oval")){
                                          System.out.println("Enter the height:");
                                          int h = input.nextInt();                            
                                          shapes.add(new Oval(x,y,w,h));
                                   }else if (selectedShape.toLowerCase().equals("circle")){
                                          shapes.add(new Circle(x,y,w));
                                   }else if (selectedShape.toLowerCase().equals("trapezoid")){
                                          System.out.println("Enter the width of the top side:");
                                          int w2 = input.nextInt();                            
                                          System.out.println("Enter the height:");
                                          int h = input.nextInt();                            
                                          shapes.add(new Trapezoid(x,y,w,w2,h));
                                   }else if (selectedShape.toLowerCase().equals("triangle")){
                                          System.out.println("Enter the height:");
                                          int h = input.nextInt();                            
                                          shapes.add(new Triangle(x,y,w,h));
                                   }      
                            }catch(InvalidShapeException e){           //if user inputted an invalid shape 
                                   System.out.println("The shape '"+e.getName()+"' cannot be drawn.");
                                   e.printStackTrace();
                            }
                     // Remove shape
                     }else if (choice == 3){
                            if (shapes.size() > 0){            
                                   shapes.remove(shapes.size()-1);
                            }else{
                                   System.out.println("No shapes currently drawn.");
                            }
                     // Modify shape
                     }else if (choice == 4){
                            if (shapes.size() == 0){
                                   System.out.println("No shapes currently drawn.");
                            }else{
                                   System.out.println("Which shape would you like to modify? (Enter its index): ");
                                   int index = input.nextInt();
                                   input.nextLine();
                                   while ((index < 0)||(index > shapes.size()-1)){          //ask for another index if the user enters an index outside range
                                          System.out.println("That index is outside of the range. Enter another index: ");
                                          index = input.nextInt();
                                          input.nextLine();
                                   }
                                   System.out.println("Would you like to change its coordinates or dimensions?");
                                   String ans = input.nextLine();
                                   if (ans.toLowerCase().equals("coordinates")){
                                          System.out.println("Enter the new x-coordinate:");
                                          int newX = input.nextInt();
                                          input.nextLine();
                                          newX = 250 + newX;       // x values according to x axis
                                          System.out.println("Enter the new y-coordinate:");
                                          int newY = input.nextInt();
                                          input.nextLine();
                                          newY = 250 - newY;     //y values according to y axis
                                          shapes.get(index).setX(newX);
                                          shapes.get(index).setY(newY);
                                   }else if (ans.toLowerCase().equals("dimensions")){
                                          System.out.println("Enter the new width:");
                                          int newW = input.nextInt();
                                          input.nextLine();
                                          System.out.println("Enter the new height:");
                                          int newH = input.nextInt();
                                          input.nextLine();
                                          shapes.get(index).setW(newW);
                                          shapes.get(index).setH(newH);
                                   }else{
                                          System.out.println("Cannot modify that.");
                                   }
                            }
                     // Translate drawing
                     }else if (choice  == 5){
                            System.out.println("How many units to translate along x-axis?");
                            int xTranslation = input.nextInt();
                            System.out.println("How many units to translate along y-axis?");
                            int yTranslation = input.nextInt();
                            
                            for (Shape shape : shapes){
                                   shape.setX(shape.getX() + xTranslation);    
                                   shape.setY(shape.getY() - yTranslation);
                            }
                     // Save drawing
                     }else if (choice == 6){
                            try{
                                   PrintWriter output = new PrintWriter(new File("savedDrawing.txt"));
                                    
                                   for (Shape shape : shapes){             //first letter of each line indicates the type of shape
                                          if (shape instanceof Oval){  
                                                 if (shape instanceof Circle){
                                                        output.print("c ");
                                                 }else{
                                                        output.print("o ");
                                                 }
                                          }else if (shape instanceof Rectangle){
                                                 if (shape instanceof Square){
                                                        output.print("s ");
                                                 }else{
                                                        output.print("r ");
                                                 }
                                          }else if (shape instanceof Parallelogram){
                                                 if (shape instanceof Rhombus){
                                                        output.print("h ");
                                                 }else{
                                                        output.print("p ");
                                                 }
                                                 output.print(((Parallelogram)shape).getTilt() + " ");
                                          }else if (shape instanceof Trapezoid){
                                                 output.print("z ");
                                                 output.print(((Trapezoid)shape).getTopW() + " ");                                                 
                                          }else if (shape instanceof Triangle){
                                                 output.print("t ");
                                          }
                                          
                                          output.print(shape.getX() + " ");
                                          output.print(shape.getY() + " ");
                                          output.print(shape.getW() + " ");
                                          output.print(shape.getH() + "\n");
                                   }
                                   
                                   System.out.println("Drawing successfully saved to savedDrawing.txt");
                                   output.close();
                            }catch(Exception e){
                                   e.printStackTrace();
                            }
                     // Load drawing
                     }else if (choice == 7){
                            try{
                                   Scanner inputFile = new Scanner(new File("savedDrawing.txt"));
                                   shapes.clear();
                                   
                                   while (inputFile.hasNext()){
                                          String dataLine = inputFile.nextLine();
                                          String[] valuesString = dataLine.substring(2).split(" ");
                                          int[] valuesInt = new int[5];
                                          for (int i  = 0; i < valuesString.length; i++){       //convert all the values to integers
                                                 valuesInt[i] = Integer.parseInt(valuesString[i]);
                                          }
                                          if (dataLine.charAt(0) == 'o'){
                                                 shapes.add(new Oval(valuesInt[0], valuesInt[1], valuesInt[2], valuesInt[3]));
                                          }else if (dataLine.charAt(0) == 'c'){
                                                 shapes.add(new Circle(valuesInt[0], valuesInt[1], valuesInt[2]));
                                          }else if (dataLine.charAt(0) == 'r'){
                                                 shapes.add(new Rectangle(valuesInt[0], valuesInt[1], valuesInt[2], valuesInt[3]));
                                          }else if (dataLine.charAt(0) == 's'){
                                                 shapes.add(new Square(valuesInt[0], valuesInt[1], valuesInt[2]));
                                          }else if (dataLine.charAt(0) == 'p'){
                                                 shapes.add(new Parallelogram(valuesInt[1], valuesInt[2], valuesInt[3], valuesInt[4], valuesInt[0]));
                                          }else if (dataLine.charAt(0) == 'h'){
                                                 shapes.add(new Rhombus(valuesInt[1], valuesInt[2], valuesInt[3], valuesInt[0]));
                                          }else if (dataLine.charAt(0) == 'z'){
                                                 shapes.add(new Trapezoid(valuesInt[1], valuesInt[2], valuesInt[3], valuesInt[0], valuesInt[4]));
                                          }else if (dataLine.charAt(0) == 't'){
                                                 shapes.add(new Triangle(valuesInt[0], valuesInt[1], valuesInt[2], valuesInt[3]));
                                          }
                                   }
                            }catch(Exception e){
                                   e.printStackTrace();
                                   System.out.println("No drawing saved.");
                            }
                     }                     
                     frame.repaint();
              }while(choice != 8);
              
       }
       
       /* This method checks if the shape selected can be drawn. If it cannot, it throws an InvalidShapeException
       *@param name the name of the selected shape
       *@throws InvalidShapeException if the selected shape cannot be drawn
       */
       public static void checkValid (String name) throws InvalidShapeException{
              String[] shapeTypes = new String[]{"circle", "oval", "parallelogram","rectangle","rhombus","square","trapezoid","triangle"};
              if (!Arrays.asList(shapeTypes).contains(name.toLowerCase())){
                     throw new InvalidShapeException(name);
              }
       }
       public static class GeometryScreen {
              
              GeometryScreen() {
                     frame = new JFrame("Geometry Drawing Program 1.0");
                     
                     JPanel graphicsPanel = new GraphicsPanel();
                     
                     frame.getContentPane().add(graphicsPanel);
                     
                     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     frame.setSize(520,540);
                     frame.setUndecorated(false);  
                     frame.setVisible(true);                     
              } 

              public static class GraphicsPanel extends JPanel {
                     
                     public void paintComponent(Graphics g) {          
                            setDoubleBuffered(true);   
                            g.setColor(Color.BLACK);
                            //draw the X/Y Axis
                            g.drawLine(250, 0, 250, 500);
                            g.drawLine(0, 250, 500, 250);
                            
                            for (Shape shape : shapes){
                                   if (shape instanceof Oval){
                                          g.drawOval(shape.getX(), shape.getY(), shape.getW(), shape.getH());
                                   }else if (shape instanceof Rectangle){                                          
                                          g.drawRect(shape.getX(), shape.getY(), shape.getW(), shape.getH());
                                   }else if (shape instanceof Parallelogram){  
                                          if (shape instanceof Rhombus){
                                                 int height = (int)(Math.sqrt(Math.pow(shape.getW(),2) - Math.pow(((Rhombus)shape).getTilt(),2)));  //calculate necessary height for all sides to be equal
                                                 shape.setH(height);
                                          }
                                          g.drawPolygon(new int[]{shape.getX(), shape.getX()+shape.getW(), shape.getX()+shape.getW()+((Parallelogram)shape).getTilt(), shape.getX()+((Parallelogram)shape).getTilt()}, new int[]{shape.getY(), shape.getY(), shape.getY() - shape.getH(), shape.getY() - shape.getH()}, 4);
                                   }else if (shape instanceof Triangle){
                                          g.drawPolygon(new int[]{shape.getX(), shape.getX()+shape.getW(), shape.getX() + (shape.getW()/2)}, new int[]{shape.getY(), shape.getY(), shape.getY() - shape.getH()}, 3);
                                   }else if (shape instanceof Trapezoid){
                                          g.drawPolygon(new int[]{shape.getX(), shape.getX()+((Trapezoid)shape).getBottomW(), shape.getX() + ((Trapezoid)shape).getTopW(), shape.getX()}, new int[]{shape.getY(), shape.getY(), shape.getY()-shape.getH(), shape.getY() - shape.getH()}, 4);
                                   }
                            }                            
                     }
              }
       }
}