/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author pc
 */
public class Usuario {
    private Integer id;
    private String nombre;
    private String password;
    private String tipo;
    private boolean estado;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String password, String tipo, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Usuario( String nombre, String password, String tipo, boolean estado) {
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
        this.estado = estado;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void SetNombre(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
