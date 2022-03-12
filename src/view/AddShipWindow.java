package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddShipWindow extends JPanel{
    JComboBox<String> comboBox;
    JButton btn_ok = new JButton("OK");
    JTextField name = new JTextField("");
    JSpinner maxSpeed = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
    JSpinner displacement = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
    JSpinner difference = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
    JLabel label_difference = new JLabel("Введите максимальную скорость на льду (км/ ч)");
    JPanel panel = new JPanel();

    public AddShipWindow() {
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(5,2));
        String[] ships = {"Ледокол",
        "Парусник",
        "Пароход"};
        JLabel label_combo = new JLabel("Выберите тип корабля");
        JLabel label_name = new JLabel("Введите название");
        JLabel label_speed = new JLabel("Введите максимальную скорость (км/ ч)");
        JLabel label_displacement = new JLabel("Введите водоизмещение (тыс. тонн)");

        comboBox = new JComboBox<>(ships);

        panel.add(label_combo);
        panel.add(comboBox);
        panel.add(label_name);
        panel.add(name);
        panel.add(label_speed);
        panel.add(maxSpeed);
        panel.add(label_displacement);
        panel.add(displacement);
        panel.add(label_difference);
        panel.add(difference);

        add(btn_ok, "South");
        add(panel, "Center");
    }

    public void chooseComboBox(ActionListener l){
        this.comboBox.addActionListener(l);
    }

    public void setLabel_differenceText(String string) {
        this.label_difference.setText(string);
    }

    public int getSelectedIndex(){
        return this.comboBox.getSelectedIndex();
    }

    public void addButton(ActionListener l){
        btn_ok.addActionListener(l);
    }

    public String getName(){
        return name.getText();
    }

    public int getDisplacement(){
        return (Integer) displacement.getValue();
    }

    public int getMaxSpeed(){
        return (Integer) maxSpeed.getValue();
    }

    public int getDifference(){
        return (Integer) difference.getValue();
    }

    public String getType(){
        return comboBox.getSelectedItem().toString();
    }

    public void reset(){
        name.setText("");
        maxSpeed.setValue(1);
        displacement.setValue(1);
        difference.setValue(1);
    }
}