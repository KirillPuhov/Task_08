package domain.services;

import domain.services.interfaces.FileHelper;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileService implements FileHelper {
    public int[][] readFileInMatrix(String filePath){
        try(FileReader fileReader = new FileReader(filePath); Scanner scanner = new Scanner(fileReader)){
            int columnsCount = scanner.nextInt();
            int rowsCount = scanner.nextInt();

            int[][] matrix = new int[columnsCount][rowsCount];

            for (int c = 0; c < columnsCount; c++) {
                for (int r = 0; r < rowsCount; r++) {
                    matrix[c][r] = scanner.nextInt();
                }
            }

            return matrix;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return new int[0][0];
        }
    }

    public boolean writeMatrixInFile(int[][] matrix, String filePath){
        try(PrintWriter out = new PrintWriter(new FileOutputStream(filePath))){
            int columnsCount = matrix[0].length;
            int rowsCount = matrix.length;

            for (int c = 0; c < columnsCount; c++) {
                for (int r = 0; r < rowsCount; r++) {
                    out.printf("%d", matrix[c][r]);
                }
                out.println();
            }
            out.println();

            return true;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
}
