/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static BaseDeDatos.Conexion.getConnection;
import static BaseDeDatos.Conexion.stmt;
import Vista.Trabajador.Vista_Principal_Trab;
import Vista.Usuario.Vista_Usuario;
import Vista.administrador.Vista_principal_Adm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pipe
 */
public class Usuario {
    public void Validar_Usuario(char contraseña[], String usuario,Vista_Usuario nn) {
        Connection con = getConnection();
        String comando;
        String exp;
        boolean existe = false;
        try {
            char clave[] = contraseña;
            String clave1 = new String(clave);
            if (usuario.isEmpty() && clave1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                        + "Campo de Usuario y/o contraseña Vacio. Por favor espere unos segundos e intente ingresar nuevamente.", "Acceso denegado",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                comando = "select *from usuario where pass='" + clave1 + "';";
                stmt = con.createStatement();
                ResultSet rss = stmt.executeQuery(comando);
                while (rss.next()) {
                    existe = true;
                    if (existe == true) {
                        exp = rss.getString("pass");
                        if (clave1.equals(exp)) {
                            Usuario(usuario,nn);
                        }
                    }
                }
                if (existe == false) {
                    JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                            + "Contraseña Incorrecta. Por favor espere unos segundos e intente ingresar nuevamente.", "Acceso denegado",
                            JOptionPane.ERROR_MESSAGE);
                }
                stmt.close();
                con.close();

            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ALERTA: Hubo un error desconocido");
            System.err.println("SQLException: " + err.getMessage());
            System.exit(0);

        }

    }
    public void Usuario(String usuario,Vista_Usuario nn) {
        Connection con = getConnection();
        String comando;
        String comando1;
        String comando2;
        String exp;
        boolean existe = false;
        boolean n = false;
        try {
            comando = "select *from usuario where usuario='" + usuario + "';";
            stmt = con.createStatement();
            ResultSet rss = stmt.executeQuery(comando);
            while (rss.next()) {
                existe = true;
                if (existe == true) {
                    exp = rss.getString("usuario");
                    if (usuario.equals("adm")) {
                        
                          nn.dispose();
                          Vista_principal_Adm adm= new Vista_principal_Adm();
                          System.out.println("Administrador");
                          //Administrador admM= new Administrador();
                          //Control_Administrador admC= new Control_Administrador(adm,admM);
                         // admC.AdministradorIniciar();
                          
                    }else {
                        
                        nn.dispose();
                        Vista_Principal_Trab m = new Vista_Principal_Trab();
                        System.out.println("Trabajador");
                        //Trabajador v = new Trabajador();
                       // Control_Trabajador sc = new Control_Trabajador(m, v);
                       // sc.TrabajadorIniciar();
                    
                    }
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                        + "Usuario Incorrecto. Por favor espere unos segundos e intente ingresar nuevamente.", "Acceso denegado",
                        JOptionPane.ERROR_MESSAGE);
            }
            stmt.close();
            con.close();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ALERTA: Hubo un error desconocido");
            System.err.println("SQLException: " + err.getMessage());
            System.exit(0);

        }

    }

    public void salir() {
        System.exit(0);
    }
    
}
