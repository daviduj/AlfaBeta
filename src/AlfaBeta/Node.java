package AlfaBeta;

import java.util.ArrayList;

public class Node {

    public boolean isMin;
    public boolean isMax;
    public boolean isTerminal;
    public int value;
    public int depth;
    public ArrayList<Node> children = new ArrayList<Node>();

    public Node() {
    }
}