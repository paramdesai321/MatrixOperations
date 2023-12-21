package MatrixLib;

public class MatrixFactory {
    public static Matrix getParallelMatrix()
    {
        return (Matrix) new ParallelMatrix();
    }
    public static Matrix getParallelMatrix(int row, int col)
    {
        return (Matrix) new ParallelMatrix(row, col);
    }

    public static Matrix getParallelMatrix(double[][] input)
    {
        return (Matrix) new ParallelMatrix(input);
    }


  public static Matrix getSequentialMatrix(int row, int col){


      return (Matrix) new SequentialMatrix(row,col);
    
  }

    public static Matrix getSequentialMatrix(double [][] input){


      return (Matrix) new SequentialMatrix(input);

      
  }

  public static Matrix getSeqeuntialMatrix(){


    return (Matrix) new SequentialMatrix();
  }
 
}