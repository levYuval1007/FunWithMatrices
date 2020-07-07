/**
 * Rotate the entries of a square matrix 90 degrees clockwise.
 *
 * <p>Time Complexity: O(n^2)
 *
 * @author William Fiset, william.alexandre.fiset@gmail.com
 */
package williamfiset;

public class RotateSquareMatrixInplace {

  // Rotates the entries of a square matrix 90 degrees clockwise.
  public static void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      int invI = n - i - 1;
      for (int j = i; j < invI; j++) {
        int invJ = n - j - 1, tmp = matrix[i][j];
        matrix[i][j] = matrix[invJ][i];
        matrix[invJ][i] = matrix[invI][invJ];
        matrix[invI][invJ] = matrix[j][invI];
        matrix[j][invI] = tmp;
      }
    }
  }

}
