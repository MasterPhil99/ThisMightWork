package main;

import view.DrawSpace;

import javax.swing.*;

public class Testo {
    public static void main(String[] args) {
        int frameWidth = 600, frameHeight = 600;
        DrawSpace ds = new DrawSpace(new Double(frameWidth), new Double(frameHeight));
        JFrame frame = new JFrame();
        frame.add(ds);
        frame.setVisible(true);
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Crazy shit yo");
    }
}
