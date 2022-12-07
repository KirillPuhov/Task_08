package domain.controllers;

import domain.interfaces.MatrixHelper;
import domain.services.FileService;
import domain.services.interfaces.FileHelper;

public final class MatrixController implements MatrixHelper {
    private final FileHelper fileService;
    private int[][] matrix;

    public MatrixController(){
        this.fileService = new FileService();
        this.matrix = new int[1][1];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void openMatrix(String filePath) {
        matrix = fileService.readFileInMatrix(filePath);
    }

    public boolean saveMatrix(String newFilePath) {
        return fileService.writeMatrixInFile(matrix, newFilePath);
    }

    public void doTask() {
        deleteAllHomogeneousItems();
    }

    private void deleteAllHomogeneousItems() {
        int[][] currentMatrix = matrix;

        int offsetRows = 0;
        int offsetColumns = 0;

        for(int i = 0; i < matrix.length; i++){
            if(isHomogeneous(matrix[i])){
                currentMatrix = deleteRow(currentMatrix, i-offsetRows);
                offsetRows++;
            }
            if(offsetRows == matrix.length){
                matrix = new int[1][];
                break;
            }
            var column = new int[matrix.length];
            for(int j = 0; j < matrix.length; j++){
                column[j] = matrix[j][i];
            }
            if(isHomogeneous(column)){
                currentMatrix = deleteColumn(currentMatrix, i-offsetColumns);
                offsetColumns++;
            }
        }
        matrix = currentMatrix;
    }

    private boolean isHomogeneous(int[] arr){
        int firstItem = arr[0];
        for (int i=1;i<arr.length;i++){
            if(firstItem != arr[i]){
                return false;
            }
        }
        return true;
    }
    
    private int[][] deleteRow(int[][] arr, int index){
        int rowCount = arr.length - 1;
        int columnCount = arr[0].length;

        int[][] newMatrix = new int[rowCount][columnCount];

        boolean isIndex = false;
        for(int i = 0; i < rowCount; i++){
            if(i == index)
                isIndex = true;

            for(int j = 0; j < columnCount; j++){
                if(isIndex){
                    newMatrix[i][j] = arr[i+1][j];
                }else{
                    newMatrix[i][j] = arr[i][j];
                }
            }
        }
        
        return newMatrix;
    }

    private int[][] deleteColumn(int[][] arr, int index){
        int rowCount = arr.length;
        int columnCount = arr[0].length-1;

        int[][] newMatrix = new int[rowCount][columnCount];

        for(int i = 0; i < rowCount; i++){
            boolean isIndex = false;
            for(int j = 0; j < columnCount; j++){
                if(j == index)
                    isIndex = true;

                if(isIndex){
                    newMatrix[i][j] = arr[i][j+1];
                }else{
                    newMatrix[i][j] = arr[i][j];
                }

            }
        }
        return newMatrix;
    }

    public void printMatrix(){
        System.out.println();
        for(int i = 0;i < matrix.length; i++){
            for(int j = 0;j < matrix[i].length; j++){
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
