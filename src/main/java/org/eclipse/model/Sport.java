package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="sports")
public class Sport {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=20)
	private String name ;
	
	private String type ;
	
	@ManyToMany(mappedBy="sports")
	private List <User> users = new ArrayList <User> ();

	public Sport(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	public void addUser(User user) {
		users.add(user);
		user.getSports().add(this);
	}

	public void removeUser(User user) {
		users.remove(user);
		user.getSports().remove(this);
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	
	
	
}
