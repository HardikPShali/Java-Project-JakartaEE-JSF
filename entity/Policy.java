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
@Table(name = "policy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Policy.findAll", query = "SELECT p FROM Policy p"),
    @NamedQuery(name = "Policy.findByPolicyId", query = "SELECT p FROM Policy p WHERE p.policyId = :policyId"),
    @NamedQuery(name = "Policy.findByPolicyNo", query = "SELECT p FROM Policy p WHERE p.policyNo = :policyNo"),
    @NamedQuery(name = "Policy.findByName", query = "SELECT p FROM Policy p WHERE p.name = :name"),
    @NamedQuery(name = "Policy.findByIssuedate", query = "SELECT p FROM Policy p WHERE p.issuedate = :issuedate"),
    @NamedQuery(name = "Policy.findByValidity", query = "SELECT p FROM Policy p WHERE p.validity = :validity"),
    @NamedQuery(name = "Policy.findByNoOfPerson", query = "SELECT p FROM Policy p WHERE p.noOfPerson = :noOfPerson"),
    @NamedQuery(name = "Policy.findByTotalAdult", query = "SELECT p FROM Policy p WHERE p.totalAdult = :totalAdult"),
    @NamedQuery(name = "Policy.findByNoOfSon", query = "SELECT p FROM Policy p WHERE p.noOfSon = :noOfSon"),
    @NamedQuery(name = "Policy.findByNoOfDaughter", query = "SELECT p FROM Policy p WHERE p.noOfDaughter = :noOfDaughter"),
    @NamedQuery(name = "Policy.findBySumInsured", query = "SELECT p FROM Policy p WHERE p.sumInsured = :sumInsured"),
    @NamedQuery(name = "Policy.findByCost", query = "SELECT p FROM Policy p WHERE p.cost = :cost"),
    @NamedQuery(name = "Policy.findByIsdelete", query = "SELECT p FROM Policy p WHERE p.isdelete = :isdelete")})
public class Policy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "policy_id")
    private Integer policyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "policy_no")
    private int policyNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "issuedate")
    private String issuedate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "validity")
    private String validity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_of_person")
    private int noOfPerson;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_adult")
    private int totalAdult;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_of_son")
    private int noOfSon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_of_daughter")
    private int noOfDaughter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sum_insured")
    private int sumInsured;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cost")
    private String cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdelete")
    private int isdelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planId")
    private Collection<TerminsuPi> terminsuPiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "policyId")
    private Collection<HealthInsu> healthInsuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "policyid")
    private Collection<Feedback> feedbackCollection;
    @JoinColumn(name = "insu_type_id", referencedColumnName = "insu_type_id")
    @ManyToOne(optional = false)
    private InsuType insuTypeId;
    @JoinColumn(name = "insu_comp_id", referencedColumnName = "comp_id")
    @ManyToOne(optional = false)
    private CompReg insuCompId;

    public Policy() {
    }

    public Policy(Integer policyId) {
        this.policyId = policyId;
    }

    public Policy(Integer policyId, int policyNo, String name, String issuedate, String validity, int noOfPerson, int totalAdult, int noOfSon, int noOfDaughter, int sumInsured, String cost, int isdelete) {
        this.policyId = policyId;
        this.policyNo = policyNo;
        this.name = name;
        this.issuedate = issuedate;
        this.validity = validity;
        this.noOfPerson = noOfPerson;
        this.totalAdult = totalAdult;
        this.noOfSon = noOfSon;
        this.noOfDaughter = noOfDaughter;
        this.sumInsured = sumInsured;
        this.cost = cost;
        this.isdelete = isdelete;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public int getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(int policyNo) {
        this.policyNo = policyNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public int getTotalAdult() {
        return totalAdult;
    }

    public void setTotalAdult(int totalAdult) {
        this.totalAdult = totalAdult;
    }

    public int getNoOfSon() {
        return noOfSon;
    }

    public void setNoOfSon(int noOfSon) {
        this.noOfSon = noOfSon;
    }

    public int getNoOfDaughter() {
        return noOfDaughter;
    }

    public void setNoOfDaughter(int noOfDaughter) {
        this.noOfDaughter = noOfDaughter;
    }

    public int getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(int sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    @XmlTransient
    public Collection<TerminsuPi> getTerminsuPiCollection() {
        return terminsuPiCollection;
    }

    public void setTerminsuPiCollection(Collection<TerminsuPi> terminsuPiCollection) {
        this.terminsuPiCollection = terminsuPiCollection;
    }

    @XmlTransient
    public Collection<HealthInsu> getHealthInsuCollection() {
        return healthInsuCollection;
    }

    public void setHealthInsuCollection(Collection<HealthInsu> healthInsuCollection) {
        this.healthInsuCollection = healthInsuCollection;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    public InsuType getInsuTypeId() {
        return insuTypeId;
    }

    public void setInsuTypeId(InsuType insuTypeId) {
        this.insuTypeId = insuTypeId;
    }

    public CompReg getInsuCompId() {
        return insuCompId;
    }

    public void setInsuCompId(CompReg insuCompId) {
        this.insuCompId = insuCompId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (policyId != null ? policyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Policy)) {
            return false;
        }
        Policy other = (Policy) object;
        if ((this.policyId == null && other.policyId != null) || (this.policyId != null && !this.policyId.equals(other.policyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Policy[ policyId=" + policyId + " ]";
    }
    
}
