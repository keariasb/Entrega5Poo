package Figuras;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cilindro {

    private double radio, altura;
    private JTextField txtRadio, txtAltura;
    private JButton btnCalcular, btnLimpiar;
    private JLabel lblVolumen, lblSuperficie;
    private JPanel frmCilindro;

    public Cilindro() {
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingInfo();
                calcularVolumen(radio, altura);
                calcularSuperficie(radio, altura);
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
        JFrame f = new JFrame("Cilindro");
        f.setContentPane(new Cilindro().frmCilindro);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
    }

    private void settingInfo(){
        this.radio = Double.parseDouble(txtRadio.getText());
        this.altura = Double.parseDouble(txtAltura.getText());
    }

    private void clearInfo(){
        txtAltura.setText("");
        txtRadio.setText("");
        lblVolumen.setText("");
        lblSuperficie.setText("");
    }

    private void calcularVolumen(double r, double h){
        double volumen = Math.PI * Math.pow(r,2) * h;
        lblVolumen.setText(String.valueOf(String.format("%.2f",volumen)));
    }

    private void calcularSuperficie(double r, double h){
        double superficie = 2*Math.PI*r*(r+h);
        lblSuperficie.setText(String.valueOf(String.format("%.2f",superficie)));
    }
}
