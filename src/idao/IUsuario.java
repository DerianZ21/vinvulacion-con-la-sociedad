/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author pc
 */
public interface IUsuario {
    public boolean insertar(Usuario usu);
    public boolean eliminar(Usuario usu);
    public boolean modificar(Usuario usu);
    public ArrayList<Object[]> consultar();
    public Usuario obtener(Usuario usu);
}
