import java.util.Scanner;
import java.lang.*;

public class Main {
   public static void main(String[] args){

       Scanner in = new Scanner(System.in);
       while(true){
           System.out.println("What do you want?\n1.Adding matrices;\n2.Multiplication matrix on K\n3.Multiplication matrices\n4.Transposition matrix\n5.Inverse matrix\n0.Exit");
           int num=in.nextInt();
           MatrixOperations manager=new MatrixOperations();
           switch(num) {
               case 1:{
                   System.out.println("Print the size of the matrices(rows and columns)\nFirst:");
                   int rowFirst=in.nextInt(),columnFirst=in.nextInt();
                   System.out.println("Second:");
                   int rowSecond=in.nextInt(),columnSecond=in.nextInt();
                   Matrix first= new Matrix(rowFirst,columnFirst);
                   Matrix second= new Matrix(rowSecond,columnSecond);

                   System.out.println("First matrix:");
                   manager.matrixView(first);
                   System.out.println("Second matrix:");
                   manager.matrixView(second);
                   System.out.println("Result matrices add:");
                   manager.matrixView(manager.addingMatrices(first,second));
                   break;
               }
               case 2:{
                   System.out.println("Print the size of the matrix(rows and columns) and factor:");
                   int rowFirst=in.nextInt(),columnFirst=in.nextInt(),factor=in.nextInt();
                   Matrix matrix= new Matrix(rowFirst,columnFirst);

                   System.out.println("Matrix:");
                   manager.matrixView(matrix);
                   System.out.println("Result multiplication on factor:");
                   manager.matrixView(manager.multiplicationByFactorMatrices(matrix,factor));
                   break;
               }
               case 3:{
                   System.out.println("Print the size of the matrices(rows and columns)\nFirst:");
                   int rowFirst=in.nextInt(),columnFirst=in.nextInt();
                   System.out.println("Second:");
                   int rowSecond=in.nextInt(),columnSecond=in.nextInt();
                   Matrix first= new Matrix(rowFirst,columnFirst);
                   Matrix second= new Matrix(rowSecond,columnSecond);

                   System.out.println("First matrix:");
                   manager.matrixView(first);
                   System.out.println("Second matrix:");
                   manager.matrixView(second);
                   System.out.println("Result matrices multiplication:");
                   manager.matrixView(manager.multiplicationMatrices(first,second));
                   break;
               }
               case 4:{
                   System.out.println("Print the size of the matrix(rows and columns):");
                   int rowFirst=in.nextInt(),columnFirst=in.nextInt();
                   Matrix matrix= new Matrix(rowFirst,columnFirst);

                   System.out.println("Matrix:");
                   manager.matrixView(matrix);
                   System.out.println("Result transposition matrix:");
                   manager.matrixView(manager.transpositionMatrix(matrix));
                   break;
               }
               case 5:{
                   System.out.println("Print the size of the matrix(rows and columns):");
                   int rowFirst=in.nextInt(),columnFirst=in.nextInt();
                   Matrix matrix= new Matrix(rowFirst,columnFirst);

                   System.out.println("Matrix:");
                   manager.matrixView(matrix);
                   System.out.println("Result inverse matrix:");
                   manager.matrixView(manager.inverseMatrix(matrix));
                   break;
               }
               case 0:
                   return;
               default:
                   System.out.println("Again");
                   break;
           }
       }
    }
}
