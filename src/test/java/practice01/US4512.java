package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class US4512 {
    /*
    Test Case 1: The User Should Register without any Problem
***************************************************


****************************************************

****************************************************

*****************************************************

*****************************************************
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
*****************************************************
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
******************************************************
     */

    static WebDriver driver;


    @BeforeClass
    public static void setUp() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
    }

    @AfterClass
    public static void tearDown() {
        //  driver.close(); // closes current window
        //  driver.quit(); //  it stops and closed driver and all window
    }

    @Test
    public void homePageIsVissible() {
        // 3. Verify that home page is visible successfully
        WebElement headerTextHomePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(headerTextHomePage.isDisplayed());
    }

    @Test
    public void signUpPageIsVissible() {
        //  4. Click on 'Signup / Login' button
        WebElement signUpLogInButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signUpLogInButton.click();
        //  5. Verify 'New User Signup!' is visible
        WebElement singUpNewUserText = driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
        Assert.assertTrue(singUpNewUserText.isDisplayed());
    }

    @Test
    public void enterAccountPageIsVissible(){
        WebElement signUpLogInButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signUpLogInButton.click();
     //   6. Enter name and email address for signup text box
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@type='text']"));
        nameTextBox.sendKeys("MehmetAli");
        WebElement emailTextBox = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        emailTextBox.sendKeys("mehmet@gmail.com");
     //   7. Click 'Signup' button
        WebElement signUpButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        signUpButton.click();
     //   8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformationText = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(enterAccountInformationText.isDisplayed());
    }
    @Test
    public void accountCreated(){
        WebElement signUpLogInButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signUpLogInButton.click();
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@type='text']"));
        nameTextBox.sendKeys("MehmetAli");
        WebElement emailTextBoxSignUpPage = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        emailTextBoxSignUpPage.sendKeys("mehmet@gmail.com");
        WebElement signUpButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        signUpButton.click();

      // 9. Fill details: Title, First and Last Name, Password, Date of birth
        //Title
        WebElement titleRadioButtonMr = driver.findElement(By.xpath("//input[@id='id_gender1']")) ;
        titleRadioButtonMr.click();
        //Password
        WebElement PasswordTextBox = driver.findElement(By.xpath("//input[@type='password']")) ;
        PasswordTextBox.sendKeys("ervanaz");
        //Date of Birth
        // Day. Month,Year is in the dropdown list so we should create Celection Obcject
        Select selectDaysDropDownList = new Select(driver.findElement(By.xpath("//select[@id='days']"))) ;
        selectDaysDropDownList.selectByIndex(20);
        Select selectMonthsDropDownList = new Select(driver.findElement(By.xpath("//select[@id='months']"))) ;
        selectMonthsDropDownList.selectByIndex(2);
        Select selectYearsDropDownList = new Select(driver.findElement(By.xpath("//select[@id='years']"))) ;
        selectYearsDropDownList.selectByVisibleText("1984");
        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement signUpForOurNewsLetterTextCheckBoxButton = driver.findElement(By.xpath("//input[@name='newsletter']")) ;
        signUpForOurNewsLetterTextCheckBoxButton.click();
        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement specialOffersTextCheckBoxButton = driver.findElement(By.xpath("//input[@name='optin']")) ;
        specialOffersTextCheckBoxButton.click();

        // 12. Fill details: First name, Last name, Address, Country, State, City, Zipcode, Mobile Number
        //First Name
        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@id='first_name']")) ;
        firstNameTextBox.sendKeys("Mehmet Ali");
        //Last Name
        WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@id='last_name']")) ;
        lastNameTextBox.sendKeys("Sezgin");
        //Address
        WebElement addressTextBox = driver.findElement(By.xpath("//input[@id='address1']")) ;
        addressTextBox.sendKeys("Ljubljana");
        //Country
        Select selectCountryDropDownList = new Select(driver.findElement(By.xpath("//select[@id='country']"))) ;
        selectCountryDropDownList.selectByIndex(2);
        //State
        WebElement StateTextBox = driver.findElement(By.xpath("//input[@id='state']")) ;
        StateTextBox.sendKeys("Ljubljana");
       //City
        WebElement CityTextBox = driver.findElement(By.xpath("//input[@id='city']")) ;
        CityTextBox.sendKeys("Ljubljana");
        //Zipcode
        WebElement ZipcodeTextBox = driver.findElement(By.xpath("//input[@id='zipcode']")) ;
        ZipcodeTextBox.sendKeys("1000");
        //MobileNumber
        WebElement MobileNumberTextBox = driver.findElement(By.xpath("//input[@id='mobile_number']")) ;
        MobileNumberTextBox.sendKeys("3865452145");
      // 13. Click 'Create Account button'
        WebElement createAccountButton = driver.findElement(By.xpath("//button[normalize-space()='Create Account']")) ;
        createAccountButton.click();
      // 14. Verify that 'ACCOUNT CREATED!' is visible

    }

}
