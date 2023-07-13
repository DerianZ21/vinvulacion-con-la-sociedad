/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author steve
 */
public class Reg_Benf extends tipoPersonaEntity{
    //Variables de ingreso del beneficiario
    String prom_sal; 
    int  num_conv,id_padres,id_escu,id_benf,id_socioec;
//    Date ben_fechainsc;

    public Reg_Benf(String prom_sal, int num_conv, int id_padres, int id_escu, int id_benf, int id_socioec) {
        this.prom_sal = prom_sal;
        this.num_conv = num_conv;
        this.id_padres = id_padres;
        this.id_escu = id_escu;
        this.id_benf = id_benf;
        this.id_socioec = id_socioec;
    }

    public Reg_Benf(String prom_sal, int num_conv, int id_padres, int id_escu, int id_benf, int id_socioec, String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String religion, int id_tipoPersona, int edad, Date fech_nac) {
        super(cedula, nombre, apellido, telefono, direccion, correo, religion, id_tipoPersona, edad, fech_nac);
        this.prom_sal = prom_sal;
        this.num_conv = num_conv;
        this.id_padres = id_padres;
        this.id_escu = id_escu;
        this.id_benf = id_benf;
        this.id_socioec = id_socioec;
    }

    public String getProm_sal() {
        return prom_sal;
    }

    public void setProm_sal(String prom_sal) {
        this.prom_sal = prom_sal;
    }

    public int getNum_conv() {
        return num_conv;
    }

    public void setNum_conv(int num_conv) {
        this.num_conv = num_conv;
    }

    public int getId_padres() {
        return id_padres;
    }

    public void setId_padres(int id_padres) {
        this.id_padres = id_padres;
    }

    public int getId_escu() {
        return id_escu;
    }

    public void setId_escu(int id_escu) {
        this.id_escu = id_escu;
    }

    public int getId_benf() {
        return id_benf;
    }

    public void setId_benf(int id_benf) {
        this.id_benf = id_benf;
    }

    public int getId_socioec() {
        return id_socioec;
    }

    public void setId_socioec(int id_socioec) {
        this.id_socioec = id_socioec;
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

   public void mostrarDato(){
        System.out.println(this.getNombre()+"\n"+ this.getApellido()+ this.getCedula());
    }
    
    

    public  Reg_Benf(){
        
    }
    
}
