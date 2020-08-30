

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

   

    public enum ColorCode{WHITE, BLACK};
    String name;
    String iconName;
    ColorCode clr;
    //Chess chess = Chess.GetInstance();
    public ArrayList<String> possibleMove;
    public Pieces(){
        
    }
    public Pieces(String name) {
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
    public void setIcon(String path){
        this.iconName = path;
    }

    public String getIcon() {
        return iconName;
    }
  
    public abstract ArrayList<String> GetPossibleMove(int curRow, int curCol);

}
