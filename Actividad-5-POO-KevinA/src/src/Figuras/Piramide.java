package Figuras;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Piramide {
    private double base, altura, apotema;
    private JPanel frmPiramide;
    private JTextField txtBase, txtAltura, txtApotema;
    private JButton btnCalcular, btnLimpiar;
    private JLabel lblVolumen, lblSuperficie;

    public Piramide() {
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingInfo();
                calcularVolumen(base, altura);
                calcularSuperficie(base, altura, apotema);
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInfo();
            }
        });
    }

    public void loadForm() {
        JFrame f = new JFrame("Pirámide");
        f.setContentPane(new Piramide().frmPiramide);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
    }

    private void settingInfo(){
        this.base = Double.parseDouble(txtBase.getText());
        this.altura = Double.parseDouble(txtAltura.getText());
        this.apotema = Double.parseDouble(txtApotema.getText());
    }

    private void clearInfo(){
        txtBase.setText("");
        txtAltura.setText("");
        txtApotema.setText("");
        lblVolumen.setText("");
        lblSuperficie.setText("");
    }

    private void calcularVolumen(double b, double h){
        double volumen = (Math.pow(base,2)*altura) /3;
        lblVolumen.setText(String.valueOf(String.format("%.2f",volumen)));
    }

    private void calcularSuperficie(double b, double h, double a){
        double superficie = Math.pow(base,2) + (2*base*apotema);
        lblSuperficie.setText(String.valueOf(String.format("%.2f",superficie)));
    }
}
