/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import idao.IMama;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Mama;

/**
 *
 * @author Sebastian Riofrio
 */
public class DaoMama  extends Conexion implements IMama{
    final String INSERT= "Insert into public.Mama(est_civ_ma,lug_tra_ma,cargo_ma) VALUES (?,?,?)";
    final String DELETE="DELETE from public.Mama where id_mama=?";
    
    @Override
    public boolean insertar(Mama ma) {
        boolean registrar = false;
        PreparedStatement sta=null;
        try {
            this.conectar();
            sta=this.conexion.prepareStatement(INSERT);
             
            sta.setString(1, ma.getNombre());
            sta.setString(2, ma.getEst_civ_ma());
            sta.setString(3, ma.getLug_tra_ma());
            sta.setString(4, ma.getCargo_ma());
            sta.setString(5, ma.getTelefono());
            
            
            
            sta.executeUpdate();
         
        }catch (SQLException e){
            System.out.println("Esta mal el registro sql del insertar"+e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id_mama "
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
    public boolean eliminar(Mama ma) {
        boolean eliminar=false;
        try{
             try {
               this.conectar();
                } catch (Exception ex) {
                    Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }  
            PreparedStatement st=this.conexion.prepareStatement(DELETE); 
            
            st.setInt(1, ma.getId_mama());
              int filas = st.executeUpdate();
           if(filas>0){
               conexion.close();
           }else{
               conexion.close();
           }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Ocurrio un error EN el sql eliminar:"+e.getMessage());
           System.out.println("esta mal el registro sql del idMama"+e);
	}
        return eliminar;
    }

    @Override
    public boolean modificar(Mama ma) {
        boolean actualizar= false;
	PreparedStatement sta=null;
        try {
             this.conectar();  
             String sql= "UPDATE public.Mama SET est_civ_ma = ?, lug_tra_ma = ?, cargo_ma = ? WHERE id_mama = ?";
             sta=this.conexion.prepareStatement(sql);
             
             sta.setString(1, ma.getNombre());
             sta.setString(2, ma.getEst_civ_ma());
             sta.setString(3, ma.getLug_tra_ma());
             sta.setString(4, ma.getCargo_ma());
             sta.setString(5, ma.getTelefono());
             sta.setInt(6, ma.getId_mama());
             
             sta.executeUpdate();
         
          if(sta.executeUpdate()==0){
                // throw new Exception("El registro no se ha modificado");
           }
        }catch (Exception e){
               JOptionPane.showMessageDialog(null, "ESTA MAL EL INGRESO DE DATOS MODIFICAR mama "+e);
               JOptionPane.showMessageDialog(null, "Faltan datos o en el campo mama_id"
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
        ArrayList<Object[]> mamaList= new ArrayList<>();
        
        
//        String sql="SELECT id_usuario, username, password, tipo_usuario, estado FROM public.usuario ORDER BY id_usuario";
        String sql="SELECT m.id_mama, t.nombre, m.est_civ_ma, m.lug_tra_ma, m.cargo_ma, t.telefono\n"+
                "FROM mama m, tipoPersona t ORDER BY id_mama.";
        
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
                mamaList.add(fila);
            }
            conexion.close();
               
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR PAPA:"+e.getMessage());
       } finally{
           return mamaList;
       }
    }

    @Override
    public Mama obtener(Mama ma) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Mama maNuev = new Mama();
        
        boolean valor = false;
        
        
        String sql="SELECT * FROM mama m, tipoPersona t\n" +
          "where t.nombre=?  and m.est_civ_ma=? and m.lug_tra_ma=? and m.cargo_ma=? and t.telefono=?;";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setString(1, ma.getNombre());
            sta.setString(2, ma.getEst_civ_ma());
            sta.setString(3, ma.getLug_tra_ma());
            sta.setString(4, ma.getCargo_ma());
            sta.setString(5, ma.getTelefono());
            
            
            valor = sta.execute();
            maNuev.setId_mama(0);
           
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                maNuev.setId_mama((Integer) rs.getObject(1));
                maNuev.setNombre((String) rs.getObject(2));
                maNuev.setEst_civ_ma((String)rs.getObject(3));
                maNuev.setLug_tra_ma((String)rs.getObject(4));
                maNuev.setCargo_ma((String) rs.getObject(5));
                maNuev.setTelefono((String) rs.getObject(6));
            }
            sta.close();
            conexion.close();
            
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER USUARIO:"+e.getMessage());
       } finally{
           return maNuev;
       }}

    @Override
    public Mama obtenerNom(Mama ma) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Mama maNuev = new Mama();
        
        boolean valor = false;
        
        
        String sql="SELECT * FROM tipoPersonaa where nombre = ?;";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setString(1, ma.getNombre());
            
            
            valor = sta.execute();
            maNuev.setId_mama(0);
           
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                maNuev.setId_mama((Integer) rs.getObject(1));
                maNuev.setNombre((String) rs.getObject(2));
                maNuev.setEst_civ_ma((String)rs.getObject(3));
                maNuev.setLug_tra_ma((String)rs.getObject(4));
                maNuev.setCargo_ma((String) rs.getObject(5));
                maNuev.setTelefono((String) rs.getObject(6));
            }
            sta.close();
            conexion.close();
            
            if (maNuev.getNombre() == null){
                maNuev.setNombre(ma.getNombre());
            }
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER mamá:"+e.getMessage());
       } finally{
           return maNuev;
       }
    }

    @Override
    public Mama obtenerDato(Mama ma) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Mama maNuev = new Mama();
        
        boolean valor = false;
        
        
        String sql="SELECT * FROM mama where id_mama = ?;";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setInt(1, ma.getId_mama());
            
            
            valor = sta.execute();
            maNuev.setId_mama(0);
           
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                maNuev.setId_mama((Integer) rs.getObject(1));
                maNuev.setNombre((String) rs.getObject(2));
                maNuev.setEst_civ_ma((String)rs.getObject(3));
                maNuev.setLug_tra_ma((String)rs.getObject(4));
                maNuev.setCargo_ma((String) rs.getObject(5));
                maNuev.setTelefono((String) rs.getObject(6));
            }
            sta.close();
            conexion.close();
            
            if (maNuev.getNombre() == null){
                maNuev.setNombre(ma.getNombre());
            }
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER mamá:"+e.getMessage());
       } finally{
           return maNuev;
       }
    }
    
}
