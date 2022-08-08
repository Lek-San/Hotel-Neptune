package fr.simplon.neptunians.Hotel_Neptune;

import java.sql.Date;

public class Client {
	private int id_client;
	private String name;
	private String first_name;
	private String email;
	private String password;
	private Date birth_date;
	public Client(int id_client, String name, String first_name, String email, String password, Date birth_date,
			String picture) {
		super();
		this.id_client = id_client;
		this.name = name;
		this.first_name = first_name;
		this.email = email;
		this.password = password;
		this.birth_date = birth_date;
		this.picture = picture;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	private String picture;
}
