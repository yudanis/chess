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
                
                targetToCheck.add(0,curRow + start > 7  ? null : "" + Math.min(7, curRow + start) + "" +curCol);
                targetToCheck.add(1, curCol + start > 7 ? null :"" + curRow+ "" + Math.min(7,curCol + start));
                targetToCheck.add(2, curCol - start < 0 ? null :"" + curRow + "" + Math.max(0,curCol - start));
                targetToCheck.add(3, curRow - start < 0  ? null :"" + Math.max(0,curRow - start) + "" +curCol);

            } else {
                if (targetToCheck.get(0) != null) 
                    targetToCheck.set(0,curRow + start > 7  ?null: "" + Math.min(7, curRow + start) + "" +curCol);
                if (targetToCheck.get(1) != null)
                    targetToCheck.set(1, curCol + start > 7 ? null :"" +  curRow+ "" + Math.min(7,curCol + start));
                if (targetToCheck.get(2) != null)
                    targetToCheck.set(2, curCol - start < 0 ? null :"" + curRow + "" + Math.max(0,curCol - start));
                if (targetToCheck.get(3) != null)
                    targetToCheck.set(3,curRow - start < 0   ? null :"" +  Math.max(0,curRow - start) + "" +curCol);
            }
            for (int i = 0; i < targetToCheck.size(); i++) {
                targetpos = targetToCheck.get(i);
                if (targetpos != null) {
                    needToCheck = true;
                    Pieces target = chess.pieces.get(targetpos);
                    if (target == null || target.clr != this.clr) {
                        possible.add(targetpos);
                    }

                    if (target != null) {
                        targetToCheck.set(i, null);
                    }
                    
                }
            }

            start++;

        } while (needToCheck);
        return possible;

//        ArrayList<String>possible = new ArrayList<>();
//        GetPossible(curRow, curCol, true,  possible);
//        GetPossible(curRow, curCol, false, possible);
//
//        return possible;

    }

    private void GetPossible(int curRow, int curCol, boolean isRow,  ArrayList<String> possible) {
        Chess chess = Chess.GetInstance();
        String targetpos = "";
        Pieces target = null;
        int start = 1;
        int targetUp = 0;
        int targetDown = 0;
        boolean checkUp = true;
        boolean checkdDown = true;
        do {
            targetUp = (isRow? curRow:curCol) + start;
            targetpos = (isRow? targetUp: curRow) + "" + (isRow ? curCol : targetUp);
            target = chess.pieces.get(targetpos);

            if (checkUp) {
                if (target == null || target.clr != this.clr) {
                    possible.add(targetpos);
                }

                if (target != null) {
                    checkUp = false;
                }
            }
            targetDown = (isRow ? curRow : curCol) - start;
            targetpos = (isRow? targetDown : curRow)+ "" + (isRow ? curCol: targetDown);
            target = chess.pieces.get(targetpos);
            if (checkdDown) {
                if (target == null || target.clr != this.clr) {
                    possible.add(targetpos);
                }
                if (target != null) {
                    checkdDown = false;
                }
            }
            start++;

        } while (targetUp < 8 || targetDown >= 0);
       
    }
}
