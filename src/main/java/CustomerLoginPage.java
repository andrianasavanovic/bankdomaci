import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class CustomerLoginPage extends BasePage{
    private By yourName = By.xpath("//*[@id=\"userSelect\"]");
    private By loginBtn = By.xpath("/html/body/div/div/div[2]/div/form/button");

    public CustomerLoginPage(WebDriver driver, WebDriverWait waitDriver) {
        super(driver, waitDriver);
    }
    /*
    public void selectCustomer(){
        //Select user = new Select(getDriver().findElement(By.className("form-control ng-pristine ng-untouched ng-valid")));
        //user.selectByIndex(user.getOptions().size()-1);
        try{
            // Waits for 20 seconds
            WebDriverWait wait = getWaitDriver();

            // Wait until expected condition size of the dropdown increases and becomes more than 1
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
                public Boolean apply(WebDriver driver)
                {
                    Select select = new Select(driver.findElement(By.id("userSelect")));
                    return select.getOptions().size()>1;
                }
            });

            //To select the first option
            Select select = new Select(getDriver().findElement(By.id("userSelect")));
            select.selectByVisibleText("Harry Potter");
        }catch(Throwable e){
            System.out.println("Error found: "+e.getMessage());
        }
    }/
     */
    public void selectCustomer(){
        System.out.println("???");
        getDriver().findElement(yourName).click();

        Select user = new Select(getDriver().findElement(By.xpath("//*[@id=\"userSelect\"]")));
        user.selectByIndex(user.getOptions().size()-1);

    }
    public void clickSelectedCustomerLoginBtn(){
        getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
    }

   /*
    public void selectCustomer(){
        //Select customer = new Select(getDriver().findElement(By.xpath("//*[@id=\"userSelect\"]")));
        //customer.getAllSelectedOptions().size();
        List<WebElement> allOptions = getDriver().findElements(By.xpath("//*[@id=\"userSelect\"]"));
        System.out.println(allOptions.size());
        for(int i = 0; i<=allOptions.size()-1; i++) {
            if(allOptions.get(i).getText().contains("Marko")) {
                allOptions.get(i).click();
                break;
            }
        }
    }/
    */
}
