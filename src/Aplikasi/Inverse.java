package Aplikasi;
import java.util.Scanner;
import Matrix.*;
public class Inverse {
    Scanner scan = new Scanner(System.in);
    public Inverse(){
        
    }
    
    public void invGJ(){
        int row,col;
        do{
            System.out.println("Masukkan ukuran baris untuk matriks: ");
            row = scan.nextInt();
            System.out.println("Masukkan ukuran kolom untuk matriks: ");
            col = scan.nextInt();
            if(row != col){
                System.out.println("Ukuruan matriks tidak sesuai. Harap masukkan ukuran yang tepat!");
            }
        } while (row != col);


        Matrix m = new Matrix(row, col);
        System.out.println("Masukkan inputan matriks: ");
        m.readMatrix();
        System.out.println("Inverse dari matriks tersebut adalah: ");
        Matrix nm = m.inverseGJ();
        nm.displayMatrix();
    }
    public void invKofDet(){
        int row,col;
        do{
            System.out.println("Masukkan ukuran baris untuk matriks: ");
            row = scan.nextInt();
            System.out.println("Masukkan ukuran kolom untuk matriks: ");
            col = scan.nextInt();
            if(row != col){
                System.out.println("Ukuruan matriks tidak sesuai. Harap masukkan ukuran yang tepat!");
            }
        } while (row != col);


        Matrix m = new Matrix(row, col);
        System.out.println("Masukkan inputan matriks: ");
        m.readMatrix();
        System.out.println("Inverse dari matriks tersebut adalah: ");
        Matrix nm = m.inverseDet();
        nm.displayMatrix();

    }
    
}
