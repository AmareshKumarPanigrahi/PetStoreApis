package api.utilities;

public class DataProvider {
	
	
	
	@org.testng.annotations.DataProvider(name="Data")
	public  Object[][] dataSupplier() throws Throwable {
		
		ExcelUtility eu=new ExcelUtility();
		
		
		Object[][] data=new Object[7][7];
		
		for(int i=0;i<data.length;i++) {
			
			for(int j=0;j<7;j++) {
				
				data[i][j]=eu.getDataFromExcel(i+1,j);
				
			}
			
		}
		
	
		return data;
		
	}

}
