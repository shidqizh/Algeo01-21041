package Matrix;

public class Matrix{
    private int row,col;
    private Double matrix[][];

    public Matrix(){
        this.col = 0;
        this.row = 0;
    }

    public Matrix(int row, int col){
        this.col = col;
        this.row = row;
        this.matrix = new Double [row][col];
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

      
}


