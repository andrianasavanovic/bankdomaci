/*
Domaći:
Otići na https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login.
Test 1: Logovanje kao Bank Manager
Test 2: Kreiranje Customera
Test 3: Kreiranje Accounta za tog Customera
Test 4: Logovanje kao Customer
Test 5: Uspešan Deposit za nekog Customera
Test 6: Uspešan Withdrawal za nekog Customera
Test 7: Logout za Bank Managera
Test 8: Logout za Customera
Prolaz (ocena 3) - Testovi 1, 2, 4, 5.
Obavezno koristiti POM.
May the odds be ever in your favor./
 */

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
/*
Domaći:
Otići na https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login.
Test 1: Logovanje kao Bank Manager
Test 2: Kreiranje Customera
Test 3: Kreiranje Accounta za tog Customera
Test 4: Logovanje kao Customer
Test 5: Uspešan Deposit za nekog Customera
Test 6: Uspešan Withdrawal za nekog Customera
Test 7: Logout za Bank Managera
Test 8: Logout za Customera
Prolaz (ocena 3) - Testovi 1, 2, 4, 5.
Obavezno koristiti POM.
May the odds be ever in your favor./
 */

public class BankTest {
    private WebDriver driver;
    private WebDriverWait waitDriver;
    private LoginPage loginPage;
    private ManagerHomePage managerHomePage;
    private AddCustomerPage addCustomerPage;
    private OpenAccPage openAccPage;
    private CustomerLoginPage customerLoginPage;
    private DepositOrWithdrawal depositOrWithdrawal;


    @BeforeClass
    public void befforeClass(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver, waitDriver);
        managerHomePage = new ManagerHomePage(driver, waitDriver);
        addCustomerPage = new AddCustomerPage(driver, waitDriver);
        openAccPage = new OpenAccPage(driver, waitDriver);
        customerLoginPage = new CustomerLoginPage(driver, waitDriver);
        depositOrWithdrawal = new DepositOrWithdrawal(driver, waitDriver);


        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(15));


        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
    @Test(priority = 1)
    public void testManagerLogin() throws InterruptedException {

        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")));
        Assert.assertTrue(loginPage.isManagerBtnEnabled());
        loginPage.clickManagerLoginBtn();
        waitDriver.until(ExpectedConditions.urlContains("manager"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }
    @Test(priority = 2)
    public void createCustomer(){
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")));
        managerHomePage.addCustomerBtn();
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form")));
        addCustomerPage.enterFirstName("Marko");
        addCustomerPage.enterLastName("Markovic");
        addCustomerPage.enterPostCode("21000");
        addCustomerPage.clickAddCustomer();
        try {
            addCustomerPage.clickAddCustomer();
            }catch (UnhandledAlertException ex){
            try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert data: " + alertText);
            alert.accept();
            } catch (NoAlertPresentException e) {
            e.printStackTrace();
            }
            }
        Assert.assertTrue(driver.switchTo().activeElement().getTagName().equalsIgnoreCase("button"));
    }
    @Test(priority = 3)
    public void createAccount(){
        managerHomePage.openAccBtn();
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userSelect\"]")));
        openAccPage.selectCustomer();
        openAccPage.selectCurrency();
        openAccPage.clickProcessBtn();
        try {
            openAccPage.clickProcessBtn();
        }catch (UnhandledAlertException ex){
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        Assert.assertTrue(driver.switchTo().activeElement().getTagName().equalsIgnoreCase("button"));
    }
    @Test(priority = 4)
    public void testCustomerLogin() throws InterruptedException {
        openAccPage.homeBtn();
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")));
        loginPage.clickCustomerLoginBtn();
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userSelect\"]")));
        customerLoginPage.selectCustomer();
        customerLoginPage.clickSelectedCustomerLoginBtn();
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[3]")));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account");
    }

    @Test(priority = 5)
    public void testDeposit(){
        waitDriver.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")));
        depositOrWithdrawal.clickDeposit();
        waitDriver.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")));
        depositOrWithdrawal.typeAmount("5000");
        depositOrWithdrawal.clickButton();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")).isDisplayed());
    }
    @Test(priority = 6)
    public void testWithdrawal() {
        driver.navigate().refresh();
        depositOrWithdrawal.clickWithdrawal();
        waitDriver.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form")));
        depositOrWithdrawal.typeAmountForWithdrawal("");
        depositOrWithdrawal.typeAmountForWithdrawal("3000");
        depositOrWithdrawal.clickButton();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")).getText(), "Transaction successful");

    }
    @Test(priority = 7)
    public void logoutCustomer(){
        depositOrWithdrawal.clickLogoutBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");

    }

    @Test(priority = 8)
    public void logoutManager(){
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userSelect\"]")));

        customerLoginPage.homeBtn();
        loginPage.clickManagerLoginBtn();
        waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")));
        managerHomePage.clickManagerLogout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");





    }



}
