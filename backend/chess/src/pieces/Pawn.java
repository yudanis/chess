package pieces;

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

            boolean inStartPosition = (this.clr == ColorCode.BLACK && curRow == 1);
            if (inStartPosition) {
                posible.add("" + (curRow + 2) + curCol);
            }
        }

        if (this.clr == ColorCode.WHITE) {
            posible.add("" + (curRow - 1) + curCol);
            posible.add("" + (curRow - 1) + (curCol + 1));
            posible.add("" + (curRow - 1) + (curCol - 1));

            boolean inStartPosition = (this.clr == ColorCode.WHITE && curRow == 6);
            if (inStartPosition) {
                posible.add("" + (curRow - 2) + curCol);
            }
        }

        Object[] objs = posible.toArray();
        for (Object o : objs) {
            Pieces obstacle = Chess.GetInstance().pieces.get(o.toString());
            if (obstacle != null && obstacle.clr == this.clr) {
                posible.remove(o);
            }

            String col = this.position.substring(1, 2);
            String col2 = o.toString().substring(1, 2);

            if (obstacle != null && col.equals(col2)) {
                posible.remove(o);
            }
            if (obstacle == null && col.equals(col2) == false) {
                posible.remove(o);
            }

        }

        return posible;
    }

}
