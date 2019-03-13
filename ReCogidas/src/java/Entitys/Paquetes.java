/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henry Daniel
 */
@Entity
@Table(name = "PAQUETES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquetes.findAll", query = "SELECT p FROM Paquetes p")
    , @NamedQuery(name = "Paquetes.findById", query = "SELECT p FROM Paquetes p WHERE p.id = :id")
    , @NamedQuery(name = "Paquetes.findByFechaRecogida", query = "SELECT p FROM Paquetes p WHERE p.fechaRecogida = :fechaRecogida")
    , @NamedQuery(name = "Paquetes.findByFechaEstEntr", query = "SELECT p FROM Paquetes p WHERE p.fechaEstEntr = :fechaEstEntr")
    , @NamedQuery(name = "Paquetes.findByCiudadOrigen", query = "SELECT p FROM Paquetes p WHERE p.ciudadOrigen = :ciudadOrigen")
    , @NamedQuery(name = "Paquetes.findByCiudadDestino", query = "SELECT p FROM Paquetes p WHERE p.ciudadDestino = :ciudadDestino")
    , @NamedQuery(name = "Paquetes.findByDireccion", query = "SELECT p FROM Paquetes p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Paquetes.findByDestinatario", query = "SELECT p FROM Paquetes p WHERE p.destinatario = :destinatario")
    , @NamedQuery(name = "Paquetes.findByEstadoActual", query = "SELECT p FROM Paquetes p WHERE p.estadoActual = :estadoActual")
    , @NamedQuery(name = "Paquetes.findByIdPersEncargada", query = "SELECT p FROM Paquetes p WHERE p.idPersEncargada = :idPersEncargada")})
public class Paquetes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_RECOGIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaRecogida = new Date();
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EST_ENTR")
    @Temporal(TemporalType.DATE)
    private Date fechaEstEntr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CIUDAD_ORIGEN")
    private String ciudadOrigen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CIUDAD_DESTINO")
    private String ciudadDestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESTINATARIO")
    private String destinatario;
    @Size(max = 150)
    @Column(name = "ESTADO_ACTUAL")
    private String estadoActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERS_ENCARGADA")
    private int idPersEncargada;

    public Paquetes() {
    }

    public Paquetes(Integer id) {
        this.id = id;
    }

    public Paquetes(Integer id, Date fechaRecogida, Date fechaEstEntr, String ciudadOrigen, String ciudadDestino, String direccion, String destinatario, int idPersEncargada) {
        this.id = id;
        this.fechaRecogida = fechaRecogida;
        this.fechaEstEntr = fechaEstEntr;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccion = direccion;
        this.destinatario = destinatario;
        this.idPersEncargada = idPersEncargada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaRecogida() {
        //Para que en el campo se muestre la fecha actual
        return fechaRecogida;
    }

    public void setFechaRecogida(Date fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public Date getFechaEstEntr() {
        return fechaEstEntr;
    }

    public void setFechaEstEntr(Date fechaEstEntr) {
        this.fechaEstEntr = fechaEstEntr;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public int getIdPersEncargada() {
        return idPersEncargada;
    }

    public void setIdPersEncargada(int idPersEncargada) {
        this.idPersEncargada = idPersEncargada;
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
        if (!(object instanceof Paquetes)) {
            return false;
        }
        Paquetes other = (Paquetes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Paquetes[ id=" + id + " ]";
    }
    
}
