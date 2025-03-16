/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import exceptions.NedovoljanUnosException;
import exceptions.NegativanBrojException;
import exceptions.NeispravanUnosException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "hero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hero.findAll", query = "SELECT h FROM Hero h")
    , @NamedQuery(name = "Hero.findById", query = "SELECT h FROM Hero h WHERE h.id = :id")
    , @NamedQuery(name = "Hero.findByName", query = "SELECT h FROM Hero h WHERE h.name = :name")
    , @NamedQuery(name = "Hero.findByRole", query = "SELECT h FROM Hero h WHERE h.role = :role")
    , @NamedQuery(name = "Hero.findByUniverse", query = "SELECT h FROM Hero h WHERE h.universe = :universe")
    , @NamedQuery(name = "Hero.findByDamage", query = "SELECT h FROM Hero h WHERE h.damage = :damage")
    , @NamedQuery(name = "Hero.findByUtility", query = "SELECT h FROM Hero h WHERE h.utility = :utility")
    , @NamedQuery(name = "Hero.findBySurvivability", query = "SELECT h FROM Hero h WHERE h.survivability = :survivability")
    , @NamedQuery(name = "Hero.findByComplexity", query = "SELECT h FROM Hero h WHERE h.complexity = :complexity")})
public class Hero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @Column(name = "universe")
    private String universe;
    @Basic(optional = false)
    @Column(name = "damage")
    private int damage;
    @Basic(optional = false)
    @Column(name = "utility")
    private int utility;
    @Basic(optional = false)
    @Column(name = "survivability")
    private int survivability;
    @Basic(optional = false)
    @Column(name = "complexity")
    private int complexity;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "heroId")
    private List<Ability> abilityList;

    public Hero() {
    }

    public Hero(Integer id) throws NegativanBrojException {
        setId(id);
    }

    public Hero(Integer id, String name, String role, String universe, int damage, int utility, int survivability, int complexity) throws NegativanBrojException, NeispravanUnosException, NedovoljanUnosException {
        setId(id);
        setName(name);
        setRole(role);
        setUniverse(universe);
        setDamage(damage);
        setUtility(utility);
        setSurvivability(survivability);
        setComplexity(complexity);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) throws NegativanBrojException {
        if(id > 0){
            this.id = id;
        }
        else{
            throw new NegativanBrojException("ERROR: Given number cannot be less than one.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NedovoljanUnosException {
        if(name.length() < 2){
            throw new NedovoljanUnosException("ERROR: Given name must consist of at least two characters.");
        }
        else{
            this.name = name;
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) throws NedovoljanUnosException {
        if(role.length() < 2){
            throw new NedovoljanUnosException("ERROR: Given role name must consist of at least two characters.");
        }
        else{
            this.role = role;
        }    
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) throws NedovoljanUnosException {
        if(universe.length() < 2){
            throw new NedovoljanUnosException("ERROR: Given universe name must consist of at least two characters.");
        }
        else{
            this.universe = universe;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) throws NegativanBrojException, NeispravanUnosException {
        if(damage <= 0){
            throw new NegativanBrojException("ERROR: Given number cannot be less than one.");
        }
        else if(damage > 10){
            throw new NeispravanUnosException("ERROR: Given number must be in range 1-10.");
        }
        else{
            this.damage = damage;
        }
    }

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) throws NegativanBrojException, NeispravanUnosException {
        if(utility <= 0){
            throw new NegativanBrojException("ERROR: Given number cannot be less than one.");
        }
        else if(utility > 10){
            throw new NeispravanUnosException("ERROR: Given number must be in range 1-10.");
        }
        else{
            this.utility = utility;
        }
    }

    public int getSurvivability() {
        return survivability;
    }

    public void setSurvivability(int survivability) throws NegativanBrojException, NeispravanUnosException {
        if(survivability <= 0){
            throw new NegativanBrojException("ERROR: Given number cannot be less than one.");
        }
        else if(survivability > 10){
            throw new NeispravanUnosException("ERROR: Given number must be in range 1-10.");
        }
        else{
            this.survivability = survivability;
        }
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) throws NegativanBrojException, NeispravanUnosException {
        if(complexity <= 0){
            throw new NegativanBrojException("ERROR: Given number cannot be less than one.");
        }
        else if(complexity > 10){
            throw new NeispravanUnosException("ERROR: Given number must be in range 1-10.");
        }
        else{
            this.complexity = complexity;
        }
    }

    @XmlTransient
    public List<Ability> getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(List<Ability> abilityList) {
        this.abilityList = abilityList;
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
        if (!(object instanceof Hero)) {
            return false;
        }
        Hero other = (Hero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID: " + id + "  NAME: " + name + "  ROLE: " + role + "  UNIVERSE: " + universe + '\n';
    }
    
    
    
}
