package Notas;

import javax.swing.*;
import java.util.Arrays;
import java.util.Locale;

public class Notas {
    double[] listaNotas;
    private double nota1, nota2, nota3, nota4, nota5, prom, desviacionEstandar;
    boolean infoComplete = false;
    private JPanel frmNotas;
    private JTextField txtNota1, txtNota2, txtNota3, txtNota4, txtNota5;
    private JButton btnCalcular, btnLimpiar;
    private JLabel lblProm, lblNotaMayor, lblNotaMenor, lblDesviacion;

    public Notas() {
        listaNotas = new double[5];
        btnCalcular.addActionListener(e -> {
            checkFieldsNotEmpty();
            if (infoComplete) {
                calcularPromedio(listaNotas);
                calcularMayor(listaNotas);
                calcularMenor(listaNotas);
                calcularDesviacion(listaNotas, prom);
            } else {
                checkFieldsNotEmpty();
            }
        });
        btnLimpiar.addActionListener(e -> clearInfo());
    }

    public void loadForm() {
        JFrame f = new JFrame("Notas");
        f.setContentPane(new Notas().frmNotas);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
    }

    private void settingInfo() {
        this.nota1 = Double.parseDouble(txtNota1.getText().trim());
        this.nota2 = Double.parseDouble(txtNota2.getText().trim());
        this.nota3 = Double.parseDouble(txtNota3.getText().trim());
        this.nota4 = Double.parseDouble(txtNota4.getText().trim());
        this.nota5 = Double.parseDouble(txtNota5.getText().trim());
        listaNotas[0] = nota1;
        listaNotas[1] = nota2;
        listaNotas[2] = nota3;
        listaNotas[3] = nota4;
        listaNotas[4] = nota5;
        infoComplete = true;
    }

    private void clearInfo(){
        txtNota1.setText("");
        txtNota2.setText("");
        txtNota3.setText("");
        txtNota4.setText("");
        txtNota5.setText("");
        lblProm.setText("");
        lblDesviacion.setText("");
        lblNotaMayor.setText("");
        lblNotaMenor.setText("");
        Arrays.fill(listaNotas, 0);
    }

    private void checkFieldsNotEmpty(){
        if(txtNota1.getText().isEmpty()){
            txtNota1.grabFocus();
        }
        else if(txtNota2.getText().isEmpty()){
            txtNota2.grabFocus();
        }
        else if(txtNota3.getText().isEmpty()){
            txtNota3.grabFocus();
        }
        else if(txtNota4.getText().isEmpty()){
            txtNota4.grabFocus();
        }
        else if(txtNota5.getText().isEmpty()){
            txtNota5.grabFocus();
        }
        else {
            settingInfo();
        }
    }

    private void calcularPromedio(double[] listaNotas){
        this.prom = 0;
        for(int i= 0; i<5; i++){
            this.prom += listaNotas[i];
        }
        this.prom /= 5;
        lblProm.setText(String.format(Locale.ROOT, "%.2f", prom));
    }

    private void calcularMayor(double[] listaNotas){
        double mayor = listaNotas[1];
        for(int i = 0; i < 5; i ++){
            if(listaNotas[i] > mayor){
                mayor = listaNotas[i];
            }
        }
        lblNotaMayor.setText(String.valueOf(mayor));
    }

    private void calcularMenor(double[] listaNotas){
        double menor = listaNotas[1];
        for(int i = 0; i < 5; i ++){
            if(listaNotas[i] < menor){
                menor = listaNotas[i];
            }
        }
        lblNotaMenor.setText(String.valueOf(menor));
    }

    private void calcularDesviacion(double[] listaNotas, double prom){
        this.desviacionEstandar = 0;
        for(int i=0; i<5; i++){
            this.desviacionEstandar += Math.pow((listaNotas[i] - prom), 2);
        }
        this.desviacionEstandar = Math.sqrt(desviacionEstandar/5);
        lblDesviacion.setText(String.format(Locale.ROOT, "%.2f", desviacionEstandar));
    }
}
