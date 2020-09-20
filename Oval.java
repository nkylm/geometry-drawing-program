public class Oval extends Shape{       
       
       /* Creates an oval with the specified values
        * @param x the x coordinate of the oval
        * @param y the y coordinate of the oval
        * @param width the width of the oval
        * @param height the height of the oval
        */
       Oval(int x, int y, int width, int height){
              super(x, y, width, height);
       }
       
       /* Calculate the area of the oval
        * @return the area of the oval
        */
       public double area(){
              return (this.getW()/2.0)*(this.getH()/2.0)*(Math.PI);
       }
       
       /* Calculate the perimeter of the oval
        * @return the perimeter of the oval
        */
       public double perimeter(){
              return 2*Math.PI*Math.sqrt((Math.pow(this.getW()/2.0,2)+Math.pow(this.getH()/2.0,2))/2.0);
       }
}