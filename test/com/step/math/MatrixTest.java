package com.step.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void representsMatrixInString() {
    int[][] elements = { { 1, 2 }, { 3, 4 } };
    Matrix matrix = new Matrix(2, 2, elements);
    String actual = matrix.toString();
    String expected = "Matrix {\n  1 2 \n  3 4 \n}";
    String message = "should give textual representation of given Matrix";
    assertEquals(message, actual, expected);
  }

  @Test
  public void equatesTwoMatricesThatAreEqual() {
    int[][] elements1 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    int[][] elements2 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix2 = new Matrix(2, 2, elements2);
    String message = "should give true on equating two equal matrices ";
    assertTrue(message, matrix1.equals(matrix2));
  }

  @Test
  public void equatesTwoMatricesThatAreSameInstance() {
    int[][] elements1 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    String message = "should give true on equating same matrix instance";
    assertTrue(message, matrix1.equals(matrix1));
  }

  @Test
  public void equatesTwoMatricesThatAreNotEqual() {
    int[][] elements1 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    int[][] elements2 = { { 3, 2 }, { 3, 4 } };
    Matrix matrix2 = new Matrix(2, 2, elements2);
    String message =
      "should give false on equating matrices with different elements";
    assertFalse(message, matrix1.equals(matrix2));
  }

  @Test
  public void equatesTwoMatricesThatAreNotEqualInDimensions() {
    int[][] elements1 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    int[][] elements2 = { { 3, 2 }, { 3, 4 }, { 4, 5 } };
    Matrix matrix2 = new Matrix(3, 2, elements2);
    String message =
      "should give false on equating matrices with different dimensions";
    assertFalse(message, matrix1.equals(matrix2));
  }

  @Test
  public void equatesMatricesWithOther() {
    int[][] elements1 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    int[][] elements2 = { { 1, 2 }, { 3, 4 } };
    String message = "should give false on equating matrix with other instance";
    assertFalse(message, matrix1.equals(elements2));
  }

  @Test
  public void addsTwoMatrices() {
    int[][] elements1 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    int[][] elements2 = { { 2, 1 }, { 4, 3 } };
    Matrix matrix2 = new Matrix(2, 2, elements2);
    int[][] elements3 = { { 3, 3 }, { 7, 7 } };
    Matrix resultantMatrix = new Matrix(2, 2, elements3);
    String message = "should give sum of two matrices of same dimensions";
    assertEquals(message, resultantMatrix, matrix1.add(matrix2));
  }

  @Test
  public void doesNotAddMatricesOfDifferentDimensions() {
    int[][] elements1 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    int[][] elements2 = { { 2, 1 }, { 4, 3 }, { 5, 6 } };
    Matrix matrix2 = new Matrix(3, 2, elements2);
    String message =
      "should give null on adding matrices of different dimensions";
    assertNull(message, matrix1.add(matrix2));
  }

  @Test
  public void subtractsTwoMatrices() {
    int[][] elements1 = { { 2, 5 }, { 4, 3 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    int[][] elements2 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix2 = new Matrix(2, 2, elements2);
    int[][] elements3 = { { 1, 3 }, { 1, -1 } };
    Matrix resultantMatrix = new Matrix(2, 2, elements3);
    String message =
      "should give difference of two matrices of same dimensions";
    assertEquals(message, resultantMatrix, matrix1.subtract(matrix2));
  }

  @Test
  public void doesNotSubtractMatricesOfDifferentDimensions() {
    int[][] elements1 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    int[][] elements2 = { { 2, 1 }, { 4, 3 }, { 5, 6 } };
    Matrix matrix2 = new Matrix(3, 2, elements2);
    String message =
      "should give null on subtracting matrices of different dimensions";
    assertNull(message, matrix1.subtract(matrix2));
  }

  @Test
  public void multipliesTwoMatrices() {
    int[][] elements1 = { { 2, 5 }, { 4, 3 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    int[][] elements2 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix2 = new Matrix(2, 2, elements2);
    int[][] elements3 = { { 17, 24 }, { 13, 20 } };
    Matrix resultantMatrix = new Matrix(2, 2, elements3);
    String message = "should give product of two matrices of same dimensions";
    assertEquals(message, resultantMatrix, matrix1.multiply(matrix2));
  }

  @Test
  public void multipliesTwoMatricesWithDifferentDimension() {
    int[][] elements1 = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix matrix1 = new Matrix(2, 3, elements1);
    int[][] elements2 = { { 7, 8 }, { 9, 10 }, { 11, 12 } };
    Matrix matrix2 = new Matrix(3, 2, elements2);
    int[][] elements3 = { { 58, 64 }, { 139, 154 } };
    Matrix resultantMatrix = new Matrix(2, 2, elements3);
    String message =
      "should give product of two matrices if column of matrixA is equal to row of matrixB";
    assertEquals(message, resultantMatrix, matrix1.multiply(matrix2));
  }

  @Test
  public void doesNotMultiplyMatricesWithWrongDimension() {
    int[][] elements1 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix1 = new Matrix(2, 2, elements1);
    int[][] elements2 = { { 2, 1 }, { 4, 3 }, { 5, 6 } };
    Matrix matrix2 = new Matrix(3, 2, elements2);
    String message =
      "should give null of two matrices if column of matrixA is not equal to row of matrixB";
    assertNull(message, matrix1.multiply(matrix2));
  }
}
