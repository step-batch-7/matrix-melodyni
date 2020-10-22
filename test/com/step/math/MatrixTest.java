package com.step.math;

import static org.junit.Assert.*;
import org.junit.Test;


public class MatrixTest {
  public void representsMatrixInString() {
    int[][] elements = {{1,2},{3,4}};
    Matrix matrix = new Matrix(2,2,elements);
    String actual = matrix.toString();
    String expected = "Matrix {\n  1 2 \n  3 4 \n}";
    assertEquals(actual, expected);
  }
}