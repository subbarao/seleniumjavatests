package seleniumtests;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstWebDriver {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  public static void main(String args[]) {
	  FirefoxDriver driver = new FirefoxDriver();
	  driver.get("http://caregeneral.net/login");
	  driver.findElement(By.id("user_email")).sendKeys("prabhakar+superadmin@bigbinary.com");
	  driver.findElement(By.id("user_password")).sendKeys("welcome");
	  driver.findElement(By.cssSelector("button.common-btn")).click();
	  driver.quit();
  }
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://caregeneral.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSuccessLogin() throws Exception {
    driver.get(baseUrl + "/login");
    try {
      assertTrue(isElementPresent(By.cssSelector("a.logo.navbar-brand")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Account login", driver.findElement(By.cssSelector("h1.page-title")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("", driver.findElement(By.id("user_email")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.id("user_password")).getText());
    try {
      assertEquals("Forgot Password", driver.findElement(By.linkText("Forgot Password")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(driver.findElement(By.linkText("Didn't receive unlock instructions?")).getText().matches("^exact:Didn't receive unlock instructions[\\s\\S]$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Contact Us", driver.findElement(By.linkText("Contact Us")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Login", driver.findElement(By.cssSelector("button.common-btn")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("", driver.findElement(By.id("badge-app-store")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Text me the link", driver.findElement(By.linkText("Text me the link")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Privacy Policy", driver.findElement(By.linkText("Privacy Policy")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Terms of Service", driver.findElement(By.linkText("Terms of Service")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("prabhakar+superadmin@bigbinary.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("welcome");
    driver.findElement(By.cssSelector("button.common-btn")).click();
    try {
      assertEquals("prabhakar+superadmin", driver.findElement(By.cssSelector("span.user_name")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("My Info", driver.findElement(By.linkText("My Info")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Translations", driver.findElement(By.cssSelector("a[title=\"Translations\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Super Admin", driver.findElement(By.linkText("Super Admin")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Admin", driver.findElement(By.linkText("Admin")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Help", driver.findElement(By.linkText("Help")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Getting Started", driver.findElement(By.linkText("Getting Started")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Get Mobile App", driver.findElement(By.linkText("Get Mobile App")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Contact Us", driver.findElement(By.linkText("Contact Us")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Feedback and Suggestions", driver.findElement(By.linkText("Feedback and Suggestions")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Change Language", driver.findElement(By.linkText("Change Language")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Log Out", driver.findElement(By.linkText("Log Out")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
