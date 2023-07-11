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
public class Papa extends tipoPersonaEntity{
     //Variables de Papa
    String lug_tra_pa,cargo_pa, est_civ_pa; 
    int id_papa ;

    public Papa() {
    }

    public Papa(String lug_tra_pa, String cargo_pa, String est_civ_pa, int id_papa) {
        this.lug_tra_pa = lug_tra_pa;
        this.cargo_pa = cargo_pa;
        this.est_civ_pa = est_civ_pa;
        this.id_papa = id_papa;
    }

    public Papa(String lug_tra_pa, String cargo_pa, String est_civ_pa, int id_papa, String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String religion, int id_tipoPersona, int edad, Date fech_nac) {
        super(cedula, nombre, apellido, telefono, direccion, correo, religion, id_tipoPersona, edad, fech_nac);
        this.lug_tra_pa = lug_tra_pa;
        this.cargo_pa = cargo_pa;
        this.est_civ_pa = est_civ_pa;
        this.id_papa = id_papa;
    }

    public String getLug_tra_pa() {
        return lug_tra_pa;
    }

    public void setLug_tra_pa(String lug_tra_pa) {
        this.lug_tra_pa = lug_tra_pa;
    }

    public String getCargo_pa() {
        return cargo_pa;
    }

    public void setCargo_pa(String cargo_pa) {
        this.cargo_pa = cargo_pa;
    }

    public String getEst_civ_pa() {
        return est_civ_pa;
    }

    public void setEst_civ_pa(String est_civ_pa) {
        this.est_civ_pa = est_civ_pa;
    }

    public int getId_papa() {
        return id_papa;
    }

    public void setId_papa(int id_papa) {
        this.id_papa = id_papa;
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