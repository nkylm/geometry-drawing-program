public class Parallelogram extends Shape{
       private int tilt;
       
       /* Creates a parallelogram with the specified values
        * @param x the x coordinate of the parallelogram
        * @param y the y coordinate of the parallelogram
        * @param width the width of the parallelogram
        * @param height the height of the parallelogram
        * @param tilt the amount that the top side is shifted in the parallelogram
        */
       Parallelogram(int x, int y, int base, int height, int tilt){
              super(x,y,base,height);
              this.tilt = tilt;
       }
       
       /* Calculate the area of the parallelogram
        * @return the area of the parallelogram
        */
       public double area(){
              return (this.getW())*(this.getH());
       }
       
       /* Calculate the perimeter of the parallelogram
        * @return the perimeter of the parallelogram
        */
       public double perimeter(){
              return (this.getW()*2.0)+(Math.sqrt(Math.pow(this.tilt,2)+Math.pow(this.getH(),2))*2.0);
       }
       
       /* Retrieve the tilt value of the parallelogram
        * @return the tilt value of the parallelogram
        */
       public int getTilt(){
              return this.tilt;
       }
       
       /* Set the tilt value of the parallelogram
        * @param the tilt value of the parallelogram
        */
       public void setTilt(int tilt){
              this.tilt = tilt;
       }
}