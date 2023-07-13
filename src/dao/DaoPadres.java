/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import idao.IPadres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Padres;

/**
 *
 * @author Sebastian Riofrio
 */
public class DaoPadres extends Conexion implements IPadres{
    final String INSERT= "Insert into public.Padres (ing_econ, id_mama,id_papa) VALUES (?,?,?)";
    final String DELETE="DELETE from public.Padres where id_padres=?";

    @Override
    public boolean insertar(Padres pad) {
        boolean registrar = false;
        PreparedStatement sta=null;
        try {
            this.conectar();
            sta=this.conexion.prepareStatement(INSERT);
             
           sta.setString(1, pad.getIng_econ());
           sta.setInt(2,pad.getId_mama());
           sta.setInt(3,pad.getId_papa());
           
            
            
            sta.executeUpdate();
         
        }catch (SQLException e){
            System.out.println("Esta mal el registro sql del insertar padres"+e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id_padres "
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
    public boolean eliminar(Padres pad) {
        boolean eliminar=false;
        try{
             try {
               this.conectar();
                } catch (Exception ex) {
                    Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }  
            PreparedStatement st=this.conexion.prepareStatement(DELETE); 
            
            st.setInt(1, pad.getId_padres());
              int filas = st.executeUpdate();
           if(filas>0){
               conexion.close();
           }else{
               conexion.close();
           }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Ocurrio un error EN el sql eliminar:"+e.getMessage());
           System.out.println("esta mal el registro sql del idPadres"+e);
	}
        return eliminar;
    }

    @Override
    public boolean modificar(Padres pad) {
        boolean actualizar= false;
	PreparedStatement sta=null;
        try {
             this.conectar();
             String sql= "UPDATE public.Padres SET ing_econ= ? WHERE id_padres = ?";
             sta=this.conexion.prepareStatement(sql);
             
             sta.setInt(1, Integer.parseInt(pad.getIng_econ()));
             sta.setInt(2, pad.getId_padres());
             
             
             sta.executeUpdate();
         
          if(sta.executeUpdate()==0){
                // throw new Exception("El registro no se ha modificado");
           }
        }catch (Exception e){
               JOptionPane.showMessageDialog(null, "ESTA MAL EL INGRESO DE DATOS MODIFICAR Padres"+e);
               JOptionPane.showMessageDialog(null, "Faltan datos o en el campo padres_id"
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
        ArrayList<Object[]> padresList= new ArrayList<>();
        
        
//        String sql="SELECT id_usuario, username, password, tipo_usuario, estado FROM public.usuario ORDER BY id_usuario";
        String sql="SELECT * FROM Padres ORDER BY id_padres ";
        
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.createStatement();
            sta.execute(sql);
            sta.close();

            stm=conexion.prepareStatement(sql);
            rs= stm.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[4];
                for(int i=0; i<=3;i++){
                   fila[i]=rs.getObject(i+1);
                }
                padresList.add(fila);
            }
            conexion.close();
               
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR PAdres:"+e.getMessage());
       } finally{
           return padresList;
       }
    }

    @Override
    public Padres obtener(Padres pad) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Padres paNuev = new Padres();
        
        boolean valor = false;
        
        
        String sql="SELECT * FROM padres where id_mama = ? and id_papa = ?;";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setInt(1, pad.getId_mama());
            sta.setInt(2, pad.getId_papa());
            
            
            valor = sta.execute();
            paNuev.setId_padres(0);
           
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                paNuev.setId_padres((Integer) rs.getObject(1));
                paNuev.setIng_econ((String) rs.getObject(2));
                paNuev.setId_papa((Integer) rs.getObject(3));
                paNuev.setId_mama((Integer)rs.getObject(4));
            }
            sta.close();
            conexion.close();
            
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER Padres:"+e.getMessage());
       } finally{
           return paNuev;
       }
    }

    @Override
    public Padres obtenerDatos(Padres pad) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Padres paNuev = new Padres();
        
        boolean valor = false;
        
        
        String sql="SELECT * FROM padres where id_padres = ? ;";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setInt(1, pad.getId_padres());
            
            
            valor = sta.execute();
            paNuev.setId_padres(0);
           
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                paNuev.setId_padres((Integer) rs.getObject(1));
                paNuev.setIng_econ(rs.getObject(2).toString());
                paNuev.setId_papa((Integer) rs.getObject(3));
                paNuev.setId_mama((Integer)rs.getObject(4));
            }
            sta.close();
            conexion.close();
            
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER Padres:"+e.getMessage());
       } finally{
           return paNuev;
       }
    }

    @Override
    public int obtenerNumPas(String nom, String ape) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        int numero = 0;
        
        boolean valor = false;
        
        String sql="SELECT pas.id_padres FROM beneficiario b, padres pas, papa p, mama m\n" +
                " where b.id_padres = pas.id_padres and pas.id_mama =m.id_mama and pas.id_papa = p.id_papa and b.nom_bene = ? and b.ape_bene = ?";
       
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);

            sta.setString(1, nom);
            sta.setString(2, ape);
            valor = sta.execute();
           
            
            rs = sta.executeQuery();
            
            while(rs.next()){
                numero = (Integer) rs.getObject(1);
            }
            sta.close();
            conexion.close();
            
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER Padres:"+e.getMessage());
       } finally{
           return numero;
       }
    }
}
    
   
