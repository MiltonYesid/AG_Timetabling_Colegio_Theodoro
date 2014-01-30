/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author milton.fernandez
 */
public  class disponibilidadHoraria {
    Nodo_disponibilidad primero,ultimo;

    public Nodo_disponibilidad getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo_disponibilidad primero) {
        this.primero = primero;
    }

    public Nodo_disponibilidad getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo_disponibilidad ultimo) {
        this.ultimo = ultimo;
    }
    public void insertar(Nodo_disponibilidad dh)
    {
         if (this.primero == null) {
            this.primero = this.ultimo = dh;
        } else {
            this.ultimo.setSig(dh);
            this.ultimo = dh;
        }
    }
    
}
