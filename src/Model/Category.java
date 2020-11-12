package Model;

public class Category {
	private String idcategory;
	private String namecategory;
	public Category(String idcategory, String namecategory) {
		super();
		this.idcategory = idcategory;
		this.namecategory = namecategory;
	}
	public String getIdcategory() {
		return idcategory;
	}
	public void setIdcategory(String idcategory) {
		this.idcategory = idcategory;
	}
	public String getNamecategory() {
		return namecategory;
	}
	public void setNamecategory(String namecategory) {
		this.namecategory = namecategory;
	}
	
}
