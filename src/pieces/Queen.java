package pieces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Queen extends Pieces {
    
    public Queen(ColorCode colorCode) {
        this.setName("Queen");
        this.clr = colorCode;
        if (colorCode == ColorCode.BLACK) {
            this.setIcon("Chess_QueenBlack.png");
        } else {
            this.setIcon("Chess_QueenWhite.png");
        }
    }

    @Override
    public ArrayList<String> GetPossibleMove(int curRow, int curCol) {
        ArrayList<String> possible = new Bishop(clr).GetPossibleMove(curRow, curCol);
         ArrayList<String> list2 = new Rook(clr).GetPossibleMove(curRow, curCol);
        
         possible.addAll(list2);
         return possible;
    }

}
