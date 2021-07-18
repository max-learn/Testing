package Step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;


public class SecondStep {
    WebDriver driver = new ChromeDriver();
    @Given("I login to Runoob page")
    public void i_login_to_runoob_page() {
        driver.get("https://www.runoob.com/csharp/csharp-tutorial.html");
    }
    @Then("I get the txt message")
    public void i_get_the_txt_message() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tutheader")));
        System.out.println(element.getText());
        Objects.equals("谁适合阅读本教程？",element.getText());
        driver.quit();

    }
}
