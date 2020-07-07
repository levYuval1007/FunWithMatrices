package com.example.funwithmatrices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import williamfiset.MatrixPower;
import williamfiset.RotateSquareMatrixInplace;

public class MainActivity extends AppCompatActivity {

    private EditText et00, et01, et02, et10, et11, et12, et20, et21, et22;
    private int[][] matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findetviews();
        matrix = new int[3][3];
    }

    private void findetviews() {
        et00 = findViewById(R.id.et_0_0);

        et01 = findViewById(R.id.et_0_1);

        et02 = findViewById(R.id.et_0_2);

        et10 = findViewById(R.id.et_1_0);

        et11 = findViewById(R.id.et_1_1);

        et12 = findViewById(R.id.et_1_2);

        et20 = findViewById(R.id.et_2_0);

        et21 = findViewById(R.id.et_2_1);

        et22 = findViewById(R.id.et_2_2);
    }

    public void powerMatrix(View view) {
        try {
            retrieveNumbers();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "please fill all numbers before" +
                            " action",
                    Toast.LENGTH_LONG).show();
            return;
        }
        matrix = convertMatrixToInt(MatrixPower.matrixPower(convertMatrixToLong(matrix), 2));
        displayNumbers();
    }

    private int[][] convertMatrixToInt(long[][] matrixPower) {
        int[][] newMat = new int[3][3];
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                newMat[i][j] = (int) matrixPower[i][j];
            }
        }
        return newMat;
    }

    private long[][] convertMatrixToLong(int[][] matrix) {
        long[][] newMat = new long[3][3];
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                newMat[i][j] = Long.valueOf(matrix[i][j]);
            }
        }
        return newMat;
    }

    private void retrieveNumbers() {
        matrix[0][0] = Integer.parseInt(et00.getText().toString());
        matrix[0][1] = Integer.parseInt(et01.getText().toString());
        matrix[0][2] = Integer.parseInt(et02.getText().toString());
        matrix[1][0] = Integer.parseInt(et10.getText().toString());
        matrix[1][1] = Integer.parseInt(et11.getText().toString());
        matrix[1][2] = Integer.parseInt(et12.getText().toString());
        matrix[2][0] = Integer.parseInt(et20.getText().toString());
        matrix[2][1] = Integer.parseInt(et21.getText().toString());
        matrix[2][2] = Integer.parseInt(et22.getText().toString());
    }

    private void displayNumbers() {
        et00.setText(String.valueOf(matrix[0][0]));
        et01.setText(String.valueOf(matrix[0][1]));
        et02.setText(String.valueOf(matrix[0][2]));

        et10.setText(String.valueOf(matrix[1][0]));
        et11.setText(String.valueOf(matrix[1][1]));
        et12.setText(String.valueOf(matrix[1][2]));

        et20.setText(String.valueOf(matrix[2][0]));
        et21.setText(String.valueOf(matrix[2][1]));
        et22.setText(String.valueOf(matrix[2][2]));
    }

    public void rotateMatrix(View view) {
        try {
            retrieveNumbers();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "please fill all numbers before" +
                            " action",
                    Toast.LENGTH_LONG).show();
            return;
        }
        RotateSquareMatrixInplace.rotate(matrix);
        displayNumbers();
    }
}
