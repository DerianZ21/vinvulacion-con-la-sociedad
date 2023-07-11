/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.util.ArrayList;
import modelo.Reg_Escolar;


/**
 *
 * @author florm
 */
public interface IEscolaridad {
    public boolean insertar(Reg_Escolar e);
    public boolean eliminar(Reg_Escolar e);
    public boolean modificar(Reg_Escolar e);
    public ArrayList<Object[]> consultar();
    public Reg_Escolar obtener(Reg_Escolar e);
    public Reg_Escolar obtenerDatos(Reg_Escolar e);
}
