/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author milton.fernandez
 */
@Entity
@Table(name = "Curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByMateriaidMateria", query = "SELECT c FROM Curso c WHERE c.cursoPK.materiaidMateria = :materiaidMateria"),
    @NamedQuery(name = "Curso.findByCodGrado", query = "SELECT c FROM Curso c WHERE c.cursoPK.codGrado = :codGrado"),
    @NamedQuery(name = "Curso.findByA\u00c3oEscolara\u00c3o", query = "SELECT c FROM Curso c WHERE c.cursoPK.a\u00c3oEscolara\u00c3o = :a\u00c3oEscolara\u00c3o")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursoPK cursoPK;
    @ManyToMany(mappedBy = "cursoCollection")
    private Collection<Profesor> profesorCollection;
    @JoinColumn(name = "A\u00c3\u00b1o_Escolar_a\u00c3\u00b1o", referencedColumnName = "a\u00c3\u00b1o", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AÃoEscolar aÃoEscolar;
    @JoinColumn(name = "cod_grado", referencedColumnName = "idGrado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Grado grado;
    @JoinColumn(name = "Materia_idMateria", referencedColumnName = "idMateria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia;

    public Curso() {
    }

    public Curso(CursoPK cursoPK) {
        this.cursoPK = cursoPK;
    }

    public Curso(int materiaidMateria, int codGrado, int aÃoEscolaraÃo) {
        this.cursoPK = new CursoPK(materiaidMateria, codGrado, aÃoEscolaraÃo);
    }

    public CursoPK getCursoPK() {
        return cursoPK;
    }

    public void setCursoPK(CursoPK cursoPK) {
        this.cursoPK = cursoPK;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    public AÃoEscolar getAÃoEscolar() {
        return aÃoEscolar;
    }

    public void setAÃoEscolar(AÃoEscolar aÃoEscolar) {
        this.aÃoEscolar = aÃoEscolar;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoPK != null ? cursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.cursoPK == null && other.cursoPK != null) || (this.cursoPK != null && !this.cursoPK.equals(other.cursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Curso[ cursoPK=" + cursoPK + " ]";
    }
    
}
