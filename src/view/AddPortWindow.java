package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddPortWindow extends JPanel{
    JTextField txt_name = new JTextField();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Введите название корабля");
    JButton btn_ok = new JButton("OK");

    public AddPortWindow(){
        setLayout(new BorderLayout());
        Font font = new Font("Segoe UI", Font.BOLD, 16);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(font);
        font = new Font("Segoe UI", Font.PLAIN, 16);
        txt_name.setHorizontalAlignment(JTextField.CENTER);
        txt_name.setFont(font);
        panel.setLayout(new GridLayout(3,1));
        panel.add(label,"Before");
        panel.add(txt_name, "Center");
        panel.add(btn_ok, "After");
        add(panel, "South");
    }

    public void addButton(ActionListener l){
        btn_ok.addActionListener(l);
    }

    public String getName(){
        return txt_name.getText();
    }
}
