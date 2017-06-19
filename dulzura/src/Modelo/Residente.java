package Modelo;

import static BaseDeDatos.Conexion.con;
import static BaseDeDatos.Conexion.getConnection;
import static BaseDeDatos.Conexion.stmt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pipe
 */
public class Residente {

    DefaultTableModel modelo;

    public void agregarResidente(String rut, String nombre, String apellidom, String apellidop, String sexo, String tiempor, String observacion) {
        String insertar;
        Connection con = getConnection();
        try {
            insertar = "insert into  residente values('" + rut + "','" + nombre + "','" + apellidom + "','" + apellidop + "','" + sexo + "','" + tiempor + "','" + observacion + "');";
            stmt = con.createStatement();
            stmt.executeUpdate(insertar);
            stmt.close();
            con.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ALERTA: Hubo un error desconocido");
            System.err.println("SQLException: " + err.getMessage());
            System.exit(0);
        }

    }

    public void actualizarResidente(JTable tablaD) {
        Connection con = getConnection();
        try {
            String Sql = "select * from residente;";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            String[] fila = new String[7];
            String[] titulos = {"Rut", "Nombre", "Apellido_M", "Apellido_P", "Sexo", "Tiempo_R", "Observación"};
            modelo = new DefaultTableModel(null, titulos);
            while (rs.next()) {

                fila[0] = rs.getString("rut");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellido_m");
                fila[3] = rs.getString("apellido_p");
                fila[4] = rs.getString("sexo");
                fila[5] = rs.getString("tiempo_r");
                fila[6] = rs.getString("observacion");
                modelo.addRow(fila);

            }

            stmt.close();
            con.close();
            tablaD.setModel(modelo);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ALERTA: Hubo un error desconocido");
            System.err.println("SQLException: " + err.getMessage());
            System.exit(0);

        }
    }

    public void EliminarResidente(String eliminar) {
        String comando;
        try {
            comando = "delete from residente where rut=" + eliminar + ";";
            stmt = con.createStatement();
            stmt.executeUpdate(comando);
            stmt.close();
            con.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ALERTA: Hubo un error desconocido");
            System.err.println("SQLException: " + err.getMessage());
            System.exit(0);
        }
    }

}
