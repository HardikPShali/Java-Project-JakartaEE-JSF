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
@Table(name = "terminsu_pi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TerminsuPi.findAll", query = "SELECT t FROM TerminsuPi t"),
    @NamedQuery(name = "TerminsuPi.findById", query = "SELECT t FROM TerminsuPi t WHERE t.id = :id"),
    @NamedQuery(name = "TerminsuPi.findByClientname", query = "SELECT t FROM TerminsuPi t WHERE t.clientname = :clientname"),
    @NamedQuery(name = "TerminsuPi.findByGender", query = "SELECT t FROM TerminsuPi t WHERE t.gender = :gender"),
    @NamedQuery(name = "TerminsuPi.findByLifestage", query = "SELECT t FROM TerminsuPi t WHERE t.lifestage = :lifestage"),
    @NamedQuery(name = "TerminsuPi.findByBday", query = "SELECT t FROM TerminsuPi t WHERE t.bday = :bday"),
    @NamedQuery(name = "TerminsuPi.findByMobile", query = "SELECT t FROM TerminsuPi t WHERE t.mobile = :mobile"),
    @NamedQuery(name = "TerminsuPi.findByEducation", query = "SELECT t FROM TerminsuPi t WHERE t.education = :education"),
    @NamedQuery(name = "TerminsuPi.findBySmoke", query = "SELECT t FROM TerminsuPi t WHERE t.smoke = :smoke"),
    @NamedQuery(name = "TerminsuPi.findByIncome", query = "SELECT t FROM TerminsuPi t WHERE t.income = :income"),
    @NamedQuery(name = "TerminsuPi.findByCover", query = "SELECT t FROM TerminsuPi t WHERE t.cover = :cover"),
    @NamedQuery(name = "TerminsuPi.findByCoverage", query = "SELECT t FROM TerminsuPi t WHERE t.coverage = :coverage"),
    @NamedQuery(name = "TerminsuPi.findByIsdelete", query = "SELECT t FROM TerminsuPi t WHERE t.isdelete = :isdelete"),
    @NamedQuery(name = "TerminsuPi.findByInsuCustId", query = "SELECT t FROM TerminsuPi t WHERE t.insuCustId = :insuCustId"),
    @NamedQuery(name = "TerminsuPi.findByIsexpire", query = "SELECT t FROM TerminsuPi t WHERE t.isexpire = :isexpire")})
public class TerminsuPi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Size(min = 1, max = 50)
    @Column(name = "lifestage")
    private String lifestage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bday")
    private String bday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobile")
    private long mobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "education")
    private String education;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "smoke")
    private String smoke;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "income")
    private String income;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cover")
    private String cover;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "coverage")
    private String coverage;
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
    @Column(name = "isexpire")
    private int isexpire;
    @JoinColumn(name = "plan_id", referencedColumnName = "policy_id")
    @ManyToOne(optional = false)
    private Policy planId;
    @JoinColumn(name = "loginid", referencedColumnName = "lid")
    @ManyToOne(optional = false)
    private Login loginid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "termpiId")
    private Collection<Termcarddetails> termcarddetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tid")
    private Collection<TerminsuAi> terminsuAiCollection;

    public TerminsuPi() {
    }

    public TerminsuPi(Integer id) {
        this.id = id;
    }

    public TerminsuPi(Integer id, String clientname, String gender, String lifestage, String bday, long mobile, String education, String smoke, String income, String cover, String coverage, int isdelete, String insuCustId, int isexpire) {
        this.id = id;
        this.clientname = clientname;
        this.gender = gender;
        this.lifestage = lifestage;
        this.bday = bday;
        this.mobile = mobile;
        this.education = education;
        this.smoke = smoke;
        this.income = income;
        this.cover = cover;
        this.coverage = coverage;
        this.isdelete = isdelete;
        this.insuCustId = insuCustId;
        this.isexpire = isexpire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLifestage() {
        return lifestage;
    }

    public void setLifestage(String lifestage) {
        this.lifestage = lifestage;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
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

    public int getIsexpire() {
        return isexpire;
    }

    public void setIsexpire(int isexpire) {
        this.isexpire = isexpire;
    }

    public Policy getPlanId() {
        return planId;
    }

    public void setPlanId(Policy planId) {
        this.planId = planId;
    }

    public Login getLoginid() {
        return loginid;
    }

    public void setLoginid(Login loginid) {
        this.loginid = loginid;
    }

    @XmlTransient
    public Collection<Termcarddetails> getTermcarddetailsCollection() {
        return termcarddetailsCollection;
    }

    public void setTermcarddetailsCollection(Collection<Termcarddetails> termcarddetailsCollection) {
        this.termcarddetailsCollection = termcarddetailsCollection;
    }

    @XmlTransient
    public Collection<TerminsuAi> getTerminsuAiCollection() {
        return terminsuAiCollection;
    }

    public void setTerminsuAiCollection(Collection<TerminsuAi> terminsuAiCollection) {
        this.terminsuAiCollection = terminsuAiCollection;
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
        if (!(object instanceof TerminsuPi)) {
            return false;
        }
        TerminsuPi other = (TerminsuPi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TerminsuPi[ id=" + id + " ]";
    }
    
}
