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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByIdMateria", query = "SELECT m FROM Materia m WHERE m.idMateria = :idMateria"),
    @NamedQuery(name = "Materia.findByNombreMateria", query = "SELECT m FROM Materia m WHERE m.nombreMateria = :nombreMateria"),
    @NamedQuery(name = "Materia.findByIntensidadHoraria", query = "SELECT m FROM Materia m WHERE m.intensidadHoraria = :intensidadHoraria"),
    @NamedQuery(name = "Materia.findByPesoAcademico", query = "SELECT m FROM Materia m WHERE m.pesoAcademico = :pesoAcademico")})
public class Materia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMateria")
    private Integer idMateria;
    @Basic(optional = false)
    @Column(name = "nombreMateria")
    private String nombreMateria;
    @Basic(optional = false)
    @Column(name = "intensidad_Horaria")
    private int intensidadHoraria;
    @Basic(optional = false)
    @Column(name = "Peso_Academico")
    private int pesoAcademico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private Collection<Curso> cursoCollection;

    public Materia() {
    }

    public Materia(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Materia(Integer idMateria, String nombreMateria, int intensidadHoraria, int pesoAcademico) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.intensidadHoraria = intensidadHoraria;
        this.pesoAcademico = pesoAcademico;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getIntensidadHoraria() {
        return intensidadHoraria;
    }

    public void setIntensidadHoraria(int intensidadHoraria) {
        this.intensidadHoraria = intensidadHoraria;
    }

    public int getPesoAcademico() {
        return pesoAcademico;
    }

    public void setPesoAcademico(int pesoAcademico) {
        this.pesoAcademico = pesoAcademico;
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
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Materia[ idMateria=" + idMateria + " ]";
    }
    
}
