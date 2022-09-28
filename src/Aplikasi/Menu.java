package Aplikasi;

import java.util.Scanner;

public class Menu {
    public Menu(){}
    Scanner scan = new Scanner(System.in);
    
    public void list() {
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier\n2. Determinan\n3. Matriks balikan\n4. Interpolasi Polinom\n5. Interpolasi Bicubic\n6. Regresi linier berganda\n7. Keluar");
    }
    
    public void pilihan(int x){
        int y;
        switch(x) {
            case 1:
                SPL s = new SPL();
                System.out.println("METODE");
                System.out.println("1. Metode Eliminasi Gauss\n2. Metode Eliminasi Gauss-Jordan\n3. Metode Balikan\n4. Metode Cramer");
                y = scan.nextInt();
                switch(y) {
                    case 1:
                        s.spl1();
                        break;
                    case 2:
                        s.spl2();
                        break;
                    case 3:
                        s.spl3();
                        break;
                    case 4:
                        s.spl4();
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
                        d.kofdet();
                        break;
                    case 2:
                        d.gaussdet();
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
                        inv.invGJ();
                        break;
                    case 2:
                        inv.invKofDet();
                        break;
                }
                break;
            case 4:
                InterpolasiPolinom inpol = new InterpolasiPolinom();
                inpol.InpolPolinom();
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
}
