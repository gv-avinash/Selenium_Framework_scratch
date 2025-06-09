package Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Utils.ExcelUtils;
import Utils.ExtentReportManager;

public class LoginTest extends BaseTest{
	
	@DataProvider(name="Excel")
	public  Object[][] getData() throws IOException{
		String file = System.getProperty("user.dir")+"/testdata/Book1.xlsx";
		ExcelUtils.LoadExcel(file, "sheet1");
		int rowcount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowcount-1][2];
		
		for(int i=1; i<rowcount;i++) {
			data[i-1][0] = ExcelUtils.getCellData(i, 0);
			data[i-1][1] = ExcelUtils.getCellData(i, 1);
		}
		
		ExcelUtils.closeExcel();
		return data;
		
	}
	
	@Test(dataProvider="Excel")
	public void login(String username, String password) {
		
		//test = ExtentReportManager.createTest("Login test"+username);
		
		//test.info("Adding credentiolas");
		
		LoginPage lt = new LoginPage(driver);
		//lt.setUname("admin@yourstore.com");
		//lt.setPwd("admin");
		lt.setUname(username);
		lt.setPwd(password);
		
		
		test.info("clicking button");
		
		lt.clickbtn();
		System.out.println(driver.getTitle());
	}
	

}
