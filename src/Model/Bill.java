package Model;

import java.sql.Timestamp;

import Dao.web.com.CustomerDAO;

public class Bill {
	private int idbill;
	private int iduser;
	private float total;
	private String payment;
	private String address;
	private Timestamp date;
	private String status;
	public int getIdbill() {
		return idbill;
	}
	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address= address;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Bill(int idbill, int iduser, float total, String payment, String address, Timestamp date,String status) {
		super();
		this.idbill = idbill;
		this.iduser = iduser;
		this.total = total;
		this.payment = payment;
		this.address = address;
		this.date = date;
		this.status=status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Bill() {
		// TODO Auto-generated constructor stub
	}
	public  Customer getUser() {
		Customer cus=CustomerDAO.getUsermail(this.iduser);
		return cus;
	}
		
}
