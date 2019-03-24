public class MatrixOperations extends Object {

    private boolean f;

    Matrix addingMatrices(Matrix firstMatrix, Matrix secondMatrix){
//        if  matrices of the same size n x n
//         create matrix size n x n
//          filling it the sum of the corresponding elements of the first and second matrices;
        if(firstMatrix.getNumRows()==secondMatrix.getNumRows() && firstMatrix.getNumColumns()==secondMatrix.getNumColumns()){
            int rowsResult=firstMatrix.getNumRows(),columnResult=firstMatrix.getNumColumns();
            Matrix result=new Matrix(rowsResult, columnResult);
            for(int indexColumns = 0; indexColumns<columnResult; indexColumns++){
                for(int indexRows = 0; indexRows<rowsResult; indexRows++){
                    result.setElemMatrix(indexRows,indexColumns,firstMatrix.getElemMatrix(indexRows,indexColumns)+secondMatrix.getElemMatrix(indexRows,indexColumns));
                }
            }
            return (result);
        }
        else System.out.println("Adding can not be completed because of different sizes");
        return null;
    }

    Matrix multiplicationByFactorMatrices(Matrix original, double factor){
//        create matrix with size like original matrix
//          filling it the multiplication of (the corresponding elements of the original matrix) x (factor);
        int rowsResult=original.getNumRows(),columnResult=original.getNumColumns();
        Matrix result= new Matrix(rowsResult,columnResult);
        for(int indexColumns = 0; indexColumns < columnResult; indexColumns++){
            for(int indexRows = 0; indexRows < rowsResult; indexRows++){
                result.setElemMatrix(indexRows, indexColumns, original.getElemMatrix(indexRows, indexColumns)*factor);
            }
        }
        return (result);
    }

    Matrix multiplicationMatrices(Matrix firstMatrix, Matrix secondMatrix){
//        if size of first matrix l x m and second matrix m x n then multiplication can be
//          create result matrix with size l x m
//              filling every elements of result matrix the sum of (multiplication of (the corresponding elements of the first and second matrices) thr corresponding row and column);
        if(firstMatrix.getNumColumns()==secondMatrix.getNumRows()){
            int rowsResult=firstMatrix.getNumRows(),columnResult=secondMatrix.getNumColumns(),plains=firstMatrix.getNumColumns();
            Matrix result= new Matrix(rowsResult, columnResult,0);
            for(int indexColumns = 0; indexColumns < columnResult; indexColumns++){
                for(int indexRows = 0; indexRows < rowsResult; indexRows++){
                    for(int indexPlainsSize=0; indexPlainsSize<plains;indexPlainsSize++){
                       result.setElemMatrix(indexRows, indexColumns,result.getElemMatrix(indexRows, indexColumns)+firstMatrix.getElemMatrix(indexRows, indexPlainsSize)*secondMatrix.getElemMatrix(indexPlainsSize, indexColumns));
                    }
                }
            }
            return (result);
        }
        else System.out.println("Multiplication can not be completed because the number of columns of the first matrix doesn't match with the number of rows of the second matrix");
        return null;
    }

    Matrix transpositionMatrix(Matrix original){
//        size of original n x m
//          create result matrix with size m x n
//              filling result matrix the 'conversely';
        int rowsResult=original.getNumColumns(),columnResult=original.getNumRows();
        Matrix result= new Matrix(rowsResult,columnResult);
            for (int indexOfColumns = 0; indexOfColumns<columnResult; indexOfColumns++){
                for (int indexOfRows = 0; indexOfRows<rowsResult; indexOfRows++){
                    result.setElemMatrix(indexOfRows,indexOfColumns,original.getElemMatrix(indexOfColumns,indexOfRows));
                }
            }
        return (result);
    }

    Matrix inverseMatrix(Matrix original){
        /**
         *
         */
//        only for squareMatrix n x n
//          if determinant != 0 then...
//              steps: 1. create supplement matrix n x n and filling of 'supplement elements'(create supplementElement matrix and search determinant for everyone elements)
//                  2. transpositionMatrix supplement
//                      3. multiplication ((transpositionMatrix supplement) x (1/determinant of original matrix));
        Double determinant=countDeterminant(original);
        if(determinant!=null && determinant!=0){
            int rowsResult=original.getNumRows(),columnResult=original.getNumColumns();
            Matrix supplementedMatrix = new Matrix(rowsResult,columnResult,0);
            Matrix supplementedMatrixForElement=new Matrix(rowsResult-1,columnResult-1,0);
            for (int indexOfColumns = 0; indexOfColumns<columnResult; indexOfColumns++){
                for (int indexOfRows = 0; indexOfRows<rowsResult; indexOfRows++){
                    fillSupplementedMatrixForElement(original,supplementedMatrixForElement,indexOfRows,indexOfColumns);
                    supplementedMatrix.setElemMatrix(indexOfRows,indexOfColumns,countDeterminant(supplementedMatrixForElement)*degreeMinusOneForElementOfMatrix(indexOfRows,indexOfColumns));
                }
            }
            //return supplementedMatrix;
            //return transpositionMatrix(supplementedMatrix);
            return multiplicationByFactorMatrices(transpositionMatrix(supplementedMatrix),1/countDeterminant(original));
          //return (multiplicationMatrices(original,multiplicationByFactorMatrices(transpositionMatrix(supplementedMatrix),1/countDeterminant(original))));

        }
        else System.out.println("The inverse matrix can not be found because the matrix is degenerate or no square");
        return (null);
    }

    /**
     *
     * @param matrix
     */
    void matrixView(Matrix matrix){
        if(matrix!=null){
            for(int indexOfRows = 0; indexOfRows<matrix.getNumRows(); indexOfRows++){
                for(int indexOfColumns = 0; indexOfColumns<matrix.getNumColumns(); indexOfColumns++){
                    System.out.printf("%.1f ",matrix.getElemMatrix(indexOfRows,indexOfColumns));
                }
                System.out.println("");
            }
        }
    }

    boolean squareMatrix(Matrix matrix){
        return(matrix.getNumRows()==matrix.getNumColumns())? true : false;
    }

    Double countDeterminant(Matrix original){
        Double determ=null;
        if(original.getNumRows()==original.getNumColumns()){
            if(original.getNumRows()==1)
                determ=original.getElemMatrix(0,0);
            else{
                double determMain=1, determSub=1;
                int num=original.getNumRows();
                for (int index=0; index<num;index++){
                    determMain*=original.getElemMatrix(index,index);
                }
                for (int index=0; index<num;index++){
                    determSub*=original.getElemMatrix(index,num-1-index);
                }
                determ=determMain-determSub;
            }
//                   if(determ==0)
//                    return null;
        }
        return determ;
    }

    void fillSupplementedMatrixForElement(Matrix original, Matrix supplemented, int indexElementRow, int indexElementColumn){
        if(supplemented.getNumRows()==1){
            supplemented.setElemMatrix(0,0,original.getElemMatrix(original.getNumRows()-1-indexElementRow,original.getNumColumns()-1-indexElementColumn));
        }
        else {
            int columnOriginal=original.getNumColumns(), rowOriginal=original.getNumRows(), columnSupplemented=supplemented.getNumColumns(), rowSupplemented=supplemented.getNumRows();
            for(int indexColumnsOriginal=0, indexColumnsSupplemented=0; indexColumnsOriginal<columnOriginal && indexColumnsSupplemented<columnSupplemented; indexColumnsOriginal++){
                if(indexColumnsOriginal==indexElementColumn)
                    continue;
                else {
                    for(int indexRowsOriginal=0, indexRowsSupplemented=0; indexRowsOriginal<rowOriginal && indexRowsSupplemented<rowSupplemented; indexRowsOriginal++){
                        if(indexRowsOriginal==indexElementRow)
                            continue;
                        else {
                            supplemented.setElemMatrix(indexRowsSupplemented,indexColumnsSupplemented,original.getElemMatrix(indexRowsOriginal,indexColumnsOriginal)*degreeMinusOneForElementOfMatrix(indexElementRow,indexElementColumn));
                            indexRowsSupplemented++;
                        }
                    }
                }
                indexColumnsSupplemented++;
            }
        }
    }

    int degreeMinusOneForElementOfMatrix(int indexRow, int indexColumn){
        return ((indexRow+indexColumn)%2==0 ? 1: -1);
    }
}
