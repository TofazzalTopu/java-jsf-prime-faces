package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="APPUSER")
public class Appuser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@Size(min=3, max=50)
	@Column(name = "firstname", nullable = false)
	private String firstname;

	@NotNull
	@Column(name = "gender", nullable = false)
	private String gender;	
	
	@NotNull
	@Column(name = "birthdate", nullable = false)
	private Date birthdate;	
	
	@NotBlank
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotBlank
	@Column(name = "username", nullable = false)
	private String username;
	
	
	@NotBlank
	@Column(name = "password", nullable = false)
	private String password;


	@Override
	public String toString() {
		return "Appuser [id=" + id + ", surname=" + surname + ", firstname=" + firstname + ", username=" + username + ", birthdate=" + birthdate + ", gender=" + gender + ", email=" + email + "]";
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}