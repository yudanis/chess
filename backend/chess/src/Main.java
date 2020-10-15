
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String ...args){
//        Chess chess = new Chess();
//        String board = chess.PrintBoard();
//        System.out.println(board);

        JFrame frame = new JFrame();
        MainPanel panel = new MainPanel();
        
        frame.setContentPane(panel);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
