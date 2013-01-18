package Game;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Board b;
        Intelligence i = new Intelligence();

        b = i.rootNode.board;
        b.Print();

        int c = 0;

        while (c < 5) {
            System.out.println("   ");
            b.SetMove(Integer.parseInt(JOptionPane.showInputDialog("digite la jugada")));

            b.Print();

            System.out.println("   ");


            b.SetMove(i.Move());
            b.Print();
            c++;

            if (c == 5) {
                System.exit(0);
            }
        }
    }
}
