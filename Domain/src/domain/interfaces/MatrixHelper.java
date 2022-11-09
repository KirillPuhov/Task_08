package domain.interfaces;

public interface MatrixHelper {
    int[][] getMatrix();
    void openMatrix(String filePath);
    boolean saveMatrix(String newFilePath);
    void doTask();
}
