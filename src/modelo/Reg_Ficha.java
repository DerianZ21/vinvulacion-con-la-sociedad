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
public class Reg_Ficha {
    Date Fechareg;
    int id_ficha, id_usu;

    public Reg_Ficha() {
    }

    public Reg_Ficha(Date Fechareg) {
        this.Fechareg = Fechareg;
    }

    public Date getFechareg() {
        return Fechareg;
    }

    public void setFechareg(Date Fechareg) {
        this.Fechareg = Fechareg;
    }

    public int getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(int id_ficha) {
        this.id_ficha = id_ficha;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }
    
    
    
    
    
}
