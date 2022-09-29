package Aplikasi;

import java.util.Scanner;

import Matrix.*;

public class SPL {
    Scanner scan = new Scanner(System.in);
    public SPL(){

    }

    public void spl1(){
        int row,col;
        int aug;
        System.out.println("Augmented? [0=No/1=Yes]");
        aug = scan.nextInt();
        Matrix Hasil = new Matrix(1,1);
        if (aug == 0) { 
            System.out.println("Sistem Matriks yang digunakan adalah Ax = B");
            System.out.println("Masukkan besar kolom matriks A:");
            col = scan.nextInt();
            System.out.println("Masukkan besar bariss matriks B:");
            row = scan.nextInt();
            int nc = col+1;
            Hasil.setSize(row, nc);
            Matrix A = new Matrix(row, col);
            Matrix B = new Matrix(row,1);
            System.out.println("Masukkan matriks A:");
            A.readMatrix();
            System.out.println("Masukkan matriks B:");
            B.readMatrix();
            System.out.println("==============================");


            for (int i = 0; i<row; i++) {
                for (int j = 0; j<col;j++) {
                    Hasil.setElmt(A.getElmt(i,j),i,j);
                }
            }
            for (int i = 0;i<row;i++) {
                Hasil.setElmt(B.getElmt(i, 0), i,Hasil.getCol()-1);
            }
        }
        else {
            System.out.println("Sistem Matriks yang digunakan adalah matriks augmented");
            System.out.println("Masukkan besar baris matriks:");
            row = scan.nextInt();
            System.out.println("Masukkan besar kolom matriks:");
            col = scan.nextInt();
            Hasil.setSize(row, col);
            System.out.println("Masukkan matriks augmented:");
            Hasil.readMatrix();
        }
        
        Hasil = Hasil.gauss();
        Hasil.displayMatrix();
        Hasil.hasilPara();

    }

    public void spl2(){
        int row,col;
        int aug;
        System.out.println("Augmented? [0=No/1=Yes]");
        aug = scan.nextInt();
        Matrix Hasil = new Matrix();

        if (aug == 0) {
            System.out.println("Sistem Matriks yang digunakan adalah Ax = B");
            System.out.println("Masukkan besar baris matriks A:");
            row = scan.nextInt();
            System.out.println("Masukkan besar kolom matriks B:");
            col = scan.nextInt();
            int nc = col+1;
            Hasil.setSize(row, nc);
            Matrix A = new Matrix(row, col);
            Matrix B = new Matrix(row,1);
            System.out.println("Masukkan matriks A:");
            A.readMatrix();
            System.out.println("Masukkan matriks B:");
            B.readMatrix();
            System.out.println("==============================");


            for (int i = 0; i<row; i++) {
                for (int j = 0; j<col;j++) {
                    Hasil.setElmt(A.getElmt(i,j),i,j);
                }
            }
            for (int i = 0;i<row;i++) {
                Hasil.setElmt(B.getElmt(i, 0), i, Hasil.getCol()-1);
            }
        }
        else {
            System.out.println("Sistem Matriks yang digunakan adalah matriks augmented");
            System.out.println("Masukkan besar baris matriks:");
            row = scan.nextInt();
            System.out.println("Masukkan besar kolom matriks:");
            col = scan.nextInt();
            Hasil.setSize(row, col);
            System.out.println("Masukkan matriks augmented:");
            Hasil.readMatrix();
        }
        
        Hasil = Hasil.gaussJordan();
        Hasil.displayMatrix();
        Hasil.hasilPara();
        }
        

    public void spl3(){
        int row,col;
        System.out.println("Sistem Matriks yang digunakan adalah Ax = B");
        System.out.println("Masukkan besar baris matriks A:");
        row = scan.nextInt();
        System.out.println("Masukkan besar kolom matriks B:");
        col = scan.nextInt();
        if (row == col){
        Matrix A = new Matrix(row, col);
        Matrix B = new Matrix(row,1);
        System.out.println("Masukkan matriks A:");
        A.readMatrix();
        System.out.println("Masukkan matriks B:");
        B.readMatrix();
        System.out.println("==============================");

        A.inversSPL(B);
        }
        else {
            System.out.println("Tidak dapat melakukan metode invers pada matriks yang tidak memiliki baris dan kolom yang sama");
        }
    }

    public void spl4(){
        int row,col;
        System.out.println("Sistem Matriks yang digunakan adalah Ax = B");
        System.out.println("Masukkan besar baris matriks A:");
        row = scan.nextInt();
        System.out.println("Masukkan besar kolom matriks B:");
        col = scan.nextInt();
        if (row == col) {
        Matrix A = new Matrix(row, col);
        Matrix B = new Matrix(row,1);
        System.out.println("Masukkan matriks A:");
        A.readMatrix();
        System.out.println("Masukkan matriks B:");
        B.readMatrix();
        System.out.println("==============================");

        Matrix Hasil = new Matrix(row,col+1);
        for (int i = 0; i<row; i++) {
            for (int j = 0; j<col;j++) {
                Hasil.setElmt(A.getElmt(i,j),i,j);
            }
        }
        for (int i = 0;i<row;i++) {
            Hasil.setElmt(B.getElmt(i, 0), i, col);
        }

        Hasil = Hasil.hascreamer();
        Hasil.displayMatrix();
        }
        else {
            System.out.println("Tidak dapat melakukan metode Cramer pada matriks yang tidak memiliki baris dan kolom yang sama");
        }
    }
}
