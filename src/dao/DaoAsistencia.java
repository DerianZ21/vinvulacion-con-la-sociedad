/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import idao.IAsistencia;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.AsistenciaEntity;

/**
 *
 * @author N.I.R.N
 */
public class DaoAsistencia extends Conexion implements IAsistencia {

    @Override
    public boolean insertar(AsistenciaEntity asistencia) {
        final String INSERT = "Insert into public.asistencia(fech_asis,estudiante,id_curso,asistencia) VALUES (?,?,?,?)";

     boolean registrar = false;
        PreparedStatement sta = null;
        try {
            this.conectar();
            sta = this.conexion.prepareStatement(INSERT);

            sta.setString(1, asistencia.getFecha());
            sta.setString(2, asistencia.getEstudiante());
            sta.setInt(3, asistencia.getCurso());
            sta.setBoolean(4, asistencia.isEstado());
            
            sta.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Esta mal el registro sql del insertar" + e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id_usuario "
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
        return registrar;   
    
    
    
    }

    @Override
    public boolean eliminar(AsistenciaEntity asistencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(AsistenciaEntity asistencia) {
       boolean actualizar= false;
	PreparedStatement sta=null;
        try {
             this.conectar(); 
             String sql= "UPDATE public.asistencia SET  asistencia=?    WHERE id_asis =?";
             sta=this.conexion.prepareStatement(sql);

             sta.setBoolean(1, asistencia.isEstado());
             sta.setInt(2, asistencia.getId_asistencia());
             
            
            int filas = sta.executeUpdate();
            
           if(filas>0){
               actualizar= true;
           }
          
        }catch (Exception e){
               JOptionPane.showMessageDialog(null, "ESTA MAL EL INGRESO DE DATOS  MODIFICAR"+e,"Error", JOptionPane.WARNING_MESSAGE);
               
        }finally{
                try {
                    this.desconectar();
                } catch (Exception ex) {
                    Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
        }return actualizar;
    }

    @Override
    public ArrayList<Object[]> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AsistenciaEntity obtener(AsistenciaEntity asistencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
