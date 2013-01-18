package AlfaBeta;


public class BestMove {
    int position;
    int val;

    public BestMove( int v )
      { this( v, 0 ); }
    
    public BestMove( int v, int p )
      { val = v; position = p; }
}
