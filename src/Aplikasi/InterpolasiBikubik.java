package Aplikasi;
import java.util.Scanner;
import Matrix.*;

public class InterpolasiBikubik {
    Scanner scan = new Scanner(System.in);
    public InterpolasiBikubik(){

    }

    public void InpolBikubik(){
        System.out.println("Masukkan matriks 4x4 : ");
        Matrix fxf = new Matrix(4,4);
        fxf.readMatrix();
        
        Matrix y = new Matrix(16,1);
        int i, j;
        int tmpidx = 0;
        for (i=0; i<4; i++){
            for (j=0; j<4; j++){
                y.setElmt(fxf.getElmt(i, j), tmpidx, 0);
                tmpidx += 1;
            }
        }
        //y.displayMatrix();
        
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
        //tmpX.displayMatrix();

        //hasil koefisien
        Matrix hasilIB = new Matrix(16,1);
        Matrix tmpInv = new Matrix(16, 16);
        tmpInv = tmpX.inverseGJ();
        hasilIB = tmpInv.multiplyMat(y);
        //hasilIB.displayMatrix();
        System.out.println("");
        //hitung aproksimasi nilai
        boolean cek = true;
        int jwb;
        while (cek) {
            System.out.print("Apakah ingin menghitung aproksimasi nilai? \n1. Ya \n2. Tidak \nJawaban : ");
            jwb = scan.nextInt();
            System.out.println("");
            if (jwb == 2) {
                cek = false;
            } else if (jwb == 1) {
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
            } else {
                System.out.println("Inputan salah! \n");
            }
        }
    }
}