package Matrix;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Matrix{
    private int row,col;
    private double[][] matrix;

    public Matrix(){
        this.col = 0;
        this.row = 0;
    }

    public Matrix(int row, int col){
        this.col = col;
        this.row = row;
        this.matrix = new double [row][col];
    }
    public Matrix(int row, int col, double c){
        this.row = row;
        this.col = col;
        for(int i = 0; i < this.row; i++){
          for(int j = 0; j < this.col; j++){
            this.matrix[i][j] = c;
          }
        }
      }
    
    public double getElmt(int i,int j) {
        return this.matrix[i][j];
    }

    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }

    public void setElmt(double x, int i, int j){
        this.matrix[i][j] = x;
    }

    public int countElmt(){
        return this.row * this.col;
    }


    public int getFirstIdx(int i){
      int idx=0;
      for (int j=0; j<getCol();j++) {
        if (getElmt(i, j) != 0) {
          idx = j;
          break;
        }
      }
      return idx;
    }

    public void simplifyRow(int i){
      int idx = getFirstIdx(i);
      double firstElmt = getElmt(i, idx);
      for (int j = idx; j<getCol();j++) {
        this.matrix[i][j] = getElmt(i,j) / firstElmt;
      }
    }

    public void swap(int i1, int i2) {
      double temp;
      for (int j = 0; j<getCol();j++) {
        temp = getElmt(i1, j);
        this.matrix[i1][j] = getElmt(i2,j);
        this.matrix[i2][j] = temp;
      }
    }

    // Mencari angka 1 pertama pada suatu kolom jika ada mereturn nomor baris jika tidak ada mereturn -1. 
    public int findOneInCol(int j){
      int tmp = -1;
      for (int i = j; i<getRow(); i++){
        if (this.matrix[i][j] == 1) {
          tmp = i;
          break;
        
        }
      }
      return tmp;
    }

    
    public void addRow(int iP, int i2, double k) {
      for (int j = 0; j<getCol();j++) {
        this.matrix[iP][j] = getElmt(iP,j)+ getElmt(i2,j)*k;
      }
    }

    public void readMatrix() {
      Scanner scan = new Scanner(System.in);
      for (int i=0; i< getRow();i++){
        for (int j=0; j< getCol();j++) {
          this.matrix[i][j] = scan.nextDouble();
        }
      }
      scan.close();
    }


  
    public double cofac(Matrix m, int r, int c){
        int i;
        int j;
        int ni;
        int nj;
        double cof;
        Matrix nm;
        ni = 0;
        cof = 0;
        nm = new Matrix(m.getRow()-1,m.getCol()-1);
        for (i=0;i<=m.getRow()-1;i++){
            nj = 0;
            for (j=0;j<=m.getCol()-1;j++){
                if (i == r){
                    ni = i - 1;
                } 
                else if (j == c){
                    nj = j - 1;
                } 
                else{
                    nm.setElmt(m.getElmt(i, j),ni,nj);
                }
                nj++;
            }
            ni++;
        }
    
        if ((r + c) % 2 == 0){
            cof = determinant(nm);
        } 
        else{
            cof = -1*determinant(nm);
        }
    
        return cof;
    }

    public double determinant(Matrix m){
        int i;
        int j;
        double det = 0;
        if(m.countElmt() == 1){
            return m.getElmt(0, 0);
        }
        else{
            i = 0;
            for (j=0;j<=m.getCol()-1;j++){
                det += m.getElmt(i, j) * cofac(m,i,j);
            }
        }
        return det;
    }

    public void displayMatrix() {
      for (int i=0; i< getRow();i++){
        for (int j=0; j< getCol();j++) {
          if (j == 0) {
            System.out.print(getElmt(i, j));
          }
          else if (j == getCol()) {
            System.out.println(getElmt(i,j));
          }
          else {
            System.out.print(getElmt(i,j)+" ");
          }
        }
      }
    }



    public Matrix gauss(Matrix m){
      
      
      tmpM = copymatrix(m);


    }
