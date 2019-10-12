package PSM;

import java.io.IOException;


import org.testng.annotations.DataProvider;


import Utils.DataLibrary1;

public class ProjectSpecificMethods  {
	public String excelfilename;
	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary1.readExcelData(excelfilename);
	}	
  
  


  }
  
  
  
  
  
  
  
  
  
  
  
  


