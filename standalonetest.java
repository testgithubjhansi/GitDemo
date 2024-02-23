package rahulshettyacademy.pageobjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.paeobjectmodule.Landingpage;


public class standalonetest {

	public static void main(String[] args) throws InterruptedException {
		String productName="ZARA COAT 3";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");

		Landingpage landpage=new Landingpage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("jhansi.423@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jh@nsi.432");
		driver.findElement(By.id("login")).click();
		driver.manage().window().maximize();
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	  Thread.sleep(3000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-animator")));
   driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
   //List<WebElement> cartproducts=driver.findElements(By.xpath("//div[class='cartSection']/h3"));
   //Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
	//Assert.assertTrue(match)
   driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
   driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
 List<WebElement> option=driver.findElements(By.xpath("//div[@class='payment__shipping']//button"));
	}
	

}
