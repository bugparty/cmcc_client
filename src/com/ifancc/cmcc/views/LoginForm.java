package com.ifancc.cmcc.views;

import com.ifancc.cmcc.models.UserBean;
import com.ifancc.wifimgr.Manager;
import com.ifancc.wifimgr.Bean.WlanInterfaceInfo;
import com.ifancc.wifimgr.Bean.WlanInterfaceInfoList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by bowman on 13-12-23.
 */
public class LoginForm {
    public LoginForm() {
        WlanIfModel ifmodel = new WlanIfModel();
        tableWlanIf.setModel(ifmodel);



    }

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception err){
            err.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("LoginForm");
        frame.setContentPane(new LoginForm().login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(screenSize.width / 2 - screenSize.width/5 / 2, screenSize.height
                / 2 - screenSize.height/5 / 2);
        frame.pack();
        frame.setVisible(true);
    }

    private JTextField textField_phone_number;
    private JPasswordField textField_password;
    private JButton button_login;
    private JPanel login;
    private JList list1;
    private JTable tableWlanIf;
    private JTable tableWlanAp;

    public void setData(UserBean data) {
        textField_phone_number.setText(data.getPassword());
        textField_password.setText(data.getPhoneNumber());
    }

    public void getData(UserBean data) {
        data.setPassword(textField_phone_number.getText());
        data.setPhoneNumber(textField_password.getText());
    }

    public boolean isModified(UserBean data) {
        if (textField_phone_number.getText() != null ? !textField_phone_number.getText().equals(data.getPassword()) : data.getPassword() != null)
            return true;
        if (textField_password.getText() != null ? !textField_password.getText().equals(data.getPhoneNumber()) : data.getPhoneNumber() != null)
            return true;
        return false;
    }
    private class WlanIfModel extends  DefaultTableModel{
        final String[] names = {"interface", "state","guid"};
        private Manager mgr;
        private WlanInterfaceInfoList list;
        private int size;

        public  WlanIfModel() {
           mgr = new Manager();
           list = mgr.WlanEnumInterfaces();
           size = list.getSize();
        }

        public WlanIfModel(int rowCount, int columnCount) {
            super(rowCount, columnCount);
        }

        @Override
        public int getRowCount() {
            return size;
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public String getColumnName(int column) {
            return names[column];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Object getValueAt(int row, int column) {
            WlanInterfaceInfo info = list.getInterfaces()[row];
            switch(column){
                case 0:
                    return info.InterfaceInfo;
                case 1:
                    return info.State;
                case 2:
                    return info.GUID;
                default:
                    return null;

            }
        }
    }
}
