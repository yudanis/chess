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
public class Bishop extends Pieces {

    public Bishop(ColorCode colorCode) {
        this.setName("Bishop");
        if(colorCode == ColorCode.BLACK)
            this.setIcon("Chess_BishopBlack.png");
        else
            this.setIcon("Chess_BishopWhite.png");
        this.clr = colorCode;
    }

    @Override
    public ArrayList<String> GetPossibleMove(int curRow, int curCol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
