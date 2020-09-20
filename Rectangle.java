public class Rectangle extends Shape{
       
       /* Creates a rectangle  with the specified values
        * @param x the x coordinate of the rectangle
        * @param y the y coordinate of the rectangle
        * @param width the width of the rectangle
        * @param height the height of the rectangle
        */
       Rectangle(int x, int y, int base, int height){
              super(x, y, base, height);
       }
       
       /* Calculate the area of the rectangle
        * @return the area of the rectangle
        */
       public double area(){
              return (this.getW())*(this.getH());
       }
       
       /* Calculate the perimeter of the rectangle
        * @return the perimeter of the rectangle
        */
       public double perimeter(){
              return (this.getW()*2)+(this.getH()*2);
       }
}