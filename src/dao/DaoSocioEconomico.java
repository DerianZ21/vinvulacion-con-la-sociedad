/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import idao.ISocioEconomico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Reg_dataSocial;

/**
 *
 * @author steve
 */
public class DaoSocioEconomico extends Conexion implements ISocioEconomico{
    final String INSERT= "Insert into public.socioeconomico(per_sus_ho, form_tra, otros_ing, gast_men) VALUES (?,?,?,?)";
    final String DELETE="DELETE from public.socioeconomico where id_socieco=?";  
    @Override
    public boolean insertar(Reg_dataSocial SocioEco) {
       boolean registrar = false;
       PreparedStatement sta=null;
       try {
            this.conectar();
            sta=this.conexion.prepareStatement(INSERT);
            sta.setString(1, SocioEco.getPer_sustento());
            sta.setString(2, SocioEco.getPer_tipo_trabajo());
            sta.setString(3, SocioEco.getPer_otro_ingreso());
            sta.setString(4, SocioEco.getPer_gastomensual());
            sta.executeUpdate();
         
        }catch (SQLException e){
            System.out.println("Esta mal el registro sql del insertar"+e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id_socioeco "
                     + " a ingresado un dato que no existe a esa tabla", "Error", JOptionPane.WARNING_MESSAGE);
        }catch (Exception ex) {
            Logger.getLogger(DaoSocioEconomico.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.desconectar();
            } catch (Exception ex) {
                Logger.getLogger(DaoSocioEconomico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registrar;
    }

    @Override
    public boolean eliminar(Reg_dataSocial SocioEco) {
       boolean eliminar=false;
       try{
             try {
               this.conectar();
                } catch (Exception ex) {
                    Logger.getLogger(DaoSocioEconomico.class.getName()).log(Level.SEVERE, null, ex);
                }  
            PreparedStatement st=this.conexion.prepareStatement(DELETE); 
            
            st.setInt(1, SocioEco.getId_socioeconmico());
              int filas = st.executeUpdate();
           if(filas>0){
               conexion.close();
           }else{
               conexion.close();
           }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Ocurrio un error EN el sql eliminar:"+e.getMessage());
           System.out.println("esta mal el registro sql del idSocioEconomico"+e);
	}
        return eliminar;
       
    }

    @Override
    public boolean modificar(Reg_dataSocial SocioEco) {
       boolean actualizar= false;
	PreparedStatement sta=null;
        try {
             this.conectar();
             String sql= "UPDATE public.socioeconomico SET per_sus_ho = ? , form_tra = ? , otros_ing = ? , gast_men = ?  WHERE id_socieco = ?";
             sta=this.conexion.prepareStatement(sql);
             sta.setString(1, SocioEco.getPer_sustento());
             sta.setString(2, SocioEco.getPer_tipo_trabajo());
             sta.setString(3, SocioEco.getPer_otro_ingreso());
             sta.setString(4, SocioEco.getPer_gastomensual());
             sta.setInt(5, SocioEco.getId_socioeconmico());
             sta.executeUpdate();
         
          if(sta.executeUpdate()==0){
                // throw new Exception("El registro no se ha modificado");
           }
        }catch (Exception e){
               JOptionPane.showMessageDialog(null, "ESTA MAL EL INGRESO DE DATOS MODIFICAR SocioEco"+e);
               JOptionPane.showMessageDialog(null, "Faltan datos"
                     + " a ingresado un dato que no existe a esa tabla, o no existe el codigo que desea cambiar", "Error", JOptionPane.WARNING_MESSAGE);
           // throw e;
        }finally{
                try {
                    this.desconectar();
                } catch (Exception ex) {
                    Logger.getLogger(DaoSocioEconomico.class.getName()).log(Level.SEVERE, null, ex);
                }
        }return actualizar;
    }

    @Override
    public ArrayList<Object[]> consultar() {
        Connection conexion= null;
        Statement sta=null;
        PreparedStatement stm= null;
        ResultSet rs=null;
        ArrayList<Object[]> SocioEcoList= new ArrayList<>();
        
        String sql="SELECT id_socieco , per_sus_ho, form_tra, otros_ing , gast_men FROM public.socioeconomico ORDER BY id_socieco"; 
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
                SocioEcoList.add(fila);
            }
            conexion.close();
               
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR LOS DATOS SOCIOECONOMICOS:"+e.getMessage());
       }finally{
           return  SocioEcoList;
       }
    }

    @Override
    public Reg_dataSocial obtener(Reg_dataSocial SocioEco) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Reg_dataSocial datoSocial= new Reg_dataSocial();
        
        boolean valor = false;
        
     
        String sql="SELECT * from socioeconomico where per_sus_ho= ? and form_tra= ? and otros_ing= ? and gast_men=?";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setString(1, SocioEco.getPer_sustento());
            System.out.println("sustenta---" + SocioEco.getPer_sustento());
            System.out.println("tipo---" + SocioEco.getPer_tipo_trabajo());
            System.out.println("otro---" + SocioEco.getPer_otro_ingreso());
            System.out.println("gasto---" + SocioEco.getPer_gastomensual());
            
            sta.setString(2, SocioEco.getPer_tipo_trabajo());
            sta.setString(3, SocioEco.getPer_otro_ingreso());
            sta.setString(4, SocioEco.getPer_gastomensual());
            
            valor = sta.execute();
            datoSocial.setId_socioeconmico(0);
           
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                datoSocial.setId_socioeconmico((Integer) rs.getObject(1));
                datoSocial.setPer_sustento((String) rs.getObject(2));
                datoSocial.setPer_tipo_trabajo((String)rs.getObject(3));
                datoSocial.setPer_otro_ingreso((String)rs.getObject(4));
                datoSocial.setPer_gastomensual((String) rs.getObject(5));
            }
            sta.close();
            conexion.close();
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER USUARIO:"+e.getMessage());
       } finally{
           return datoSocial;
       }
    }

    @Override
    public Reg_dataSocial obtenerDatos(Reg_dataSocial SocioEco) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Reg_dataSocial datoSocial= new Reg_dataSocial();
        
        boolean valor = false;
        
        
        String sql="SELECT * from socioeconomico where id_socieco= ?";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setInt(1, SocioEco.getId_socioeconmico());
            
            valor = sta.execute();
            datoSocial.setId_socioeconmico(0);
           
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                datoSocial.setId_socioeconmico((Integer) rs.getObject(1));
                datoSocial.setPer_sustento((String) rs.getObject(2));
                datoSocial.setPer_tipo_trabajo((String)rs.getObject(3));
                datoSocial.setPer_otro_ingreso((String)rs.getObject(4));
                datoSocial.setPer_gastomensual((String) rs.getObject(5));
            }
            sta.close();
            conexion.close();
            
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER USUARIO:"+e.getMessage());
       } finally{
           return datoSocial;
       }
    }
    
}
