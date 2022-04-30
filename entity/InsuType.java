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
@Table(name = "insu_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InsuType.findAll", query = "SELECT i FROM InsuType i"),
    @NamedQuery(name = "InsuType.findByInsuTypeId", query = "SELECT i FROM InsuType i WHERE i.insuTypeId = :insuTypeId"),
    @NamedQuery(name = "InsuType.findByType", query = "SELECT i FROM InsuType i WHERE i.type = :type")})
public class InsuType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "insu_type_id")
    private Integer insuTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insuTypeId")
    private Collection<Policy> policyCollection;

    public InsuType() {
    }

    public InsuType(Integer insuTypeId) {
        this.insuTypeId = insuTypeId;
    }

    public InsuType(Integer insuTypeId, String type) {
        this.insuTypeId = insuTypeId;
        this.type = type;
    }

    public Integer getInsuTypeId() {
        return insuTypeId;
    }

    public void setInsuTypeId(Integer insuTypeId) {
        this.insuTypeId = insuTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (insuTypeId != null ? insuTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsuType)) {
            return false;
        }
        InsuType other = (InsuType) object;
        if ((this.insuTypeId == null && other.insuTypeId != null) || (this.insuTypeId != null && !this.insuTypeId.equals(other.insuTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.InsuType[ insuTypeId=" + insuTypeId + " ]";
    }
    
}
