package pieces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author DELL
 */
public class Bishop extends Pieces {

    public Bishop(ColorCode colorCode) {
        this.setName("Bishop");
        if (colorCode == ColorCode.BLACK) {
            this.setIcon("Chess_BishopBlack.png");
        } else {
            this.setIcon("Chess_BishopWhite.png");
        }
        this.clr = colorCode;
    }

    @Override
    public ArrayList<String> GetPossibleMove(int curRow, int curCol) {
        ArrayList<String> possible = new ArrayList<>();
        Chess chess = Chess.GetInstance();
        String targetpos = "";
        int start = 1;
        ArrayList<String> targetToCheck = null;
        boolean needToCheck = false;
        do {
            needToCheck = false;
            if (targetToCheck == null) {
                targetToCheck = new ArrayList<>();
                
                targetToCheck.add(0,curRow == 7 || curCol == 7 ? null : "" + Math.min(7, curRow + start) + "" + Math.min(7,curCol + start));
                targetToCheck.add(1, curRow == 0|| curCol == 7 ? null :"" + Math.max(0,curRow - start) + "" + Math.min(7,curCol + start));
                targetToCheck.add(2, curRow == 7 || curCol == 0 ? null :"" + Math.min(7,curRow + start) + "" + Math.max(0,curCol - start));
                targetToCheck.add(3, curRow == 0 || curCol == 0 ? null :"" + Math.max(0,curRow - start) + "" + Math.max(0,curCol - start));

            } else {
                if (targetToCheck.get(0) != null) 
                    targetToCheck.set(0, "" +Math.min(7,curRow + start) + "" + Math.min(7,curCol + start));
                if (targetToCheck.get(1) != null)
                    targetToCheck.set(1, "" + Math.max(0,curRow - start) + "" + Math.min(7,curCol + start));
                if (targetToCheck.get(2) != null)
                    targetToCheck.set(2, "" + Math.min(7,curRow + start) + "" + Math.max(0,curCol - start));
                if (targetToCheck.get(3) != null)
                    targetToCheck.set(3, "" + Math.max(0,curRow - start) + "" + Math.max(0,curCol - start));
            }
            for (int i = 0; i < targetToCheck.size(); i++) {
                targetpos = targetToCheck.get(i);
                if (targetpos != null) {
                    needToCheck = true;
                    Pieces target = chess.pieces.get(targetpos);
                    if (target == null || target.clr != this.clr) {
                        possible.add(targetpos);
                    }

                    if (target != null || targetpos.contains("0") || targetpos.contains("7")) {
                        targetToCheck.set(i, null);
                    }
                    
                }
            }

            start++;

        } while (needToCheck);
        return possible;
    }

  

}
