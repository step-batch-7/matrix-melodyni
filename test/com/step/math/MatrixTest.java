package com.step.math;

import static org.junit.Assert.*;
import org.junit.Test;


public class MatrixTest {
  @Test
  public void representsMatrixInString() {
    int[][] elements = {{1,2},{3,4}};
    Matrix matrix = new Matrix(2,2,elements);
    String actual = matrix.toString();
    String expected = "Matrix {\n  1 2 \n  3 4 \n}";
    assertEquals(actual, expected);
  }

  @Test
  public void equatesTwoMatricesThatAreEqual() {
    int[][] elements1 = {{1,2},{3,4}};
    Matrix matrix1 = new Matrix(2,2,elements1);
    int[][] elements2 = {{1,2},{3,4}};
    Matrix matrix2 = new Matrix(2,2,elements2);
    assertTrue(matrix1.equals(matrix2));
  }

  @Test
  public void equatesTwoMatricesThatAreSameInstance() {
    int[][] elements1 = {{1,2},{3,4}};
    Matrix matrix1 = new Matrix(2,2,elements1);
    assertTrue(matrix1.equals(matrix1));
  }

  @Test
  public void equatesTwoMatricesThatAreNotEqual() {
    int[][] elements1 = {{1,2},{3,4}};
    Matrix matrix1 = new Matrix(2,2,elements1);
    int[][] elements2 = {{3,2},{3,4}};
    Matrix matrix2 = new Matrix(2,2,elements2);
    assertFalse( matrix1.equals(matrix2));
  }

  @Test
  public void equatesTwoMatricesThatAreNotEqualInDimensions() {
    int[][] elements1 = {{1,2},{3,4}};
    Matrix matrix1 = new Matrix(2,2,elements1);
    int[][] elements2 = {{3,2},{3,4},{4,5}};
    Matrix matrix2 = new Matrix(3,2,elements2);
    assertFalse(matrix1.equals(matrix2));
  }

  @Test
  public void equatesMatricesWithOther() {
    int[][] elements1 = {{1,2},{3,4}};
    Matrix matrix1 = new Matrix(2,2,elements1);
    int[][] elements2 = {{3,2},{3,4},{4,5}};
    assertFalse(matrix1.equals(elements2));
  }

  @Test
  public void addsTwoMatrices() {
    int[][] elements1 = {{1,2},{3,4}};
    Matrix matrix1 = new Matrix(2,2,elements1);
    int[][] elements2 = {{2,1},{4,3}};
    Matrix matrix2 = new Matrix(2,2,elements2);
    int[][] elements3 = {{3,3},{7,7}};
    Matrix resultantMatrix = new Matrix(2,2,elements3);
    assertEquals(resultantMatrix,matrix1.add(matrix2));
  }

  @Test
  public void doesNotAddMatricesOfDifferentDimensions() {
    int[][] elements1 = {{1,2},{3,4}};
    Matrix matrix1 = new Matrix(2,2,elements1);
    int[][] elements2 = {{2,1},{4,3},{5,6}};
    Matrix matrix2 = new Matrix(3,2,elements2);
    assertNull(matrix1.add(matrix2));
  }

}