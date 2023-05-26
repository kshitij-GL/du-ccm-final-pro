package com.testng.selenium.v2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class LoginLogoutTest {
    private static final String timeout = null;
	WebDriver driver;
    String baseUrl = "http://localhost/studreg/login.php";
    String username = "kshitij";
    String password = "12345678";

    @BeforeTest
    @Parameters({ "browser" })
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/driver/chromedriver.exe");
       // driver = new ChromeDriver();
        ChromeOptions handlingSSL = new ChromeOptions();
		 
		 handlingSSL.addArguments("--no-sandbox");
	    handlingSSL.addArguments("--remote-allow-origins=*");
		 
		 handlingSSL.setAcceptInsecureCerts(true);
				
		driver = new ChromeDriver(handlingSSL);
      //  ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--remote-allow-origins=*");
      //  driver = new ChromeDriver(options);
       driver.manage().window().maximize();
      driver.get(baseUrl);
    }

    @Test(priority = 1)
    @Parameters({"username","password"})
    public void loginTest() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(5000);

       driver.findElement(By.xpath("/html/body/div/div/div[1]/form/button")).click();
      
    }

  
         @Test(priority=2)
 @Parameters({"card_no","user_phone","user_first_name","user_last_name","user_email","user_dob"})
 
 public void userregister() throws InterruptedException {
    	
  driver.get("http://localhost/studreg/index.php");
	   
   driver.findElement(By.xpath("/html/body/div[1]/button")).click();

  Thread.sleep(5000);
   driver.findElement(By.name("card_no")).sendKeys("123456789123");
   driver.findElement(By.name("user_phone")).sendKeys("6306665668");
   driver.findElement(By.name("user_first_name")).sendKeys("Kshitij");  
     driver.findElement(By.name("user_last_name")).sendKeys("Kshitij");
     driver.findElement(By.name("user_email")).sendKeys("imkshitij9.58@gmail.com");
     driver.findElement(By.name("user_dob")).sendKeys("09/02/2001");
       
    Thread.sleep(5000);
       
     driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/input")).click();


   }
   


   @Test(priority=3)
  @Parameters({"card_no","user_phone","user_first_name","user_last_name","user_email","user_dob"})

   public void testUserDetailsModification() throws InterruptedException {
      
   driver.get("http://localhost/studreg/index.php");
  driver.findElement(By.xpath("/html/body/div[1]/div/table/tbody/tr[4]/td[7]/span/a")).click();
  Thread.sleep(5000);

  WebElement card_no = driver.findElement(By.xpath("/html/body/div[68]/div/div/div[2]/form/div[1]/div[1]/input"));
  card_no.clear();
  card_no.sendKeys("000000000000");
  
  WebElement user_last_name = driver.findElement(By.xpath("/html/body/div[68]/div/div/div[2]/form/div[2]/div[2]/input"));
  user_last_name.clear();
  user_last_name.sendKeys("Horizon");
  
  Actions action = new Actions(driver);
  action.sendKeys(Keys.PAGE_DOWN).build().perform();
  
  

    //driver.findElement(By.name("user_phone")).sendKeys("6306665668");
    // driver.findElement(By.name("user_first_name")).sendKeys("Kshitij");  
      //driver.findElement(By.name("user_last_name")).sendKeys("Horizon");
      //driver.findElement(By.name("user_email")).sendKeys("imkshitij9.58@gmail.com");
      //driver.findElement(By.name("user_dob")).sendKeys("09/02/2001");
      Thread.sleep(5000);
      
    driver.findElement(By.xpath("/html/body/div[68]/div/div/div[2]/form/div[12]/input")).click();

   }
   
 @Test(priority = 4)
  public void logoutTest() throws InterruptedException {
      Thread.sleep(5000);
       


      driver.findElement(By.xpath("/html/body/div[1]/a[2]")).click();
      Thread.sleep(5000);

      
  }
      
     // WebElement submitButton = driver.findElement(By.name("submit"));
      // submitButton.click();
      // driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/div/div[1]/section/main/div/div/div[1]/div[2]/form/div[7]/div")).click();
     //  try {
     //      Thread.sleep(1000);
     //  } catch (InterruptedException e) {
          // e.printStackTrace();
    //   }

      // WebElement emailOrPhoneOutput = driver.findElement(By.name("emailOrPhone"));
      // Assert.assertEquals(emailOrPhoneOutput.getText(), "imkshitij9.58@gmail.com");

      // WebElement usernameOutput = driver.findElement(By.name("username"));
      // Assert.assertEquals(usernameOutput.getText(), "kshitij958");
       
     //  WebElement passwordOutput = driver.findElement(By.name("password"));
     //  Assert.assertEquals(passwordOutput.getText(), "abcde");
   

@AfterTest
public void terminatetest() {
  driver.close();
}
}


   
    
