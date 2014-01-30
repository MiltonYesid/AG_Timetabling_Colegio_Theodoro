/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author milton.fernandez
 */
public class ListaProfesores {

    public ListaProfesores() {
    }

    public void insertarProfesor(Nodo_profesor profesor) {
        if (this.primero == null) {
            this.primero = this.ultimo = profesor;
        } else {
            this.ultimo.setSig(profesor);
            this.ultimo = profesor;
        }
    }

    public Nodo_profesor buscar(int id) {
        Nodo_profesor x = this.primero;
        while (x != null) {
            if (x.getId_profesor() == id) {
                break;
            }
            x = x.getSig();
        }
        return x;
    }

    public Nodo_profesor getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo_profesor primero) {
        this.primero = primero;
    }

    public Nodo_profesor getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo_profesor ultimo) {
        this.ultimo = ultimo;
    }
    private Nodo_profesor primero, ultimo;
}
