package com.ifancc.cmcc.views;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bowman on 14-1-8.
 */
public class UserMain {
    private JPanel userMain;
    private JTabbedPane tabbedPane1;
    private JLabel PhoneVal;
    private JLabel TimeLeft;
    private JLabel TimeLeftVal;
    private JPanel BasicInfo;
    private JPanel Fee;
    private JLabel Phone;

    public UserMain() {

    }

    public static void start() {
        JFrame frame = new JFrame("UserMain");
        frame.setContentPane(new UserMain().userMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
