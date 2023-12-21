package MatrixLib;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public abstract class Matrix 
{
  //fields
  final double[][] elements;
  final int rows;
  final int columns;
  
  //constructors
  protected Matrix() 
  {
    this(2, 2);
  }
  protected Matrix(int rows, int columns) 
  {
    this.rows = rows;
    this.columns = columns;
    this. elements = IntStream.range(0, rows).mapToObj(x
                           -> new Random().doubles(-1000,1000).limit(columns).toArray()
                                          ).toArray(double[][]::new); 
    }

protected Matrix(double[][] input) {
        this.rows = input.length;
        this.columns = input[0].length;
        this.elements = IntStream.range(0,this.rows).parallel().mapToObj(x 
                        -> IntStream.range(0,this.columns).parallel().mapToDouble(y 
                            -> input[x][y] ).toArray()).toArray(double[][]::new);
       
    }
    public abstract Matrix add(Matrix input);
    public abstract Matrix subtract(Matrix input);
    public abstract Matrix dot (Matrix input);
    public abstract Matrix hadamard(Matrix input);
    public abstract Object clone();
    
  @Override
  public String toString()
  {
    /* 
     I'm just playing around with spacing to see if I can make the stream more readable :/        */
     return Arrays.stream(elements)
                        .map(
                              x -> Arrays
                                         .stream(x)
                                          .mapToObj(
                                                     i -> String.format(" % 8f", i)
                                                   )
                                          .reduce
                                                 (
                                                  "", (a,b)-> a + b
                                                 )
                          )
                        .reduce("", (a,b) -> a + b+'\n');

   
    }

    public static boolean equalDim(Matrix m1, Matrix m2) {
        return (m1.rows == m2.rows && m1.columns == m2.columns);
    }

    public static boolean notvalidfordot(Matrix m1, Matrix m2) {
        return (m1.columns == m2.rows);
    }
}