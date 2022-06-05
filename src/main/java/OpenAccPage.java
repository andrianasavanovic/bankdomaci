import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OpenAccPage extends BasePage{

    private By customer = By.xpath("//*[@id=\"userSelect\"]");
    private By currency = By.xpath("//*[@id=\"currency\"]");
    private By process = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    public OpenAccPage(WebDriver driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
    }
// //*[@name='programs'][@value='"+ None +"']
    // //*[@name='userSelect'][@value='"+ 6 +"']
    public void selectCustomer(){
        Select user = new Select(getDriver().findElement(By.xpath("//*[@id=\"userSelect\"]")));
        user.selectByIndex(user.getOptions().size()-1);
        //uzima poslednji element, a novi korisnik je uvek poslednji u listi
        ////*[@id="userSelect"]
    }

    public void selectCurrency(){
        Select currency = new Select(getDriver().findElement(By.xpath("//*[@id=\"currency\"]")));
        currency.selectByVisibleText("Dollar");
    }
    public void clickProcessBtn(){
        getDriver().findElement(process).click();
    }
}
