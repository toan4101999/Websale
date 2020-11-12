package Model;

import Dao.web.com.CustomerDAO;
import Tool.MD5;

public class Customer {
	String userName;
	String pass;
	int id;
	String mail;
	public Customer(int id, String userName, String pass, String mail) {
		super();
		this.id = id;
		this.userName=userName;
		this.pass=pass;
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Customer( String userName, String pass,String mail) {
		super();
		this.userName = userName;
		this.pass = pass;
		this.mail=mail;
	
	}
	public boolean check() {
		return CustomerDAO.checkManager(this.userName);
	}
	public Customer(int id, String userName, String pass) {
		super();
		this.id=id;
		this.userName = userName;
		this.pass = pass;
	
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", pass=" + pass + ", id=" + id + "]";
	}
}
