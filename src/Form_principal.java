import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form_principal {
    public JPanel panel;
    private JLabel lb_titulo;
    private JButton bt_insertar;
    private JButton bt_buscar;


    public Form_principal() {
        bt_insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insertarFrame = new JFrame("Insertar Datos");
                insertarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                insertarFrame.setContentPane(new Form_insertar().panel);
                insertarFrame.pack();
                insertarFrame.setSize(550, 600);
                insertarFrame.setLocationRelativeTo(null);
                insertarFrame.setVisible(true);
            }
        });
        bt_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame insertarFrame = new JFrame("Insertar Datos");
                insertarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                insertarFrame.setContentPane(new Form_buscar().panel);
                insertarFrame.pack();
                insertarFrame.setSize(500, 300);
                insertarFrame.setLocationRelativeTo(null);
                insertarFrame.setVisible(true);

            }
        });
    }

}
