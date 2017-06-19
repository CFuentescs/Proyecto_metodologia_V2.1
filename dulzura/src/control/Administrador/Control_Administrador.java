/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.Administrador;

import static BaseDeDatos.Conexion.getConnection;
import static BaseDeDatos.Conexion.stmt;
import Modelo.Administrador;
import Modelo.Residente;
import Vista.administrador.Vista_Residente_Adm;
import Vista.administrador.Vista_principal_Adm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author carl
 */
public class Control_Administrador implements ActionListener {

    private Vista_principal_Adm adm;
    private Administrador admM;
    public String comando;
    public boolean existe = false;
    public String exp;
    Connection con = getConnection();

    public Control_Administrador(Vista_principal_Adm adm, Administrador admM) {
        this.adm = adm;
        this.admM = admM;
        this.adm.Buscar.addActionListener(this);
        this.adm.Actualizar.addActionListener(this);
        this.adm.Factura.addActionListener(this);
        this.adm.buscarTrabajador.addActionListener(this);
        this.adm.ActualizarTra.addActionListener(this);
        this.adm.seccion.addActionListener(this);
        this.adm.salir.addActionListener(this);
        this.adm.bottonResidente.addActionListener(this);
        this.adm.bottonTutor.addActionListener(this);
        this.adm.BottonTrabajador.addActionListener(this);
        this.adm.bottonHorario.addActionListener(this);

    }

    public void AdministradorIniciar() {

        adm.setVisible(true);
        adm.setTitle("Administrador");
        adm.setLocationRelativeTo(null);
        adm.setResizable(false);
        adm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admM.VistaResidente(adm.TablaResidente, "");
        admM.VistaTrabajador(adm.TablaTrabajador,"");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (adm.Buscar == ae.getSource()) {
            try {
                if (adm.ResidenteTXT.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo de rut está vacío", "Error de captura", JOptionPane.ERROR_MESSAGE);
                } else if (adm.ResidenteTXT.getText().length() == 8) {
                    comando = "select *from residente where rut=" + adm.ResidenteTXT.getText() + ";";
                    stmt = con.createStatement();
                    ResultSet rss = stmt.executeQuery(comando);
                    while (rss.next()) {
                        existe = true;
                        if (existe == true) {
                            exp = rss.getString("rut");
                            if (adm.ResidenteTXT.getText().equals(exp)) {
                                admM.VistaResidente(adm.TablaResidente, adm.ResidenteTXT.getText());
                            }
                        }
                    }
                    if (existe == false) {
                        JOptionPane.showMessageDialog(null, "No existe el rut ingresado en el sistema" + adm.ResidenteTXT.getText() + "");
                    }
                    stmt.close();
                    con.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Campo de rut NO VALIDO", "Error de captura", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "no se pudo guardar");
            }
        } else if (adm.Actualizar == ae.getSource()) {

            try {

                admM.VistaResidente(adm.TablaResidente, "");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "no se pudo Actualizar");
            }
        }
        if (adm.buscarTrabajador == ae.getSource()) {

            try {
                if (adm.trabajadorTXT.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo de rut está vacío", "Error de captura", JOptionPane.ERROR_MESSAGE);
                } else if (adm.trabajadorTXT.getText().length() == 9) {
                    comando = "select *from usuario where rut=" + adm.trabajadorTXT.getText() + ";";
                    stmt = con.createStatement();
                    ResultSet rss = stmt.executeQuery(comando);
                    while (rss.next()) {
                        existe = true;
                        if (existe == true) {
                            exp = rss.getString("rut");
                            if (adm.trabajadorTXT.getText().equals(exp)) {
                                admM.VistaTrabajador(adm.TablaTrabajador, adm.trabajadorTXT.getText());
                            }
                        }
                    }
                    if (existe == false) {
                        JOptionPane.showMessageDialog(null, "No existe el rut ingresado en el sistema" + adm.trabajadorTXT.getText() + "");
                    }
                    stmt.close();
                    con.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Campo de rut NO VALIDO", "Error de captura", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "no se pudo guardar");
            }
        } else if (adm.ActualizarTra == ae.getSource()) {

            try {

                admM.VistaTrabajador(adm.TablaTrabajador, "");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "no se pudo Actualizar");
            }
        }
        if (adm.bottonResidente == ae.getSource()) {

            try {
                adm.dispose();
                Vista_Residente_Adm m = new Vista_Residente_Adm();
                Residente v = new Residente();
                Control_Residente_Adm sc = new Control_Residente_Adm(m, v);
                sc.iniciarResidente();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "no se pudo Actualizar");
            }
        }else if (adm.salir == ae.getSource()) {

            try {
               admM.Salir();
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "no se pudo Actualizar");
            }
        }else if (adm.BottonTrabajador == ae.getSource()) {

            try {
              
                
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "no se pudo Actualizar");
            }
                    }
    
    }
}
