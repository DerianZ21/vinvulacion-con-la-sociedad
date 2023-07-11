/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.Reg_Ficha;

/**
 *
 * @author steve
 */
public interface IFicha {
    public boolean insertar();
    public boolean eliminar(Reg_Ficha Ficha);
    public ArrayList<Object[]> consultar();
}
