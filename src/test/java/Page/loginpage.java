package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;


public class loginpage extends BaseClass  {
//	public static WebDriver driver; 


//	public void i_open_the_chrome_browser() throws InterruptedException {
//		
//		setUp();
		
//		WebDriverManager.edgedriver().setup();
//
//		EdgeOptions options = new EdgeOptions();
//		options.addArguments("--remote-allow-origins=*");
//
//		driver = new EdgeDriver(options);
//		//	driver.get("http://adbc4806fc81c4f3a980a0aedb189b77-2042542790.us-east-1.elb.amazonaws.com/#/");
//		driver.get("https://www.saucedemo.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		Thread.sleep(600);

//}




	public void enter_username() throws InterruptedException {

		//driver.findElement(By.xpath("/html/body/app-root/body/app-sign-in/div/form/div/div/div[2]/div/div[1]/div/input")).sendKeys("alok@gmail.com");
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username"));

	}

	public void Enter_Password()throws InterruptedException {
		//	driver.findElement(By.xpath("/html/body/app-root/body/app-sign-in/div/form/div/div/div[2]/div/div[2]/div/input")).sendKeys("aaaaaa");

		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
	}

	public void click_on_login_button()throws InterruptedException {
		//driver.findElement(By.xpath("/html/body/app-root/body/app-sign-in/div/form/div/div/div[2]/div/div[4]/button")).click();

		driver.findElement(By.id("login-button")).click();
		//driver.close();
	}

	////	public void click_on_Remove_button() throws InterruptedException {
	////		Thread.sleep(900);
	////		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
	////	}

	public void Homepage_should_display() {  

		String expectedResult= "Products"; 

		String ActualResult = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

		assertEquals("Products", expectedResult,ActualResult );
		//  assertEquals(expectedResult, ActualResult, "Home");


	}

	public void click_on_add_to_cart_button() throws InterruptedException {

		//		  String expectedResult= "Products"; 
		//		  String ActualResult = driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).getText();
		//		  assertEquals("Products", expectedResult,ActualResult );
		//		  
		Thread.sleep(10000);
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(900);
		//	driver.close();
	}

	public void Scroll_Down() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor jse =  (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 5000)");
	}

	public void Scroll_Up() throws InterruptedException {

		Thread.sleep(3000);
		JavascriptExecutor jse2 =  (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollBy(0, -5000)");
	}

	public void click_on_add_to_cart_button_then_1_count_will_be_visible() throws InterruptedException {

		Thread.sleep(10000);

		//		 String expectedResult= "Products"; 
		//		  String ActualResult = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		//		  assertEquals("Products", expectedResult,ActualResult );

		WebElement cartcount = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));


		String cartcounttext = cartcount.getText(); //Get data from above x path  

		if (cartcounttext.equals(1)) {

			System.out.println("1 count is showing");
		}
		else {

			System.out.println ("1 count is not showing");
		}
		//		 Thread.sleep(900);
		//		  driver.close();
	}

	public void click_on_cart_button() {
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).click();

	}


	public void click_on_Checkout_button() throws InterruptedException {
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(900);
		//driver.close();
	}

	public void Enter_First_Name() {
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("Ajit");
	}

	public void Enter_Last_Name() {
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("kumar");
	}

	public void Enter_Postal_Code(){
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input")).sendKeys("110041");
	}

	public void Click_on_Continue_Button() {
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input")).click();
	}

	public void Click_on_Finish_Button() throws InterruptedException {

		driver.findElement(By.id("finishwrong code")).click();
		Thread.sleep(3000);

	}


}