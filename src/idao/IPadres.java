/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.Padres;

/**
 *
 * @author Sebastian Riofrio
 */
public interface IPadres {
    public boolean insertar(Padres pad);
    public boolean eliminar(Padres pad);
    public boolean modificar(Padres pad);
    public ArrayList<Object[]> consultar();
    public Padres obtener(Padres pad);
    public Padres obtenerDatos(Padres pad);
    public int obtenerNumPas(String nom, String ape);
}
