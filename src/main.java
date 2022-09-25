import Matrix.*;

public class main {
    public static void main(String[] agrs) {
        Matrix m = new Matrix(3, 4);
        m.readMatrix();
        m.displayMatrix();
        Matrix p = new Matrix(3,1);
        p = m.hascreamer();
        p.displayMatrix();
        
    }
}
