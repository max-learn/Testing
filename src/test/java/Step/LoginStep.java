package Step;

import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class LoginStep {
     WebDriver driver =null;
     LoginPage login; //<--- 调用了LoginPage的类
    @Given("browser is open")
    public void browser_is_open() {
        driver = new ChromeDriver(); //需要装chromeDriver,添加selenium java依赖包后才可以用
    }
    @And("user is on login page")
    public void user_is_on_login_page()
    {
        driver.get("https://example.testproject.io/web/");
        // driver.navigate().to("https://example.testproject.io/web/");
        //navigate 方法比较长，和get 方法是一个作用
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //提供时间让这个page loading完成
    }
    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password)
    {
        login= new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();
        //------- 以下是没有用POM的写法--------（这么多的steps文件，会造成code duplication)
        //WebElement FullName = driver.findElement(By.id("name")); <---WebElement 是variable type
        //FullName.sendKeys(username);
       // driver.findElement(By.id("password")).sendKeys(password); //也可以不保存在变量中
        //driver.findElement(By.id("login")).click() ;
    }
    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page()
    {
      login.checkLogout();
      driver.close();
      driver.quit();
    }


}
