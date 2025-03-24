import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private static final int SIZE = 8;

    public static void main(String[] args) {
        //Создание матрицы
        int[][] matrix = createMatrix(SIZE, SIZE);

        //Вывод матрицы
        System.out.println("Оригинальная матрица:");
        printMatrix(matrix);

        //Выбор угла поворота
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите угол поворота (90, 180 или 270):");
        int angle = scanner.nextInt();

        //Разворот матрицы
        int[][] rotatedMatrix = rotateMatrix(matrix, angle);

        //Вывод матрицы после поворота
        System.out.println("Матрица после поворота:");
        printMatrix(rotatedMatrix);

        scanner.close();
    }

    //Создает двумерную матрицу заданного размера и заполняет её случайными числами.
    private static int[][] createMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(256);
            }
        }
        return matrix;
    }

    private static int[][] rotateMatrix(int[][] matrix, int angle) {
        int[][] rotated = matrix; // Изначально rotated = исходная матрица
        angle = angle % 360; // Нормализуем угол, чтобы избежать лишних поворотов

        if (angle < 0) {
            angle += 360; // Чтобы работало с отрицательными углами
        }

        if (angle == 90) {
            rotated = rotate90(rotated);
        } else if (angle == 180) {
            rotated = rotate180(rotated);
        } else if (angle == 270) {
            rotated = rotate270(rotated);
        }

        return rotated;
    }

    private static int[][] rotate90(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotated = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[j][rows - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    private static int[][] rotate180(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotated = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[rows - 1 - i][cols - 1 - j] = matrix[i][j];
            }
        }
        return rotated;
    }

    private static int[][] rotate270(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotated = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[cols - 1 - j][i] = matrix[i][j];
            }
        }
        return rotated;
    }


    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}