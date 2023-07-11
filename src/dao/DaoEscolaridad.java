/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import idao.IEscolaridad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Reg_Escolar;

/**
 *
 * @author florm
 */
public class DaoEscolaridad extends Conexion implements IEscolaridad{
    final String DELETE="DELETE from public.escuela where id_escu=?";


    @Override
     public boolean insertar(Reg_Escolar escuelita){
         String INSERT= "insert into escuela(escolaridad,nom_escu,grado,nom_prof,tele_prof,dir_escu) values(?,?,?,?,?,?)";
        boolean registrar=false;
        
        PreparedStatement sta=null;
        
        try {
            this.conectar();
            sta=this.conexion.prepareStatement(INSERT);
            
            
            sta.setString(1, escuelita.getBen_escolaridad());
            sta.setString(2, escuelita.getBen_nomEsc());
            sta.setString(3, escuelita.getBen_grado());
            sta.setString(4, escuelita.getBen_nomprof());
            sta.setString(5, escuelita.getBen_numprof());
            sta.setString(6, escuelita.getBen_dir());
            
            sta.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Esta mal el registro sql del insertar "+e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id_escu"
                     + " a ingresado un dato que no existe a esa tabla", "Error", JOptionPane.WARNING_MESSAGE);
            
             Logger.getLogger(DaoEscolaridad.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.desconectar();
            } catch (Exception e) {
                 Logger.getLogger(DaoEscolaridad.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return registrar;
    }

    @Override
    public boolean eliminar(Reg_Escolar e) {
        boolean eliminar=false;
        try{
             try {
               this.conectar();
                } catch (Exception ex) {
                    Logger.getLogger(DaoEscolaridad.class.getName()).log(Level.SEVERE, null, ex);
                }  
            PreparedStatement st=this.conexion.prepareStatement(DELETE); 
            
            st.setInt(1, e.getId_escuela());
              int filas = st.executeUpdate();
           if(filas>0){
               conexion.close();
           }else{
               conexion.close();
           }
        }catch(SQLException ep){
           JOptionPane.showMessageDialog(null,"Ocurrio un error EN el sql eliminar:"+ep.getMessage());
           System.out.println("esta mal el registro sql del Nombre Escolaridad"+ep);
	}
        return eliminar;
    
    }

    
    @Override
    public boolean modificar(Reg_Escolar e) {
        boolean actualizar= false;
	PreparedStatement sta=null;
        try {
             this.conectar();
             
             String sql= "UPDATE public.escuela SET escolaridad = ? , nom_escu = ? , grado = ? , nom_prof = ? , tele_prof = ? , dir_escu = ?  WHERE id_escu = ?";
             sta=this.conexion.prepareStatement(sql);

             System.out.println("id "+ e.getId_escuela());
             System.out.println("escolaridad "+ e.getBen_escolaridad());
             System.out.println("nombre "+ e.getBen_nomEsc());
             System.out.println("grado "+ e.getBen_grado());
             System.out.println("profesor "+ e.getBen_nomprof());
             System.out.println("telefono "+ e.getBen_numprof());
             System.out.println("direccion "+ e.getBen_dir());
             
             //no se puede cambiar el pk
             sta.setString(1, e.getBen_escolaridad());
             sta.setString(2, e.getBen_nomEsc());
             sta.setString(3, e.getBen_grado());
             sta.setString(4, e.getBen_nomprof());
             sta.setString(5, e.getBen_numprof());
             sta.setString(6, e.getBen_dir());
             sta.setInt(7, e.getId_escuela());
             
             
             sta.executeUpdate();
         
          if(sta.executeUpdate()>0){
               actualizar= true;
           }
        }catch (Exception ep){
               JOptionPane.showMessageDialog(null, "ESTA MAL EL INGRESO DE DATOS MODIFICAR Escolaridad "+ep);
               JOptionPane.showMessageDialog(null, "Faltan campos en Escolaridad"
                     + " a ingresado un dato que no existe a esa tabla, o no existe el codigo que desea cambiar", "Error", JOptionPane.WARNING_MESSAGE);
           // throw e;
        }finally{
                try {
                    this.desconectar();
                } catch (Exception ex) {
                    Logger.getLogger(DaoEscolaridad.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return actualizar;
        
    }

    

    @Override
    public ArrayList<Object[]> consultar() {
        Connection conexion= null;
        Statement sta=null;
        PreparedStatement stm= null;
        ResultSet rs=null;
        ArrayList<Object[]> esList= new ArrayList<>();
        
        
//        String sql="SELECT id_usuario, username, password, tipo_usuario, estado FROM public.usuario ORDER BY id_usuario";
        String sql="SELECT * from escuela order by id_escu";
        
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
                esList.add(fila);
            }
            conexion.close();
               
        } catch(Exception e){
            //Aqui puede ver un error al consultar, corrigeme
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR Escolaridad:"+e.getMessage());
       } finally{
           return esList;
        }  
    }

    @Override
    public Reg_Escolar obtener(Reg_Escolar e) {
       Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Reg_Escolar escolaNuev = new Reg_Escolar();
        
        boolean valor = false;

        String sql="SELECT * from escuela where escolaridad= ? and nom_escu = ? and grado=? and nom_prof=? and tele_prof =? and dir_escu=?";
        
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setString(1, e.getBen_escolaridad());
            sta.setString(2, e.getBen_nomEsc());
            sta.setString(3, e.getBen_grado());
            sta.setString(4, e.getBen_nomprof());
            sta.setString(5, e.getBen_numprof());
            sta.setString(6, e.getBen_dir());
            
            valor = sta.execute();
            
            rs = sta.executeQuery();
            while(rs.next()){
                
                escolaNuev.setId_escuela((Integer) rs.getObject(1));
                escolaNuev.setBen_escolaridad((String) rs.getObject(2));
                escolaNuev.setBen_nomEsc((String)rs.getObject(3));
                escolaNuev.setBen_grado((String)rs.getObject(4));
                escolaNuev.setBen_nomprof((String) rs.getObject(5));
                escolaNuev.setBen_numprof((String) rs.getObject(6));
                escolaNuev.setBen_dir((String) rs.getObject(7));
            }
            sta.close();
            conexion.close();
               
        }finally{
           return escolaNuev;
        }  
        
    }

    @Override
    public Reg_Escolar obtenerDatos(Reg_Escolar e) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Reg_Escolar escolaNuev = new Reg_Escolar();
        
        boolean valor = false;

        String sql="SELECT * from escuela where id_escu= ? ";
        
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setInt(1, e.getId_escuela());
            
            valor = sta.execute();
            
            rs = sta.executeQuery();
            while(rs.next()){
                escolaNuev.setId_escuela((Integer) rs.getObject(1));
                escolaNuev.setBen_escolaridad((String) rs.getObject(2));
                escolaNuev.setBen_nomEsc((String)rs.getObject(3));
                escolaNuev.setBen_grado((String)rs.getObject(4));
                escolaNuev.setBen_nomprof((String) rs.getObject(5));
                escolaNuev.setBen_numprof((String) rs.getObject(6));
                escolaNuev.setBen_dir((String) rs.getObject(7));
            }
            sta.close();
            conexion.close();
               
        }finally{
           return escolaNuev;
        }  
    }
}
