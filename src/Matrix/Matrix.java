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

    public void setSize(int row, int col) {
      this.row = row;
      this.col = col;
      this.matrix = new double [row][col];
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
      for (int j=0; j<getCol();j++) {
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
    Scanner scan = new Scanner(System.in);
    public void readMatrix() {
      for (int i=0; i< getRow();i++){
        for (int j=0; j< getCol();j++) {
          this.matrix[i][j] = scan.nextDouble();
        }
      }
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
          if (j<getCol()-1) {
            System.out.print(getElmt(i, j) + " ");
          }
          else {
            System.out.print( getElmt(i, j));
          }
        }
        if(i<getRow()-1){
          System.out.print("\n");
        }
      }
      System.out.print("\n");
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
      for (int i = mg.getRow()-1; i>0; i--) {
        for (int j=0; ((j<i) && (j<mg.getCol()));j++) {
          mg.addRow(j, i, -1*mg.getElmt(j,i));
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
        nm.setElmt(1, i, j);
      }
      else{
        nm.setElmt(0, i, j);
      }
    }
  }
  return nm.gaussJordan();
}

public Matrix multiplyByRow(int row,double x) {
  for (int i=0; i<getCol(); i++) {
    setElmt(getElmt(row, i)*x, row , i);
  }
  return this;
}
public Matrix inverseGJ(){
  Matrix id = createIdentity(getRow());
  Matrix nm = new Matrix(getRow(),2*getCol());
  for(int i=0;i<getRow();i++){
    for(int j=0;j<getCol();j++){
      nm.setElmt(getElmt(i, j), i, j);
      nm.setElmt(id.getElmt(i, j), i, j+getCol());
    }
  }
  nm = nm.gauss();
  for (int i = nm.getRow()-1; i>0; i--) {
    for (int j=0; j<i;j++) {
      nm.addRow(j, i, -1*nm.getElmt(j,nm.getFirstIdx(i)));
    }
  }
  Matrix hasil = new Matrix(getRow(),getCol());
  for(int i=0;i<getRow();i++){
    for(int j=0;j<getCol();j++){
      hasil.setElmt(nm.getElmt(i, j+getCol()), i, j);
    }
  }
  return hasil;
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
    public Matrix swapColCre(int j){
      Matrix tmpM = new Matrix(getRow(),getRow());
      int i, k;

      for (i=0; i<tmpM.getRow(); i++){
        for (k=0; k<tmpM.getCol(); k++){
          if (k==j) {
            tmpM.setElmt(getElmt(i,getCol()-1),i,k);
          } else {
            tmpM.setElmt(getElmt(i,k),i,k);
          }
        }
      }
      return tmpM;
    }

    public Matrix hascreamer(){
      Matrix tmpM = new Matrix(getRow(), 1);
      Matrix tmpDet1 = new Matrix(getRow(), getRow());
      Matrix tmpDet2 = new Matrix(getRow(), getRow());
      int i, j;
      double det1, det2;

      for (i=0; i<tmpDet1.getRow(); i++){
        for (j=0; j<tmpDet1.getCol(); j++){
          tmpDet1.setElmt(getElmt(i,j),i,j);
        }
      }
      det1 = tmpDet1.determinant();
      for (j=0; j<tmpDet2.getCol(); j++){
        tmpDet2 = swapColCre(j);
        det2 = tmpDet2.determinant();
        tmpM.setElmt(det2/det1, j, 0);
      }
    return tmpM;
    }

    public double detGauss(){
      Matrix tmpM = new Matrix(getRow(), getCol());
      int i, j, tmpix;
      double hasil;
      hasil =1;

      tmpM = copyMatrix();
      for (j=0; j<tmpM.getCol(); j++){
        if (tmpM.findOneInCol(j) != -1){
          if (j!=tmpM.findOneInCol(j)){
            hasil *= (-1);
          }
          tmpM.swap(j, tmpM.findOneInCol(j));
          for (i=j+1; i<tmpM.getRow(); i++){
            tmpM.addRow(i, j, tmpM.getElmt(i,j)*(-1));
            }
        } else {
          tmpix = tmpM.getFirstIdxRow(j);
          if (tmpix != -1) {
            if (j!=tmpix){
              hasil *= (-1);
            }
            tmpM.swap(j, tmpix);
            hasil *= tmpM.getElmt(j,j);
            tmpM.simplifyRow(j);
            for (i=j+1; i<tmpM.getRow(); i++){
              tmpM.addRow(i, j, tmpM.getElmt(i,j)*(-1));
              }
          }
        }
      }
      return hasil;
    }

    public Matrix multiplyMat(Matrix M){
      Matrix mtemp = new Matrix(getRow(),M.getCol());
      double temp;
      for (int i = 0; i<mtemp.getRow();i++) {
          for (int j = 0; j<mtemp.getCol();j++) {
              temp = 0;
              for (int k=0; k<getCol();k++){
                  temp = temp + getElmt(i, k)*M.getElmt(k, j);
              }
              mtemp.setElmt(temp, i, j);
          }
      }
      return mtemp;
    }

    public Matrix inversSPL(Matrix M){
      Matrix inv = new Matrix(getRow(),getCol());
      inv = inverseGJ();
      Matrix hasil = new Matrix(getRow(),1);
      hasil = inv.multiplyMat(M);
      return hasil;
    }

    public boolean isRowzero(int i){
      boolean temp = true;
      for (int j = 0; j<getCol(); j++){
        if (getElmt(i, j) != 0){
          temp = false;
        }
      }
      return temp;
    }

    public void hasilPara() {
      Matrix m = new Matrix(getRow(), getCol());
      Matrix a = new Matrix(getRow(), getCol()-1);

      m = gaussJordan();
      int i,j,c;
      boolean solv=true;

      for (i=0;i<getRow();i++){
        for (j=0; j<getCol()-1;j++){
          a.setElmt(m.getElmt(i, j), i, j);
        }
      }

      for (i=0;i<getRow();i++){
        if (m.isRowzero(i)){
          solv = false;
        }
      }

      if (!solv){
        for (i = 0; i<getRow();i++){
          if (!isRowzero(i)){
            c=0;
            for (j=0;j<getCol();j++){
              if (j!=getCol()-1){
                if (m.getElmt(i, j)!=0) {
                  if (c==0){
                    System.out.printf("%.2fx%d",m.getElmt(i, j),j);
                    c++;
                  }
                  else{
                    System.out.printf(" + %.2fx%d " , m.getElmt(i, j),j);
                  }
                }
              }
              else{
                if (c!=0){
                  System.out.printf(" = %.2f\n", m.getElmt(i, j));
                }
              }
            }
          }
        } 
      }
      else{
        for (i=0;i<getRow();i++){
          if (a.isRowzero(i)){
            solv = false;
          }
        }
        if (solv){
          for (i = 0; i<getRow();i++){
            if (!isRowzero(i)){
              c=0;
              for (j=0;j<getCol();j++){
                if (j!=getCol()-1){
                  if (m.getElmt(i, j)!=0) {
                    if (c==0){
                      System.out.printf("%.2fx%d",m.getElmt(i, j),j);
                      c++;
                    }
                    else{
                      System.out.printf(" + %.2fx%d " , m.getElmt(i, j),j);
                    }
                  }
                }
                else{
                  if (c != 0) {
                    System.out.printf(" = %.2f\n", m.getElmt(i, j));
                  }
                }
              }
            }
          } 
        }
        else{
          System.out.println("Tidak ada nilai x yang memenuhi");
        }
      }
    }

}
