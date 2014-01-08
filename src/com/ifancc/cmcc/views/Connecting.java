package com.ifancc.cmcc.views;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by bowman on 14-1-8.
 */
public class Connecting implements ActionListener, ChangeListener {
    private JProgressBar progressBar1;
    private JLabel label;
    private JButton buttonCancel;
    private JPanel LoginProgress;
    private Timer timer;
    private JFrame frame;

    public Connecting(JFrame JFlogin, JFrame frame) {
        this.JFlogin = JFlogin;
        this.frame = frame;
        timer = new Timer(100, this);
        buttonCancel.addActionListener(this);
        progressBar1.setMinimum(0);
        progressBar1.setMaximum(100);
        progressBar1.setValue(0);
        progressBar1.setStringPainted(true);
        progressBar1.addChangeListener(this);
        progressBar1.setPreferredSize(new Dimension(300, 20));
        progressBar1.setBorderPainted(true);
        progressBar1.setBackground(Color.pink);
        timer.start();
    }

    private JFrame JFlogin;

    public static void start(JFrame loginFrame) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception err) {
            err.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Connecting");

        //frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);//采用指定的窗口装饰风格
        frame.setBounds(screenSize.width / 2 - 200, screenSize.height
                / 2 - 150, 400, 300);
        frame.setContentPane(new Connecting(loginFrame, frame).LoginProgress);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == timer) {
            int value = progressBar1.getValue();
            if (value < 100)
                progressBar1.setValue(value + 10);
            else {
                timer.stop();
                UserMain.start();
                JFlogin.setVisible(false);
                frame.dispose();


            }
        }
        if (e.getSource() == buttonCancel) {
            timer.stop();
            frame.dispose();
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int value = progressBar1.getValue();
        if (e.getSource() == progressBar1) {

            label.setText("目前已完成进度：" + Integer.toString(value) + "%");
            label.setForeground(Color.blue);
        }
    }

}
