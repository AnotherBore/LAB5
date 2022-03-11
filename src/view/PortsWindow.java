package view;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import model.MyTableModel;

import java.awt.*;
import java.awt.event.*;

public class PortsWindow extends JPanel {
    JPanel pnl_table = new JPanel();
    JPanel pnl_buttons = new JPanel();
    JTable table;
    JButton btn_add;
    JButton btn_enter;
    JButton btn_del;
    JScrollPane scroll;

    public PortsWindow() {
        setLayout(new BorderLayout());
        pnl_table.setLayout(new BorderLayout());
        pnl_buttons.setLayout(new GridLayout(1, 4));
        add(pnl_table, BorderLayout.CENTER);
        add(pnl_buttons, BorderLayout.PAGE_END);

        btn_add = new JButton("Добавить");
        pnl_buttons.add(btn_add);

        btn_del = new JButton("Удалить");
        pnl_buttons.add(btn_del);

        btn_enter = new JButton("Войти");
        btn_enter.setEnabled(false);
        pnl_buttons.add(btn_enter);

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

    public void deleteButton(ActionListener l){
        btn_del.addActionListener(l);
    }

    public void enterButton(ActionListener l){
        btn_enter.addActionListener(l);
    }

    public int getSelectedRow(){
        return table.getSelectedRow();
    }

    public void makeEnterEnabled(boolean b){
        btn_enter.setEnabled(b);
    }

    public void tableListener(ListSelectionListener l){
        table.getSelectionModel().addListSelectionListener(l);
    }
}
