package Matrix;

import java.io.ObjectInputStream.GetField;

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

    
}


