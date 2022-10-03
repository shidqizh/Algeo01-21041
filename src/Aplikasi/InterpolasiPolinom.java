package Aplikasi;
import java.util.Scanner;
//import javax.swing.event.SwingPropertyChangeSupport;
import Matrix.*;

public class InterpolasiPolinom {
    Scanner scan = new Scanner(System.in);
    public InterpolasiPolinom(){

    }
    
    public double cekOutput(double x){
        double tmp = x;
        if (tmp < 0) {
            tmp = (-1)*x;
        }
        return tmp;
    }

    public double nilaiTaksiran(int n, Matrix rix, double x){
        double hasil = 0;
        int i;
        for (i=0; i<n; i++){
            hasil = hasil + (rix.getElmt(i, n) * Math.pow(x, i));
        }
        return hasil;
    }

    public void InpolPolinom(){
        int n, i, j;
        double x, y;
        System.out.print("Masukkan jumlah titik yang ingin dimasukkan: ");
        n = scan.nextInt();
        Matrix tmpM = new Matrix(n, n+1);
        Matrix tmpH = new Matrix(n, n+1);

        for (i=0; i<n; i++){
            System.out.print("Masukkan x[" + i + "] y[" + i + "] = ");
            x = scan.nextDouble();
            y = scan.nextDouble();
            for (j=0; j<n; j++){
                tmpM.setElmt(Math.pow(x,j), i, j);
            }
            tmpM.setElmt(y, i, n);
        }
        System.out.println("");
        System.out.println("==============================");
        System.out.println("");
        tmpM.displayMatrix();
        System.out.println("");

        tmpH = tmpM.gaussJordan();
        System.out.println("Solusi dari interpolasi polinom tersebut adalah");
        for (i=0; i<n; i++){
            System.out.println("a[" + i +"] = " + tmpH.getElmt(i, n));
        }
        System.out.println((""));

        //Output fungsi jadi
        double nilai;
        for (i=0; i<n; i++){
            nilai = tmpH.getElmt(i, n);
            if (i == 0){
                if (tmpH.getElmt(i+1, n) < 0){
                    System.out.print("f(x) = " + cekOutput(nilai) + " - ");
                } else {
                    System.out.print("f(x) = " + cekOutput(nilai) + " + ");
                }
            } else if (i == n-1) {
                System.out.print(cekOutput(nilai) + "(x^" + i + ")");
            } else {
                if (tmpH.getElmt(i+1, n) < 0){
                    System.out.print(cekOutput(nilai) + "(x^" + i + ") - ");
                } else {
                    System.out.print(cekOutput(nilai) + "(x^" + i + ") + ");
                }
            }
        }
        System.out.println("\n");

        //Menghitung nilai taksiran
        boolean cek = true;
        int jwb;
        while (cek){
            System.out.print("Apakah ingin menghitung nilai taksiran pada fungsi tersebut? \n1. Ya \n2. Tidak \nJawaban : ");
            jwb = scan.nextInt();
            System.out.println("");
            if (jwb == 2){
                cek = false;
            } else if (jwb == 1) {
                double fx, hasil;
                System.out.print("Masukkan nilai x = ");
                fx = scan.nextDouble();
                hasil = nilaiTaksiran(n, tmpH, fx);
                System.out.print("\nf(" + fx + ") = " + hasil);
                System.out.println("\n");
            } else {
                System.out.println("Inputan salah! \n");
            }
        }
    }
}