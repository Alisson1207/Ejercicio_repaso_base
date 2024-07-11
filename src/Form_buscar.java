import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Form_buscar {
    public JPanel panel;
    private JLabel lb_titulo;
    private JLabel lb_buscar;
    private JTextField tf_buscar_placa;
    private JButton bt_buscar;
    private JLabel lb_placa;
    private JLabel lb_marca;
    private JLabel lb_cilindraje;
    private JLabel lb_combustible;
    private JLabel lb_color;
    private JLabel lb_propietario;

    public Form_buscar() {
        bt_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setteo de datos
                Vehiculo vehiculo1 = new Vehiculo();
                vehiculo1.setPlaca(tf_buscar_placa.getText());
                //Coneccion
                String url = "jdbc:mysql://localhost:3306/vehiculos";
                String user = "root";
                String password = "123456";




                try (Connection connection = DriverManager.getConnection(url, user, password)){
                     String sql = "SELECT * FROM  vehiculo WHERE placa = '"+vehiculo1.getPlaca()+"'";
                     PreparedStatement resultadobusqueda = connection.prepareStatement(sql);
                    ResultSet resultado = resultadobusqueda.executeQuery();


                    if (resultado.next()) {

                        lb_placa.setText("Placa: "+resultado.getString("placa"));
                        lb_marca.setText("Marca: "+resultado.getString("marca"));
                        lb_cilindraje.setText("Cilindraje: "+resultado.getString("cilindraje"));
                        lb_combustible.setText("Tipo combustible: "+resultado.getString("tipo_conbustible"));
                        lb_color.setText("Color: "+resultado.getString("color"));
                        lb_propietario.setText("Propietario: "+resultado.getString("propietario"));
                    } else {
                        lb_placa.setText("No se encontraron datos para la cédula: ");
                    }

                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                    lb_placa.setText("Error al buscar datos: " + ex.getMessage());
                }


            }
        });
    }
}
