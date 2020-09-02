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
        
        var possible = new Queen(clr).GetPossibleMove(curRow, curCol);
        Object[] obj = possible.toArray();
        for(Object o: obj){
            int row = Integer.parseInt(o.toString().substring(0, 1));
            int col =  Integer.parseInt(o.toString().substring(1, 2));
            Pieces target = Chess.GetInstance().pieces.get(o);
           // boolean haveBackup = target.IsHaveBackup();
            if(Math.abs(curRow - row) > 1 || Math.abs(curCol -  col) > 1)
                possible.remove(o);
            
        }
        return possible;
    }

}
