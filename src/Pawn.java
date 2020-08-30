/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author DELL
 */
public class Pawn extends Pieces {

    public Pawn(ColorCode colorCode) {
        this.setName("Pawn");
        this.clr = colorCode;
        if (colorCode == ColorCode.BLACK) {
            this.setIcon("Chess_PawnBlack.png");
        } else {
            this.setIcon("Chess_PawnWhite.png");
        }
    }

    @Override
    public ArrayList<String> GetPossibleMove(int curRow, int curCol) {

        ArrayList<String> posible = new ArrayList<>();
        if (this.clr == ColorCode.BLACK) {
            posible.add("" + (curRow + 1) + curCol);
            posible.add("" + (curRow + 1) + (curCol + 1));
            posible.add("" + (curRow + 1) + (curCol - 1));
        }

        if (this.clr == ColorCode.WHITE) {
            posible.add("" + (curRow - 1) + curCol);
            posible.add("" + (curRow - 1) + (curCol + 1));
            posible.add("" + (curRow - 1) + (curCol - 1));
        }
        
        Iterator<String> it =  posible.iterator();
        while(it.hasNext()){
            String pos = it.next();
            if(Chess.GetInstance().pieces.containsKey(pos))
                posible.remove(pos);
        }
        return posible;
    }

}
