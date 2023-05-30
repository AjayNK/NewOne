package DataProvider_Component;


import org.testng.annotations.DataProvider;
import Generic_Component.Excel_RW;
import java.util.*;


public class dataProvider_loadData {
	
	@DataProvider(name="dp_invalidLogin")
	public static Iterator<Object[]> getInvalidLogin() throws Exception {
		return commondp_logic("Login", "InvalidLogin");
	}

	@DataProvider(name="dp_validLogin")
	public static Iterator<Object[]> getValidLogin() throws Exception {
		return commondp_logic("Login", "ValidLogin");
	}
	
	@DataProvider(name="dp_validSearch")
	public static Iterator<Object[]> getValidSearch() throws Exception {
		return commondp_logic("Search", "ValidSearch");
	}

	@DataProvider(name="dp_invalidSearch")
	public static Iterator<Object[]> getInvalidSearch() throws Exception {
		return commondp_logic("Search", "InvalidSearch");
	}
	
	@DataProvider(name="dp_addcart")
	public static Iterator<Object[]> getCart() throws Exception {
		return commondp_logic("Cart", "AddToCart");
	}
	
	public static Iterator<Object[]> commondp_logic(String SheetName,  String sName) throws Exception{
		Excel_RW xl = new Excel_RW("E:\\hybridFramework\\TestData\\testdata_rediff.xlsx");
		int rowCount = xl.getRowCount(SheetName);
		int columnCount = xl.getRowCount(SheetName);
		
		List<Object[]> arr_List = new ArrayList<Object[]>();
		
		for(int i=1;i<=rowCount;i++) {
		String Execute_Flag = xl.getCellValue(SheetName, i, 2);
		String Script_Name = xl.getCellValue(SheetName, i, 3);
		
		if((Execute_Flag.equalsIgnoreCase("Y"))&&(Script_Name.equalsIgnoreCase(sName))) {
			
			Map<String,String> dMap = new HashMap<String,String>();
			
			Object[] x = new Object[1];
			
			for(int j=0;j<columnCount;j++) {
				
				String sKey = xl.getCellValue(SheetName, 0, j);
				String value = xl.getCellValue(SheetName, i, j);
				dMap.put(sKey, value);
			}
			
			x[0] = dMap;
			arr_List.add(x);
		
		}
			
	}
	return 	arr_List.iterator();
		
	}
	
	

}
