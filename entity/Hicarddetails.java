/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hardik
 */
@Entity
@Table(name = "hicarddetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hicarddetails.findAll", query = "SELECT h FROM Hicarddetails h"),
    @NamedQuery(name = "Hicarddetails.findByCid", query = "SELECT h FROM Hicarddetails h WHERE h.cid = :cid"),
    @NamedQuery(name = "Hicarddetails.findByPaymentno", query = "SELECT h FROM Hicarddetails h WHERE h.paymentno = :paymentno"),
    @NamedQuery(name = "Hicarddetails.findByName", query = "SELECT h FROM Hicarddetails h WHERE h.name = :name"),
    @NamedQuery(name = "Hicarddetails.findByPaymentMethod", query = "SELECT h FROM Hicarddetails h WHERE h.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Hicarddetails.findByStatus", query = "SELECT h FROM Hicarddetails h WHERE h.status = :status"),
    @NamedQuery(name = "Hicarddetails.findByAmount", query = "SELECT h FROM Hicarddetails h WHERE h.amount = :amount"),
    @NamedQuery(name = "Hicarddetails.findByDate", query = "SELECT h FROM Hicarddetails h WHERE h.date = :date")})
public class Hicarddetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid")
    private Integer cid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paymentno")
    private int paymentno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "paymentMethod")
    private String paymentMethod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private float amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "date")
    private String date;
    @JoinColumn(name = "hid", referencedColumnName = "hid")
    @ManyToOne(optional = false)
    private HealthInsu hid;

    public Hicarddetails() {
    }

    public Hicarddetails(Integer cid) {
        this.cid = cid;
    }

    public Hicarddetails(Integer cid, int paymentno, String name, String paymentMethod, String status, float amount, String date) {
        this.cid = cid;
        this.paymentno = paymentno;
        this.name = name;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.amount = amount;
        this.date = date;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public int getPaymentno() {
        return paymentno;
    }

    public void setPaymentno(int paymentno) {
        this.paymentno = paymentno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HealthInsu getHid() {
        return hid;
    }

    public void setHid(HealthInsu hid) {
        this.hid = hid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hicarddetails)) {
            return false;
        }
        Hicarddetails other = (Hicarddetails) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hicarddetails[ cid=" + cid + " ]";
    }
    
}
