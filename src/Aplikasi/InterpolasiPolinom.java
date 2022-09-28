package Aplikasi;

import java.util.Scanner;

import Matrix.*;

public class InterpolasiPolinom {
    Scanner scan = new Scanner(System.in);
    public InterpolasiPolinom(){

    }
    
    public void InpolPolinom(){
        int n, i, j, x, y;
        System.out.println("Masukkan jumlah titik yang ingin dimasukkan: ");
        n = scan.nextInt();
        Matrix tmpM = new Matrix(n, n+1);
        Matrix tmpH = new Matrix(n, n+1);

        for (i=0; i<n; i++){
            System.out.print("Masukkan x[" + i + "] y[" + i + "] = ");
            x = scan.nextInt();
            y = scan.nextInt();
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
    }
}