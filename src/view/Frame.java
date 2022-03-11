package view;

import javax.swing.*;
import java.awt.*;
import controller.*;

public class Frame extends JFrame{
    AddPortWindow addPortWindow = new AddPortWindow();
    AddShipWindow addShipWindow = new AddShipWindow();
    PortsWindow portsWindow = new PortsWindow();
    ShipsWindow shipsWindow = new ShipsWindow();

    CardLayout layout = new CardLayout();
    public Frame(){
        super("Терминал морских портов");
        setLayout(layout);

        new Controller(portsWindow, shipsWindow, addPortWindow, addShipWindow);

        add(portsWindow, "portsWindow");
        add(shipsWindow, "shipsWindow");
        add(addPortWindow, "addPortWindow");
        add(addShipWindow, "addShipWindow");

        portsWindow.addButton(e -> layout.show(this.getContentPane(), "addPortWindow"));
        addPortWindow.addButton(e -> layout.show(this.getContentPane(), "portsWindow"));
        addShipWindow.addButton(e -> layout.show(this.getContentPane(), "shipsWindow"));
        shipsWindow.addButton(e -> layout.show(this.getContentPane(), "addShipWindow"));
        portsWindow.enterButton(e -> layout.show(this.getContentPane(), "shipsWindow"));
        shipsWindow.backButton(e -> layout.show(this.getContentPane(), "portsWindow"));

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}