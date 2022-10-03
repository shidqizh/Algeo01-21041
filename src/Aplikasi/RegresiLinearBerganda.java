package Aplikasi;

import java.util.Scanner;

import Matrix.Matrix;

public class RegresiLinearBerganda {
    public RegresiLinearBerganda(){}

    public void regresi(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Matriks yang digunakan adalah matriks augmented");
        int row,col;
        int i,j,k;
        double temp;
        double tempC;

        System.out.print("Masukkan banyaknya titik yang digunakan: ");
        col = scan.nextInt();

        System.out.print("Masukkan banyaknya data yang digunakan: ");
        row = scan.nextInt();

        Matrix tmpM = new Matrix(row,col+1);
        System.out.println("Masukkan data yang digunakan");

        for (i = 0;i<tmpM.getRow(); i++){
            System.out.printf("Data ke-%d\n",i+1);
            for (j=0;j<tmpM.getCol();j++) {
                if (j == tmpM.getCol()-1) {
                    System.out.printf("y = ");
                }
                else{
                    System.out.printf("x%d = ",j+1);
                }
                temp = scan.nextDouble();
                tmpM.setElmt(temp, i, j);
            }
        }
        
        Matrix tmpH = new Matrix(col, col+1);

        for (i = 0; i<tmpH.getRow();i++){
            for (j = 0; j<tmpH.getCol()-1;j++){
                tempC =0;
                if (i==0 && j==0) {
                    tempC = row;
                }
                else {
                    for (k=0;k<row;k++) {
                        tempC = tempC + tmpM.getElmt(k, i)*tmpM.getElmt(k, j);
                    }
                }
                tmpH.setElmt(tempC, i, j);
            }
        }
        
        Matrix hasil = new Matrix(tmpH.getRow(), tmpH.getCol());
        hasil = tmpH.gaussJordan();

        // display

        for (i = 0; i<hasil.getRow();i++){
            if (i==0) {
                System.out.printf("y = (%.4f)x%d", hasil.getElmt(i,hasil.getCol()-1), i+1);
            }
            else {
                System.out.printf(" + (%.4f)x%d", hasil.getElmt(i,hasil.getCol()-1), i+1);
            }
        }

        // tafsiran
        int pil;
        boolean cek=true;
        while (cek) {
            System.out.println("Apakah ingin menghitung tafsiran nilai pada fungsi tersebut?\n1.Ya\n2.Tidak");
            System.out.print("Pilahan : ");
            pil = scan.nextInt(); 
            System.out.println("");
            switch (pil) {
                case 1:
                    double tempH=hasil.getElmt(0, hasil.getCol());
                    double in;
                    for (i=1;i<row;i++){
                        System.out.printf("x%d = ",i);
                        in = scan.nextDouble();
                        tempH = tempH + in*hasil.getElmt(i, hasil.getCol());
                    }
                    System.out.printf("y = %.4f", tempH);
                case 2:
                    cek = false;
                    break;
                default:
                    System.out.println("Inputan salah!");
                    break;
            }
        }

    }

}
