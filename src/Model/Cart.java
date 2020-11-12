package Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private String Size;
	private String idshoes;
	private int iduser;
	private String url;
	private String name;
	private Float Price;
	private int qty;
	private int idcart;
	private float total;

	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getIdcart() {
		return idcart;
	}
	public void setIdcart(int idcart) {
		this.idcart = idcart;
	}
	public Cart(int idcart, int iduser, String idshoes, String url, String name, Float price,String size,int qty ) {
		super();
		this.idcart = idcart;
		this.iduser = iduser;
		this.idshoes = idshoes;
		this.url = url;
		this.name = name;
		this.Price = price;
		this.Size = size;
		this.qty = qty;
	}
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		this.Size = size;
	}
	public String getIdshoes() {
		return idshoes;
	}
	public void setIdshoes(String idshoes) {
		this.idshoes = idshoes;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	
}
