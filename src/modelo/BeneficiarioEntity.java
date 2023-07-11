/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class BeneficiarioEntity {
    //Variables de ingreso del beneficiario
    String ben_promsal; 
    int ben_convivientes;

    public BeneficiarioEntity(String ben_promsal, int ben_convivientes) {
        this.ben_promsal = ben_promsal;
        this.ben_convivientes = ben_convivientes;
    }

    public String getBen_promsal() {
        return ben_promsal;
    }

    public void setBen_promsal(String ben_promsal) {
        this.ben_promsal = ben_promsal;
    }

    public int getBen_convivientes() {
        return ben_convivientes;
    }

    public void setBen_convivientes(int ben_convivientes) {
        this.ben_convivientes = ben_convivientes;
    }
   
//    public void mostrarDato(){
//        System.out.println(this.getBen_nom()+"\n"+ this.getBen_ape()+ this.getBen_ced());
//    }
    

    public  BeneficiarioEntity(){
        
    }
    
}
