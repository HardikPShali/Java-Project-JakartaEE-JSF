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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "health_insu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HealthInsu.findAll", query = "SELECT h FROM HealthInsu h"),
    @NamedQuery(name = "HealthInsu.findByHid", query = "SELECT h FROM HealthInsu h WHERE h.hid = :hid"),
    @NamedQuery(name = "HealthInsu.findByClientname", query = "SELECT h FROM HealthInsu h WHERE h.clientname = :clientname"),
    @NamedQuery(name = "HealthInsu.findByGender", query = "SELECT h FROM HealthInsu h WHERE h.gender = :gender"),
    @NamedQuery(name = "HealthInsu.findByMobileno", query = "SELECT h FROM HealthInsu h WHERE h.mobileno = :mobileno"),
    @NamedQuery(name = "HealthInsu.findByEmailid", query = "SELECT h FROM HealthInsu h WHERE h.emailid = :emailid"),
    @NamedQuery(name = "HealthInsu.findByState", query = "SELECT h FROM HealthInsu h WHERE h.state = :state"),
    @NamedQuery(name = "HealthInsu.findByCity", query = "SELECT h FROM HealthInsu h WHERE h.city = :city"),
    @NamedQuery(name = "HealthInsu.findByPincode", query = "SELECT h FROM HealthInsu h WHERE h.pincode = :pincode"),
    @NamedQuery(name = "HealthInsu.findByPlantype", query = "SELECT h FROM HealthInsu h WHERE h.plantype = :plantype"),
    @NamedQuery(name = "HealthInsu.findBySuminsured", query = "SELECT h FROM HealthInsu h WHERE h.suminsured = :suminsured"),
    @NamedQuery(name = "HealthInsu.findByDobi", query = "SELECT h FROM HealthInsu h WHERE h.dobi = :dobi"),
    @NamedQuery(name = "HealthInsu.findByHeight", query = "SELECT h FROM HealthInsu h WHERE h.height = :height"),
    @NamedQuery(name = "HealthInsu.findByWeight", query = "SELECT h FROM HealthInsu h WHERE h.weight = :weight"),
    @NamedQuery(name = "HealthInsu.findByIsdelete", query = "SELECT h FROM HealthInsu h WHERE h.isdelete = :isdelete"),
    @NamedQuery(name = "HealthInsu.findByInsuCustId", query = "SELECT h FROM HealthInsu h WHERE h.insuCustId = :insuCustId"),
    @NamedQuery(name = "HealthInsu.findByAddress", query = "SELECT h FROM HealthInsu h WHERE h.address = :address")})
public class HealthInsu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hid")
    private Integer hid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "clientname")
    private String clientname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobileno")
    private long mobileno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emailid")
    private String emailid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pincode")
    private String pincode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "plantype")
    private String plantype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suminsured")
    private float suminsured;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dobi")
    private String dobi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "height")
    private String height;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private float weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdelete")
    private int isdelete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "insu_cust_id")
    private String insuCustId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "loginid", referencedColumnName = "lid")
    @ManyToOne(optional = false)
    private Login loginid;
    @JoinColumn(name = "policy_id", referencedColumnName = "policy_id")
    @ManyToOne(optional = false)
    private Policy policyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hid")
    private Collection<Himember> himemberCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hid")
    private Collection<Hicarddetails> hicarddetailsCollection;

    public HealthInsu() {
    }

    public HealthInsu(Integer hid) {
        this.hid = hid;
    }

    public HealthInsu(Integer hid, String clientname, String gender, long mobileno, String emailid, String state, String city, String pincode, String plantype, float suminsured, String dobi, String height, float weight, int isdelete, String insuCustId, String address) {
        this.hid = hid;
        this.clientname = clientname;
        this.gender = gender;
        this.mobileno = mobileno;
        this.emailid = emailid;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.plantype = plantype;
        this.suminsured = suminsured;
        this.dobi = dobi;
        this.height = height;
        this.weight = weight;
        this.isdelete = isdelete;
        this.insuCustId = insuCustId;
        this.address = address;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPlantype() {
        return plantype;
    }

    public void setPlantype(String plantype) {
        this.plantype = plantype;
    }

    public float getSuminsured() {
        return suminsured;
    }

    public void setSuminsured(float suminsured) {
        this.suminsured = suminsured;
    }

    public String getDobi() {
        return dobi;
    }

    public void setDobi(String dobi) {
        this.dobi = dobi;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public String getInsuCustId() {
        return insuCustId;
    }

    public void setInsuCustId(String insuCustId) {
        this.insuCustId = insuCustId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Login getLoginid() {
        return loginid;
    }

    public void setLoginid(Login loginid) {
        this.loginid = loginid;
    }

    public Policy getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Policy policyId) {
        this.policyId = policyId;
    }

    @XmlTransient
    public Collection<Himember> getHimemberCollection() {
        return himemberCollection;
    }

    public void setHimemberCollection(Collection<Himember> himemberCollection) {
        this.himemberCollection = himemberCollection;
    }

    @XmlTransient
    public Collection<Hicarddetails> getHicarddetailsCollection() {
        return hicarddetailsCollection;
    }

    public void setHicarddetailsCollection(Collection<Hicarddetails> hicarddetailsCollection) {
        this.hicarddetailsCollection = hicarddetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hid != null ? hid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HealthInsu)) {
            return false;
        }
        HealthInsu other = (HealthInsu) object;
        if ((this.hid == null && other.hid != null) || (this.hid != null && !this.hid.equals(other.hid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.HealthInsu[ hid=" + hid + " ]";
    }
    
}
