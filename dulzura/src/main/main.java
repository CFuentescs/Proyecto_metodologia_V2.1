/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Modelo.Usuario;
import Vista.Usuario.Vista_Usuario;
import control.Usuario.Control_Usuario;

/**
 *
 * @author carl
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista_Usuario m = new Vista_Usuario();
        Usuario v = new Usuario();
        Control_Usuario sc = new Control_Usuario(m, v);
        sc.IniciarUsuario();
    }
    
}
