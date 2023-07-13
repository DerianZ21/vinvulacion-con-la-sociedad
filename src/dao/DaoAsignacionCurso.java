/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import idao.IAsignacionCurso;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.AsignacionCurso;

/**
 *
 * @author pc
 */
public class DaoAsignacionCurso extends Conexion implements IAsignacionCurso{
    final String INSERT = "INSERT INTO asignacion_curso( id_padres, id_curso, parentesco) VALUES ( ?, ?, ?)";
    
    @Override
    public boolean insertar(AsignacionCurso asignacion) {
         boolean ingresar = false;
        PreparedStatement sta = null;
        try {
            this.conectar();
            sta = this.conexion.prepareStatement(INSERT);

            sta.setInt(1, asignacion.getId_padre());
            sta.setInt(2, asignacion.getId_curso());
            sta.setString(3, asignacion.getParentesco());
          
            
            int filas = sta.executeUpdate();
            if(filas>0){
               ingresar= true;
           }

        } catch (SQLException e) {
            System.out.println("Esta mal el registro sql del insertar asignacion" + e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id asignacion "
                    + " a ingresado un dato que no existe a esa tabla", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.desconectar();
            } catch (Exception ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ingresar;
    }

    @Override
    public boolean eliminar(AsignacionCurso asignacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(AsignacionCurso asignacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object[]> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
