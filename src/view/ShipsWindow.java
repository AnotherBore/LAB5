package view;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import model.MyTableModel;

import java.awt.*;
import java.awt.event.*;

public class ShipsWindow extends JPanel {
    JPanel pnl_table = new JPanel();
    JPanel pnl_buttons = new JPanel();
    JButton btn_del;
    JButton btn_info;
    JButton btn_add;
    JButton btn_back;
    JTable table;
    JScrollPane scroll;
    public ShipsWindow(){
        setLayout(new BorderLayout());
        pnl_table.setLayout(new BorderLayout());
        pnl_buttons.setLayout(new GridLayout(1, 4));
        add(pnl_table, BorderLayout.CENTER);
        add(pnl_buttons, BorderLayout.PAGE_END);

        btn_add = new JButton("Добавить");
        pnl_buttons.add(btn_add);

        btn_del = new JButton("Удалить");
        btn_del.setEnabled(false);
        pnl_buttons.add(btn_del);

        btn_info = new JButton("Информация");
        btn_info.setEnabled(false);
        pnl_buttons.add(btn_info);

        btn_back = new JButton("Назад");
        pnl_buttons.add(btn_back);

        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll = new JScrollPane(table);
    }

    public void setTableModel(MyTableModel tableModel){
        table.setModel(tableModel);
        pnl_table.add(scroll);
    }

    public void addButton(ActionListener l){
        btn_add.addActionListener(l);
    }

    public void backButton(ActionListener l){
        btn_back.addActionListener(l);
    }

    public void deleteButton(ActionListener l){
        btn_del.addActionListener(l);
    }

    public void makeDeleteEnabled(boolean b){
        btn_del.setEnabled(b);
    }

    public void makeInfoEnabled(boolean b){
        btn_info.setEnabled(b);
    }

    public void infoButton(ActionListener l){
        btn_info.addActionListener(l);
    }

    public void tableListener(ListSelectionListener l){
        table.getSelectionModel().addListSelectionListener(l);
    }

    public int getSelectedRow(){
        return table.getSelectedRow();
    }
}
