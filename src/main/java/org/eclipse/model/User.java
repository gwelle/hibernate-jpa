package org.eclipse.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.enums.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@NamedQuery(name = "usersByRole", query = "FROM User WHERE role = :role ")
public class User {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(length=200, name="email", unique=true, nullable=false)
	private String email;
	
	@Column(length=200, name="password", unique=false, nullable=false)
	private String password ;
	
	@Column(name="role", nullable=false)
	private String role ;
	
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="created_at", nullable=false)
	@CreationTimestamp
	private Instant created_at ;
	
	@Column(name="updated_at", nullable=true)
	@UpdateTimestamp
    private Instant updated_at;
	
	//@OneToOne(cascade = { CascadeType.PERSIST })
	//@ManyToOne(cascade = { CascadeType.PERSIST })
	//private Address adress ;
	
	@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	private List <Address> addresses;
	
	@ManyToMany(cascade = { CascadeType.PERSIST })
	private List <Sport> sports = new ArrayList <Sport> ();
	
	public User() {}
	
	public User(String email, String password, String role) {
		super();
		System.out.println("User::User()");
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public User(String email, String password, String role, Gender gender) {
		super();
		System.out.println("User::User()");
		this.email = email;
		this.password = password;
		this.role = role;
		this.gender = gender ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	

	/*public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}*/
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	public boolean addAddress(Address e) {
		return addresses.add(e);
	}

	public boolean removeAddress(Object o) {
		return addresses.remove(o);
	}
	
	public void addSport(Sport sport) {
		sports.add(sport);
		sport.getUsers().add(this);
	}

	public void removeSport(Sport sport) {
		sports.remove(sport);
		sport.getUsers().remove(this);
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role 
				+ ", gender=" + gender + ", created_at=" + created_at + ", updated_at=" + updated_at 
				+ ", addresses=" + addresses + ", sports=" + sports + "]";
	}
}
