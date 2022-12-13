package GUI;

import DB.ConnectDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

public class Ask extends JFrame implements ActionListener {
    JLabel ask = new JLabel("Are you Customer or Partner?");
    Font font = new Font("Serif", Font.BOLD, 20);
    JButton customer = new JButton("Customer");
    JButton partner = new JButton("Partner");
    public Ask(){
        setBackground(Color.white);
        setLayout(null);
        ask.setBounds(100,100,280,30);
        ask.setFont(font);
        add(ask);

        customer.setBackground(new Color(238,104,69));
        customer.setForeground(Color.white);
        customer.setBorderPainted(true);
//        customer.setBorder(BorderFactory.createLineBorder(new Color(238,104,69), 2));
        customer.setBounds(100,150,90,40);
        customer.setSize(90,40);
        add(customer);
        customer.addActionListener(this);

        partner.setBackground(new Color(238,104,69));
        partner.setForeground(Color.white);
        partner.setBorderPainted(true);
//        partner.setBorder(BorderFactory.createLineBorder(new Color(238,104,69), 2));
        partner.setBounds(260,150,90,40);
        partner.setSize(90,40);
        add(partner);
        partner.addActionListener(this);


        setSize(450,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == customer) {
            setVisible(false);
            new LogIn().setVisible(true);
        } else if(source == partner){
            setVisible(false);
            new AdminLogin().setVisible(true);
        }
    }

}
