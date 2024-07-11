import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Form_insertar {
    public JPanel panel;
    private JLabel lb_titulo;
    private JTextField tf_placa;
    private JTextField tf_marca;
    private JTextField tf_cilindraje;
    private JTextField tf_combustible;
    private JTextField tf_color;
    private JTextField tf_propietario;
    private JButton bt_insertar;
    private JLabel lb_placa;
    private JLabel lb_marca;
    private JLabel lb_cilindraje;
    private JLabel lb_combustible;
    private JLabel lb_color;
    private JLabel lb_propietario;
    private JLabel lb_confirmacion;
    private JButton limpiarButton;

    public Form_insertar() {
        bt_insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setteo de datos
                Vehiculo vehiculo1 = new Vehiculo();
                vehiculo1.setPlaca(tf_placa.getText());
                vehiculo1.setMarca(tf_marca.getText());
                vehiculo1.setCilindraje(Double.parseDouble(tf_cilindraje.getText()));
                vehiculo1.setTipo_combustible(tf_combustible.getText());
                vehiculo1.setColor(tf_color.getText());
                vehiculo1.setPropetiario(tf_propietario.getText());
                //Coneccion
                String url = "jdbc:mysql://localhost:3306/vehiculos";
                String user = "root";
                String password = "123456";


                String sql = "INSERT INTO vehiculo (placa,marca,cilindraje,tipo_conbustible,color,propietario) VALUES (?, ?, ?, ?,?,?)";

                try (Connection connection = DriverManager.getConnection(url, user, password);
                     PreparedStatement resultadoinsertar = connection.prepareStatement(sql)) {
                    resultadoinsertar.setString(1, vehiculo1.getPlaca());
                    resultadoinsertar.setString(2, vehiculo1.getMarca());
                    resultadoinsertar.setDouble(3, vehiculo1.getCilindraje());
                    resultadoinsertar.setString(4, vehiculo1.getTipo_combustible());
                    resultadoinsertar.setString(5, vehiculo1.getColor());
                    resultadoinsertar.setString(6, vehiculo1.getPropetiario());
                    resultadoinsertar.executeUpdate();//para que se ejecuten los cambios
                    lb_confirmacion.setText("Se ha registrado con exito");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Error al insertar datos: " + ex.getMessage());
                }
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf_placa.setText("");
                tf_marca.setText("");
                tf_cilindraje.setText("");
                tf_combustible.setText("");
                tf_color.setText("");
                tf_propietario.setText("");

            }
        });
    }
}
