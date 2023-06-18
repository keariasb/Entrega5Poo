package Figuras;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Esfera {
    private double radio;
    private JPanel frmEsfera;
    private JTextField txtRadio;
    private JButton btnCalcular;
    private JButton btnLimpiar;
    private JLabel lblVolumen;
    private JLabel lblSuperficie;

    public Esfera() {
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingInfo();
                calcularVolumen(radio);
                calcularSuperficie(radio);
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
        JFrame f = new JFrame("Esfera");
        f.setContentPane(new Esfera().frmEsfera);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
    }

    private void settingInfo(){
        this.radio = Double.parseDouble(txtRadio.getText());
    }

    private void clearInfo(){
        txtRadio.setText("");
        lblVolumen.setText("");
        lblSuperficie.setText("");
    }

    private void calcularVolumen(double r){
        double volumen = (4*Math.PI * Math.pow(r,3)) / 3;
        lblVolumen.setText(String.valueOf(String.format("%.2f",volumen)));
    }

    private void calcularSuperficie(double r){
        double superficie = 4*Math.PI * Math.pow(r,2);
        lblSuperficie.setText(String.valueOf(String.format("%.2f",superficie)));
    }
}
