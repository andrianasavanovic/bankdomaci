import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{


    private By customerLoginButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private By managerLoginButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");

    public LoginPage(WebDriver driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
    }


    public boolean isCustomerBtnEnabled() {
        return getDriver().findElement(customerLoginButton).isEnabled();
    }

    public void clickCustomerLoginBtn(){
        if(isCustomerBtnEnabled()) {
            getDriver().findElement(customerLoginButton).click();
        }
    }



    public boolean isManagerBtnEnabled() {
        return getDriver().findElement(managerLoginButton).isEnabled();
    }

    public void clickManagerLoginBtn(){
        if(isManagerBtnEnabled()) {
            getDriver().findElement(managerLoginButton).click();
        }
    }




}
