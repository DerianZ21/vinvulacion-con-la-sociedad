package modelo;

import java.util.Date;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class tipoPersonaEntity {
    String cedula, nombre, apellido, telefono, direccion, correo, religion;
    int id_tipoPersona, edad;
    Date fech_nac;

    public tipoPersonaEntity() {
    }

    public tipoPersonaEntity(String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String religion, int id_tipoPersona, int edad, Date fech_nac) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.religion = religion;
        this.id_tipoPersona = id_tipoPersona;
        this.edad = edad;
        this.fech_nac = fech_nac;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public int getId_tipoPersona() {
        return id_tipoPersona;
    }

    public void setId_tipoPersona(int id_tipoPersona) {
        this.id_tipoPersona = id_tipoPersona;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFech_nac() {
        return fech_nac;
    }

    public void setFech_nac(Date fech_nac) {
        this.fech_nac = fech_nac;
    }
    
    
    
}
