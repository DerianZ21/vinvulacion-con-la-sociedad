/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import idao.IUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;
/**
 *
 * @author pc
 */
public class DaoUsuario extends Conexion implements IUsuario{
    final String INSERT= "Insert into public.usuarios( ur_name, ur_password,ur_type, estado) VALUES (?,?,?,?)";
    final String DELETE="DELETE from public.usuarios where id_user=?";

    Usuario  usuario;
    
    @Override
    public boolean insertar(Usuario usu) {
        boolean registrar = false;
        PreparedStatement sta=null;
        try {
            this.conectar();
            sta=this.conexion.prepareStatement(INSERT);
             
            sta.setString(1, usu.getNombre());
            sta.setString(2, usu.getPassword());
            sta.setString(3, usu.getTipo());
            sta.setBoolean(4, usu.getEstado());
            
            sta.executeUpdate();
            registrar = true;         
        }catch (SQLException e){
            System.out.println("Esta mal el registro sql del insertar"+e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id_usuario "
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
    public boolean eliminar(Usuario usu) {
        boolean eliminar=false;
        try{
             try {
               this.conectar();
                } catch (Exception ex) {
                    Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }  
            PreparedStatement st=this.conexion.prepareStatement(DELETE); 
            
            st.setInt(1, usu.getId());
            
              int filas = st.executeUpdate();
           if(filas>0){
               conexion.close();
           }else{
               conexion.close();
           }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Ocurrio un error EN el sql eliminar:"+e.getMessage());
           System.out.println("esta mal el registro sql del idUsuario"+e);
	}
        return eliminar;
    }

    @Override
    public boolean modificar(Usuario usu) {
        boolean actualizar= false;
	PreparedStatement sta=null;
        try {
             this.conectar();
             String sql= "UPDATE public.usuarios SET ur_type = ? , ur_name = ? , ur_password = ? , estado = ?  WHERE id_user = ?";
             sta=this.conexion.prepareStatement(sql);

             sta.setString(1, usu.getTipo());
             sta.setString(2, usu.getNombre());
             sta.setString(3, usu.getPassword());
             sta.setBoolean(4, usu.getEstado());
             sta.setInt(5, usu.getId());
             
            
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
        Connection conexion= null;
        Statement sta=null;
        PreparedStatement stm= null;
        ResultSet rs=null;
        ArrayList<Object[]> usuaList= new ArrayList<>();
        
        
        String sql="SELECT id_user, ur_name, ur_password, ur_type , estado FROM usuarios ORDER by id_user;";
        
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.createStatement();
            sta.execute(sql);
            sta.close();

            stm=conexion.prepareStatement(sql);
            rs= stm.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[5];
                for(int i=0; i<=4;i++){
                   fila[i]=rs.getObject(i+1);
                }
                usuaList.add(fila);
            }
            conexion.close();
               
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR USUARIO:"+e.getMessage());
       } finally{
           return usuaList;
       }
    }

    @Override
    public Usuario obtener(Usuario usu) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        usuario = new Usuario();
        
        boolean valor = false;
        String sql="SELECT id_user, ur_name, ur_password, ur_type,"
                    + " estado FROM usuarios where ur_name = ? and ur_password = ?;";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setString(1, usu.getNombre());
            sta.setString(2, usu.getPassword());
            
            
            valor = sta.execute();
            usuario.setId(0);
           
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                usuario.setId((Integer) rs.getObject(1));
                usuario.setNombre((String) rs.getObject(2));
                usuario.setPassword((String)rs.getObject(3));
                usuario.setTipo((String)rs.getObject(4));
                usuario.setEstado((boolean) rs.getObject(5));
            }
            sta.close();
            conexion.close();
            
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER USUARIO:"+e.getMessage());
       } finally{
           return usuario;
       }
    }
    
    
}
