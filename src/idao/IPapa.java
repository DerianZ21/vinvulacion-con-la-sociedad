/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.Papa;
import modelo.tipoPersonaEntity;

/**
 *
 * @author Sebastian Riofrio
 */
public interface IPapa {
    public boolean insertar(Papa pa);
    public boolean eliminar(Papa pa);
    public boolean modificar(Papa pa);
    public ArrayList<Object[]> consultar();
    public Papa obtener(Papa pa);
    public Papa obtenerNom(Papa pa);
    public Papa obtenerDato(Papa pa);
}
