/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.Reg_Benf;


public interface IBeneficiario {
    
    public boolean insertar(Reg_Benf beneficiario);
    public boolean eliminar(Reg_Benf beneficiario);
    public boolean modificar(Reg_Benf beneficiario);
    public ArrayList<Object[]> consultar();
    public Reg_Benf obtener(Reg_Benf beneficiario);

    
}
