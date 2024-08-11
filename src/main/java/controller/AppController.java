package controller;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.Appuser;
import util.PasswordUtil;
import dao.UserDAO;

@ManagedBean(name = "appController", eager = true)
@RequestScoped
public class AppController {


	private String surname;
	private String firstname;
	private String gender;
	private Date birthdate;
	private String email;
	private String password;
	private String username;
	private UserDAO dao;

	public String registration() {
		return "registration";
	}

	public String saveUser() throws Exception {
		Map<String, String> map = new UserDAO().saveUser(getAppuser());
		if (map.get("result").equals("F")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(map.get("message"), map.get("message")));
			return "registration";
		}
		return "successRegistration";
	}

	private Appuser getAppuser() {
		Appuser appuser = new Appuser();
		appuser.setSurname(surname);
		appuser.setFirstname(firstname);
		appuser.setGender(gender);
		appuser.setBirthdate(birthdate);
		appuser.setEmail(email);
		appuser.setPassword(PasswordUtil.encodePassword(password));
		appuser.setUsername(username);
		return appuser;
	}
	
	


	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
