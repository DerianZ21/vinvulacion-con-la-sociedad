/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import vista.Inicio;
import controlador.Controlador;

/**
 *
 * @author pc
 */
public class Main {
    public static void main(String[] args) {
//        Inicio inicio= new Inicio();//Instancia de la clase 
//        inicio.setVisible(true); 
        Controlador controller = new Controlador();
        controller.iniciarVista();
    }
    
}
