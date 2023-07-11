/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.CursoEntity;

/**
 *
 * @author N.I.R.N
 */
public interface ICurso {
    
    public boolean insertar(CursoEntity curso);
    public boolean eliminar(CursoEntity curso);
    public boolean modificar(CursoEntity curso);
    public ArrayList<Object[]> consultar();
    public CursoEntity obtener(CursoEntity curso);
    
    
}
