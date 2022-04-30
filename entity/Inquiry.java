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
@Table(name = "inquiry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inquiry.findAll", query = "SELECT i FROM Inquiry i"),
    @NamedQuery(name = "Inquiry.findById", query = "SELECT i FROM Inquiry i WHERE i.id = :id"),
    @NamedQuery(name = "Inquiry.findByName", query = "SELECT i FROM Inquiry i WHERE i.name = :name"),
    @NamedQuery(name = "Inquiry.findByEmail", query = "SELECT i FROM Inquiry i WHERE i.email = :email"),
    @NamedQuery(name = "Inquiry.findBySuminsured", query = "SELECT i FROM Inquiry i WHERE i.suminsured = :suminsured"),
    @NamedQuery(name = "Inquiry.findByMobile", query = "SELECT i FROM Inquiry i WHERE i.mobile = :mobile"),
    @NamedQuery(name = "Inquiry.findByTotalmember", query = "SELECT i FROM Inquiry i WHERE i.totalmember = :totalmember"),
    @NamedQuery(name = "Inquiry.findByPincode", query = "SELECT i FROM Inquiry i WHERE i.pincode = :pincode"),
    @NamedQuery(name = "Inquiry.findByInsuType", query = "SELECT i FROM Inquiry i WHERE i.insuType = :insuType")})
public class Inquiry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suminsured")
    private int suminsured;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobile")
    private long mobile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalmember")
    private int totalmember;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pincode")
    private int pincode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "insu_type")
    private String insuType;

    public Inquiry() {
    }

    public Inquiry(Integer id) {
        this.id = id;
    }

    public Inquiry(Integer id, String name, String email, int suminsured, long mobile, int totalmember, int pincode, String insuType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.suminsured = suminsured;
        this.mobile = mobile;
        this.totalmember = totalmember;
        this.pincode = pincode;
        this.insuType = insuType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSuminsured() {
        return suminsured;
    }

    public void setSuminsured(int suminsured) {
        this.suminsured = suminsured;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public int getTotalmember() {
        return totalmember;
    }

    public void setTotalmember(int totalmember) {
        this.totalmember = totalmember;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getInsuType() {
        return insuType;
    }

    public void setInsuType(String insuType) {
        this.insuType = insuType;
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
        if (!(object instanceof Inquiry)) {
            return false;
        }
        Inquiry other = (Inquiry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Inquiry[ id=" + id + " ]";
    }
    
}
