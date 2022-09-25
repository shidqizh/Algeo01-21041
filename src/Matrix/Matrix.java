package Matrix;

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

    public Matrix copyMatrix(){
      int i;
      int j;
      Matrix nm;
      nm = new Matrix(this.getRow(),this.getCol());
      for(i=0;i<getRow();i++){
          for(j=0;j<getCol();j++){
              nm.setElmt(getElmt(i, j), i, j);
          }
      }
      return nm;
  }

  public Matrix transpose(){
      int i;
      int j;
      Matrix nm = new Matrix(getCol(),getRow());
      for(i=0;i<=nm.getRow()-1;i++){
          for(j=0;j<=nm.getCol()-1;j++){
              nm.setElmt(getElmt(j, i), i, j);     
          }
      } 
      return nm;
  }

    public int getFirstIdx(int i){
      int idx = -1;
      for (int j=0; j<getCol()-1;j++) {
        if (getElmt(i, j) != 0) {
          idx = j;
          break;
        }
      }
      return idx;
    }

    public int getFirstIdxRow(int j){
      int idx = -1;
      for (int i=j; i<getRow(); i++) {
        if (getElmt(i, j) != 0) {
          idx = i;
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
        this.matrix[iP][j] = getElmt(iP,j) + getElmt(i2,j)*k;
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

    public double cofac(int r, int c){
        int i;
        int j;
        int ni;
        int nj;
        double cof;
        Matrix nm;
        ni = 0;
        cof = 0;
        nm = new Matrix(this.getRow()-1,this.getCol()-1);
        for (i=0;i<=this.getRow()-1;i++){
            nj = 0;
            for (j=0;j<=this.getCol()-1;j++){
                if (i == r){
                    ni = i - 1;
                } 
                else if (j == c){
                    nj = j - 1;
                } 
                else{
                    nm.setElmt(this.getElmt(i, j),ni,nj);
                }
                nj++;
            }
            ni++;
        }
    
        if ((r + c) % 2 == 0){
            cof = nm.determinant();
        } 
        else{
            cof = -1*nm.determinant();
        }
    
        return cof;
    }

    public double determinant(){
        int i;
        int j;
        double det = 0;
        if(this.countElmt() == 1){
            return getElmt(0, 0);
        }
        else{
            i = 0;
            for (j=0;j<=getCol()-1;j++){
                det += getElmt(i, j) * cofac(i,j);
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
          else if (j == getCol()-1) {
            System.out.print(" "+getElmt(i,j)+"\n");
          }
          else {
            System.out.print(" "+getElmt(i,j));
          }
        }
      }
    }

    public boolean isSquare(){
      return (this.getCol() == this.getRow());
    }

    public boolean isIdentity(){
      int i;
      int j;
      boolean cek = true;
      if(this.isSquare() != true){
           cek = false;
      }
      else{
           for(i=0;i<this.getRow()-1;i++){
               for(j=0;j<this.getCol()-1;j++){
                   if (i == j) {
                       if (this.getElmt(i, j) != 1) {
                           cek = false;
                       }
                   }
                   else {
                       if (this.getElmt(i, j) != 0) {
                           cek = false;
                       }
                   }
               }
           }
      }
      return cek; 
    }

    public Matrix gauss(){
      Matrix tmpM = new Matrix(getRow(), getCol());
      int i, j, tmpix;

      tmpM = copyMatrix();
      for (j=0; j<tmpM.getCol()-1; j++){
        if (tmpM.findOneInCol(j) != -1){
          tmpM.swap(j, tmpM.findOneInCol(j));
          for (i=j+1; i<tmpM.getRow(); i++){
            tmpM.addRow(i, j, tmpM.getElmt(i,j)*(-1));
            }
        } else {
          tmpix = tmpM.getFirstIdxRow(j);
          if (tmpix != -1) {
            tmpM.swap(j, tmpix);
            tmpM.simplifyRow(j);
            for (i=j+1; i<tmpM.getRow(); i++){
              tmpM.addRow(i, j, tmpM.getElmt(i,j)*(-1));
              }
          }
        }
      }
      return tmpM;
    }


    public Matrix gaussJordan() {
      Matrix mg = this.gauss();
      for (int i = getRow()-1; i>0; i--) {
        for (int j=i-1; j>=0;j--) {
          mg.addRow(j, i, -1*getElmt(getFirstIdx(i),j));
        }
      }
      return mg;
    }

public Matrix multiplyByConst(double x){
  int i;
  int j;
  for(i=0;i<this.getRow();i++){
      for(j=0;j<this.getCol();j++){
          this.setElmt(x*this.getElmt(i, j), i, j);
      }
  }  
  return this;
}

public Matrix createIdentity(int x){
  Matrix nm = new Matrix(x,x);
  int i,j;
  for(i=0;i<x;i++){
    for(j=0;j<x;j++){
      if(i == j){
        setElmt(1, i, j);
      }
      else{
        setElmt(0, i, j);
      }
    }
  }
  return nm;
}

public Matrix inverseGJ(){
  Matrix id = createIdentity(this.getRow());
  Matrix tmpM;
  int i, j, tmpix;
  double ter;

  tmpM = copyMatrix();
  for (j=0; j<tmpM.getCol()-1; j++){
    if (tmpM.findOneInCol(j) != -1){
      tmpM.swap(j, tmpM.findOneInCol(j));
      id.swap(j, tmpM.findOneInCol(j));
      for (i=j+1; i<tmpM.getRow(); i++){
        ter = tmpM.getElmt(i,j);
        tmpM.addRow(i, j, ter*(-1));
        id.addRow(i, j, ter*(-1));
        }
    } else {
      tmpix = tmpM.getFirstIdxRow(j);
      if (tmpix != -1) {
        tmpM.swap(j, tmpix);
        id.swap(j, tmpix);
        tmpM.simplifyRow(j);
        id.simplifyRow(j);
        for (i=j+1; i<tmpM.getRow(); i++){
          ter = tmpM.getElmt(i,j);
          tmpM.addRow(i, j, ter*(-1));
          id.addRow(i, j, ter*(-1));
          }
      }
    }
  }
  Matrix mg = this.gauss();
  for (int k = getRow(); k>0; k--) {
    for (int l=k-1; l>=0;l--) {
      mg.addRow(l, k, -1*mg.getElmt(l, getFirstIdx(k)));
      id.addRow(l, k, -1*id.getElmt(l, getFirstIdx(k)));
    }
  }
  return id;
}

public Matrix inverseDet(){
  Matrix kofak = new Matrix(getRow(), getCol());
  Matrix adj = new Matrix(getCol(),getRow());
  int i;
  int j;
  for(i=0;i<getRow();i++){
    for(j=0;j<getCol();j++){
      kofak.setElmt(cofac(i, j), i, j);
    }
  }

  adj = kofak.transpose();
  double det = this.determinant();
  return adj.multiplyByConst(1/det);
}
}

