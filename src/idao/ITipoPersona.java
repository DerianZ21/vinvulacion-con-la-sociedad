/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.tipoPersonaEntity;

/**
 *
 * @author Asus
 */
public interface ITipoPersona {
    
    public boolean insertar(tipoPersonaEntity tipoPersona);
    public boolean eliminar(tipoPersonaEntity tipoPersona);
    public boolean modificar(tipoPersonaEntity tipoPersona);
    public ArrayList<Object[]> consultar();
    public tipoPersonaEntity obtener(tipoPersonaEntity tipoPersona);
    
}
