/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.Reg_dataSocial;


/**
 *
 * @author steve
 */
public interface ISocioEconomico {
    public boolean insertar(Reg_dataSocial SocioEco);
    public boolean eliminar(Reg_dataSocial SocioEco);
    public boolean modificar(Reg_dataSocial SocioEco);
    public ArrayList<Object[]> consultar();
    public Reg_dataSocial obtener (Reg_dataSocial SocioEco);
    public Reg_dataSocial obtenerDatos (Reg_dataSocial SocioEco);
}
