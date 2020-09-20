public class Triangle extends Shape{
       /* Creates a triangle with the specified values
        * @param x the x coordinate of the triangle
        * @param y the y coordinate of the triangle
        * @param base the width of the triangle
        * @param height the height of the triangle
        */
       Triangle(int x, int y, int base, int height){
              super(x, y, base, height);
       }
       
       /* Calculate the area of the triangle
        * @return the area of the triangle
        */
       public double area(){
              return (this.getW())*(this.getH())/2.0;
       }
       
       /* Calculate the perimeter of the triangle
        * @return the perimeter of the triangle
        */
       public double perimeter(){
              return this.getW() + (Math.sqrt(Math.pow(this.getW()/2.0,2)+Math.pow(this.getH(),2))*2.0);
       }
}