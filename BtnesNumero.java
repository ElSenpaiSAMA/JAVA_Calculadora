import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class BtnesNumero {
    private JPanel panel;
    private JTextField pantalla;

    public BtnesNumero(JPanel panel, JTextField pantalla) {
        this.panel = panel;
        this.pantalla = pantalla;
    }

    public void crearBotones() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = (JButton) e.getSource();
                String imp = boton.getActionCommand();
                if (pantalla.getText().length() < 15) { 
                    pantalla.setText(pantalla.getText() + imp);
                }
            }
        };

        int[] posX = {10, 10, 95, 180, 10, 95, 180, 10, 95, 180};
        int[] posY = {400, 340, 340, 340, 280, 280, 280, 220, 220, 220};
        String[] vboton = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < vboton.length; i++) {
            btnNume(vboton[i], posX[i], posY[i], listener);
        }
    }

    private void btnNume(String valor, int x, int y, ActionListener listener) {
        JButton boton = new JButton(valor);
        if (valor.equals("0")) {
            boton.setBounds(x, y, 170, 60);  
        } 
        else {
            boton.setBounds(x, y, 85, 60);  
        }
        boton.setFont(new Font("Arial", Font.PLAIN, 20)); 
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        boton.setBackground(new Color(174, 174, 178)); 
        boton.setForeground(Color.WHITE); 
        boton.addActionListener(listener); 
        panel.add(boton);
    }
}
