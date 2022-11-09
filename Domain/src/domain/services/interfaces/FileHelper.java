package domain.services.interfaces;

import java.io.FileNotFoundException;

public interface FileHelper {
    int[][] readFileInMatrix(String filePath);
    boolean writeMatrixInFile(int[][] matrix, String filePath);
}
