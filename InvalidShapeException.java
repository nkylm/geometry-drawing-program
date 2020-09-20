public class InvalidShapeException extends Exception{
       
       private String name;
       
       /* Create an InvalidShapeException
        * @param s the name of the shape
        */
       InvalidShapeException(String s){
              this.name = s;
       }
       
       /*Retrieve the name of the invalid shape
        * @return the name of the invalid shape
        */
       public String getName(){
              return this.name;
       }
}