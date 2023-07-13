
package dao;

import conexion.Conexion;
import idao.ICurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.CursoEntity;

/**
 *
 * @author N.I.R.N
 */
public class DaoCurso extends Conexion implements ICurso {
     final String INSERT = "Insert into public.curso(nom_cur,estado_cur,dirigido_cur) VALUES (?,?,?)";

    @Override
    public boolean insertar(CursoEntity curso) {
        boolean registrar = false;
        PreparedStatement sta = null;
        try {
            this.conectar();
            sta = this.conexion.prepareStatement(INSERT);

            sta.setString(1, curso.getNombre());
            sta.setBoolean(2, curso.isEstado());          
            sta.setString(3, curso.getDirigido());
            
            sta.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Esta mal el registro sql del insertar" + e);
            JOptionPane.showMessageDialog(null, "Faltan datos o en el campo id_usuario "
                    + " a ingresado un dato que no existe a esa tabla", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.desconectar();
            } catch (Exception ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registrar;      
    }

    @Override
    public boolean eliminar(CursoEntity curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(CursoEntity curso) {
       boolean actualizar= false;
	PreparedStatement sta=null;
        try {
             this.conectar();
             String sql= "UPDATE public.curso SET nom_cur = ?  , estado_cur = ?  , dirigido_cur = ?  WHERE id_curso = ?";
             sta=this.conexion.prepareStatement(sql);

             sta.setString(1, curso.getNombre());
             sta.setBoolean(2, curso.isEstado());
             sta.setString(3, curso.getDirigido());
             sta.setInt(4, curso.getId());
             
            
            int filas = sta.executeUpdate();
            
           if(filas>0){
               actualizar= true;
           }
          
        }catch (Exception e){
               JOptionPane.showMessageDialog(null, "ESTA MAL EL INGRESO DE DATOS MODIFICAR Curso"+e,"Error", JOptionPane.WARNING_MESSAGE);
               
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
        ArrayList<Object[]> cursoList= new ArrayList<>();
        
        String sql="SELECT id_curso,nom_cur,estado_cur,dirigido_cur FROM PUBLIC.curso  ORDER by id_curso";
        
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
                cursoList.add(fila);
            }
            conexion.close();
               
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR curso:"+e.getMessage());
       } finally{
           return cursoList;
       }
    }

    
       public ArrayList<Object[]> consultar(int index) {
         Connection conexion= null;
        Statement sta=null;
        PreparedStatement stm= null;
        ResultSet rs=null;
        ArrayList<Object[]> cursoList= new ArrayList<>();
        
        String dirigido = "";
        //String dirigidoAmbos = "";
        String sql= "";
        
         switch (index) {
             case 0:
                 sql="SELECT id_curso,nom_cur,estado_cur,dirigido_cur FROM PUBLIC.curso WHERE dirigido_cur= 'Niños' ORDER by id_curso";
                 break;
             case 1:
                 sql="SELECT id_curso,nom_cur,estado_cur,dirigido_cur FROM PUBLIC.curso WHERE dirigido_cur= 'Padres' OR dirigido_cur = 'Ambos Padres' ORDER by id_curso";
                 break;   
             case 2:
                 sql="SELECT id_curso,nom_cur,estado_cur,dirigido_cur FROM PUBLIC.curso WHERE dirigido_cur= 'Madres' OR dirigido_cur = 'Ambos Padres' ORDER by id_curso";
                 break;
             default:
                 break;
         }
        
         //sql="SELECT id_curso,nom_cur,estado_cur,dirigido_cur FROM PUBLIC.curso  ORDER by id_curso";
        
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
                cursoList.add(fila);
            }
            conexion.close();
               
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error EN sql CONSULTAR curso:"+e.getMessage());
       } finally{
           return cursoList;
       }
    }
    
    @Override
    public CursoEntity obtener(CursoEntity curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
