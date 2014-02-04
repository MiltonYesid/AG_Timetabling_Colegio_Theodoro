/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author milton.fernandez
 */
@Embeddable
public class DisponibilidadHorariaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Profesor_idProfesor")
    private int profesoridProfesor;
    @Basic(optional = false)
    @Column(name = "A\u00c3\u00b1o_Escolar_a\u00c3\u00b1o")
    private int aÃoEscolaraÃo;

    public DisponibilidadHorariaPK() {
    }

    public DisponibilidadHorariaPK(int profesoridProfesor, int aÃoEscolaraÃo) {
        this.profesoridProfesor = profesoridProfesor;
        this.aÃoEscolaraÃo = aÃoEscolaraÃo;
    }

    public int getProfesoridProfesor() {
        return profesoridProfesor;
    }

    public void setProfesoridProfesor(int profesoridProfesor) {
        this.profesoridProfesor = profesoridProfesor;
    }

    public int getAÃoEscolaraÃo() {
        return aÃoEscolaraÃo;
    }

    public void setAÃoEscolaraÃo(int aÃoEscolaraÃo) {
        this.aÃoEscolaraÃo = aÃoEscolaraÃo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) profesoridProfesor;
        hash += (int) aÃoEscolaraÃo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisponibilidadHorariaPK)) {
            return false;
        }
        DisponibilidadHorariaPK other = (DisponibilidadHorariaPK) object;
        if (this.profesoridProfesor != other.profesoridProfesor) {
            return false;
        }
        if (this.aÃoEscolaraÃo != other.aÃoEscolaraÃo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DisponibilidadHorariaPK[ profesoridProfesor=" + profesoridProfesor + ", a\u00c3oEscolara\u00c3o=" + aÃoEscolaraÃo + " ]";
    }
    
}
