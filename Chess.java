/*
 * a simple game of Chess
 */
public class Chess {

    public final int None = 0;
    public final int King = 1;
    public final int Pawn = 2;
    public final int Knight = 3;
    public final int Bishop = 4;
    public final int Rook = 5;
    public final int Queen = 6;
    public final int White = 8;
    public final int Black = 16;

    public static int[] boardPos;

    public static void main (String[] args) {
        boardPos = new int[64];
        Chess chess = new Chess();
        chess.StartGame();
    }

    public void StartGame(){
        boardPos[0] = King|White;
        System.out.println(boardPos[0]);
    }
    
    public static void loadFromFen (String fen){
        

    }
}