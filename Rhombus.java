public class Rhombus extends Parallelogram{
       /* Creates a rhombus with the specified values
        * @param x the x coordinate of the rhombus
        * @param y the y coordinate of the rhombus
        * @param base the width of the rhombus
        * @param tilt the amount that the top side is shifted in the rhombus
        */
       Rhombus (int x, int y, int base, int tilt){
              super(x, y, base, base, tilt);
       }
}