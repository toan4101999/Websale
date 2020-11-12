package Model;

public class Billdetails {
	private int iddbill;
	private int idbill;
	private String idshoes;
	private float price;
	private int qty;
	private String size;
	private String url;
	public String getSize() {
		return size;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getIddbill() {
		return iddbill;
	}
	public void setIddbill(int iddbill) {
		this.iddbill = iddbill;
	}
	public int getIdbill() {
		return idbill;
	}
	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}
	public String getIdshoes() {
		return idshoes;
	}
	public void setIdshoes(String idshoes) {
		this.idshoes = idshoes;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Billdetails(int iddbill, int idbill, String idshoes, float price, int qty) {
		super();
		this.iddbill = iddbill;
		this.idbill = idbill;
		this.idshoes = idshoes;
		this.price = price;
		this.qty = qty;
	}
	public Billdetails(int idbill,String idshoes, float price, int qty,String size,String url) {
		super();
		this.idbill = idbill;
		this.idshoes = idshoes;
		this.price = price;
		this.qty = qty;
		this.size=size;
		this.url=url;
	}
	public Billdetails() {
		// TODO Auto-generated constructor stub
	}
}
