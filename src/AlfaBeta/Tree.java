package AlfaBeta;


public class Tree {

    public AlfaBeta alf = new AlfaBeta();
    public Node max1;

    public Tree() {
        fillTree();
    }
    
    public void fillTree(){
    Node t1 = new Node();
    t1.value  = 9;
    t1.depth  = 2;
    t1.isTerminal  = true;
    t1.isMax = true;
    t1.isMin = false;
    
    Node t2 = new Node();
    t2.value  = 8;
    t2.depth  = 2;
    t2.isTerminal  = true;
    t2.isMax = true;
    t2.isMin = false;
    
    Node t3 = new Node();
    t3.value  = 7;
    t3.depth  = 2;
    t3.isTerminal  = true;
    t3.isMax = true;
    t3.isMin = false;
    
    Node min1 = new Node();
    min1.isTerminal  = false;
    min1.depth  = 1;
    min1.isMin = true;
    min1.isMax = false;
    
    min1.children.add (t1);

    min1.children.add (t2);

    min1.children.add (t3);
    
    Node t4 = new Node();
    t4.value  = 6;
    t4.depth  = 2;
    t4.isTerminal  = true;
    t4.isMax = true;
    t4.isMin = false;
    
    Node t5 = new Node();
    t5.value  = 5;
    t5.depth  = 2;
    t5.isTerminal  = true;
    t5.isMax = true;
    t5.isMin = false;
    
    Node t6 = new Node();
    t6.value  = 4;
    t6.depth  = 2;
    t6.isTerminal  = true;
    t6.isMax = true;
    t6.isMin = false;
    
    Node min2 = new Node();
    min2.isMin  = true;
    min2.isMax = false;
    min2.isTerminal  = false;
    min2.depth  = 1;

    min2.children.add (t4);

    min2.children.add (t5);

    min2.children.add (t6);
    
    Node t7 = new Node();

    t7.value  = 3 ;
    t7.depth  = 2;
    t7.isTerminal  = true;
    t7.isMax = true;
    t7.isMin = false;
    
    Node t8 = new Node();
    t8.value  = 2;
    t8.depth  = 2;
    t8.isTerminal  = true;
    t8.isMax = true;
    t8.isMin = false;
    
    Node t9 = new Node();
    t9.value  = 1;
    t9.depth  = 2;
    t9.isTerminal  = true;
    t9.isMax = true;
    t9.isMin = false;
    
    Node min3 = new Node();
    min3.isMin  = true;
    min3.isMax = false;
    min3.isTerminal  = false;
    min3.depth  = 1;
    

    min3.children.add (t7);

    min3.children.add (t8);

    min3.children.add (t9);
    
    max1 = new Node();
    max1.isMax  = true;
    max1.isMin = false;
    max1.isTerminal  = false;
    max1.depth  = 0;

    max1.children.add (min1);

    max1.children.add (min2);

    max1.children.add (min3);

   }
    

   
}
