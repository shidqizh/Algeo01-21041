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
                System.out.println("Pilihan: ");
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
                                Matrix hasil = nm.gauss();
                                IO.outputFileMatrix(hasil,"output");
                                System.out.println("Hasil telah terbentuk dalam bentuk file output.txt");
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
                                IO.outputFileMatrix(hasil,"output");
                                System.out.println("Hasil telah terbentuk dalam bentuk file output.txt");
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
                                    for (int j = 0; j<C.getRow();j++) {
                                        A.setElmt(C.getElmt(i,j),i,j);
                                    }
                                }
                                for (int i = 0;i<C.getRow();i++) {
                                    B.setElmt(C.getElmt(i,C.getCol()-1), i, 0);
                                }
                                Matrix hasil = A.inversSPL(B);
                                IO.outputFileMatrix(hasil,"output");
                                System.out.println("Hasil telah terbentuk dalam bentuk file output.txt");
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
                                IO.outputFileMatrix(hasil,"output");
                                System.out.println("Hasil telah terbentuk dalam bentuk file output.txt");
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
                                IO.outputFileDouble(hasil,"output");
                                System.out.println("Hasil telah terbentuk dalam bentuk file output.txt");
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
                                IO.outputFileDouble(hasil,"output");
                                System.out.println("Hasil telah terbentuk dalam bentuk file output.txt");
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
                            Matrix hasil = nm.inverseGJ();
                            IO.outputFileMatrix(hasil, "output");
                            System.out.println("Hasil telah terbentuk dalam bentuk file output.txt");
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
                            IO.outputFileMatrix(hasil, "output");
                            System.out.println("Hasil telah terbentuk dalam bentuk file output.txt");
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
                inpol.InpolPolinom();
                break;
            case 5:
                InterpolasiBikubik bik = new InterpolasiBikubik();
                bik.InpolBikubik();
                break;
            case 6:
                break;
            default:
                System.out.println("\nMohon masukkan input yang sesuai!");
                break;
        }
    
    }
}
