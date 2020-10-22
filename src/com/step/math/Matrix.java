package com.step.math;

public class Matrix {
  private int row;
  private int col;
  private int[][] data;

  public Matrix(int row, int col) {
    this.row = row;
    this.col = col;
    this.data = new int[row][col];
  }

  public Matrix(int row, int col, int[][] data) {
    this.row = row;
    this.col = col;
    this.data = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        this.data[i][j] = data[i][j];
      }
    }
  }

  public Matrix add(Matrix matrix) {
    if (matrix.row != this.row || matrix.col != this.col) {
      return null;
    }
    Matrix result = new Matrix(this.row, this.col);
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col; j++) {
        result.data[i][j] = matrix.data[i][j] + this.data[i][j];
      }
    }
    return result;
  }

  public Matrix subtract(Matrix matrix) {
    if (matrix.row != this.row || matrix.col != this.col) {
      return null;
    }
    Matrix result = new Matrix(this.row, this.col);
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col; j++) {
        result.data[i][j] = this.data[i][j] - matrix.data[i][j];
      }
    }
    return result;
  }

  public Matrix multiply(Matrix matrix) {
    if (this.col != matrix.row) {
      return null;
    }
    Matrix result = new Matrix(this.row, matrix.col);
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < matrix.col; j++) {
        for (int k = 0; k < matrix.row; k++) {
          result.data[i][j] += (this.data[i][k] * matrix.data[k][j]);
        }
      }
    }
    return result;
  }

  private boolean isDeepEqual(Matrix matrix) {
    for (int i = 0; i < this.row; i++) {
      for (int j = 0; j < this.col; j++) {
        if (this.data[i][j] != matrix.data[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Matrix {");
    for (int[] row : this.data) {
      sb.append("\n  ");
      for (int element : row) {
        sb.append(element).append(" ");
      }
    }
    sb.append("\n}");
    return sb.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Matrix)) {
      return false;
    }
    Matrix matrix2 = (Matrix) other;
    if (this.row != matrix2.row || this.col != matrix2.col) {
      return false;
    }
    return this.isDeepEqual(matrix2);
  }
}
