/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author steve
 */
public class Reg_Escolar {
    //Variables de ingreso de la escolaridad del beneficiario
    String ben_escolaridad, ben_nomEsc, ben_grado, ben_nomprof,ben_dir,ben_numprof;
    int id_escuela;
    
    public Reg_Escolar(){
        
    }

    public String getBen_escolaridad() {
        return ben_escolaridad;
    }

    public void setBen_escolaridad(String ben_escolaridad) {
        this.ben_escolaridad = ben_escolaridad;
    }

    public String getBen_nomEsc() {
        return ben_nomEsc;
    }

    public void setBen_nomEsc(String ben_nomEsc) {
        this.ben_nomEsc = ben_nomEsc;
    }

    public String getBen_grado() {
        return ben_grado;
    }

    public void setBen_grado(String ben_grado) {
        this.ben_grado = ben_grado;
    }

    public String getBen_nomprof() {
        return ben_nomprof;
    }

    public void setBen_nomprof(String ben_nomprof) {
        this.ben_nomprof = ben_nomprof;
    }

    public String getBen_dir() {
        return ben_dir;
    }

    public void setBen_dir(String ben_dir) {
        this.ben_dir = ben_dir;
    }

    public int getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(int id_escuela) {
        this.id_escuela = id_escuela;
    }

    public String getBen_numprof() {
        return ben_numprof;
    }

    public void setBen_numprof(String ben_numprof) {
        this.ben_numprof = ben_numprof;
    }
    
    public void mostrarDato(){
        System.out.println(this.getBen_dir());
    }
    
}
