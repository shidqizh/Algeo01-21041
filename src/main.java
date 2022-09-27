import Matrix.*;

public class main {
    public static void main(String[] agrs) {
        Matrix m = new Matrix(3, 3);
        m.readMatrix();
        m.displayMatrix();
        //Matrix p = new Matrix(3,3);
        double det;
        det = m.detGauss();
        System.out.println(det);
        //p = m.inverseGJ();
        //p.displayMatrix();
        
    }
}
