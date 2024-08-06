package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.LoginPage;
import utils.DataUtility;
import utils.ElementUtil;
import utils.EqBrikOTP;

import javax.mail.Folder;
import java.time.Duration;

public class LoginInvestorSteps {


    private LoginPage loginPage;
    private Hooks hooks;
    private ElementUtil eleUtil;
    private DataUtility dataUtil;
    private EqBrikOTP eqBrikOTP;
    protected String OTP;

    public LoginInvestorSteps(Hooks hooks) {
        this.loginPage=hooks.getLoginPage();
        this.eleUtil= hooks.getElementUtil();
        this.eqBrikOTP= hooks.getEbOTP();
        this.dataUtil= hooks.getDataUtil();
    }

    @Given("user is on Investor Login page")
    public void user_is_on_investor_login_page() {
    loginPage.waitForPageToLoad();
    }
    @Given("wait for page to load")
    public void wait_for_page_to_load() {


    }
    @When("enter username {string} and password {string}")
    public void enter_username_and_password(String userName, String passWord) {
    loginPage.enterCredentials(userName, passWord);

    }
    @When("click on Sign in button")
    public void click_on_sign_in_button() {
        loginPage.clickSignInButton();
    }


    @Then("page title should be {string}")
    public void pageTitleShouldBe(String arg0) {
        String ActualTitle= loginPage.getPageTitle();
        Assert.assertEquals("Sign in", ActualTitle);
    }

    @When("user clicks on Sign in link")
    public void userClicksOnSignInLink() {
        loginPage.clickSignIn();
    }
    @And("enters email clicks send verification button")
    public void entersEmailClicksSendVerificationButton() throws InterruptedException {
        String email= dataUtil.randomEmailGenerator();
        OTP= loginPage.getVerificationCode(email);

    }


    /*@And("enters {string} clicks send verification button")
    public void entersEmailClicksSendVerificationButton(String ff) throws InterruptedException {

        String email= dataUtil.randomEmailGenerator();
       OTP= loginPage.getVerificationCode(email);

    }*/

    @And("waits for some time")
    public void waitsForSomeTime() throws InterruptedException {
       // Wait<LoginPage> newWait= new FluentWait<LoginPage>(loginPage).withTimeout(Duration.ofMinutes(2));
        loginPage.waitsForSomeTime();
    }



    @When("opt is received and enters otp")
    public void optIsReceivedAndEntersOtp() {
        System.out.println("What is sent ---"+OTP);
        loginPage.enterOTPAndCredentials(OTP);
    }

    @And("clicks verify button")
    public void clicksVerifyButton() {
    }




}
