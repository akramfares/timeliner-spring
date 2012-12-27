/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author afares01
 */
@Entity
@Table(name="Utilisateur")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String login;
	private String motDePasse;
        private String nom;
        private String prenom;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date datenaissance;
        private Boolean sexe;
        private String adresse;
        
        @OneToMany
	private List<Status> statusEnvoye = new ArrayList<Status>();
        @OneToMany
	private List<Status> statusRecus = new ArrayList<Status>();
        
        @OneToMany
	private List<Ami> amisEnvoyes = new ArrayList<Ami>();
        @OneToMany
	private List<Ami> amisRecus = new ArrayList<Ami>();

    public List<Ami> getAmisEnvoyes() {
        return amisEnvoyes;
    }

    public void setAmisEnvoyes(List<Ami> amisEnvoyes) {
        this.amisEnvoyes = amisEnvoyes;
    }

    public List<Ami> getAmisRecus() {
        return amisRecus;
    }

    public void setAmisRecus(List<Ami> amisRecus) {
        this.amisRecus = amisRecus;
    }

        
        
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public Boolean getSexe() {
        return sexe;
    }

    public void setSexe(Boolean sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

        
        
    public List<Status> getStatusRecus() {
        return statusRecus;
    }

    public void setStatusRecus(List<Status> statusRecus) {
        this.statusRecus = statusRecus;
    }
        
        

    public List<Status> getStatusEnvoye() {
        return statusEnvoye;
    }

    public void setStatusEnvoye(List<Status> statusEnvoye) {
        this.statusEnvoye = statusEnvoye;
    }

    public User(String login, String motDePasse, String nom, String prenom, Date datenaissance, Boolean sexe, String adresse) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.sexe = sexe;
        this.adresse = adresse;
    }
	

	public User() {
	}

	public User(String login, String motdepasse) {
		this.login = login;
		this.motDePasse = motdepasse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "DAO.User[ id=" + id + " ]";
	}

    void addStatusEnvoye(Status s) {
        statusEnvoye.add(s);
    }
    void addStatusRecu(Status s) {
        statusRecus.add(s);
    }
	
}
