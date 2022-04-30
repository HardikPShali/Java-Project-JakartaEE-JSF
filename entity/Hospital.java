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
@Table(name = "hospital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h"),
    @NamedQuery(name = "Hospital.findByHospitalId", query = "SELECT h FROM Hospital h WHERE h.hospitalId = :hospitalId"),
    @NamedQuery(name = "Hospital.findByName", query = "SELECT h FROM Hospital h WHERE h.name = :name"),
    @NamedQuery(name = "Hospital.findByAddress", query = "SELECT h FROM Hospital h WHERE h.address = :address"),
    @NamedQuery(name = "Hospital.findByEmailid", query = "SELECT h FROM Hospital h WHERE h.emailid = :emailid"),
    @NamedQuery(name = "Hospital.findByWebsite", query = "SELECT h FROM Hospital h WHERE h.website = :website"),
    @NamedQuery(name = "Hospital.findByCity", query = "SELECT h FROM Hospital h WHERE h.city = :city"),
    @NamedQuery(name = "Hospital.findByPincode", query = "SELECT h FROM Hospital h WHERE h.pincode = :pincode"),
    @NamedQuery(name = "Hospital.findByImage", query = "SELECT h FROM Hospital h WHERE h.image = :image"),
    @NamedQuery(name = "Hospital.findByContactno", query = "SELECT h FROM Hospital h WHERE h.contactno = :contactno")})
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hospital_id")
    private Integer hospitalId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emailid")
    private String emailid;
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

    public Hospital() {
    }

    public Hospital(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Hospital(Integer hospitalId, String name, String address, String emailid, String website, String city, int pincode, String image, long contactno) {
        this.hospitalId = hospitalId;
        this.name = name;
        this.address = address;
        this.emailid = emailid;
        this.website = website;
        this.city = city;
        this.pincode = pincode;
        this.image = image;
        this.contactno = contactno;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
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

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hospitalId != null ? hospitalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.hospitalId == null && other.hospitalId != null) || (this.hospitalId != null && !this.hospitalId.equals(other.hospitalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hospital[ hospitalId=" + hospitalId + " ]";
    }
    
}
