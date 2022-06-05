import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepositOrWithdrawal extends BasePage{

    private By deposit = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By withdrawal = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By amount = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By button = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By logoutBtn = By.xpath("/html/body/div/div/div[1]/button[2]");



    public DepositOrWithdrawal(WebDriver driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
    }

    public void clickDeposit(){
        getDriver().findElement(deposit).click();
    }
    public void clickWithdrawal(){
        getDriver().findElement(withdrawal).click();
    }
    public void typeAmount(String amount){
        getDriver().findElement(this.amount).sendKeys(amount);
    }
    public void typeAmountForWithdrawal(String amount){
        getDriver().findElement(this.amount).sendKeys(amount);
    }
    public void clickButton(){
        getDriver().findElement(button).click();
    }
    public void clickLogoutBtn(){getDriver().findElement(logoutBtn).click();}
}
