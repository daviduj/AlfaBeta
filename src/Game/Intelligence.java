package Game;

/**
 *
 * @author David
 */
public class Intelligence {

    public Node rootNode;

    public Intelligence() {
        this.rootNode = new Node();
    }

    public Intelligence(Board b) {
        Board newB = new Board(b);
        rootNode = new Node(newB);

    }

    public int Move() {
        int max = -10;
        Node bestNode = new Node();
        for (int x = 0; x <= 8; x++) {
            Node n = new Node();
            n.copy(rootNode);
            if (n.board.SetMove(x) == true) {
                n.moveBox = x;
                int val = minimaxAB(n, true, -10, 10);
                if (val >= max) {
                    max = val;
                    bestNode = n;
                }

            }
        }
        return bestNode.moveBox;

    }

    private int minimaxAB(Node node, boolean min, int alpha, int beta) {
        if (boardPoint(node) != -2) {

            node.point = boardPoint(node);
            //retorna -1 0 1 
            return boardPoint(node);

        }
        // Max
        if (min == false) {
            for (int x = 0; x < 9; x++) {
                Node n = new Node();
                n.copy(node);
                if (n.board.SetMove(x) == true) {
                    n.moveBox = x;
                    int val = minimaxAB(n, true, alpha, beta);

                    if (alpha < val) {
                        alpha = val;
                    }
                    if (alpha > beta) {
                        break;
                    }
                }
            }
            return alpha;
        } // Min  
        else {
            for (int x = 0; x < 9; x++) {
                Node n = new Node();
                n.copy(node);
                if (n.board.SetMove(x) == true) {
                    n.moveBox = x;
                    int val = minimaxAB(n, false, alpha, beta);

                    if (val < beta) {
                        beta = val;
                    }
                    if (alpha > beta) {

                        break;
                    }
                }

            }
            return beta;
        }

    }

    private int boardPoint(Node n) {
        //player 1 wins
        if (n.board.CheckCondition() == 1) {
            return -1;
        }
        //player 2 wins
        if (n.board.CheckCondition() == 2) {
            return 1;
        }
        // draw
        if (n.board.CheckCondition() == -1) {
            return 0;
        }
        return -2;

    }
}
