

import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class Chess {

    private static Chess instance = null;
    public static Chess GetInstance(){
        if(instance == null)
            instance = new Chess();
        return instance;
    }
    HashMap<String, Pieces> pieces = new HashMap<>();
    Pieces selectedPiece = null;
    public Chess() {
        Pieces.ColorCode black = Pieces.ColorCode.BLACK;
        Pieces.ColorCode white = Pieces.ColorCode.WHITE;
        pieces.put("00", new Rook(black));
        pieces.put("01", new Knight(black));
        pieces.put("02", new Bishop(black));
        pieces.put("03", new Queen(black));
        pieces.put("04", new King(black));
        pieces.put("05", new Bishop(black));
        pieces.put("06", new Knight(black));
        pieces.put("07", new Rook(black));

        pieces.put("10", new Pawn(black));
        pieces.put("11", new Pawn(black));
        pieces.put("12", new Pawn(black));
        pieces.put("13", new Pawn(black));
        pieces.put("14", new Pawn(black));
        pieces.put("15", new Pawn(black));
        pieces.put("16", new Pawn(black));
        pieces.put("17", new Pawn(black));

        pieces.put("70", new Rook(white));
        pieces.put("71", new Knight(white));
        pieces.put("72", new Bishop(white));
        pieces.put("73", new Queen(white));
        pieces.put("74", new King(white));
        pieces.put("75", new Bishop(white));
        pieces.put("76", new Knight(white));
        pieces.put("77", new Rook(white));

        pieces.put("60", new Pawn(white));
        pieces.put("61", new Pawn(white));
        pieces.put("62", new Pawn(white));
        pieces.put("63", new Pawn(white));
        pieces.put("64", new Pawn(white));
        pieces.put("65", new Pawn(white));
        pieces.put("66", new Pawn(white));
        pieces.put("67", new Pawn(white));
    }

  

    void Select(Pieces selected, int row, int col) {
        this.selectedPiece = selected;
        this.selectedPiece.possibleMove = selected.GetPossibleMove(row, col);
    }
    
}
