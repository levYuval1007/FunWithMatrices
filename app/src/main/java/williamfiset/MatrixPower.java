/**
 * Raise an nxn square matrix to a certain power p.
 *
 * <p>Time Complexity: O(n^3log(p))
 *
 * @author William Fiset, william.alexandre.fiset@gmail.com
 */
package williamfiset;

public class MatrixPower {

  static long[][] matrixDeepCopy(long[][] M) {
    final int N = M.length;
    long[][] newMatrix = new long[N][N];
    for (int i = 0; i < N; i++) newMatrix[i] = M[i].clone();
    return newMatrix;
  }

  // Perform matrix multiplication, O(n^3)
  static long[][] squareMatrixMult(long[][] m1, long[][] m2) {

    final int N = m1.length;
    long[][] newMatrix = new long[N][N];

    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        for (int k = 0; k < N; k++)
          // Overflow can happen here, watch out!
          newMatrix[i][j] = newMatrix[i][j] + m1[i][k] * m2[k][j];

    return newMatrix;
  }

  // Raise a matrix to the pth power. If p is negative
  // return null and if p is zero return the identity.
  // NOTE: Make sure the matrix is a square matrix and
  // also watch out for overflow as the numbers climb quickly!
  public static long[][] matrixPower(long[][] matrix, long p) {

    if (p < 0) return null;

    final int N = matrix.length;
    long[][] newMatrix = null;

    // Return identity matrix
    if (p == 0) {
      newMatrix = new long[N][N];
      for (int i = 0; i < N; i++) newMatrix[i][i] = 1L;
    } else {

      long[][] P = matrixDeepCopy(matrix);

      while (p > 0) {

        if ((p & 1L) == 1L) {
          if (newMatrix == null) newMatrix = matrixDeepCopy(P);
          else newMatrix = squareMatrixMult(newMatrix, P);
        }

        // Repeatedly square P every loop, O(n^3)
        P = squareMatrixMult(P, P);
        p >>= 1L;
      }
    }

    return newMatrix;
  }

  static void print2DMatrix(long[][] M) {
    for (long[] m : M) System.out.println(java.util.Arrays.toString(m));
    System.out.println();
  }
}
