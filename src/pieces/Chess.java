package pieces;



import pieces.King;
import pieces.Bishop;
import pieces.Pieces;
import pieces.Knight;
import pieces.Rook;
import pieces.Queen;
import pieces.Pawn;
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
        pieces.put("00", new Rook(black).SetPosition("00"));
        pieces.put("01", new Knight(black).SetPosition("01"));
        pieces.put("02", new Bishop(black).SetPosition("02"));
        pieces.put("03", new Queen(black).SetPosition("03"));
        pieces.put("04", new King(black).SetPosition("04"));
        pieces.put("05", new Bishop(black).SetPosition("05"));
        pieces.put("06", new Knight(black).SetPosition("06"));
        pieces.put("07", new Rook(black).SetPosition("07"));

        pieces.put("10", new Pawn(black).SetPosition("10"));
        pieces.put("11", new Pawn(black).SetPosition("11"));
        pieces.put("12", new Pawn(black).SetPosition("12"));
        pieces.put("13", new Pawn(black).SetPosition("13"));
        pieces.put("14", new Pawn(black).SetPosition("14"));
        pieces.put("15", new Pawn(black).SetPosition("15"));
        pieces.put("16", new Pawn(black).SetPosition("16"));
        pieces.put("17", new Pawn(black).SetPosition("17"));

        pieces.put("70", new Rook(white).SetPosition("70"));
        pieces.put("71", new Knight(white).SetPosition("71"));
        pieces.put("72", new Bishop(white).SetPosition("72"));
        pieces.put("73", new Queen(white).SetPosition("73"));
        pieces.put("74", new King(white).SetPosition("74"));
        pieces.put("75", new Bishop(white).SetPosition("75"));
        pieces.put("76", new Knight(white).SetPosition("76"));
        pieces.put("77", new Rook(white).SetPosition("77"));

        pieces.put("60", new Pawn(white).SetPosition("60"));
        pieces.put("61", new Pawn(white).SetPosition("61"));
        pieces.put("62", new Pawn(white).SetPosition("62"));
        pieces.put("63", new Pawn(white).SetPosition("63"));
        pieces.put("64", new Pawn(white).SetPosition("64"));
        pieces.put("65", new Pawn(white).SetPosition("65"));
        pieces.put("66", new Pawn(white).SetPosition("66"));
        pieces.put("67", new Pawn(white).SetPosition("67"));
    }

  
    public HashMap<String, Pieces> GetAll(){
        return pieces;
    }
    public void Select(Pieces selected, int row, int col) {
        if(selected == null)
        {
            this.UnSelect();
            return;
        }
        this.selectedPiece = selected;
        this.selectedPiece.possibleMove = selected.GetPossibleMove(row, col);
    }
    public Pieces GetSelectedPieces(){
        return this.selectedPiece;                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    }
    public void UnSelect(){
        this.selectedPiece = null;
    }

    public void Move(Pieces from, Pieces to, String newpos) {
        if(to == null){
           pieces.remove(from.position);
           pieces.put(newpos, from.SetPosition(newpos));
       }
       else{//capture
           pieces.remove(from.position);
           pieces.put(newpos, from.SetPosition(newpos));
       }
       this.UnSelect();
    }

}
