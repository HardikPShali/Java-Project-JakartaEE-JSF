/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hardik
 */
@Entity
@Table(name = "comp_reg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompReg.findAll", query = "SELECT c FROM CompReg c"),
    @NamedQuery(name = "CompReg.findByCompId", query = "SELECT c FROM CompReg c WHERE c.compId = :compId"),
    @NamedQuery(name = "CompReg.findByName", query = "SELECT c FROM CompReg c WHERE c.name = :name"),
    @NamedQuery(name = "CompReg.findByAddress", query = "SELECT c FROM CompReg c WHERE c.address = :address"),
    @NamedQuery(name = "CompReg.findByEmail", query = "SELECT c FROM CompReg c WHERE c.email = :email"),
    @NamedQuery(name = "CompReg.findByWebsite", query = "SELECT c FROM CompReg c WHERE c.website = :website"),
    @NamedQuery(name = "CompReg.findByCity", query = "SELECT c FROM CompReg c WHERE c.city = :city"),
    @NamedQuery(name = "CompReg.findByPincode", query = "SELECT c FROM CompReg c WHERE c.pincode = :pincode"),
    @NamedQuery(name = "CompReg.findByImage", query = "SELECT c FROM CompReg c WHERE c.image = :image"),
    @NamedQuery(name = "CompReg.findByContactno", query = "SELECT c FROM CompReg c WHERE c.contactno = :contactno"),
    @NamedQuery(name = "CompReg.findByIsdelete", query = "SELECT c FROM CompReg c WHERE c.isdelete = :isdelete")})
public class CompReg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comp_id")
    private Integer compId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pincode")
    private int pincode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contactno")
    private long contactno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdelete")
    private int isdelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insuCompId")
    private Collection<Policy> policyCollection;

    public CompReg() {
    }

    public CompReg(Integer compId) {
        this.compId = compId;
    }

    public CompReg(Integer compId, String name, String address, String email, String website, String city, int pincode, String image, long contactno, int isdelete) {
        this.compId = compId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.website = website;
        this.city = city;
        this.pincode = pincode;
        this.image = image;
        this.contactno = contactno;
        this.isdelete = isdelete;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getContactno() {
        return contactno;
    }

    public void setContactno(long contactno) {
        this.contactno = contactno;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    @XmlTransient
    public Collection<Policy> getPolicyCollection() {
        return policyCollection;
    }

    public void setPolicyCollection(Collection<Policy> policyCollection) {
        this.policyCollection = policyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compId != null ? compId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompReg)) {
            return false;
        }
        CompReg other = (CompReg) object;
        if ((this.compId == null && other.compId != null) || (this.compId != null && !this.compId.equals(other.compId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CompReg[ compId=" + compId + " ]";
    }
    
}
