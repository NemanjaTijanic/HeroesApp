/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import exceptions.NedovoljanUnosException;
import exceptions.NegativanBrojException;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "ability")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ability.findAll", query = "SELECT a FROM Ability a")
    , @NamedQuery(name = "Ability.findByAbilityId", query = "SELECT a FROM Ability a WHERE a.abilityId = :abilityId")
    , @NamedQuery(name = "Ability.findByTitle", query = "SELECT a FROM Ability a WHERE a.title = :title")
    , @NamedQuery(name = "Ability.findByDescription", query = "SELECT a FROM Ability a WHERE a.description = :description")})
public class Ability implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ability_id")
    private Integer abilityId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "hero_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hero heroId;

    public Ability() {
    }

    public Ability(Integer abilityId) throws NegativanBrojException {
        setAbilityId(abilityId);
    }

    public Ability(Integer abilityId, String title, String description) throws NegativanBrojException, NedovoljanUnosException {
        setAbilityId(abilityId);
        setTitle(title);
        setDescription(description);
    }

    public Integer getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Integer abilityId) throws NegativanBrojException {
        if(abilityId < 0){
            throw new NegativanBrojException("ERROR: Given number cannot be less than zero.");
        }
        else{
            this.abilityId = abilityId;
        } 
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws NedovoljanUnosException {
        if(title.length() < 2){
            throw new NedovoljanUnosException("ERROR: Given spell title must consist of at least two characters.");
        }
        else{
            this.title = title;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws NedovoljanUnosException {
        if(description.length() < 2){
            throw new NedovoljanUnosException("ERROR: Given spell description must consist of at least two characters.");
        }
        else{
            this.description = description;
        }
    }

    public Hero getHeroId() {
        return heroId;
    }

    public void setHeroId(Hero heroId) {
        this.heroId = heroId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abilityId != null ? abilityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ability)) {
            return false;
        }
        Ability other = (Ability) object;
        if ((this.abilityId == null && other.abilityId != null) || (this.abilityId != null && !this.abilityId.equals(other.abilityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title + ' ';
    }
    
    
}
