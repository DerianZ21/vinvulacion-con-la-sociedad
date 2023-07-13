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
public class Reg_dataSocial {
    //Variables de ingreso de los datos sociales
    String per_sustento, per_tipo_trabajo,per_gastomensual,per_otro_ingreso;
    int id_socioeconmico,per_total_ingreso;
    public String getPer_sustento() {
        return per_sustento;
    }

    public void setPer_sustento(String per_sustento) {
        this.per_sustento = per_sustento;
    }

    public String getPer_tipo_trabajo() {
        return per_tipo_trabajo;
    }

    public void setPer_tipo_trabajo(String per_tipo_trabajo) {
        this.per_tipo_trabajo = per_tipo_trabajo;
    }

    public int getPer_total_ingreso() {
        return per_total_ingreso;
    }

    public void setPer_total_ingreso(int per_total_ingreso) {
        this.per_total_ingreso = per_total_ingreso;
    }

    public String getPer_gastomensual() {
        return per_gastomensual;
    }

    public void setPer_gastomensual(String per_gastomensual) {
        this.per_gastomensual = per_gastomensual;
    }

    public String getPer_otro_ingreso() {
        return per_otro_ingreso;
    }

    public void setPer_otro_ingreso(String per_otro_ingreso) {
        this.per_otro_ingreso = per_otro_ingreso;
    }

    public int getId_socioeconmico() {
        return id_socioeconmico;
    }

    public void setId_socioeconmico(int id_socioeconmico) {
        this.id_socioeconmico = id_socioeconmico;
    }
    public void mostrarDato(){
        System.out.println(this.getPer_otro_ingreso());
    }
    
    public Reg_dataSocial(){
        
    }

    public Reg_dataSocial(String per_sustento, String per_tipo_trabajo, String per_otro_ingreso, String per_gastomensual) {
        this.per_sustento = per_sustento;
        this.per_tipo_trabajo = per_tipo_trabajo;
        this.per_otro_ingreso = per_otro_ingreso;
        this.per_gastomensual = per_gastomensual;
    }
}
