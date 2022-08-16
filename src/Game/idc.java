package Game;

import javax.swing.*;
import java.awt.*;

public class idc {
    public static boolean hasAI = false;
    public static Column[] columns = new Column[7];

    public static void main(String[] args) {

        for (int i =0; i<columns.length;i++){
            columns[i] = new Column(i);
        }
        drawFrame();

        if(hasAI)
            Game.startGame(new RandomAI());
        else Game.startGame();
    }


    private static void drawFrame(){
        Panel[] panels = new Panel[7];
        for (int i=0;i<7;i++){
            panels[i] = new Panel();
            panels[i].setBounds(100*i,0,100,600);
            panels[i].setLayout(null);
        }

        for (int i=0; i<7;i++){
            JLabel[] x = columns[i].getLabels();
            for(int j=0; j<6; j++){
                panels[i].add(x[j]);
            }
        }

        Panel boardPanel = new Panel();
        boardPanel.setLayout(null);
        boardPanel.setSize(700,600);
        for (Panel p : panels) {
            boardPanel.add(p);
        }
        boardPanel.setBounds(0,100,700,600);

        JFrame frame = new JFrame("Connect Four");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel titlePanel = new Panel();
        titlePanel.setLayout(null);
        JLabel f = new JLabel("Connect Four");
        f.setBounds(0,0,700,100);
        titlePanel.add(f);
        titlePanel.setBounds(0,0,700,100);

        frame.add(titlePanel);
        frame.add(boardPanel);

        frame.pack();
        frame.setVisible(true);
        frame.setLocation(300,50);
    }

}
