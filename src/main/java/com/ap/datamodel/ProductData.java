package com.ap.datamodel;



public class ProductData {

	
	private String productName;
	private String quality;
	private String size;
	private String color;
	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getQuality() {
		return quality;
	}


	public void setQuality(String quality) {
		this.quality = quality;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	

	
	@Override
	public int hashCode() {
	final int prime = 31; //setting the buying purchase to limit of 31 purchases//
	int result = 1;

/*hashCode() is a function that takes an object and outputs a numeric value. 
 * The hashcode for an object is always the same if the object doesn't change.*/
	
/* Example:

a=1;
b=2;

x=3;
y=4;

answer = a > b ? x : y;
answer=4 since the condition is false it takes y value.

A question mark (?)
. The value to use if the condition is true

A colon (:)
. The value to use if the condition is false */
	
	
	
		result= prime * result + ((color==null)? 0 : color.hashCode());
		result= prime * result + ((productName==null)? 0 : productName.hashCode());
		result= prime * result + ((quality==null)? 0 : quality.hashCode());
		result= prime * result + ((size==null)? 0 : size.hashCode());
		return result;
	}
	



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductData other = (ProductData) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (quality == null) {
			if (other.quality != null)
				return false;
		} else if (!quality.equals(other.quality))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ProductData [productName=" + productName + ", quality=" + quality + ", size=" + size + ", color="
				+ color + ", getProductName()=" + getProductName() + ", getQuality()=" + getQuality() + ", getSize()="
				+ getSize() + ", getColor()=" + getColor() + ", hashcode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}



	
	
	
}
