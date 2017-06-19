/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.Administrador;

import Modelo.Trabajador;
import Vista.administrador.Vista_Trabajador_Adm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author carl
 */
public class Control_Trabajadores_Adm implements ActionListener {
    private Vista_Trabajador_Adm hh;
    private Trabajador nn;
    public Control_Trabajadores_Adm(Vista_Trabajador_Adm hh,Trabajador nn){
        this.hh=hh;
        this.nn=nn;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        
    }
    
}
