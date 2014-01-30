/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author milton.fernandez
 */
public class Nodo_profesor {

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public cursosAsignadosProfesor getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(cursosAsignadosProfesor listaCursos) {
        this.listaCursos = listaCursos;
    }

    public disponibilidadHoraria getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(disponibilidadHoraria disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Nodo_profesor getSig() {
        return sig;
    }

    public void setSig(Nodo_profesor sig) {
        this.sig = sig;
    }
    private int id_profesor;
    private String nombre;
    private cursosAsignadosProfesor listaCursos;
    private disponibilidadHoraria disponibilidad;
    private Nodo_profesor sig;
}
