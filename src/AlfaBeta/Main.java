package AlfaBeta;

import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Main {

    public static void main(String[] args) {
        AlfaBeta alf = new AlfaBeta();
        //Tree arbol = new Tree();
        //int res = alf.alphaBetaSearch(arbol.max1, arbol.max1.isMax, 0, -99999, 99999);
        //int mini = alf.minimax(arbol.max1);


        int cont = 0;
        alf.board.Print();
        System.out.println("\n");

        while (cont < 6) {
            alf.board.markPosition(Integer.parseInt(JOptionPane.showInputDialog("jugada ??")), 0);
            alf.board.Print();
            System.out.println("\n");
            BestMove b = alf.alfaBetaPruning();
            alf.board.markPosition(b.position, 1);
            alf.board.Print();
            cont++;
            if (cont == 5) {
                System.exit(0);
            }
        }
        //System.out.println("mini es " + mini);
        //System.out.println("res es  " + res);



    }
}
