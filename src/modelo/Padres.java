/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sebastian Riofrio
 */
public class Padres {
    String ing_econ; 
    int id_padres,id_mama,id_papa;

    public Padres() {
    }

    public Padres(String ing_econ, int id_mama, int id_papa) {
        this.ing_econ = ing_econ;
        this.id_mama = id_mama;
        this.id_papa = id_papa;
    }

    public String getIng_econ() {
        return ing_econ;
    }

    public void setIng_econ(String ing_econ) {
        this.ing_econ = ing_econ;
    }

    public int getId_padres() {
        return id_padres;
    }

    public void setId_padres(int id_padres) {
        this.id_padres = id_padres;
    }

    public int getId_mama() {
        return id_mama;
    }

    public void setId_mama(int id_mama) {
        this.id_mama = id_mama;
    }

    public int getId_papa() {
        return id_papa;
    }

    public void setId_papa(int id_papa) {
        this.id_papa = id_papa;
    }

    @Override
    public String toString() {
        return "Padres{" + "ing_econ=" + ing_econ + ", id_padres=" + id_padres + ", id_mama=" + id_mama + ", id_papa=" + id_papa + '}';
    }
    
    
}
