/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Sebastian Riofrio
 */
public class Mama extends tipoPersonaEntity{
     //Variables de Mama
    String lug_tra_ma,cargo_ma, est_civ_ma;  
    int id_mama = 0;

    public Mama() {
    }

    public Mama(String lug_tra_ma, String cargo_ma, String est_civ_ma) {
        this.lug_tra_ma = lug_tra_ma;
        this.cargo_ma = cargo_ma;
        this.est_civ_ma = est_civ_ma;
    }

    public Mama(String lug_tra_ma, String cargo_ma, String est_civ_ma, String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String religion, int id_tipoPersona, int edad, Date fech_nac) {
        super(cedula, nombre, apellido, telefono, direccion, correo, religion, id_tipoPersona, edad, fech_nac);
        this.lug_tra_ma = lug_tra_ma;
        this.cargo_ma = cargo_ma;
        this.est_civ_ma = est_civ_ma;
    }

    public String getLug_tra_ma() {
        return lug_tra_ma;
    }

    public void setLug_tra_ma(String lug_tra_ma) {
        this.lug_tra_ma = lug_tra_ma;
    }

    public String getCargo_ma() {
        return cargo_ma;
    }

    public void setCargo_ma(String cargo_ma) {
        this.cargo_ma = cargo_ma;
    }

    public String getEst_civ_ma() {
        return est_civ_ma;
    }

    public void setEst_civ_ma(String est_civ_ma) {
        this.est_civ_ma = est_civ_ma;
    }

    public int getId_mama() {
        return id_mama;
    }

    public void setId_mama(int id_mama) {
        this.id_mama = id_mama;
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
