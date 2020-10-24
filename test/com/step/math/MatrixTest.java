package com.step.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldRepresentMatrixInString() {
    Matrix matrix = matrix_2x2(1, 2, 3, 4);
    assertEquals("Matrix {\n  1 2 \n  3 4 \n}", matrix.toString());
  }

  @Test
  public void shouldEquateTwoMatricesThatAreEqual() {
    Matrix matrix1 = matrix_2x2(1, 2, 3, 4);
    Matrix matrix2 = matrix_2x2(1, 2, 3, 4);
    assertEquals(matrix1, matrix2);
  }

  @Test
  public void shouldNotEquateTwoMatricesThatAreNotEqual() {
    Matrix matrix1 = matrix_2x2(1, 2, 3, 4);
    Matrix matrix2 = matrix_2x2(3, 7, 9, 4);
    assertNotEquals(matrix1, matrix2);
  }

  @Test
  public void shouldNotEquateTwoMatricesOfDifferentDimensions() {
    Matrix matrix1 = matrix_2x2(1, 2, 3, 4);
    Matrix matrix2 = matrix_3x2(3, 2, 3, 4, 4, 5);
    assertNotEquals(matrix1, matrix2);
  }

  @Test
  public void shouldNotEquateMatrixWithOtherInstance() {
    Matrix matrix1 = matrix_2x2(1, 2, 3, 4);
    int[][] array = { { 1, 2 }, { 3, 4 } };
    assertNotEquals(matrix1, array);
  }

  @Test
  public void shouldAddTwoMatricesOfSameDimensions() {
    Matrix matrix1 = matrix_2x2(1, 2, 3, 4);
    Matrix matrix2 = matrix_2x2(2, 1, 4, 3);
    Matrix resultantMatrix = matrix_2x2(3, 3, 7, 7);
    assertEquals(resultantMatrix, matrix1.add(matrix2));
  }

  @Test
  public void shouldNotAddMatricesOfDifferentDimensions() {
    Matrix matrix1 = matrix_2x2(1, 2, 3, 4);
    Matrix matrix2 = matrix_3x2(2, 1, 4, 3, 5, 6);
    assertEquals(null, matrix1.add(matrix2));
  }

  @Test
  public void shouldSubtractTwoMatricesOfSameDimensions() {
    Matrix matrix1 = matrix_2x2(2, 5, 4, 3);
    Matrix matrix2 = matrix_2x2(1, 2, 3, 4);
    Matrix resultantMatrix = matrix_2x2(1, 3, 1, -1);
    assertEquals(resultantMatrix, matrix1.subtract(matrix2));
  }

  @Test
  public void shouldNotSubtractMatricesOfDifferentDimensions() {
    Matrix matrix1 = matrix_2x2(1, 2, 3, 4);
    Matrix matrix2 = matrix_3x2(2, 1, 4, 3, 5, 6);
    assertEquals(null, matrix1.subtract(matrix2));
  }

  @Test
  public void shouldMultiplyTwoMatricesOfSameDimensions() {
    Matrix matrix1 = matrix_2x2(2, 5, 4, 3);
    Matrix matrix2 = matrix_2x2(1, 2, 3, 4);
    Matrix resultantMatrix = matrix_2x2(17, 24, 13, 20);
    assertEquals(resultantMatrix, matrix1.multiply(matrix2));
  }

  @Test
  public void shouldMultiplyTwoMatricesOfDifferentDimensions() {
    int[][] elements1 = { { 1, 2, 3 }, { 4, 5, 6 } };
    Matrix matrix1 = new Matrix(2, 3, elements1);
    Matrix matrix2 = matrix_3x2(7, 8, 9, 10, 11, 12);
    Matrix resultantMatrix = matrix_2x2(58, 64, 139, 154);
    assertEquals(resultantMatrix, matrix1.multiply(matrix2));
  }

  @Test
  public void shouldNotMultiplyMatricesOfWrongDimensions() {
    Matrix matrix1 = matrix_2x2(1, 2, 3, 4);
    int[][] elements2 = { { 2, 1 }, { 4, 3 }, { 5, 6 } };
    Matrix matrix2 = new Matrix(3, 2, elements2);
    assertEquals(null, matrix1.multiply(matrix2));
  }

  private Matrix matrix_2x2(int a, int b, int c, int d) {
    return new Matrix(2, 2, new int[][] { { a, b }, { c, d } });
  }

  private Matrix matrix_3x2(int a, int b, int c, int d, int e, int f) {
    return new Matrix(3, 2, new int[][] { { a, b }, { c, d }, { e, f } });
  }
}
