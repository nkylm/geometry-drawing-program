abstract class Shape implements Comparable <Shape>{
       private int x;
       private int y;
       private int w;
       private int h;
       
       Shape (int x, int y, int width, int height){
              this.x = x;
              this.y = y;
              this.w = width;
              this.h = height;
       }
       
       public int compareTo(Shape s){
              return (int)(s.area() - this.area());
       }
       
       abstract double area();
       
       abstract double perimeter();
       
       public int getX(){
              return this.x;
       }
       
       public void setX(int x){
              this.x = x;
       }
       
       public int getY(){
              return this.y;
       }
       
       public void setY(int y){
              this.y = y;
       }
       
       public int getW(){
              return this.w;
       }
       
       public void setW(int w){
              this.w = w;
       }
       
       public int getH(){
              return this.h;
       }
       
       public void setH(int h){
              this.h = h;
       }
}