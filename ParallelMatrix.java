package MatrixLib;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ParallelMatrix extends Matrix 
{

  public ParallelMatrix() 
  {
    super(2, 2);
  }

  public ParallelMatrix(int rows, int columns) 
  {
    super(rows, columns);
  }

  public ParallelMatrix(double[][] input) 
  {
    super(input);
  }
  
  @Override
  public Matrix add(Matrix input) 
  {
    return (Matrix) new ParallelMatrix
            (IntStream.range(0, this.rows).parallel().mapToObj(x 
            -> IntStream.range(0,this.columns).parallel().mapToDouble(y 
                -> this.elements[x][y] + input.elements[x][y]).toArray()).toArray(double[][]::new));
    }

  @Override
  public Matrix subtract(Matrix input) 
  {
    return (Matrix) new ParallelMatrix
            (IntStream.range(0, this.rows).parallel().mapToObj(x 
              -> IntStream.range(0, this.columns).parallel().mapToDouble(y 
                -> this.elements[x][y] - input.elements[x][y]).toArray()).toArray(double[][]::new));
  }
  
  @Override
  public Matrix dot(Matrix input) 
  {
    return (Matrix) new ParallelMatrix
            (IntStream.range(0, this.rows).parallel().mapToObj(i 
              -> IntStream.range(0, input.columns).parallel().mapToDouble(j 
                -> IntStream.range(0, this.columns).parallel().mapToDouble(k 
                  -> this.elements[i][k] * input.elements[k][j]).reduce(0, (a, b) 
                    -> a + b)).toArray()).toArray(double[][]::new));
  }
  
  @Override
  public Matrix hadamard(Matrix input) 
  {
    return (Matrix) new ParallelMatrix
            (IntStream.range(0, this.rows).parallel().mapToObj(x 
              -> IntStream.range(0, this.columns).parallel().mapToDouble(y 
                -> this.elements[x][y] * input.elements[x][y]).toArray()).toArray(double[][]::new));
  }
  
  @Override
  public Object clone() 
  {
    return (Object) new ParallelMatrix(super.elements);
  }
  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof Matrix)
    {
      Matrix m = (Matrix) obj;
      if (m.rows == this.rows && this.columns == m.columns)
        return IntStream.range(0, this.rows).parallel().mapToObj(i 
              -> IntStream.range(0, this.columns).parallel().mapToObj(j
                -> this.elements[i][j] == m.elements[i][j]).reduce(true, (a,b) -> a&&b)).reduce(true, (a,b) -> a && b);
       return false; 
    }

      return false;
  }
  
  @Override
  public String toString()
  {
    return Arrays.stream(elements).map(x 
                -> Arrays.stream(x).parallel().mapToObj(i 
                    -> String.format(" % 8f", i)).reduce("", (a,b)
                                        -> a + b)).reduce("", (a,b) 
                                                       -> a + b+"\n");
  }
}
