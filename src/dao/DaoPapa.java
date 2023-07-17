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

/**
 *
 * @author Sebastian Riofrio
 */
public class DaoPapa extends Conexion implements IPapa{
    final String INSERT= "Insert into public.Papa( nombre_pa, est_civ_pa, lug_tra_pa, cargo_pa, tele_pa) VALUES (?,?,?,?,?)";
    final String DELETE="DELETE from public.Papa where id_papa=?";

    //Papa paNuev ;
    @Override
    public boolean insertar(Papa pa) {
        boolean registrar = false;
        PreparedStatement sta=null;
        try {
            this.conectar();
            sta=this.conexion.prepareStatement(INSERT);
             
            sta.setString(1, pa.getNombre());
            sta.setString(2, pa.getEst_civ_pa());
            sta.setString(3, pa.getLug_tra_pa());
            sta.setString(4, pa.getCargo_pa());
            sta.setString(5, pa.getTelefono());
            
            
            
            sta.executeUpdate();
         
        }catch (SQLException e){
            System.out.println("Esta mal el registro sql del insertar"+e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id_papa "
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
             String sql= "UPDATE public.Papa SET nombre_pa = ?, est_civ_pa = ?, lug_tra_pa = ?, cargo_pa = ?, tele_pa = ? WHERE id_papa = ?";
             sta=this.conexion.prepareStatement(sql);
             
            sta.setString(1, pa.getNombre());
            sta.setString(2, pa.getEst_civ_pa());
            sta.setString(3, pa.getLug_tra_pa());
            sta.setString(4, pa.getCargo_pa());
            sta.setString(5, pa.getTelefono());
            sta.setInt(6, pa.getId_papa());
             
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
        String sql="SELECT id_papa, nombre_pa, est_civ_pa, lug_tra_pa, cargo_pa, tele_pa FROM public.Papa ORDER BY id_papa ";
        
        
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
        
        boolean valor = false;
        
        
        String sql="SELECT * FROM papa where nombre_pa = ? and est_civ_pa = ? and lug_tra_pa = ? and cargo_pa = ? and tele_pa= ?;";
       
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
        
        
        String sql="SELECT * FROM papa where nombre_pa = ? ;";
       
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
            
            if (paNuev.getNombre()== null){
                paNuev.setNombre(pa.getNombre());
            }
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error en sql OBTENER papá:"+e.getMessage());
       } finally{
           return paNuev;
       }
    }
}
