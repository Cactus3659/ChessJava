/*
 * a simple game of Chess
 */

import java.util.*;

public class Chess {


    //default position in fen notation
    public final static String StartPos = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

    //values for pieces
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
        chess.loadFromFen(StartPos);
        chess.PrintBoard();
    }

    /*
     * Display board in terminal
     */

    public void PrintBoard(){
        for(int j = 7; j >= 0; j--){
            for(int i = 7; i >= 0; i--){
            System.out.printf("%3d",boardPos[j*8 + i]);
            }
            System.out.println();
        }

    }

    public void AlgebraicNotation(){
        

    }
    
    /*
     * Load board position from a fen notation string
     */

    public void loadFromFen (String fen){
        Dictionary<Character,Integer> pieceTypeLetter= new Hashtable<>();
        pieceTypeLetter.put('k', King);
        pieceTypeLetter.put('p', Pawn);
        pieceTypeLetter.put('n', Knight);
        pieceTypeLetter.put('b', Bishop);
        pieceTypeLetter.put('r', Rook);
        pieceTypeLetter.put('q', Queen);


        char[] fenSplit = fen.toCharArray();
        int file = 0, rank = 7;

        for (char letter : fenSplit) {
            if(letter == '/'){
                file = 0;
                rank--;
            }
            else if (Character.isDigit(letter)) {
                int numberFromChar = letter;
                file += numberFromChar;
            }
            else {
                int colour = (Character.isUpperCase(letter)) ? White : Black;
                int type = pieceTypeLetter.get(Character.toLowerCase(letter));
                boardPos[rank * 8 + file] = type|colour;
                file ++;
            }
            
        }

    }
}