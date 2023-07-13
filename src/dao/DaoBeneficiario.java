/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import idao.IBeneficiario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.BeneficiarioEntity;
import modelo.Reg_Benf;


public class DaoBeneficiario extends Conexion implements IBeneficiario {
    final String INSERT= "Insert into public.beneficiario(prom_sal,num_conv, id_escu, id_socieco) VALUES (?,?,?,?)";
   

     @Override
    public boolean insertar(Reg_Benf beneficiario) {
        
        boolean registrar = false;
        PreparedStatement sta=null;
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = simpleDateFormat.format(beneficiario.getFech_nac());
        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);
        
        try {
            this.conectar();
            sta=this.conexion.prepareStatement(INSERT);
             
            sta.setString(1, beneficiario.getCedula());
            
            
            sta.setDate(2, date1);
            
            sta.setString(3, beneficiario.getNombre());
            sta.setString(4, beneficiario.getApellido());
            sta.setInt(5, beneficiario.getEdad());
            sta.setString(6, beneficiario.getDireccion());
            sta.setString(7, beneficiario.getCorreo());
            sta.setString(8, beneficiario.getReligion());
            sta.setString(9, beneficiario.getProm_sal());
            sta.setString(10, beneficiario.getTelefono());
            sta.setInt(11, beneficiario.getNum_conv());
            sta.setInt(12, beneficiario.getId_escu());
            sta.setInt(13, beneficiario.getId_socioec());
            
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
    public boolean eliminar(Reg_Benf beneficiario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Reg_Benf bene) {
        boolean actualizar= false;
	PreparedStatement sta=null;
        try {
             this.conectar();
             String sql= "UPDATE beneficiario SET  prom_sal=?, num_conv=? WHERE id_bene = ?";
             sta=this.conexion.prepareStatement(sql);

            
            sta.setBoolean(1,Boolean.parseBoolean(bene.getProm_sal()));
            sta.setInt(2, bene.getNum_conv());
            sta.setInt(3, bene.getId_benf());
             
            
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
        ArrayList<Object[]> beneficiariosList= new ArrayList<>();
        
        String sql="SELECT t.cedula, t.nombre, t.apellido,  t.direccion, t.telefono\n" +
<<<<<<< HEAD
                    "FROM  tipoPersona t ";
=======
                "FROM tipoPersona t";
>>>>>>> 524838123c04a47a83abe419a23a176cb6187ee8
        
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.createStatement();
            sta.execute(sql);
            sta.close();

            stm=conexion.prepareStatement(sql);
            rs= stm.executeQuery();
            while(rs.next()){
<<<<<<< HEAD
                Object[] fila = new Object[5];
                for(int i=0; i<=4;i++){
=======
                Object[] fila = new Object[7];
                for(int i=0; i<=6;i++){
>>>>>>> 524838123c04a47a83abe419a23a176cb6187ee8
                   fila[i]=rs.getObject(i+1);
                }
                beneficiariosList.add(fila);
            }
            conexion.close();
               
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR Beneficiario:"+e.getMessage());
       } finally{
           return beneficiariosList;
       }
    }

    @Override
    public Reg_Benf obtener(Reg_Benf beneficiario) {
        Connection conexion= null;
        PreparedStatement sta=null;
        Statement stm= null;
        ResultSet rs=null;
        Reg_Benf benefi= new Reg_Benf();
        
        boolean valor = false;
        
        String sql="SELECT * FROM tipoPersona where cedula = ? and nombre = ? and apellido = ? and direccion = ? ";
        
        try {
            this.conectar();
            conexion=this.getCon();
            sta=conexion.prepareStatement(sql);
            sta.setString(1, beneficiario.getCedula());
            sta.setString(2, beneficiario.getNombre());
            sta.setString(3, beneficiario.getApellido());
            sta.setString(4, beneficiario.getDireccion());
            
            valor = sta.execute();
            beneficiario.setId_benf(0);
            
            rs = sta.executeQuery(); 
            
            while(rs.next()){
                beneficiario.setId_benf((Integer) rs.getObject(1));
                beneficiario.setCedula((String) rs.getObject(2));
                beneficiario.setFech_nac((Date)rs.getObject(3));
                beneficiario.setNombre((String)rs.getObject(4));
                beneficiario.setApellido((String)rs.getObject(5));
                beneficiario.setEdad((Integer)rs.getObject(6));
                beneficiario.setDireccion((String)rs.getObject(7));
                beneficiario.setCorreo((String)rs.getObject(8));
                beneficiario.setReligion((String)rs.getObject(9));
                beneficiario.setProm_sal(rs.getObject(10).toString());
                beneficiario.setTelefono((String)rs.getObject(11));
                beneficiario.setId_padres((Integer)rs.getObject(12));
                beneficiario.setId_escu((Integer)rs.getObject(13));
                beneficiario.setId_socioec((Integer)rs.getObject(14));
                beneficiario.setNum_conv((Integer)rs.getObject(15)); 
            }
            sta.close();
            conexion.close();              
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql Obtener Beneficiario:"+e.getMessage());
       } finally{
           return beneficiario;
       }
    }
    
}
