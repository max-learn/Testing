package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public LoginPage (WebDriver driver)
    {
        this.driver=driver; //我这个类里面的driver=穿参进来的driver
        if (!driver.getTitle().equals("TestProject Demo"))
        {
            throw new IllegalStateException("This is not login page." +
                    "the current page is" + driver.getCurrentUrl() );
        }
    }

     protected WebDriver driver;
    // this class contains all locators used in this login page
    // 这个类代表了一个页面，这个里面存放的是这个页面上所有的locator
     private By txt_username = By.id("name");
     private  By txt_password = By.id("password");
     private By btn_login =By.id("login");
     By btn_logout =By.id("logout");
     // 对locator的命名一般采用的是：这个object的类型 （比如text box) + 作用 （输入username的）
    //我理解的By 是一种variable type, 类似String，意思是 '组件'

    public void enterUsername(String username)
    {
        driver.findElement(txt_username).sendKeys(username); //给我找id=name的控件然后输入username
    }
    public void enterPassword(String password)
    {
        driver.findElement(txt_password).sendKeys(password);
    }
    public void clickLogin ()
    {
        driver.findElement(btn_login).click();
    }
    public void checkLogout()
    {
        driver.findElement(btn_logout).isDisplayed();
    }

  /*
  也可以把前面的三个独立的动作看成是一个独立的行为，写一个方法来实现"输入用户名'这件事情
  public void loginValidUser (String username, String password)
  {
     driver.findElement(txt_username).sendKeys(username);
     driver.findElement(txt_username).sendKeys(password);
     driver.findElement(btn_login).click();
  }
   */
}
