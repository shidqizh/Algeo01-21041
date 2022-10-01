package Aplikasi;


import java.util.Scanner;
import java.util.*;
import Matrix.Matrix;
import Utility.IO;

public class Menu {
    public Menu(){}
    Scanner scan = new Scanner(System.in);
    IO io = new IO();
    
    public void list() {
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier\n2. Determinan\n3. Matriks balikan\n4. Interpolasi Polinom\n5. Interpolasi Bicubic\n6. Regresi linier berganda\n7. Keluar");
    }
    
    public void pilihan(int x){
        int y;
        String namaf;
        int z;
        switch(x) {
            case 1:
                SPL s = new SPL();
                System.out.println("METODE");
                System.out.println("1. Metode Eliminasi Gauss\n2. Metode Eliminasi Gauss-Jordan\n3. Metode Balikan\n4. Metode Cramer");
                System.out.print("Pilihan: ");
                y = scan.nextInt();
                System.out.println("");
                switch(y) {
                    case 1:
                        System.out.println("INPUT");
                        System.out.print("1. Input File\n2. Input Keyboard\nPilihan: ");
                        z = scan.nextInt();
                        System.out.println("");
                        switch(z){
                            case 1:
                                System.out.println("Masukkan nama file (dalam .txt):");
                                namaf = scan.next();
                                Matrix nm = IO.fileToMatrix(namaf);
                                Matrix hasil = nm.gauss();
                                IO.outputFileMatrix(hasil,namaf);
                                System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                                System.out.println("\n");
                                break;
                            case 2:
                                s.spl1();
                                break;
                            default:
                                System.out.println("\nMohon masukkan input yang sesuai!");
                                break;
                        }
                        break;    
                    case 2:
                        System.out.println("INPUT");
                        System.out.println("1. Input File\n2. Input Keyboard");
                        z = scan.nextInt();
                        switch(z){
                            case 1:
                                System.out.println("Masukkan nama file (dalam .txt):");
                                namaf = scan.next();
                                Matrix nm = IO.fileToMatrix(namaf);
                                Matrix hasil = nm.gaussJordan();
                                IO.outputFileMatrix(hasil,namaf);
                                System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                                System.out.println("\n");
                                break;
                            case 2:
                                s.spl2();
                                break;
                            default:
                                System.out.println("\nMohon masukkan input yang sesuai!");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("INPUT");
                        System.out.println("1. Input File\n2. Input Keyboard");
                        z = scan.nextInt();
                        switch(z){
                            case 1:
                                System.out.println("Masukkan nama file (dalam .txt):");
                                namaf = scan.next();
                                Matrix C = IO.fileToMatrix(namaf);
                                Matrix A = new Matrix(C.getRow(),C.getCol()-1);
                                Matrix B = new Matrix(C.getRow(),1);
                                for (int i = 0; i<C.getRow(); i++) {
                                    for (int j = 0; j<C.getCol()-1;j++) {
                                        A.setElmt(C.getElmt(i,j),i,j);
                                    }
                                }
                                for (int i = 0;i<C.getRow();i++) {
                                    B.setElmt(C.getElmt(i,C.getCol()-1), i, 0);
                                }
                                Matrix hasil = new Matrix(C.getRow(), 1);
                                hasil = A.inversSPL(B);
                                IO.outputFileMatrix(hasil,namaf);
                                System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                                System.out.println("\n");
                                break; 
                            case 2:
                                s.spl3();
                                break;
                            default:
                                System.out.println("\nMohon masukkan input yang sesuai!");
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("INPUT");
                        System.out.println("1. Input File\n2. Input Keyboard");
                        z = scan.nextInt();
                        switch(z){
                            case 1:
                                System.out.println("Masukkan nama file (dalam .txt):");
                                namaf = scan.next();
                                Matrix nm = IO.fileToMatrix(namaf);
                                Matrix hasil = nm.hascreamer();
                                IO.outputFileMatrix(hasil,namaf);
                                System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                                System.out.println("\n");
                                break;
                            case 2:
                                s.spl4();
                                break;
                            default:
                                System.out.println("\nMohon masukkan input yang sesuai!");
                                break;
                        }
                        break;
                    default:
                        System.out.println("\nMohon masukkan input yang sesuai!");
                        break;
                }
                break;
            case 2:
                Determinan d = new Determinan();
                System.out.println("METODE");
                System.out.println("1. Metode Kofaktor\n2. Metode Eliminasi Gauss-Jordan");
                y = scan.nextInt();
                switch(y) {
                    case 1:
                        System.out.println("INPUT");
                        System.out.println("1. Input File\n2. Input Keyboard");
                        z = scan.nextInt();
                        switch(z){
                            case 1:
                                System.out.println("Masukkan nama file (dalam .txt):");
                                namaf = scan.next();
                                Matrix nm = IO.fileToMatrix(namaf);
                                double hasil = nm.determinant();
                                IO.outputFileDouble(hasil,namaf);
                                System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                                System.out.println("\n");
                                break;
                            case 2:
                                d.kofdet();
                                break;
                            default:
                                System.out.println("\nMohon masukkan input yang sesuai!");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("INPUT");
                        System.out.println("1. Input File\n2. Input Keyboard");
                        z = scan.nextInt();
                        switch(z){
                            case 1:
                                System.out.println("Masukkan nama file (dalam .txt):");
                                namaf = scan.next();
                                Matrix nm = IO.fileToMatrix(namaf);
                                double hasil = nm.detGauss();
                                IO.outputFileDouble(hasil,namaf);
                                System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                                System.out.println("\n");
                                break;
                            case 2:
                                d.gaussdet();
                                break;
                            default:
                                System.out.println("\nMohon masukkan input yang sesuai!");
                                break;
                        }
                        break;
                    default:
                        System.out.println("\nMohon masukkan input yang sesuai!");
                        break;
                
                }
                break;
            case 3:
                Inverse inv = new Inverse();
                System.out.println("METODE");
                System.out.println("1. Metode Eliminasi Gauss-Jordan\n2. Metode Adjoin");
                y = scan.nextInt();
                switch(y) {
                    case 1:
                    System.out.println("INPUT");
                    System.out.println("1. Input File\n2. Input Keyboard");
                    z = scan.nextInt();
                    switch(z){
                        case 1:
                            System.out.println("Masukkan nama file (dalam .txt):");
                            namaf = scan.next();
                            Matrix nm = IO.fileToMatrix(namaf);
                            Double det = nm.determinant();
                            if(det != 0){
                                Matrix hasil = nm.inverseGJ();
                                IO.outputFileMatrix(hasil, namaf);
                                System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                                System.out.println("\n");
                            }
                            else{
                                IO.outputFileString("Matriks tidak memiliki balikan", namaf);
                                System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                                System.out.println("\n");
                            }
                            
                            break;
                        case 2:
                            inv.invGJ();
                            break;
                        default:
                            System.out.println("\nMohon masukkan input yang sesuai!");
                            break;
                    }
                    break;
                    case 2:
                    System.out.println("INPUT");
                    System.out.println("1. Input File\n2. Input Keyboard");
                    z = scan.nextInt();
                    switch(z){
                        case 1:
                            System.out.println("Masukkan nama file (dalam .txt):");
                            namaf = scan.next();
                            Matrix nm = IO.fileToMatrix(namaf);
                            Matrix hasil = nm.inverseDet();
                            IO.outputFileMatrix(hasil, namaf);
                            System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                            System.out.println("\n");
                            break;
                        case 2:
                            inv.invKofDet();
                            break;
                        default:
                            System.out.println("\nMohon masukkan input yang sesuai!");
                            break;
                    }
                    default:
                        System.out.println("\nMohon masukkan input yang sesuai!");
                        break;
                
                }
                break;
            case 4:
                InterpolasiPolinom inpol = new InterpolasiPolinom();
                System.out.println("INPUT");
                System.out.println("1. Input File\n2. Input Keyboard");
                z = scan.nextInt();
                switch(z){
                    case 1:
                        System.out.println("Masukkan nama file data titik (dalam .txt):");
                        namaf = scan.next();
                        Matrix nm = IO.fileToMatrix(namaf);
                        int row = nm.getRow();

                        Matrix tmpM = new Matrix(row, row+1);
                        Matrix tmpH = new Matrix(row, row+1);
                
                        for (int i=0; i<row; i++){
                            for (int j=0; j<row; j++){
                                tmpM.setElmt(Math.pow(nm.getElmt(i,0),j), i, j);
                            }
                            tmpM.setElmt(nm.getElmt(i,1), i, row);
                        }
                        tmpH = tmpM.gaussJordan();

                        boolean cek = true;
                        int jwb;
                        while (cek){
                            System.out.print("Apakah ingin menghitung nilai taksiran pada fungsi tersebut? \n1. Ya \n2. Tidak \nJawaban : ");
                            jwb = scan.nextInt();
                            System.out.println("");
                            if (jwb == 2){
                                cek = false;
                            } else if (jwb == 1) {
                                System.out.println("Apakah ingin menggunakan file untuk tafsiran? [1=ya/0=tidak]");
                                int pil = scan.nextInt();
                                if(pil == 1){
                                    String namaf2 = scan.next();
                                    Matrix nm2 = IO.fileToMatrix(namaf2);
                                    Matrix hasil = new Matrix(nm2.getRow(),1);
                                    for (int i = 0; i<hasil.getRow();i++) {
                                        hasil.setElmt(inpol.nilaiTaksiran(tmpM.getRow(),tmpH,nm2.getElmt(i,0)),i,0);
                                    } 
                                    IO.outputFileTafsiranInpol(tmpH, nm2, namaf);
                                    System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                                    System.out.println("\n");
                                    }
                                else if(pil == 0){
                                    double fx, hasilT;
                                    System.out.print("Masukkan nilai x = ");
                                    fx = scan.nextDouble();
                                    hasilT = inpol.nilaiTaksiran(nm.getRow(), tmpH, fx);
                                    System.out.print("\nf(" + fx + ") = " + hasilT);
                                    System.out.println("\n");    
                                }
                                
                            } else {
                                System.out.println("Inputan salah! \n");
                            }
                        }
                        
                        break;
                    case 2:
                        inpol.InpolPolinom();
                        break;
                    default:
                        System.out.println("\nMohon masukkan input yang sesuai!");
                        break;
                }
                break;
            case 5:
                InterpolasiBikubik inbik = new InterpolasiBikubik();
                System.out.println("INPUT");
                System.out.println("1. Input File\n2. Input Keyboard");
                z = scan.nextInt();
                switch(z){
                    case 1:
                        System.out.println("Masukkan nama file data (dalam .txt):");
                        namaf = scan.next();
                        Matrix nm = IO.fileToMatrix(namaf);
                        int row = nm.getRow();

                        Matrix tmpM = new Matrix(row, row+1);
                        Matrix tmpH = new Matrix(row, row+1);
                
                        for (int i=0; i<row; i++){
                            for (int j=0; j<row; j++){
                                tmpM.setElmt(Math.pow(nm.getElmt(i,0),j), i, j);
                            }
                            tmpM.setElmt(nm.getElmt(i,1), i, row);
                        }
                        tmpH = tmpM.gaussJordan();
                        
                        Matrix hasil = new Matrix(nm.getRow(),1);
                        for (int i = 0; i<hasil.getRow();i++) {
                            hasil.setElmt(inbik.nilaiTaksiran(tmpM.getRow(),tmpH,nm.getElmt(i,0)),i,0);
                        } 
                        IO.outputFileTafsiranInpol(tmpH, nm, namaf);
                        System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                        System.out.println("\n");
                        break;
                    case 2:
                        inbik.InpolBikubik();
                        break;
                    default:
                        System.out.println("\nMohon masukkan input yang sesuai!");
                        break;
                }
                break;
            case 6:
                break;
            default:
                System.out.println("\nMohon masukkan input yang sesuai!");
                break;
        }
    
    }
}
