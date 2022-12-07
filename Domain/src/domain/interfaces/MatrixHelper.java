package domain.interfaces;

public interface MatrixHelper {
    int[][] getMatrix();
    void setMatrix(int[][] matrix);
    void openMatrix(String filePath);
    boolean saveMatrix(String newFilePath);
    void doTask();
    void printMatrix();
}
