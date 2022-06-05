import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait waitDriver;
    private By homeButton = By.xpath("/html/body/div/div/div[1]/button[1]");

    public BasePage() {
    }

    public BasePage(WebDriver driver, WebDriverWait waitDriver) {
        this.driver = driver;
        this.waitDriver = waitDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWaitDriver() {
        return waitDriver;
    }

    public void setWaitDriver(WebDriverWait waitDriver) {
        this.waitDriver = waitDriver;
    }

    public void homeBtn(){
        getDriver().findElement(homeButton).click();
    }



}
