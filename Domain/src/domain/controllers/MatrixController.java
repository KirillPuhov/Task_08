package domain.controllers;

import domain.interfaces.MatrixHelper;
import domain.services.FileService;
import domain.services.interfaces.FileHelper;

public final class MatrixController implements MatrixHelper {
    private final FileHelper fileService;
    private int[][] matrix;

    public MatrixController(String filePath){
        this.fileService = new FileService();
        this.matrix = new int[1][1];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void openMatrix(String filePath) {
        this.matrix = fileService.readFileInMatrix(filePath);
    }

    public boolean saveMatrix(String newFilePath) {
        return fileService.writeMatrixInFile(matrix, newFilePath);
    }

    public void doTask() {
        deleteAllHomogeneousItems();
    }

    private void deleteAllHomogeneousItems() {
        //todo:реализовать метод
    }
}
