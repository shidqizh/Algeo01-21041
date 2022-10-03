package Aplikasi;


import java.util.Scanner;
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
                        System.out.print("1. Input File\n2. Input Keyboard\nPilihan: ");
                        z = scan.nextInt();
                        System.out.println("");
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
                        System.out.print("1. Input File\n2. Input Keyboard\nPilihan: ");
                        z = scan.nextInt();
                        System.out.println("");
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
                        System.out.print("1. Input File\n2. Input Keyboard\nPilihan: ");
                        z = scan.nextInt();
                        System.out.println("");
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
                System.out.print("1. Metode Kofaktor\n2. Metode Eliminasi Gauss-Jordan\nPilihan: ");
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
                        System.out.print("1. Input File\n2. Input Keyboard\nPilihan: ");
                        z = scan.nextInt();
                        System.out.println("");
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
                System.out.print("1. Metode Eliminasi Gauss-Jordan\n2. Metode Adjoin\nPilihan: ");
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
                    System.out.print("1. Input File\n2. Input Keyboard\nPilihan: ");
                    z = scan.nextInt();
                    System.out.println("");
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
                System.out.print("1. Input File\n2. Input Keyboard\nPilihan: ");
                z = scan.nextInt();
                System.out.println("");
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

                        IO.outputFileFungsiInpol(tmpH, row, namaf);

                        boolean cek = true;
                        int jwb;
                        while (cek){
                            System.out.print("Apakah ingin menghitung nilai taksiran pada fungsi tersebut? \n1. Ya \n2. Tidak \nJawaban : ");
                            jwb = scan.nextInt();
                            System.out.println("");
                            if (jwb == 2){
                                cek = false;
                            } else if (jwb == 1) {
                                System.out.print("Apakah ingin menggunakan file untuk taksiran?\n1.Ya\n2.Tidak\nPilihan: ");
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
                                else if(pil == 2){
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
                System.out.print("1. Input File\n2. Input Keyboard\nPilihan: ");
                z = scan.nextInt();
                System.out.println("");
                switch(z){
                    case 1:
                        System.out.println("Masukkan nama file data (dalam .txt):");
                        namaf = scan.next();
                        Matrix nm = IO.fileToMatrix(namaf);

                        Matrix mm = new Matrix(16,1);
                        int i, j;
                        int tmpidx = 0;
                        for (i=0; i<4; i++){
                            for (j=0; j<4; j++){
                                mm.setElmt(nm.getElmt(i, j), tmpidx, 0);
                                tmpidx += 1;
                            }
                        }
                        
                        Matrix tmpX = new Matrix(16, 16);
                        int k, l;
                        int r = 0;
                        for (i=-1; i<=2; i++){
                            for (j=-1; j<=2; j++){
                                int c = 0;
                                for (k=0; k<=3; k++){
                                    for (l=0; l<=3; l++){
                                        tmpX.setElmt((Math.pow(i, k)*(Math.pow(j, l))), r, c);
                                        c += 1;
                                    }
                                }
                                r += 1;
                            }
                        }

                        Matrix hasilIB = new Matrix(16,1);
                        Matrix tmpInv = new Matrix(16, 16);
                        tmpInv = tmpX.inverseGJ();
                        hasilIB = tmpInv.multiplyMat(mm);
                        
                        boolean cek = true;
                        int jwb;
                        while (cek) {
                            System.out.print("Apakah ingin menghitung aproksimasi nilai? \n1. Ya \n2. Tidak \nJawaban : ");
                            jwb = scan.nextInt();
                            System.out.println("");
                            if (jwb == 2) {
                                cek = false;
                            } else if (jwb == 1) {
                                System.out.print("Apakah ingin menggunakan data pada file? \n1.Ya\n2.Tidak\nPilihan: ");
                                int t = scan.nextInt();
                                if (t==2) {
                                double nx, ny;
                                System.out.print("Masukkan nilai x dan y = ");
                                nx = scan.nextDouble();
                                ny = scan.nextDouble();
                                double hasilTak = 0;
                                int tmpidx1 = 0;
                                for (i=0; i<=3; i++){
                                    for (j=0; j<=3; j++){
                                        hasilTak = hasilTak + (hasilIB.getElmt(tmpidx1, 0) * Math.pow(nx, i) * Math.pow(ny, j));
                                        tmpidx1 += 1;
                                    }
                                }
                                System.out.println("\nf(" + nx + "," + ny + ") = " + hasilTak + "\n");
                                }
                                else if (t==1) {
                                    double hasilTak = 0;
                                    int tmpidx1 = 0;
                                    for (i=0; i<=3; i++){
                                        for (j=0; j<=3; j++){
                                            hasilTak = hasilTak + (hasilIB.getElmt(tmpidx1, 0) * Math.pow(nm.getElmt(4, 0), i) * Math.pow(nm.getElmt(4, 1), j));
                                            tmpidx1 += 1;
                                        }
                                    }
                                    IO.outputFileTafsiranBikubik(nm, namaf, hasilTak );
                                    System.out.printf("Hasil telah terbentuk dalam bentuk file output_%s", namaf);
                                    System.out.println("\n");
                                }
                            } else {
                                System.out.println("Inputan salah! \n");
                            }
                        }

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
                RegresiLinearBerganda rlb = new RegresiLinearBerganda();
                System.out.println("INPUT");
                System.out.print("1. Input File\n2. Input Keyboard\nPilihan: ");
                z = scan.nextInt();
                System.out.println("");
                switch (z) {
                    case 1:
                    System.out.println("Masukkan nama file data (dalam .txt):");
                    namaf = scan.next();
                    Matrix tmpM = IO.fileToMatrix(namaf);
                    int row,col;
                    int i,j,k;
                    double tempC;
                    col = tmpM.getCol();
                    row = tmpM.getRow();
                    
                    Matrix tmpH = new Matrix(col, col+1);
            
                    for (i = 0; i<tmpH.getRow();i++){
                        for (j = 0; j<tmpH.getCol();j++){
                            tempC =0;
                            if (i==0) {
                                if (j == 0) {
                                    tempC = row;
                                }
                                else {
                                    for (k=0;k<row;k++) {
                                        
                                        tempC = tempC + tmpM.getElmt(k, j-1);
                                    }
                                }
                            }
                            else {
                                if (j!=0){
                                    for (k=0;k<row;k++) {
                                        tempC = tempC + tmpM.getElmt(k, i-1)*tmpM.getElmt(k, j-1);
                                    }
                                }
                                else {
                                    for (k=0;k<row;k++) {
                                        tempC = tempC + tmpM.getElmt(k, i-1);
                                    }
                                }
            
                            }
                            tmpH.setElmt(tempC, i, j);
                        }
                    }
            
                    
                    
                    Matrix hasil = new Matrix(tmpH.getRow(), tmpH.getCol());
                    hasil = tmpH.gaussJordan();
                    System.out.println("");
                    // display
            
                    for (i = 0; i<hasil.getRow();i++){
                        if (i==0) {
                            System.out.printf("y = (%.4f)", hasil.getElmt(i,hasil.getCol()-1), i);
                        }
                        else {
                            System.out.printf(" + (%.4f)x%d", hasil.getElmt(i,hasil.getCol()-1), i);
                        }
                    }
                    System.out.println("");
                    System.out.println("");
                    // tafsiran
                    int pil;
                    boolean cek=true;
                    while (cek) {
                        System.out.println("Apakah ingin menghitung nilai taksiran pada fungsi tersebut?\n1.Ya\n2.Tidak");
                        System.out.print("Pilihan : ");
                        pil = scan.nextInt(); 
                        System.out.println("");
                        switch (pil) {
                            case 1:
                                double tempH=hasil.getElmt(0, hasil.getCol()-1);
                                double in;
                                for (i=1;i<hasil.getRow();i++){
                                    System.out.printf("x%d = ",i);
                                    in = scan.nextDouble();
                                    tempH = tempH + in*hasil.getElmt(i, hasil.getCol()-1);
                                }
                                System.out.printf("y = %.4f", tempH);
                                System.out.println("");
                                break;
                            case 2:
                                cek = false;
                                break;
                            default:
                                System.out.println("Inputan salah!");
                                break;
                        }
                    }
                    break;
                    case 2:
                    rlb.regresi();
                    break;
                    default :
                    System.out.println("\nMohon masukkan input yang sesuai!");
                    break;
                }
                break;
            default:
                System.out.println("\nMohon masukkan input yang sesuai!");
                break;
        }   
    }
}