import MatrixLib.*;
import java.util.Arrays;
import java.util.Scanner;

class Main

{

public static Matrix dim1(){

Scanner in  = new Scanner(System.in);


System.out.print("Rows of Matrix A: ");
 int row1 = in.nextInt();
System.out.print("Columns of Matrix A: ");
 int col1 = in.nextInt();  

  Matrix A = MatrixFactory.getSequentialMatrix(row1,col1);

  return A;


    
  
}

public static Matrix dim2(){


Scanner in  = new Scanner(System.in);


System.out.print("Rows of Matrix B: ");
 int row2 = in.nextInt();
System.out.print("Columns of Matrix B: ");
 int col2 = in.nextInt();  

  Matrix B = MatrixFactory.getSequentialMatrix(row2,col2);

  return B;

 
}

public static void verifydim(Matrix A,Matrix B){

if(Matrix.equalDim(A, B)==false){

  System.out.println("Invalid Dimensions");
  dim1();
  dim2();
  verifydim(A, B);
  
}
  else{

    System.out.println("This is Matrix A:");
    System.out.print(A.toString());
    System.out.println("This is Matrix B:");
    System.out.println(B.toString());
    
  }


}

  public static void cloneCall(Matrix A,Matrix B){

    Scanner in = new Scanner(System.in);
            System.out.print("Choose the Matrix that you want to clone: ");
        int cl = in.nextInt();
        if(cl == 1){
        System.out.println("Clone of A:");
         System.out.print(A.clone());  
        }
        else if(cl ==2){
         System.out.println("Clone of B: ");
           System.out.print(B.clone());
       }
       else{
         System.out.println("Invalid Input");
         cloneCall(A,B);
       }



    
  }

  public static void toStringCall(Matrix A, Matrix B){

    Scanner in = new Scanner(System.in);
            System.out.print("Choose the Matrix that you want to print: ");
        int cl = in.nextInt();
        if(cl == 1){
        System.out.println("Printing of A:");
        System.out.println(A.toString());  
        }
        else if(cl ==2){
         System.out.println("Printing of B: ");
         System.out.println(B.toString()); 
       }
       else{
         System.out.println("Invalid Input");
         toStringCall(A, B);
       }


    
  }
public static void rerun(Matrix A,Matrix B){
  Scanner in = new Scanner(System.in);

System.out.println("Do you want to work on other Operations?: Y/N");
  String c = in.next();
  
 if(c.charAt(0)=='Y') {
   Operations(A,B);
   rerun(A,B);
 }
 else if(c.charAt(0)=='N');
 else{
   System.out.println("Invalid Input");
   rerun(A, B);
 } 

  
}




  // add, sub,dot,hadammard,clone,equals,toString

  public static  void Operations(Matrix A,Matrix B){

    Scanner in = new Scanner(System.in);
    System.out.println("Choose Operations:");
    System.out.println("1. Add");
    System.out.println("2. Subtract");
    System.out.println("3. Dot Product");
    System.out.println("4. Hadammard");
    System.out.println("5. Clone");
    System.out.println("6. Equal to");
    System.out.println("7. Print the Matrix");

    System.out.print("Enter your choice:");
     int choice = in.nextInt();

    switch(choice){

      case 1:
        System.out.println("Matrix A + Matrix B: ");
        System.out.print(A.add(B));
        break;
      case 2:
        System.out.println("Matrix A - Matrix B: ");
         System.out.print(A.subtract(B));
        break;
      case 3:
        System.out.println("Matrix A . Matrix B: ");
         System.out.print(A.dot(B));
        break;
      case 4:
        System.out.println("Matrix A hadammard Matrix B:");
         System.out.print(A.hadamard(B));
        break;
      case 5: 
        cloneCall(A,B);
        break;
      case 6:
        System.out.println("Matrix A == Matrix B:");
         System.out.println(A.equals(B));
        break;
      case 7:
        toStringCall(A, B);
      break; 
      default:
        System.out.println("Invalid Input");
        Operations(A, B);
        
        }
        
        
        




      
    }




    

    
  
  



  

  public static void main(String[] args) {
    System.out.print("Hello \n");

    Matrix A = dim1();
    Matrix B = dim2();
    
    verifydim(A, B);
    Operations(A, B);
    rerun(A,B);

    
   
    
    
    






    
  }
}