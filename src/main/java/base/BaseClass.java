package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    protected static WebDriver driver;
    protected static Properties prop;

  static {
	  try {
		  FileInputStream file= new FileInputStream("TestData/Config.properties");
		  prop = new Properties();
		  prop.load(file);
	  } catch (FileNotFoundException e) {
		  e.printStackTrace();
		  
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

    public void mouseHover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void handleExceptionAndReloadPage(By errorElementLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(errorElementLocator));
        } catch (Exception e) {
            if (isErrorMessageDisplayed()) {
                reloadPage();
            }
        }
    }

    public static void reloadPage() {
        driver.navigate().refresh();
    }

    public static boolean isErrorMessageDisplayed() {
        // This method should be implemented to actually check for error messages
        return false;
    }

    public void selectByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void javaExecutorClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
    }

    public void explicitWait(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAlertAndAccept(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void waitForElementClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void getScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\AjitKumar(QA)\\eclipse-workspace\\Ajit\\target" + System.currentTimeMillis() + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}