/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.AsistenciaEntity;

/**
 *
 * @author N.I.R.N
 */
public interface IAsistencia {
    public boolean insertar(AsistenciaEntity asistencia);
    public boolean eliminar(AsistenciaEntity asistencia);
    public boolean modificar(AsistenciaEntity asistencia);
    public ArrayList<Object[]> consultar();
    public AsistenciaEntity obtener(AsistenciaEntity asistencia);
}
