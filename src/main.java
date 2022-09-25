import Matrix.*;

public class main {
    public static void main(String[] agrs) {
        Matrix m = new Matrix(3, 3);
        m.readMatrix();
        m.displayMatrix();
        Matrix p = new Matrix(3,3);
        p = m.inverseGJ();
        p.displayMatrix();
        
    }
}
