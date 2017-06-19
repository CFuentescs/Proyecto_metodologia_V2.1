/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.Administrador;

import Modelo.Residente;
import Vista.administrador.Vista_Residente_Adm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author carl
 */
public class Control_Residente_Adm implements ActionListener {

    private Vista_Residente_Adm sc;
    private Residente nn;

    public Control_Residente_Adm(Vista_Residente_Adm sc, Residente nn) {
        this.sc = sc;
        this.nn = nn;
        this.sc.AgregarResidente.addActionListener(this);
        this.sc.EliminarResidente.addActionListener(this);

    }

    public void iniciarResidente() {
        sc.setVisible(true);
        sc.setTitle("Mantenedor Residente");
        sc.setLocationRelativeTo(null);
        sc.setResizable(false);
        sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (sc.AgregarResidente == ae.getSource()) {

            try {
                nn.agregarResidente(sc.RutResidente.getText(), sc.NombreResidente.getText(), sc.Apellido_MResidente.getText(), sc.ApellidoPResidente.getText(), sc.SexoResidente.getText(), sc.Tiempo_RResidente.getText(), sc.observacion.getText());
                nn.actualizarResidente(sc.Tablaproducto);
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "no se pudo Actualizar");
            }
        } else if (sc.EliminarResidente == ae.getSource()) {

            try {
                nn.EliminarResidente(sc.eliminar.getText());
                nn.actualizarResidente(sc.Tablaproducto);
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "no se pudo Actualizar");
            }
        }/*if (sc.ActuBotton == ae.getSource()) {

            try {
             
               
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "no se pudo Actualizar");
            }
        }
         */


    }
}
