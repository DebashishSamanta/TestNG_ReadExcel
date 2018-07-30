package readexcelsheet;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import excelread.ReadExcel;


public class ExcelUtils {
	
	
	ReadExcel Read = new ReadExcel();
	

    @Test(dataProvider = "GetData")
    public void testMethod(String TCName, String UserName,String Password ) {
        System.err.println("Test case Name :" + TCName + " User Name " + UserName + " Password "+ Password);
    }

    @DataProvider(name = "GetData")
    // Pass the Excel path in the below mentioned Method...
    public Object[][] Authentication() throws Exception{
        Object[][] testObjArray = Read.readnumericvalue("/Users/Apple/Documents/TestData.xlsx");	
       return (testObjArray);
		}
    
    
}
