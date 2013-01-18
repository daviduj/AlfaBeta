package AlfaBeta;

public class Board {

    public int[] board = new int[9];
    public int symbol = 1;

    public Board() {
        for (int i = 0; i < 9; i++) {
            board[i] = 2;
        }
    }

    public boolean markPosition(int boxNo, int piece) {
        symbol = piece;
        board[boxNo] = symbol;
        return true;
    }

    public boolean isEmptySquare(int boxNo) {
        if (board[boxNo] != 2) {
            return false;
        }
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == 2) {
                return false;
            }
        }
        return true;
    }

    public int boardPoint(int side) {
        //player 1 wins
        if (isAwiner(side) == 1) {
            return 3;
        }
        //player 2 wins
        if (isAwiner(side) == 0) {
            return 0;
        }
        // empty cases
        if (isAwiner(side) == 2) {
            return 2;
        }
        // draw
        return 1;
    }

    private int isAwiner(int side) {

        if ((board[0] == board[1] & board[1] == board[2] & board[2] != 2) && board[0] == side) {
            return board[0];
        } else if ((board[3] == board[4] & board[4] == board[5] & board[5] != 2) && board[3] == side) {
            return board[3];
        } else if ((board[6] == board[7] & board[7] == board[8] & board[8] != 2) && board[6] == side) {
            return board[6];
        } else if ((board[0] == board[3] & board[3] == board[6] & board[6] != 2) && board[0] == side) {
            return board[0];
        } else if ((board[1] == board[4] & board[4] == board[7] & board[7] != 2) && board[1] == side) {
            return board[1];
        } else if ((board[2] == board[5] & board[5] == board[8] & board[8] != 2) && board[2] == side) {
            return board[2];
        } else if ((board[0] == board[4] & board[4] == board[8] & board[8] != 2) && board[0] == side) {
            return board[0];
        } else if ((board[2] == board[4] & board[4] == board[6] & board[6] != 2) && board[2] == side) {
            return board[2];
        } else {
            for (int x = 0; x < 9; x++) {
                if (board[x] == 2) {
                    return 2;
                }
            }
        }

        return 3;
    }

    public void Print() {
        for (int x = 0; x < 3; x++) {
            System.out.println();
            for (int y = 0; y < 3; y++) {
                System.out.print("|");
                if (board[y + (3 * x)] != 2) {
                    if (board[y + (3 * x)] == 1) {
                        System.out.print("[X]");
                    } else {
                        System.out.print("[0]");
                    }
                } else {
                    System.out.print(" " + (y + (3 * x)) + " ");
                }
                System.out.print("|");

            }
        }

    }
}