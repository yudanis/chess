package pieces;

import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public abstract class Pieces {

   

    public enum ColorCode {
        WHITE, BLACK
    };
    String name;
    String iconName;
    ColorCode clr;
    //Chess chess = Chess.GetInstance();
    public ArrayList<String> possibleMove;
    String position = "";
    ArrayList<Pieces> backupPieces;
    public Pieces() {

    }

    public Pieces(String name) {
        this.name = name;
    }

    public Pieces(ColorCode colorCode, String position) {
        this.clr = colorCode;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setIcon(String path) {
        this.iconName = path;
    }

    public String getIcon() {
        return iconName;
    }

    public Pieces SetPosition(String position) {
        this.position = position;
        return this;
    }
    public void AddBackup(Pieces pieces){
        backupPieces.add(pieces);
    }
    public void RemoveBackup(Pieces pieces){
        backupPieces.remove(pieces);
    }
    public abstract ArrayList<String> GetPossibleMove(int curRow, int curCol);
    boolean IsHaveBackup() {
       return backupPieces != null && backupPieces.size() > 0;
    }

}
