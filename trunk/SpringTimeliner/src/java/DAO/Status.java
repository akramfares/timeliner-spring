/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Fares
 */
@Entity
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String contenu;
    private String piecejointe;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateheure;
    @ManyToOne
    private User proprio;
    @ManyToOne
    private User destinataire;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateheure() {
        return dateheure;
    }

    public void setDateheure(Date dateheure) {
        this.dateheure = dateheure;
    }
    
    

    public User getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(User destinataire) {
        this.destinataire = destinataire;
    }
    
    

    public User getProprio() {
        return proprio;
    }

    public void setProprio(User proprio) {
        this.proprio = proprio;
    }


    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getPiecejointe() {
        return piecejointe;
    }

    public void setPiecejointe(String piecejointe) {
        this.piecejointe = piecejointe;
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
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Status[ id=" + id + " ]";
    }
    
}
