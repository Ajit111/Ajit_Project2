package StepDefinition;

import org.openqa.selenium.WebDriver;

import Page.loginpage;
import base.BaseClass;
import base.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class login extends BaseClass {
	
	
 loginpage L =new loginpage();
 
// public static WebDriver driver; 
	
//	@Given("I Open the Chrome Browser")
//	public void i_open_the_chrome_browser() throws InterruptedException {
//    L.i_open_the_chrome_browser();
//	}
//	

	@Given ("Enter Username")
	public void enter_username() throws InterruptedException {
    L.enter_username();
	}
	
	@Then ("Enter Password")
    public void enter_password() throws InterruptedException {
	L.Enter_Password();
	}
	@Then("click on login button")
	public void click_on_login_button() throws InterruptedException {
	L.click_on_login_button();
	   
	}
//	
//	@Then ("click on add to cart button") 
//	public void click_on_add_to_cart_button() throws InterruptedException {
//	L.click_on_add_to_cart_button();
//	}
//	
////	@Then ("click on Remove button") 
////	public void click_on_Remove_button() throws InterruptedException {
////		Thread.sleep(900);
////	L.click_on_Remove_button();
////	}
//	
//	
//	
//	
//	
	
	@Then ("Homepage should display") 
	
	public void Homepage_should_display() {  
     L.Homepage_should_display();
	 }
	
	@Then ("Scroll Down")
	public void Scroll_Down() throws InterruptedException {
		L.Scroll_Down();
	}
	
	@Then ("Scroll Up")
	public void Scroll_Up() throws InterruptedException {
	L.Scroll_Up();	
		
	}
	
	@Then ("click on add to cart button") 
	public void click_on_add_to_cart_button() throws InterruptedException {
		Thread.sleep(1000);
	L.click_on_add_to_cart_button();
	}
	
	@Then ("click on add to cart button then 1 count will be visible") 
		
	public void click_on_add_to_cart_button_then_1_count_will_be_visible() throws InterruptedException {
	
	L.click_on_add_to_cart_button_then_1_count_will_be_visible();
		
	}

	@Then ("click on Checkout button")
	public void click_on_Checkout_button() throws InterruptedException {
		Thread.sleep(900);
		L.click_on_Checkout_button();
	}
	
	@Then ("click on cart button")
	public void click_on_cart_button() throws InterruptedException {
		Thread.sleep(900);
		L.click_on_cart_button();
	}
	
	@Then ("Enter First Name")
	public void Enter_First_Name() {
		
		L.Enter_First_Name();
	}
	
	@Then ("Enter Last Name")
	public void Enter_Last_Name() {
		
	    L.Enter_Last_Name();	
	}

	@Then ("Enter Zip/Postal Code")
	public void Enter_Postal_Code() {
		L.Enter_Postal_Code();
		
	}
	@Then ("Click on Continue Button")
	public void Click_on_Continue_Button() {
		L.Click_on_Continue_Button();
	}
	@Then ("Click on Finish Button")
	public void Click_on_Finish_Button() throws InterruptedException {
		L.Click_on_Finish_Button();
		
	}
	
}