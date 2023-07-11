/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import idao.IFicha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Reg_Ficha;

/**
 *
 * @author steve
 */
public class DaoFicha extends Conexion implements IFicha{
    final String INSERT = "Insert into public.ficha_prin(fech_ins) VALUES(?)";
    final String DELETE="DELETE from public.ficha_prin where id_fich=?";

    @Override
    public boolean insertar() {
        Date date = new Date();
        boolean registrar = false;
        PreparedStatement sta=null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(date);

        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
        try {
            this.conectar();
            sta=this.conexion.prepareStatement(INSERT);
             
            sta.setDate(1, date1);
            
            
            sta.executeUpdate();
         
        } catch (SQLException e){
            System.out.println("Esta mal el registro sql del insertar"+e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id_fich "
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
    public boolean eliminar(Reg_Ficha Ficha) {
        boolean eliminar=false;
        try{
             try {
               this.conectar();
                } catch (Exception ex) {
                    Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }  
            PreparedStatement st=this.conexion.prepareStatement(DELETE); 
            
            st.setInt(1, Ficha.getId_ficha());
            
              int filas = st.executeUpdate();
           if(filas>0){
               conexion.close();
           }else{
               conexion.close();
           }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Ocurrio un error EN el sql eliminar:"+e.getMessage());
           System.out.println("esta mal el ingreso de idFicha"+e);
	}
        return eliminar;
    }

    @Override
    public ArrayList<Object[]> consultar() {
        Connection conexion= null;
        Statement sta=null;
        PreparedStatement stm= null;
        ResultSet rs=null;
        ArrayList<Object[]> FichaList = new ArrayList<>();
        
        
        String sql="SELECT id_fich, id_bene, fech_ins;";
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
                FichaList.add(fila);
            }
            conexion.close();
               
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR Ficha:"+e.getMessage());
       } finally{
           return FichaList;
       }
        
    }
    
}
