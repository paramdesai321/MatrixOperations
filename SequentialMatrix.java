package MatrixLib;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SequentialMatrix extends Matrix {

  public SequentialMatrix() {
    super(2, 2);
  }

  public SequentialMatrix(int rows, int columns) {
    super(rows, columns);
  }

  public SequentialMatrix(double[][] input) {
    super(input);
  }

  @Override
  public Matrix add(Matrix input) {
    double[][] result = new double[super.rows][super.columns];
    for (int i = 0; i < super.rows; i += 1)
      for (int j = 0; j < super.columns; j += 1) {
        result[i][j] = this.elements[i][j] + input.elements[i][j];
      }

    
    return new SequentialMatrix(result);
  
  }

  @Override
  public Matrix subtract(Matrix input) {
    double[][] result = new double[super.rows][super.columns];
    for (int i = 0; i < super.rows; i += 1)
      for (int j = 0; j < super.columns; j += 1) {
        result[i][j] = this.elements[i][j] - input.elements[i][j];
      }

    return new SequentialMatrix(result);
  }

  @Override
  public Matrix dot(Matrix input) {
    if (super.columns != input.rows)
      return null;
    

    double result[][] = new double[super.rows][super.columns];
    for (int i = 0; i < super.rows; i += 1)
      for (int j = 0; j < input.columns; j += 1) {

        for (int k = 0; k < super.columns; k++) {

          result[i][j] += this.elements[i][k] * input.elements[k][j];

        }

      }

    return new SequentialMatrix(result);
  }

  @Override
  public Matrix hadamard(Matrix input) {

    double result[][] = new double[super.rows][super.columns];

    for (int i = 0; i < super.rows; i++)
      for (int j = 0; j < super.columns; j++) {

        result[i][j] = this.elements[i][j] * input.elements[i][j];

      }

    return new SequentialMatrix(result);

  }

  @Override
  public Object clone() {
    return (Object) new SequentialMatrix(super.elements);
  }

  @Override
  public boolean equals(Object obj) {
    boolean result = true;
    if (obj instanceof Matrix) {
      Matrix m = (Matrix) obj;

      if (result == true) {
        for (int i = 0; i < super.rows; i += 1)
          for (int j = 0; j < super.columns; j++) {

            result = (m.elements[i][j] == this.elements[i][j]);

          }

      }

    }

    return result;
  }

  @Override
  public String toString() {
    String result = " ";
    for(int i=0; i<super.rows;i++){

    for(int j=0;j<super.columns;j++){

      result += Double.toString(this.elements[i][j]) + " ";
    }

    result += "\n";

      
    }



return result;
    
  }

   

}

