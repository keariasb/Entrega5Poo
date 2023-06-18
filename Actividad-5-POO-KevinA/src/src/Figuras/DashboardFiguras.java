package Figuras;

import Notas.Notas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardFiguras {
    private JPanel frmFiguras;
    private JButton btnCilindro, btnEsfera, btnPiramide;

    public DashboardFiguras() {
        btnCilindro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cilindro cilindro = new Cilindro();
                cilindro.loadForm();
            }
        });
        btnEsfera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Esfera esfera = new Esfera();
                esfera.loadForm();
            }
        });
        btnPiramide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Piramide piramide = new Piramide();
                piramide.loadForm();
            }
        });
    }

    public void loadForm() {
        JFrame f = new JFrame("Figuras");
        f.setContentPane(new DashboardFiguras().frmFiguras);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
    }
}
