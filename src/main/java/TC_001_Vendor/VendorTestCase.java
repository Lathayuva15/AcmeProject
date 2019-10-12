
package TC_001_Vendor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PSM.ProjectSpecificMethods;

public class VendorTestCase extends ProjectSpecificMethods{
	
	
	
	@BeforeTest
	public void setData()
	{
		excelfilename="Vendor";
		
	}

@Test(dataProvider="fetchData")
public  void FindVendor(String username, String password,String Vendor) throws InterruptedException
{
	
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	 ChromeDriver driver=new ChromeDriver(); driver.manage().window().maximize();
	 driver.get("https://acme-test.uipath.com/account/login");
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.findElementById("email").sendKeys(username);
	driver.findElementById("password").sendKeys(password);
	driver.findElementById("buttonLogin").click();
	
	Thread.sleep(1000);
	
	WebElement Vendorbtn = driver.findElementByXPath("(//button[@class='btn btn-default btn-lg'])[4]");
	
	Actions actions = new Actions(driver);
	 actions.moveToElement(Vendorbtn).perform();
     driver.findElement(By.linkText("Search for Vendor")).click();
   
 
 Thread.sleep(1000);
 
 driver.findElementById("vendorName").sendKeys(Vendor);
	driver.findElementById("buttonSearch").click();
	
	Thread.sleep(1000);
	
	WebElement Table = driver.findElementByClassName("table");
	List<WebElement> RowCount = Table.findElements(By.tagName("tr"));
	 WebElement Row = RowCount.get(1);
	 List<WebElement> Col=Row.findElements(By.tagName("td"));
	 String CountryName = Col.get(4).getText();
	 System.out.println(CountryName);
	driver.findElementByLinkText("Log Out").click();
	driver.close();
	
	
	
}
}


