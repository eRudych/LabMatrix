public class Matrix {

    private int numOfColumns = 0;
    private int numOfRows = 0;
    private double[][] matrixArr;

    Matrix(int numOfRows, int numOfColumns) {
        this.numOfColumns = numOfColumns;
        this.numOfRows = numOfRows;
        createMatrix();
        fillMatrixRandom();
    }
    Matrix(int numOfRows, int numOfColumns, int value) {
        this.numOfColumns = numOfColumns;
        this.numOfRows = numOfRows;
        createMatrix();
        fillMatrixValue(value);
    }

    void setNumRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    void setNumColumns(int numOfColumns) {
        this.numOfColumns = numOfColumns;
    }

    int getNumRows() {
        return numOfRows;
    }

    int getNumColumns() {
        return numOfColumns;
    }

    void createMatrix() {
        matrixArr = new double[numOfRows][numOfColumns];
    }

    void fillMatrixRandom() {
        for (int indexOfColumns = 0; indexOfColumns < numOfColumns; indexOfColumns++) {
            for (int indexOfRows = 0; indexOfRows < numOfRows; indexOfRows++) {
                matrixArr[indexOfRows][indexOfColumns] =  (Math.random() *11);
            }
        }
    }

    void fillMatrixValue( double value) {
        for (int indexOfColumns = 0; indexOfColumns < numOfColumns; indexOfColumns++) {
            for (int indexOfRows = 0; indexOfRows < numOfRows; indexOfRows++) {
                matrixArr[indexOfRows][indexOfColumns] = value;
            }
        }
    }

    void setElemMatrix(int indexOfRows,int indexOfColumns, double value) {
        matrixArr[indexOfRows][indexOfColumns] = value;
    }

    double getElemMatrix(int indexOfRows, int indexOfColumns) {
        return matrixArr[indexOfRows][indexOfColumns];
    }

}
