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
public class Knight extends Pieces {

    public Knight(ColorCode colorCode) {
        this.setName("Knight");
        this.clr = colorCode;
        if (colorCode == ColorCode.BLACK) {
            this.setIcon("Chess_KnightBlack.png");
        } else {
            this.setIcon("Chess_KnightWhite.png");
        }
    }

    @Override
    public ArrayList<String> GetPossibleMove(int curRow, int curCol) {
        ArrayList<String> possible = new ArrayList<>();
        possible.add("" + (curRow + 1) + (curCol + 2));
        possible.add("" + (curRow + 1) + (curCol - 2));
        possible.add("" + (curRow - 1) + (curCol + 2));
        possible.add("" + (curRow - 1) + (curCol - 2));
        possible.add("" + (curRow + 2) + (curCol + 1));
        possible.add("" + (curRow + 2) + (curCol - 1));
        possible.add("" + (curRow - 2) + (curCol + 1));
        possible.add("" + (curRow - 2) + (curCol - 1));

        Object[] obj = possible.toArray();
        for (Object o : obj) {
            System.out.println("" + o);
            Pieces target = Chess.GetInstance().pieces.get(o);
            if (target != null && target.clr.equals(this.clr)) {
                possible.remove(o);
            }

            if (o.toString().contains("-")) {
                possible.remove(o);
            } else {
                int row = Integer.parseInt(o.toString().substring(0, 1));
                int col = Integer.parseInt(o.toString().substring(1, 2));
                if (row < 0 || row > 7 || col < 0 || col > 7) {
                    possible.remove(o);
                }
            }
        }
        return possible;
    }

}
