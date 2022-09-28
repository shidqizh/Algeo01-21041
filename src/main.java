import Matrix.*;

import java.util.Scanner;

//import Aplikasi.Menu;

import Aplikasi.InterpolasiPolinom;


public class main {
    public static void main(String[] agrs) {
        //Matrix m = new Matrix(4, 6);
        //m.readMatrix();
        //m.displayMatrix();

        //double det = m.detGauss();
        //System.out.println(det);

        //Matrix p = new Matrix(4,6);
        //p = m.gaussJordan();
        //p.displayMatrix();
        
        InterpolasiPolinom tmp = new InterpolasiPolinom();
        tmp.InpolPolinom();

        //Determinan txp = new Determinan();
        //txp.kofdet();
        //txp.gaussdet();

        //Inverse txx = new Inverse();
        //txx.invKofDet();
    }
}
