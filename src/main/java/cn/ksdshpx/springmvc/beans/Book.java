package cn.ksdshpx.springmvc.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book {
	private String name;
	private Integer price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}
}
