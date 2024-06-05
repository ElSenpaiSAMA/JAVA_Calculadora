import java.awt.*;
import javax.swing.*;

public class Calculadora extends JFrame {
    private JPanel panel;
    private JTextField pantalla;
    private JTextField rAnterior; 

    public Calculadora() {
        this.setSize(380, 500);
        setTitle("MEJOR QUE LA ANTERIOR ESTA :)");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200, 200));
        pantalla = new JTextField();
        rAnterior = new JTextField();
        iniciar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciar() {
        miPanel();
    }

    private void miPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 30, 30));
        this.getContentPane().add(panel);
        pantalla.setBounds(10, 100, this.getWidth() - 50, 70);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setOpaque(false);
        pantalla.setBorder(null);
        pantalla.setFont(new Font("Arial", Font.PLAIN, 30));
        pantalla.setForeground(Color.WHITE);
        panel.add(pantalla);

        rAnterior.setBounds(10, 50, this.getWidth() - 50, 15); 
        rAnterior.setHorizontalAlignment(JTextField.RIGHT);
        rAnterior.setEditable(false);
        rAnterior.setOpaque(false);
        rAnterior.setBorder(null);
        rAnterior.setFont(new Font("Arial", Font.PLAIN, 20));
        rAnterior.setForeground(Color.WHITE);
        panel.add(rAnterior); 

        BtnesNumero num = new BtnesNumero(panel, pantalla);
        num.crearBotones();
        BtnesOtros otr = new BtnesOtros(panel, pantalla, rAnterior); 
        otr.crearBotones();
    }
}



