/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author milton.fernandez
 */
public class Nodo_disponibilidad {

    public Nodo_disponibilidad getSig() {
        return sig;
    }

    public void setSig(Nodo_disponibilidad sig) {
        this.sig = sig;
    }

    public int getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(int diaHora) {
        this.diaHora = diaHora;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    private int diaHora;
    private String tarea;
    private Nodo_disponibilidad sig;
}
