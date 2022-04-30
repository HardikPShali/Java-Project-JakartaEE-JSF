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
@Table(name = "terminsu_ai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TerminsuAi.findAll", query = "SELECT t FROM TerminsuAi t"),
    @NamedQuery(name = "TerminsuAi.findByAid", query = "SELECT t FROM TerminsuAi t WHERE t.aid = :aid"),
    @NamedQuery(name = "TerminsuAi.findByOccupation", query = "SELECT t FROM TerminsuAi t WHERE t.occupation = :occupation"),
    @NamedQuery(name = "TerminsuAi.findByWeight", query = "SELECT t FROM TerminsuAi t WHERE t.weight = :weight"),
    @NamedQuery(name = "TerminsuAi.findByHeightf", query = "SELECT t FROM TerminsuAi t WHERE t.heightf = :heightf"),
    @NamedQuery(name = "TerminsuAi.findByHeighti", query = "SELECT t FROM TerminsuAi t WHERE t.heighti = :heighti"),
    @NamedQuery(name = "TerminsuAi.findByMother", query = "SELECT t FROM TerminsuAi t WHERE t.mother = :mother"),
    @NamedQuery(name = "TerminsuAi.findByFather", query = "SELECT t FROM TerminsuAi t WHERE t.father = :father"),
    @NamedQuery(name = "TerminsuAi.findByAddress", query = "SELECT t FROM TerminsuAi t WHERE t.address = :address"),
    @NamedQuery(name = "TerminsuAi.findByIsdelete", query = "SELECT t FROM TerminsuAi t WHERE t.isdelete = :isdelete"),
    @NamedQuery(name = "TerminsuAi.findByLoginid", query = "SELECT t FROM TerminsuAi t WHERE t.loginid = :loginid"),
    @NamedQuery(name = "TerminsuAi.findByInsuCustId", query = "SELECT t FROM TerminsuAi t WHERE t.insuCustId = :insuCustId"),
    @NamedQuery(name = "TerminsuAi.findByIsexpire", query = "SELECT t FROM TerminsuAi t WHERE t.isexpire = :isexpire")})
public class TerminsuAi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aid")
    private Integer aid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "occupation")
    private String occupation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private int weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heightf")
    private int heightf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heighti")
    private int heighti;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mother")
    private String mother;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "father")
    private String father;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdelete")
    private int isdelete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loginid")
    private int loginid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "insu_cust_id")
    private String insuCustId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isexpire")
    private int isexpire;
    @JoinColumn(name = "tid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TerminsuPi tid;

    public TerminsuAi() {
    }

    public TerminsuAi(Integer aid) {
        this.aid = aid;
    }

    public TerminsuAi(Integer aid, String occupation, int weight, int heightf, int heighti, String mother, String father, String address, int isdelete, int loginid, String insuCustId, int isexpire) {
        this.aid = aid;
        this.occupation = occupation;
        this.weight = weight;
        this.heightf = heightf;
        this.heighti = heighti;
        this.mother = mother;
        this.father = father;
        this.address = address;
        this.isdelete = isdelete;
        this.loginid = loginid;
        this.insuCustId = insuCustId;
        this.isexpire = isexpire;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeightf() {
        return heightf;
    }

    public void setHeightf(int heightf) {
        this.heightf = heightf;
    }

    public int getHeighti() {
        return heighti;
    }

    public void setHeighti(int heighti) {
        this.heighti = heighti;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
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

    public TerminsuPi getTid() {
        return tid;
    }

    public void setTid(TerminsuPi tid) {
        this.tid = tid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TerminsuAi)) {
            return false;
        }
        TerminsuAi other = (TerminsuAi) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TerminsuAi[ aid=" + aid + " ]";
    }
    
}
