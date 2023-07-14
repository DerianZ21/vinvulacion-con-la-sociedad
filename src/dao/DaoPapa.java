/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import idao.IPapa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Papa;
import modelo.tipoPersonaEntity;

/**
 *
 * @author Sebastian Riofrio
 */
public class DaoPapa extends Conexion implements IPapa{
    
    final String DELETE="DELETE from public.Papa where id_papa=?";
    final String INSERT_TIPO_PERSONA = "INSERT INTO public.tipoPersona (nombre, telefono) VALUES (?, ?)";
    final String INSERT_PAPA = "INSERT INTO public.Papa (id_tipo_persona, est_civ_pa, lug_tra_pa, cargo_pa) VALUES (?, ?, ?, ?)";

    @Override
    public boolean insertar(Papa pa) {
        boolean registrar = false;
        PreparedStatement staTipoPersona = null;
        PreparedStatement staPapa = null;
        ResultSet generatedKeys = null;
        try {
            this.conectar();
            this.conexion.setAutoCommit(false); // Iniciar transacción

            // Insertar en tabla tipoPersona
            staTipoPersona = this.conexion.prepareStatement(INSERT_TIPO_PERSONA, Statement.RETURN_GENERATED_KEYS);
            staTipoPersona.setString(1, pa.getNombre());
            staTipoPersona.setString(2, pa.getTelefono());
            staTipoPersona.executeUpdate();

            // Obtener el ID generado para el registro insertado en tipoPersona
            generatedKeys = staTipoPersona.getGeneratedKeys();
            int idTipoPersona = -1;
            if (generatedKeys.next()) {
                idTipoPersona = generatedKeys.getInt(1);
            }

            if (idTipoPersona != -1) {
                // Insertar en tabla Papa
                staPapa = this.conexion.prepareStatement(INSERT_PAPA);
                staPapa.setInt(1, idTipoPersona);
                staPapa.setString(2, pa.getEst_civ_pa());
                staPapa.setString(3, pa.getLug_tra_pa());
                staPapa.setString(4, pa.getCargo_pa());
                staPapa.executeUpdate();

                registrar = true;
            }

            this.conexion.commit(); // Confirmar la transacción
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL del insertar: " + e);
            JOptionPane.showMessageDialog(null, "Faltan datos o se ingresó un dato incorrecto en la tabla tipoPersona", "Error", JOptionPane.WARNING_MESSAGE);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback(); // Revertir la transacción en caso de error
                }
            } catch (SQLException ex) {
                System.out.println("Error al realizar rollback: " + ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (staTipoPersona != null) {
                    staTipoPersona.close();
                }
                if (staPapa != null) {
                    staPapa.close();
                }
                this.conexion.setAutoCommit(true); // Restaurar el modo de autocommit
                this.desconectar();
            } catch (Exception ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registrar;
}
    @Override
    public boolean eliminar(Papa pa) {
        boolean eliminar=false;
        try{
             try {
               this.conectar();
                } catch (Exception ex) {
                    Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }  
            PreparedStatement st=this.conexion.prepareStatement(DELETE); 
            
            st.setInt(1, pa.getId_papa());
              int filas = st.executeUpdate();
           if(filas>0){
               conexion.close();
           }else{
               conexion.close();
           }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Ocurrio un error EN el sql eliminar:"+e.getMessage());
           System.out.println("esta mal el registro sql del idPapa"+e);
	}
        return eliminar;
    }

    @Override
    public boolean modificar(Papa pa) {
        boolean actualizar= false;
	PreparedStatement sta=null;
        try {
             this.conectar();
             String sql= "UPDATE public.Papa SET est_civ_pa = ?, lug_tra_pa = ?, cargo_pa = ? WHERE id_papa = ?";
             sta=this.conexion.prepareStatement(sql);
             
            sta.setString(1, pa.getEst_civ_pa());
            sta.setString(2, pa.getLug_tra_pa());
            sta.setString(3, pa.getCargo_pa());
            sta.setInt(4, pa.getId_papa());
             
             sta.executeUpdate();
         
          if(sta.executeUpdate()==0){
                // throw new Exception("El registro no se ha modificado");
           }
        }catch (Exception e){
               JOptionPane.showMessageDialog(null, "ESTA MAL EL INGRESO DE DATOS MODIFICAR papa "+e);
               JOptionPane.showMessageDialog(null, "Faltan datos o en el campo papa_id"
                     + " a ingresado un dato que no existe a esa tabla, o no existe el codigo que desea cambiar", "Error", JOptionPane.WARNING_MESSAGE);
           // throw e;
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
        ArrayList<Object[]> papaList= new ArrayList<>();
        
        
//        String sql="SELECT id_usuario, username, password, tipo_usuario, estado FROM public.usuario ORDER BY id_usuario";
        String sql="SELECT p.id_papa, t.nombre, p.est_civ_pa, p.lug_tra_pa, p.cargo_pa, t.telefono\n"+
                "FROM papa p, tipoPersona t ORDER BY id_papa.";
        
        
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.createStatement();
            sta.execute(sql);
            sta.close();

            stm=conexion.prepareStatement(sql);
            rs= stm.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[6];
                for(int i=0; i<=5;i++){
                   fila[i]=rs.getObject(i+1);
                }
                papaList.add(fila);
            }
            System.out.println("---------entrooo");
            conexion.close();
               
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR PAPA:"+e.getMessage());
       } finally{
           return papaList;
       }
    }

    @Override
    public Papa obtener(Papa pa) {
        
    Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Papa paNuev = new Papa();
        
        tipoPersonaEntity tipoPersona= new tipoPersonaEntity();
        
        boolean valor = false;
        
        
        String sql="SELECT * FROM papa p, tipoPersona t\n" +
          "where t.nombre=?  and p.est_civ_pa=? and p.lug_tra_pa=? and p.cargo_pa=? and t.telefono=?;";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setString(1, pa.getNombre());
            sta.setString(2, pa.getEst_civ_pa());
            sta.setString(3, pa.getLug_tra_pa());
            sta.setString(4, pa.getCargo_pa());
            sta.setString(5, pa.getTelefono());
            
            
            valor = sta.execute();
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                paNuev.setId_papa((Integer) rs.getObject(1));
                paNuev.setNombre((String) rs.getObject(2));
                paNuev.setEst_civ_pa((String)rs.getObject(3));
                paNuev.setLug_tra_pa((String)rs.getObject(4));
                paNuev.setCargo_pa((String) rs.getObject(5));
                paNuev.setTelefono((String) rs.getObject(6));
            }
            sta.close();
            conexion.close();
            
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER papá:"+e.getMessage());
       } finally{
           return paNuev;
       }}

    @Override
    public Papa obtenerNom(Papa pa) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Papa paNuev = new Papa();
        
        boolean valor = false;
        
        
        String sql="SELECT * FROM tipoPersona where nombre = ? ;";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setString(1, pa.getNombre());
            
            valor = sta.execute();
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                paNuev.setId_papa((Integer) rs.getObject(1));
                paNuev.setNombre((String) rs.getObject(2));
                paNuev.setEst_civ_pa((String)rs.getObject(3));
                paNuev.setLug_tra_pa((String)rs.getObject(4));
                paNuev.setCargo_pa((String) rs.getObject(5));
                paNuev.setTelefono((String) rs.getObject(6));
            }
            sta.close();
            conexion.close();
            
            if (paNuev.getNombre()== null){
                paNuev.setNombre(pa.getNombre());
            }
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER papá:"+e.getMessage());
       } finally{
           return paNuev;
       }}

    @Override
    public Papa obtenerDato(Papa pa) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Papa paNuev = new Papa();
        
        boolean valor = false;
        
        
        String sql="SELECT * FROM papa where id_papa = ? ;";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setInt(1, pa.getId_papa());
            
            valor = sta.execute();
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                paNuev.setId_papa((Integer) rs.getObject(1));
                paNuev.setNombre((String) rs.getObject(2));
                paNuev.setEst_civ_pa((String)rs.getObject(3));
                paNuev.setLug_tra_pa((String)rs.getObject(4));
                paNuev.setCargo_pa((String) rs.getObject(5));
                paNuev.setTelefono((String) rs.getObject(6));
            }
            sta.close();
            conexion.close();
            
            if (paNuev.getNombre() == null){
                paNuev.setNombre(pa.getNombre());
            }
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER papá:"+e.getMessage());
       } finally{
           return paNuev;
       }}
}
