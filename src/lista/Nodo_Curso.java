/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author milton.fernandez
 */
public class Nodo_Curso {

    public Nodo_Curso getSig() {
        return sig;
    }

    public void setSig(Nodo_Curso sig) {
        this.sig = sig;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public int getCantidadHoraria() {
        return cantidadHoraria;
    }

    public void setCantidadHoraria(int cantidadHoraria) {
        this.cantidadHoraria = cantidadHoraria;
    }
    private int idCurso;
    private String nombreCurso;
    private int grado;
    private int cantidadHoraria;
    private Nodo_Curso sig;
}
