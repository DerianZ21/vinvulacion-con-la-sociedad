/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.Mama;

/**
 *
 * @author Sebastian Riofrio
 */
public interface IMama {
    public boolean insertar(Mama ma);
    public boolean eliminar(Mama ma);
    public boolean modificar(Mama ma);
    public ArrayList<Object[]> consultar();
    public Mama obtener(Mama ma);
    public Mama obtenerNom(Mama ma);
    public Mama obtenerDato(Mama ma);
}
