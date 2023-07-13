/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.AsignacionCurso;

/**
 *
 * @author pc
 */
public interface IAsignacionCurso {
    public boolean insertar(AsignacionCurso asignacion);
    public boolean eliminar(AsignacionCurso asignacion );
    public boolean modificar(AsignacionCurso asignacion);
    public ArrayList<Object[]> consultar();
}
