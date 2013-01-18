package AlfaBeta;

public class AlfaBeta {

    public Board board;

    public AlfaBeta() {
        board = new Board();
    }

    public int alphaBetaSearch(Node state, boolean max, int depth, int alfa, int beta) {

        if (state.isTerminal) {
            return state.value;
        } else {

            if (state.isMax == true) {

                for (Node n : state.children) {

                    alfa = Math.max(alfa, alphaBetaSearch(n, state.isMax, depth + 1, alfa, beta));
                    state.value = alfa;

                    if (beta <= alfa) {
                        break;
                    }
                }

                return alfa;
            } else {
                for (Node n : state.children) {
                    beta = Math.min(beta, alphaBetaSearch(n, state.isMin, depth + 1, alfa, beta));
                    state.value = beta;

                    if (beta <= alfa) {
                        break;
                    }
                }

                return beta;
            }

        }
    }

    public int minimax(Node state) {

        if (state.isTerminal) {
            return state.value;
        }
        int value = -99999;

        for (Node n : state.children) {
            value = Math.max(value, -minimax(n));

        }
        return value;
    }

    public BestMove alfaBetaPruning() {
        // computer = 1, alfa , beta
        BestMove b = alfaBetaPruning(1, 0, 3);
        return b;
    }

    public BestMove alfaBetaPruning(int player, int alfa, int beta) {

        int value;
        BestMove reply;
        int bestPosition = 0;
        int evalution;
        int opponent;

        if ((evalution = positionValue()) != 2) {
            return new BestMove(evalution);
        }

        if (player == 1) {
            opponent = 0;
            value = alfa;
        } else {
            opponent = 1;
            value = beta;
        }

        for (int position = 0; position < 9; position++) {
            if (board.isEmptySquare(position)) {
                board.markPosition(position, player);
                reply = alfaBetaPruning(opponent, alfa, beta);
                board.markPosition(position, 2);
                if (player == 1 && value < reply.val
                        || player == 0 && reply.val < value) {

                    if (player == 1) {
                        value = reply.val;
                        alfa = value;

                    } else {
                        value = reply.val;
                        beta = value;

                    }
                    bestPosition = position;

                    if (alfa >= beta) {
                        break;  // Refutation
                    }
                }
            }
        }

        return new BestMove(value, bestPosition);

    }

    private int positionValue() {
        return board.boardPoint(1) == 3 ? 3
                : board.boardPoint(0) == 0 ? 0
                : board.isFull() ? 1 : 2;
    }
}
