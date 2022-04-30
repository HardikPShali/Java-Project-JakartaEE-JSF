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
@Table(name = "termcarddetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Termcarddetails.findAll", query = "SELECT t FROM Termcarddetails t"),
    @NamedQuery(name = "Termcarddetails.findByCid", query = "SELECT t FROM Termcarddetails t WHERE t.cid = :cid"),
    @NamedQuery(name = "Termcarddetails.findByPaymentno", query = "SELECT t FROM Termcarddetails t WHERE t.paymentno = :paymentno"),
    @NamedQuery(name = "Termcarddetails.findByName", query = "SELECT t FROM Termcarddetails t WHERE t.name = :name"),
    @NamedQuery(name = "Termcarddetails.findByPaymentMethod", query = "SELECT t FROM Termcarddetails t WHERE t.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Termcarddetails.findByStatus", query = "SELECT t FROM Termcarddetails t WHERE t.status = :status"),
    @NamedQuery(name = "Termcarddetails.findByAmount", query = "SELECT t FROM Termcarddetails t WHERE t.amount = :amount"),
    @NamedQuery(name = "Termcarddetails.findByDate", query = "SELECT t FROM Termcarddetails t WHERE t.date = :date")})
public class Termcarddetails implements Serializable {

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
    @Column(name = "payment_method")
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
    @Size(min = 1, max = 50)
    @Column(name = "date")
    private String date;
    @JoinColumn(name = "termpi_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TerminsuPi termpiId;

    public Termcarddetails() {
    }

    public Termcarddetails(Integer cid) {
        this.cid = cid;
    }

    public Termcarddetails(Integer cid, int paymentno, String name, String paymentMethod, String status, float amount, String date) {
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

    public TerminsuPi getTermpiId() {
        return termpiId;
    }

    public void setTermpiId(TerminsuPi termpiId) {
        this.termpiId = termpiId;
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
        if (!(object instanceof Termcarddetails)) {
            return false;
        }
        Termcarddetails other = (Termcarddetails) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Termcarddetails[ cid=" + cid + " ]";
    }
    
}
