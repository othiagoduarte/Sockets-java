package com.othiagoduarte.windows;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelExemplo {

    private JFrame jFrame;
    private JPanel panel1;
    private JPanel panel2;
    private JTextField textFieldNome;
    private JTextField textFieldSobrenome;

    public JPanelExemplo() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        jFrame = new JFrame("Mensagem");
        jFrame.setLayout(new GridLayout(2,2));

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 0));

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 0));

        textFieldNome = new JTextField(15);
        textFieldSobrenome = new JTextField(15);

        panel1.add(new JLabel("Porta: "));
        panel1.add(textFieldNome);

        jFrame.add(panel1);

        jFrame.pack();

        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new JPanelExemplo();
    }
}