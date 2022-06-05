import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerHomePage extends BasePage{

    private By addCustomerButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By openAccountButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By customerButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");
    private By managerLogout = By.xpath("/html/body/div/div/div[1]/button[2]");

    public ManagerHomePage(WebDriver driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
    }
    public void addCustomerBtn(){
        getDriver().findElement(addCustomerButton).click();
    }
    public void openAccBtn(){
        getDriver().findElement(openAccountButton).click();

    }
    public void customerBtn(){
        getDriver().findElement(customerButton).click();
    }
    public void clickManagerLogout(){
        WebElement el = getDriver().findElement(managerLogout);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", el);
        js.executeScript("arguments[0].click();", el);
    }
}
