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
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
    @NamedQuery(name = "Feedback.findByFid", query = "SELECT f FROM Feedback f WHERE f.fid = :fid"),
    @NamedQuery(name = "Feedback.findByMsg", query = "SELECT f FROM Feedback f WHERE f.msg = :msg")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fid")
    private Integer fid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "msg")
    private String msg;
    @JoinColumn(name = "policyid", referencedColumnName = "policy_id")
    @ManyToOne(optional = false)
    private Policy policyid;
    @JoinColumn(name = "lid", referencedColumnName = "lid")
    @ManyToOne(optional = false)
    private Login lid;

    public Feedback() {
    }

    public Feedback(Integer fid) {
        this.fid = fid;
    }

    public Feedback(Integer fid, String msg) {
        this.fid = fid;
        this.msg = msg;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Policy getPolicyid() {
        return policyid;
    }

    public void setPolicyid(Policy policyid) {
        this.policyid = policyid;
    }

    public Login getLid() {
        return lid;
    }

    public void setLid(Login lid) {
        this.lid = lid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fid != null ? fid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.fid == null && other.fid != null) || (this.fid != null && !this.fid.equals(other.fid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Feedback[ fid=" + fid + " ]";
    }
    
}
