/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import idao.ITipoPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.tipoPersonaEntity;

/**
 *
 * @author Asus
 */
public class DaoTipoPersona extends Conexion implements ITipoPersona{
    
    final String INSERT= "Insert into public.tipoPersona(cedula,fech_nac,nombre,apellido,edad,direccion,correo,religion,telefono) VALUES (?,?,?,?,?,?,?,?,?)";

    @Override
    public boolean insertar(tipoPersonaEntity tipoPersona) {
        
        boolean registrar = false;
        PreparedStatement sta=null;
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(tipoPersona.getFech_nac());
        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
        
        try {
            this.conectar();
            sta=this.conexion.prepareStatement(INSERT);
             
            sta.setString(1, tipoPersona.getCedula());
            
            
            sta.setDate(2, date1);
            
            sta.setString(3, tipoPersona.getNombre());
            sta.setString(4, tipoPersona.getApellido());
            sta.setInt(5, tipoPersona.getEdad());
            sta.setString(6, tipoPersona.getDireccion());
            sta.setString(7, tipoPersona.getCorreo());
            sta.setString(8, tipoPersona.getReligion());
            sta.setString(9, tipoPersona.getTelefono());
            
            if (sta.executeUpdate() >0){
                JOptionPane.showMessageDialog(null, "Fueron ingresados todos los datos", "Sistema", JOptionPane.PLAIN_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "No se guardardo los datos del beneficiario", "Error", JOptionPane.WARNING_MESSAGE);
            
            }
                
         
        }catch (SQLException e){
            System.out.println("Esta mal el registro sql del insertar"+e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id_beneficio "
                     + " a ingresado un dato que no existe a esa tabla", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.desconectar();
            } catch (Exception ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registrar;
    }

    @Override
    public boolean eliminar(tipoPersonaEntity tipoPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(tipoPersonaEntity tipoPersona) {
        boolean actualizar= false;
	PreparedStatement sta=null;
        try {
             this.conectar();
             String sql= "UPDATE tipoPersona SET cedula=?, fech_nac=?, nombre=?, apellido=?, edad=?, direccion=?, correo=?, religion=?, telefono=?, WHERE id_tipoPersona = ?";
             sta=this.conexion.prepareStatement(sql);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = simpleDateFormat.format(tipoPersona.getFech_nac());
            java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
            
            sta.setString(1, tipoPersona.getCedula());
            sta.setDate(2, date1);
            sta.setString(3, tipoPersona.getNombre());
            sta.setString(4, tipoPersona.getApellido());
            sta.setInt(5, tipoPersona.getEdad());
            sta.setString(6, tipoPersona.getDireccion());
            sta.setString(7, tipoPersona.getCorreo());
            sta.setString(8, tipoPersona.getReligion());
            sta.setString(9, tipoPersona.getTelefono());
            sta.setInt(10, tipoPersona.getId_tipoPersona());
             
            
            int filas = sta.executeUpdate();
            
           if(filas>0){
               actualizar= true;
           }
          
        }catch (Exception e){
               JOptionPane.showMessageDialog(null, "ESTA MAL EL INGRESO DE DATOS MODIFICAR Beneficciarios"+e,"Error", JOptionPane.WARNING_MESSAGE);
               
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
        Connection conexion= null;
        Statement sta=null;
        PreparedStatement stm= null;
        ResultSet rs=null;
        ArrayList<Object[]> tipoPersonaList= new ArrayList<>();
        
        String sql="SELECT t.nombre, t.apellido, t.cedula, t.telefono, t.religion, t.correo,t.direccion,\n" +
                    "FROM  tipoPersona t\n";
        
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.createStatement();
            sta.execute(sql);
            sta.close();

            stm=conexion.prepareStatement(sql);
            rs= stm.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[7];
                for(int i=0; i<=6;i++){
                   fila[i]=rs.getObject(i+1);
                }
                tipoPersonaList.add(fila);
            }
            conexion.close();
               
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR tipoPersona:"+e.getMessage());
       } finally{
           return tipoPersonaList;
       }
    }

    @Override
    public tipoPersonaEntity obtener(tipoPersonaEntity tipoPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
