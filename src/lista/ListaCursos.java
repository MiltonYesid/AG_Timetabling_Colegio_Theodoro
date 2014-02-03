/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author milton.fernandez
 */
public class ListaCursos {

    public ListaCursos()
    {
       
    }
    public Nodo_Curso buscar(int id)
    {
        Nodo_Curso x = this.primero;
        while(x != null)
        {
            if(x.getIdCurso() == id)
            {
                return x;
            }
            x = x.getSig();
        }
        return null;
    }
    public void insertarCurso(Nodo_Curso curso)
    {
         if (this.primero == null) {
            this.primero = this.ultimo = curso;
        } else {
            this.ultimo.setSig(curso);
            this.ultimo = curso;
        }

    }
    public Nodo_Curso getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo_Curso primero) {
        this.primero = primero;
    }

    public Nodo_Curso getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo_Curso ultimo) {
        this.ultimo = ultimo;
    }
    private Nodo_Curso primero,ultimo;
    
}
