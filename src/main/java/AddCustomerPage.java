import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage extends BasePage{

    private By firstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By addCustomer = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    public AddCustomerPage(WebDriver driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
    }

    public void enterFirstName(String firstName){
        getDriver().findElement(this.firstName).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        getDriver().findElement(this.lastName).sendKeys(lastName);
    }
    public void enterPostCode(String postCode){
        getDriver().findElement(this.postCode).sendKeys(postCode);
    }
    public void clickAddCustomer(){
        getDriver().findElement(addCustomer).click();
    }
}
