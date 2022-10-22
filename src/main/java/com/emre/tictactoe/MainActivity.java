package com.emre.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String PLAYER_1 = "X";
    static final String PLAYER_2 = "O";
    boolean player1Turn = true;

    byte[][] board = new byte[3][3];
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textview);


        TableLayout table = findViewById(R.id.board);
        for (int i = 0; i < 3; i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            for (int j = 0; j < 0; j++) {
                Button button = (Button) row.getChildAt(j);
                button.setOnClickListener(new CellListener(i, j));
            }

        }
    }

    class CellListener implements View.OnClickListener {
        int row, col;

        public CellListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void onClick(View v) {
            if (isValidMove(row, col)) {
                if (player1Turn) {
                    ((Button) v).setText(PLAYER_1);
                    board[row][col] = 1;
                    player1Turn = false;
                } else {
                    ((Button) v).setText(PLAYER_2);
                    board[row][col] = 2;
                    player1Turn = true;
                }
            }
            gameEnded(board);
        }

        public boolean isValidMove(int row, int col) {
            if (board[row][col] == 1 || board[row][col] == 2) return false;
            else {
                return true;
            }
        }

        public void gameEnded(byte[][] board) {

            for (int j = 0; j < 3; j++) {
                //check cols
                if ((board[j][0] == board[j][1]) && (board[j][0] == board[j][2])) {
                    if (board[j][0] == 1) {
                        result.setText("Player1 wins");
                    } else {
                        result.setText("Player2 wins");
                    }

                }
                //check rows
                else if ((board[0][j] == board[1][j]) && (board[0][j] == board[2][j])) {
                    if (board[0][j] == 1) {
                        result.setText("Player1 wins");
                    } else {
                        result.setText("Player2 wins");
                    }

                }
            }

            // check crosses
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
                if (board[0][0] == 1) {
                    result.setText("Player1 wins");
                } else {
                    result.setText("Player2 wins");
                }
            }
            else if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
                if (board[0][0] == 1) {
                    result.setText("Player1 wins");
                } else {
                    result.setText("Player2 wins");
                }
            }
        }
    }
}
