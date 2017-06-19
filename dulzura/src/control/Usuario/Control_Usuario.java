/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.Usuario;

import Modelo.Usuario;
import Vista.Usuario.Vista_Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author carl
 */
public class Control_Usuario implements ActionListener{
    private Usuario nn;
     private Vista_Usuario sc;
    public Control_Usuario(Vista_Usuario sc,Usuario nn){
        this.sc=sc;
        this.nn=nn;
        this.sc.Aceptar.addActionListener(this);
        this.sc.Salir.addActionListener(this);
    }
     public void IniciarUsuario() {
        sc.setVisible(true);
        sc.setTitle("Usuario");
        sc.setLocationRelativeTo(null);
        sc.setResizable(false);
        sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (sc.Aceptar == ae.getSource()) {

            try {

                nn.Validar_Usuario(sc.Contraseña.getPassword(), sc.Usuario.getText(),sc);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "No se pudo realizar el siguiente evento");
            }
        } else if (sc.Salir == ae.getSource()) {
            try {
                nn.salir();
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "No se pudo realizar el siguiente evento");
            }
        }
    }
    
}
