import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class BtnesOtros {
    private JPanel panel;
    private JTextField pantalla;
    private JTextField rAnterior; 
    private double pri;
    private String operador;
    private boolean ope;
    private boolean punto;
    private double uresultado; 

    public BtnesOtros(JPanel panel, JTextField pantalla, JTextField rAnterior) {
        this.panel = panel;
        this.pantalla = pantalla;
        this.rAnterior = rAnterior; 
        this.ope = false;
        this.punto = false;
        this.uresultado = 0; 
    }

    public void crearBotones() {
        int[] posX = {265, 265, 265, 265, 180, 265, 180, 95, 10};
        int[] posY = {220, 280, 340, 400, 400, 160, 160, 160, 160};
        String[] simbolo = {"+", "-", "*", "=", ".", "C", "<-", "÷", "^"};
        
        for (int i = 0; i < simbolo.length; i++) {
            btnOtr(simbolo[i], posX[i], posY[i]);
        }
    }

    private void btnOtr(String simbolo, int x, int y) {
        JButton boton = new JButton(simbolo);
        boton.setBounds(x, y, 85, 60);  
        boton.setFont(new Font("Arial", Font.PLAIN, 20)); 
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        if (simbolo.equals("<-") || simbolo.equals("C")) {
            boton.setBackground(new Color(255, 59, 48)); 
            boton.setForeground(Color.WHITE); 
        }
        else if(simbolo.equals("^") || simbolo.equals("÷") || simbolo.equals(".")){
            boton.setBackground(new Color(127, 127, 132)); 
            boton.setForeground(Color.WHITE);
        } 
        else {
            boton.setBackground(new Color(255, 149, 0)); 
            boton.setForeground(Color.WHITE); 
        }

        panel.add(boton);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (simbolo.equals("=")) {
                    try {
                        double seg = Double.parseDouble(pantalla.getText());
                        double resultado = Operaciones.op(pri, seg, operador);
                        uresultado= resultado; 
                        rAnterior.setText(String.valueOf(uresultado)); 
                        pantalla.setText(String.valueOf(resultado));
                    } 
                    catch (ArithmeticException | NumberFormatException ex) {
                        pantalla.setText("Error");
                    }
                    ope = false;
                    punto = false;
                } else if (simbolo.equals(".")) {
                    if (!punto) {
                        pantalla.setText(pantalla.getText() + ".");
                        punto = true;
                    }
                } else if (simbolo.equals("C")) {
                    pantalla.setText("");
                    ope = false;
                    punto = false;
                } 
                else if (simbolo.equals("<-")) {
                    String borra = pantalla.getText();
                    if (borra.length() > 0) {
                        pantalla.setText(borra.substring(0, borra.length() - 1));
                    }
                } 
                else {
                    if (ope) {
                        try {
                            double seg = Double.parseDouble(pantalla.getText());
                            double resultado = Operaciones.op(pri, seg, operador);
                            uresultado = resultado; 
                            rAnterior.setText(String.valueOf(uresultado)); 
                            pantalla.setText(String.valueOf(resultado));
                        } 
                        catch (ArithmeticException | NumberFormatException ex) {
                            pantalla.setText("Error");
                        }
                    }
                    pri = Double.parseDouble(pantalla.getText());
                    operador = simbolo;
                    ope = true;
                    pantalla.setText("");
                    punto = false;
                }
            }
        });
    }
}







