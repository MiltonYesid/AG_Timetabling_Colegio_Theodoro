/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author milton.fernandez
 */
@Entity
@Table(name = "Disponibilidad_Horaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisponibilidadHoraria.findAll", query = "SELECT d FROM DisponibilidadHoraria d"),
    @NamedQuery(name = "DisponibilidadHoraria.findByProfesoridProfesor", query = "SELECT d FROM DisponibilidadHoraria d WHERE d.disponibilidadHorariaPK.profesoridProfesor = :profesoridProfesor"),
    @NamedQuery(name = "DisponibilidadHoraria.findByA\u00c3oEscolara\u00c3o", query = "SELECT d FROM DisponibilidadHoraria d WHERE d.disponibilidadHorariaPK.a\u00c3oEscolara\u00c3o = :a\u00c3oEscolara\u00c3o"),
    @NamedQuery(name = "DisponibilidadHoraria.findByDia", query = "SELECT d FROM DisponibilidadHoraria d WHERE d.dia = :dia"),
    @NamedQuery(name = "DisponibilidadHoraria.findByHora", query = "SELECT d FROM DisponibilidadHoraria d WHERE d.hora = :hora")})
public class DisponibilidadHoraria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DisponibilidadHorariaPK disponibilidadHorariaPK;
    @Basic(optional = false)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @Column(name = "hora")
    private int hora;
    @JoinColumn(name = "A\u00c3\u00b1o_Escolar_a\u00c3\u00b1o", referencedColumnName = "a\u00c3\u00b1o", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AÃoEscolar aÃoEscolar;
    @JoinColumn(name = "Profesor_idProfesor", referencedColumnName = "idProfesor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesor profesor;

    public DisponibilidadHoraria() {
    }

    public DisponibilidadHoraria(DisponibilidadHorariaPK disponibilidadHorariaPK) {
        this.disponibilidadHorariaPK = disponibilidadHorariaPK;
    }

    public DisponibilidadHoraria(DisponibilidadHorariaPK disponibilidadHorariaPK, String dia, int hora) {
        this.disponibilidadHorariaPK = disponibilidadHorariaPK;
        this.dia = dia;
        this.hora = hora;
    }

    public DisponibilidadHoraria(int profesoridProfesor, int aÃoEscolaraÃo) {
        this.disponibilidadHorariaPK = new DisponibilidadHorariaPK(profesoridProfesor, aÃoEscolaraÃo);
    }

    public DisponibilidadHorariaPK getDisponibilidadHorariaPK() {
        return disponibilidadHorariaPK;
    }

    public void setDisponibilidadHorariaPK(DisponibilidadHorariaPK disponibilidadHorariaPK) {
        this.disponibilidadHorariaPK = disponibilidadHorariaPK;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public AÃoEscolar getAÃoEscolar() {
        return aÃoEscolar;
    }

    public void setAÃoEscolar(AÃoEscolar aÃoEscolar) {
        this.aÃoEscolar = aÃoEscolar;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disponibilidadHorariaPK != null ? disponibilidadHorariaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisponibilidadHoraria)) {
            return false;
        }
        DisponibilidadHoraria other = (DisponibilidadHoraria) object;
        if ((this.disponibilidadHorariaPK == null && other.disponibilidadHorariaPK != null) || (this.disponibilidadHorariaPK != null && !this.disponibilidadHorariaPK.equals(other.disponibilidadHorariaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DisponibilidadHoraria[ disponibilidadHorariaPK=" + disponibilidadHorariaPK + " ]";
    }
    
}
