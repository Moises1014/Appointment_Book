/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment_book;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author moises
 */
@Entity
@Table(name = "APPOINTMENTBOOK", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Appointmentbook.findAll", query = "SELECT a FROM Appointmentbook a"),
    @NamedQuery(name = "Appointmentbook.findById", query = "SELECT a FROM Appointmentbook a WHERE a.id = :id"),
    @NamedQuery(name = "Appointmentbook.findByDate", query = "SELECT a FROM Appointmentbook a WHERE a.date = :date")})
public class Appointmentbook implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Lob
    @Column(name = "APPOINTMENT")
    private String appointment;
    @Basic(optional = false)
    @Lob
    @Column(name = "TYPE_OF_APPOINTMENT")
    private String typeOfAppointment;

    public Appointmentbook() {
    }

    public Appointmentbook(Integer id) {
        this.id = id;
    }

    public Appointmentbook(Integer id, Date date, String appointment, String typeOfAppointment) {
        this.id = id;
        this.date = date;
        this.appointment = appointment;
        this.typeOfAppointment = typeOfAppointment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        String oldAppointment = this.appointment;
        this.appointment = appointment;
        changeSupport.firePropertyChange("appointment", oldAppointment, appointment);
    }

    public String getTypeOfAppointment() {
        return typeOfAppointment;
    }

    public void setTypeOfAppointment(String typeOfAppointment) {
        String oldTypeOfAppointment = this.typeOfAppointment;
        this.typeOfAppointment = typeOfAppointment;
        changeSupport.firePropertyChange("typeOfAppointment", oldTypeOfAppointment, typeOfAppointment);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointmentbook)) {
            return false;
        }
        Appointmentbook other = (Appointmentbook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appointment_book.Appointmentbook[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
