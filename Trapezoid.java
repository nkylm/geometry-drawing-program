public class Trapezoid extends Shape{
       private int topW;
       private int bottomW;
       
       /* Creates a trapezoid with the specified values
        * @param x the x coordinate of the trapezoid
        * @param y the y coordinate of the trapezoid
        * @param bottomW the width of the bottom side of the trapezoid
        * @param topW the width of the top side of the trapezoid
        * @param height the height of the trapezoid
        */
       Trapezoid (int x, int y, int bottomW, int topW, int height){
              super (x, y, bottomW, height);
              this.bottomW = bottomW;
              this.topW = topW;
       }
       
       /* Calculate the area of the trapezoid
        * @return the area of the trapezoid
        */
       public double area(){
              return (this.getTopW()+this.getBottomW())/2.0 * this.getH();
       }
       
       /* Calculate the perimeter of the trapezoid
        * @return the perimeter of the trapezoid
        */
       public double perimeter(){
              return this.getTopW()+this.getBottomW()+this.getH()+(Math.sqrt(Math.pow(Math.abs(this.getTopW()-this.getBottomW()),2)+Math.pow(this.getH(),2)));
       }
       
       /* Retrieve the width of the top side of the trapezoid
        * @return the width of the top side of the trapezoid
        */
       public int getTopW(){
              return this.topW;
       }
       
       /* Set the width of the top side of the trapezoid
        * @param the width of the top side of the trapezoid
        */
       public void setTopW(int topW){
              this.topW = topW;
       }
       
       /* Retrieve the width of the bottom side of the trapezoid
        * @return the width of the bottom side of the trapezoid
        */
       public int getBottomW(){
              return this.bottomW;
       }
       
       /* Set the width of the bottom side of the trapezoid
        * @param the width of the bottom side of the trapezoid
        */
       public void setBottomW(int bottomW){
              this.bottomW = bottomW;
       }
}