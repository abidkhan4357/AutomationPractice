package com.ap.dataprovider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ap.datamodel.ProductData;

public class DataBuilder {

	
		@DataProvider(name = "ProductData")
		public Iterator<Object[]> loginDataProvider(){
			
			Collection<Object[]> customerData = new ArrayList<Object[]>();
			{
				{
					DataBuilder dataBuilder = new DataBuilder();
					List<DataBuilder> data = dataBuilder.prepareProductData();
					for(DataBuilder customerModel : data) {
						customerData.add(new Object[] {customerModel});
				}
			}
				
		}
		return customerData.iterator();
			

}




private List<DataBuilder> prepareProductData() {
			return null;
		}

@Test(dataProvider="ProductData")
public void tetsData(ProductData data) {
	System.out.println(data.getProductName());
	System.out.println(data.getColor());
	System.out.println(data.getQuality());
	System.out.println(data.getSize());
}
}
