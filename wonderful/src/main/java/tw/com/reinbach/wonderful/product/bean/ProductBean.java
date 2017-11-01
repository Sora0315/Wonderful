package tw.com.reinbach.wonderful.product.bean;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class ProductBean {

	@Id
	private String PID;
	@ManyToOne
	@JoinColumn(name = "PStatusID")
	private ProdStatusBean prodStatusBean;
	private String PName;
	private int Price;
	private int Stock;
	private byte[] PImage;

	public String getPID() {
		return PID;
	}

	public void setPID(String pID) {
		PID = pID;
	}

	public ProdStatusBean getProdStatusBean() {
		return prodStatusBean;
	}

	public void setProdStatusBean(ProdStatusBean prodStatusBean) {
		this.prodStatusBean = prodStatusBean;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public byte[] getPImage() {
		return PImage;
	}

	public void setPImage(byte[] pImage) {
		PImage = pImage;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return true;
		}

		if (!(obj instanceof ProductBean)) {
			return false;
		}

		return false;
	}

}
