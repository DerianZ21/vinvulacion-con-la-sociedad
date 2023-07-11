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
public class AsignacionCurso {
    int id_asignacion, id_padre, id_curso;
    String parentesco;

    public AsignacionCurso() {
    }

    public AsignacionCurso(int id_asignacion, int id_padre, int id_curso, String parentesco) {
        this.id_asignacion = id_asignacion;
        this.id_padre = id_padre;
        this.id_curso = id_curso;
        this.parentesco = parentesco;
    }

    public int getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
    
}
