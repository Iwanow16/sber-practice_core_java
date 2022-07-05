public class Matrix {
    
    private int[][] matrix;
    private int rows;
    private int columns;
    
    public Matrix(int[][] matrix){
        rows = matrix.length;
        columns = matrix[0].length;
        this.matrix = matrix;
    }

    public void setValue(int i, int j, int value){
        matrix[i][j] = value;
    }

    public int getValue(int i, int j){
        return matrix[i][j];
    }

    public int[][] additionMatrix(Matrix matrix){
        int[][] sumMatrix = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                sumMatrix[i][j] = this.matrix[i][j] + matrix.getValue(i, j);
        return sumMatrix;
    }

    public void multiplyByNumber(int number){
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] *= number;
    }

    public int[][] multiplyMatrix(Matrix matrix){
        int[][] multMatrix = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                multMatrix[i][j] = this.matrix[i][j] * matrix.getValue(i, j);
        return multMatrix;
    }

    public void outputMatrix(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}