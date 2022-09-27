import Matrix.*;

public class main {
    public static void main(String[] agrs) {
        Matrix m = new Matrix(3, 3);
        m.readMatrix();
        m.displayMatrix();

        double det = m.detGauss();
        System.out.println(det);

        //Matrix p = new Matrix(3,1);
        //p = m.hascreamer();
        //p.displayMatrix();
        
    }
}
