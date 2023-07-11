
package modelo;

public class AsistenciaEntity {
    
    
   int id_asistencia;
   String fecha,estudiante;
   boolean estado;
   int curso;

    public AsistenciaEntity(int id_asistencia, String fecha, String estudiante,int curso, boolean estado) {
        this.id_asistencia = id_asistencia;
        this.fecha = fecha;
        this.estudiante = estudiante;
        this.estado = estado;
        this.curso = curso;
    }

    public AsistenciaEntity(String fecha, String estudiante,int curso, boolean estado) {
        this.fecha = fecha;
        this.estudiante = estudiante;
        this.estado = estado;
         this.curso = curso;
    }

    public AsistenciaEntity(int id_asistencia, boolean estado) {
        this.id_asistencia = id_asistencia;
        this.estado = estado;
    }

    public AsistenciaEntity() {
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "AsistenciaEntity{" + "id_asistencia=" + id_asistencia + ", fecha=" + fecha + ", estudiante=" + estudiante + ", estado=" + estado + '}';
    }
   
   
   
   
   
    
}
