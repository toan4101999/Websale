package Model;

public class Product {
	private String shoesid;
	private String url;
	private String urllogo;
	private float price;
	private String name;
	private String category;
	private float unitprice;
	public Product(String shoesid, String url, String urllogo, float price, String name, String category,float unitprice) {
		super();
		this.shoesid = shoesid;
		this.url = url;
		this.urllogo = urllogo;
		this.price = price;
		this.name = name;
		this.category = category;
		this.unitprice=unitprice;
	}		
	public Product(String shoesid, String urllogo, String url, float price, String name,String category ){
		super();
		this.shoesid = shoesid;
		this.urllogo = urllogo;
		this.url = url;
		this.price = price;
		this.name = name;
		this.category = category;
	}
	
	public float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public String getShoesid() {
		return shoesid;
	}
	public void setShoesid(String shoesid) {
		this.shoesid = shoesid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrllogo() {
		return urllogo;
	}
	public void setUrllogo(String urllogo) {
		this.urllogo = urllogo;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
	