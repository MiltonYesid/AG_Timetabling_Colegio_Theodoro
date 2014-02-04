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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdProfesor", query = "SELECT p FROM Profesor p WHERE p.idProfesor = :idProfesor"),
    @NamedQuery(name = "Profesor.findByNombres", query = "SELECT p FROM Profesor p WHERE p.nombres = :nombres")})
public class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfesor")
    private Integer idProfesor;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @JoinTable(name = "Cursos_dicta_profesor", joinColumns = {
        @JoinColumn(name = "Profesor_idProfesor", referencedColumnName = "idProfesor")}, inverseJoinColumns = {
        @JoinColumn(name = "Curso_Materia_idMateria", referencedColumnName = "Materia_idMateria"),
        @JoinColumn(name = "Curso_Grado_idGrado", referencedColumnName = "cod_grado"),
        @JoinColumn(name = "Curso_A\u00c3\u00b1o_Escolar_a\u00c3\u00b1o", referencedColumnName = "A\u00c3\u00b1o_Escolar_a\u00c3\u00b1o")})
    @ManyToMany
    private Collection<Curso> cursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    private Collection<DisponibilidadHoraria> disponibilidadHorariaCollection;

    public Profesor() {
    }

    public Profesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Profesor(Integer idProfesor, String nombres) {
        this.idProfesor = idProfesor;
        this.nombres = nombres;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @XmlTransient
    public Collection<DisponibilidadHoraria> getDisponibilidadHorariaCollection() {
        return disponibilidadHorariaCollection;
    }

    public void setDisponibilidadHorariaCollection(Collection<DisponibilidadHoraria> disponibilidadHorariaCollection) {
        this.disponibilidadHorariaCollection = disponibilidadHorariaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesor != null ? idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idProfesor == null && other.idProfesor != null) || (this.idProfesor != null && !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Profesor[ idProfesor=" + idProfesor + " ]";
    }
    
}
