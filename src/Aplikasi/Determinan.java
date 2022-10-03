package Aplikasi;
import java.util.Scanner;
import Matrix.*;

public class Determinan{
    Scanner scan = new Scanner(System.in);
    public Determinan(){
        
    }
    
    public void kofdet(){
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
        System.out.println("Hasil dari determinan matriks tersebut adalah: ");
        double hasil = m.determinant();
        System.out.println(hasil);
    }
    public void gaussdet(){
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
        System.out.println("Hasil dari determinan matriks tersebut adalah: ");
        double hasil = m.detGauss();
        System.out.println(hasil);
    }
}