/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.bg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rohan
 */
public class BGTest extends JFrame implements ActionListener {

    private MyCanvas canvas = null;
    private JFrame frame = null;
    private JPanel mainPanel = null;
    private JButton startBtn = null;
    private JButton stopBtn = null;
    private JButton pauseBtn = null;
    private JButton continueBtn = null;
    private JTextField Times = null;
    private JTextField Length = null;
    private JTextField Angel = null;
    private JLabel LTimes = null;
    private JLabel LLength = null;
    private JLabel LAngel = null;
    private GetRadian getRadian = null;
    private BGRule bGRule = null;
    private BGGeneration bGGeneration = null;
    private BGStem bGStem = null;
    private BGGenerationSet bGGS = null;
    private Thread thread = null;

    public BGTest() {
        initGUI();
    }

    private void initGUI() {
        frame = new JFrame();
        frame.setSize(800, 1000);
        frame.setResizable(true);
        frame.setTitle("MyAppUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(getMainPanel(), BorderLayout.NORTH);
        canvas = new MyCanvas();
        frame.add(canvas, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JPanel getMainPanel() {
        mainPanel = new JPanel();
        Times = new JTextField(5);
        Length = new JTextField(5);
        Angel = new JTextField(5);
        LTimes = new JLabel("Times");
        LLength = new JLabel("Length");
        LAngel = new JLabel("Angel");
        mainPanel.setLayout(new FlowLayout());
        startBtn = new JButton("Start");
        startBtn.addActionListener(this);
        stopBtn = new JButton("Stop");
        stopBtn.addActionListener(this);
        continueBtn = new JButton("Continue");
        continueBtn.addActionListener(this);
        pauseBtn = new JButton("Pause");
        pauseBtn.addActionListener(this);
        mainPanel.add(startBtn);
        mainPanel.add(pauseBtn);
        mainPanel.add(continueBtn);
        mainPanel.add(stopBtn);
        mainPanel.add(LTimes);
        mainPanel.add(Times);
        mainPanel.add(LLength);
        mainPanel.add(Length);
        mainPanel.add(LAngel);
        mainPanel.add(Angel);
        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        System.out.println("Call Action Performed!");
        if (e.getActionCommand().equals("Start")) {

            if (thread != null) {
                thread.stop();
            }

            System.out.println("Start Called!");

            getRadian = GetRadian.instance();
            bGGeneration = new BGGeneration();

            bGRule = new BGRule();

            bGGS = new BGGenerationSet();

            double[] in_x = new double[2];
            double[] in_y = new double[2];
            in_x[0] = 400;
            in_x[1] = 700;
            in_y[0] = 400;
            in_y[1] = 600;
            bGStem = new BGStem(in_x, in_y);
            bGStem.setColor(new Color(128, 42, 42));
            bGGeneration.addBGStem(bGStem);
            bGStem.setRadian(getRadian.getRadian(in_x, in_y));
            bGStem.setLength(Math.pow(Math.pow(in_y[0] - in_x[0], 2) + Math.pow(in_y[1] - in_x[1], 2), 0.5));

            canvas.clear();
            canvas.repaint();

            if (!Length.getText().equals("")) {
                bGRule.setLength(Double.parseDouble(Length.getText()));
            }

            if (!Angel.getText().equals("")) {
                bGRule.setAngel(Double.parseDouble(Angel.getText()));
            }

            bGGS.addStemList(bGGeneration);
            bGGS = GenerationStems(bGGS, Integer.parseInt(Times.getText()));

            for (BGGeneration gg : bGGS.getbGGSet()) {
                for (BGStem stem : gg.getStemList()) {
                    canvas.addStem(stem);
                }
            }

            System.out.println(canvas.GetStems().size());

//            canvas.repaint();
            bGGS = null;

            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    for (int index = 0; index < canvas.GetStems().size(); index++) {
                        canvas.setCounter(index);
                        canvas.repaint();
                        try {
                            thread.sleep(5);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Thread ended");

                }
            };

            thread = new Thread(runnable);
            thread.start();
        }

        if (e.getSource() == stopBtn) {
            canvas.clear();
            canvas.repaint();
            thread.stop();
        }
        if (e.getSource() == pauseBtn) {
            thread.suspend();
        }
        if (e.getSource() == continueBtn) {
            thread.resume();
        }
    }

    public BGGenerationSet GenerationStems(BGGenerationSet bGGS, int layer) {
        for (int i = 1; i < layer; i++) {
            BGGeneration tempBGG = Generate(bGGS.getbGGSet().get(bGGS.getbGGSet().size() - 1));
            bGGS.addStemList(tempBGG);
        }
        return bGGS;
    }

    public BGGeneration Generate(BGGeneration bGG) {
        BGGeneration outSet = new BGGeneration();
        for (BGStem b : bGG.getStemList()) {
            outSet.addBGStem(bGRule.growBranchL(b));
            outSet.addBGStem(bGRule.growBranchM(b));
            outSet.addBGStem(bGRule.growBranchR(b));
        }
        for (BGStem temp : outSet.getStemList()) {
//            System.out.println("Test for outcome: " + temp.getEnd()[0] + " , " + temp.getEnd()[1]);
        }
        return outSet;
    }

}
