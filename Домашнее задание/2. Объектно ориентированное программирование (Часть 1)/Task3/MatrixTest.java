public class MatrixTest {
    public static void main(String[] args) {

        int[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] array2 = {{6, 5, 4}, {3, 2, 1}};

        Matrix matrix1 = new Matrix(array1);
        Matrix matrix2 = new Matrix(array2);
        matrix1.outputMatrix();
        matrix2.outputMatrix();

        Matrix matrix3 = new Matrix(array1);
        Matrix matrix4 = new Matrix(matrix1.additionMatrix(matrix3));
        matrix4.outputMatrix();
        
        matrix2.multiplyByNumber(5);
        matrix2.setValue(0, 0, 0);
        matrix2.outputMatrix();

        Matrix matrix5 = new Matrix(matrix1.multiplyMatrix(matrix3));
        matrix5.outputMatrix();
    }
}
