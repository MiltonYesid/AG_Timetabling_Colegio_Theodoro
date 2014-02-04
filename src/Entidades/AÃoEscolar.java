/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author milton.fernandez
 */
@Entity
@Table(name = "A\u00c3\u00b1o_Escolar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "A\u00c3oEscolar.findAll", query = "SELECT a FROM A\u00c3oEscolar a"),
    @NamedQuery(name = "A\u00c3oEscolar.findByA\u00c3o", query = "SELECT a FROM A\u00c3oEscolar a WHERE a.a\u00c3o = :a\u00c3o")})
public class AÃoEscolar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "a\u00c3\u00b1o")
    private Integer aÃo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a\u00c3oEscolar")
    private Collection<DisponibilidadHoraria> disponibilidadHorariaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a\u00c3oEscolar")
    private Collection<Curso> cursoCollection;

    public AÃoEscolar() {
    }

    public AÃoEscolar(Integer aÃo) {
        this.aÃo = aÃo;
    }

    public Integer getAÃo() {
        return aÃo;
    }

    public void setAÃo(Integer aÃo) {
        this.aÃo = aÃo;
    }

    @XmlTransient
    public Collection<DisponibilidadHoraria> getDisponibilidadHorariaCollection() {
        return disponibilidadHorariaCollection;
    }

    public void setDisponibilidadHorariaCollection(Collection<DisponibilidadHoraria> disponibilidadHorariaCollection) {
        this.disponibilidadHorariaCollection = disponibilidadHorariaCollection;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aÃo != null ? aÃo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AÃoEscolar)) {
            return false;
        }
        AÃoEscolar other = (AÃoEscolar) object;
        if ((this.aÃo == null && other.aÃo != null) || (this.aÃo != null && !this.aÃo.equals(other.aÃo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.A\u00c3oEscolar[ a\u00c3o=" + aÃo + " ]";
    }
    
}
