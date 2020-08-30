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
public class King extends Pieces {

    public King(ColorCode colorCode) {
        this.setName("King");
        this.clr = colorCode;
        if (colorCode == ColorCode.BLACK) {
            this.setIcon("Chess_KingBlack.png");
        } else {
            this.setIcon("Chess_KingWhite.png");
        }
    }

    @Override
    public ArrayList<String> GetPossibleMove(int curRow, int curCol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
