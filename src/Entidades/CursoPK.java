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
public class CursoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Materia_idMateria")
    private int materiaidMateria;
    @Basic(optional = false)
    @Column(name = "cod_grado")
    private int codGrado;
    @Basic(optional = false)
    @Column(name = "A\u00c3\u00b1o_Escolar_a\u00c3\u00b1o")
    private int aÃoEscolaraÃo;

    public CursoPK() {
    }

    public CursoPK(int materiaidMateria, int codGrado, int aÃoEscolaraÃo) {
        this.materiaidMateria = materiaidMateria;
        this.codGrado = codGrado;
        this.aÃoEscolaraÃo = aÃoEscolaraÃo;
    }

    public int getMateriaidMateria() {
        return materiaidMateria;
    }

    public void setMateriaidMateria(int materiaidMateria) {
        this.materiaidMateria = materiaidMateria;
    }

    public int getCodGrado() {
        return codGrado;
    }

    public void setCodGrado(int codGrado) {
        this.codGrado = codGrado;
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
        hash += (int) materiaidMateria;
        hash += (int) codGrado;
        hash += (int) aÃoEscolaraÃo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoPK)) {
            return false;
        }
        CursoPK other = (CursoPK) object;
        if (this.materiaidMateria != other.materiaidMateria) {
            return false;
        }
        if (this.codGrado != other.codGrado) {
            return false;
        }
        if (this.aÃoEscolaraÃo != other.aÃoEscolaraÃo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CursoPK[ materiaidMateria=" + materiaidMateria + ", codGrado=" + codGrado + ", a\u00c3oEscolara\u00c3o=" + aÃoEscolaraÃo + " ]";
    }
    
}
