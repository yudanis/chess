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
public class Rook extends Pieces {

    public Rook(ColorCode colorCode) {
        this.setName("Rook");
        this.clr = colorCode;
        if (colorCode == ColorCode.BLACK) {
            this.setIcon("Chess_RookBlack.png");
        } else {
            this.setIcon("Chess_RookWhite.png");
        }
        
    }
    

    @Override
    public ArrayList<String> GetPossibleMove(int curRow, int curCol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
