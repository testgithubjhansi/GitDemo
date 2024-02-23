package rahulshettyacademy.pageobjects;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.paeobjectmodule.CartCheckPage;
import rahulshettyacademy.paeobjectmodule.Landingpage;
import rahulshettyacademy.paeobjectmodule.PayMethodPage;
import rahulshettyacademy.paeobjectmodule.productCatolo;
import rahulshettyscademy.testcomp.BaseTest;

public class submitorder extends BaseTest{

	@Test
	public void submitordertest() throws IOException, InterruptedException
	{
		String productName="ZARA COAT 3";
        landpage.loginapp("jhansi.423@gmail.com", "Jh@nsi.432");
		productCatolo prodpage=new productCatolo(driver);
		prodpage. prodAddCart(productName);
		prodpage.AddCart();
	
		CartCheckPage checkpage=new CartCheckPage(driver);
		
		checkpage.myCartpage();
		PayMethodPage paymethod=new PayMethodPage(driver);
		paymethod.paymentMethod("in");
		paymethod.selectDropdn("Argentina");
		getScreenshot();
		paymethod.placebutton();
		
		
				
	}

}
