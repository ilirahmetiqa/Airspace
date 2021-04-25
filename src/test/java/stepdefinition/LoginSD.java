package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.LoginPage;
import framework.webPages.SecuredPage;
import org.testng.Assert;

public class LoginSD {
    LoginPage loginPage = new LoginPage();
    SecuredPage securedPage = new SecuredPage();


    @Given("^I am on Login page$")
    public void iAmOnLoginPage() {
        Assert.assertEquals(loginPage.getLoginPageText(), "Login Page", "YOU ARE NOT IN THE LOGIN PAGE");
    }

     @Then("^I verify that username input has the apporpriate label$")
    public void isRightUsernameLabel(){
         Assert.assertEquals(loginPage.getUsernameLabel(), "Username", "WAS NOT THE CORRECT LABEL FOR THE Username");
    }

    @And("^I verify that pasword input has the apporpriate label$")
    public void iclickOnUsernameLabel(){
        Assert.assertEquals(loginPage.getPasswordLabel(), "Password", "WAS NOT THE CORRECT LABEL FOR THE Password");
    }

    @When("^I click on login button$")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }

    @Then("^I verify that I am not able to login$")
    public void iAmNotAbleToLogin(){
        Assert.assertEquals(loginPage.getInvalidUserText(), "Your username is invalid!\n" +
                "×", "WAS NOT THE CORRECT LABEL FOR THE Username");
    }

    @Then("^I verify that I am not able to login without password$")
    public void iAmNotAbleToLoginWithoutPassord(){
        Assert.assertEquals(loginPage.getInvalidUserText(), "Your password is invalid!\n" +
                "×", "WAS NOT THE CORRECT LABEL FOR THE Password");
    }

    @When("^I enter my username$")
    public void enterUsername(){
        loginPage.enterUsername("tomsmith");
    }

    @And("^I enter my password$")
    public void enterPassword(){
        loginPage.enterPassword("SuperSecretPassword!");
    }

    @And("^I verify that I am able to login$")
    public void iAmAbleToLogin(){
        Assert.assertEquals(securedPage.getsecuredPageText(), "You logged into a secure area!\n" +
                "×", "FAIL TO LOGIN");
    }

    @And("^I verify that the Alert background text is red$")
    public void verifyAlertBackgroundColorIsRed(){
        Assert.assertEquals(loginPage.flashAlertBackgroundColor(), "rgba(198, 15, 19, 1)", "THE ALERT BACKGROUND COLOR WAS NOT RED");
    }

    @And("^I verify that the Alert text is white$")
    public void verifyAlertTextColor(){
        Assert.assertEquals(loginPage.flashAlertTextColor(), "rgba(255, 255, 255, 1)", "THE ALERT TEXT COLOR WAS NOT WHITE");
    }

    @And("^I verify that the Alert background text is green$")
    public void verifyAlertBackgroundColorIsGreen(){
        Assert.assertEquals(securedPage.flashAlertBackgroundColor(), "rgba(93, 164, 35, 1)", "THE ALERT BACKGROUND COLOR WAS NOT GREEN");
    }

    @And("^I verify that the Alert text is white.$")
    public void verifyAlertTextColorIsWhite(){
        Assert.assertEquals(securedPage.flashAlertTextColor(), "rgba(255, 255, 255, 1)", "THE ALERT TEXT COLOR WAS NOT WHITE");
    }


    @Then("^I verify that all texts of login page are correct$")
    public void verifyAllLoginPageTexts(){
        Assert.assertEquals(loginPage.loginPageText(), "Login Page", "THE TEXT IS NOT CORRECT IN LOGIN PAGE");
        Assert.assertEquals(loginPage.loginPageInfoText(), "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.", "THE LONG TEXT IS NOT CORRECT IN LOGIN PAGE");
        Assert.assertEquals(loginPage.getLoginButtonText(), "Login", "THE LOGIN BUTTON TEXT IS NOT CORRECT IN THE LOGIN PAGE");
    }


    @And("^I verify that all texts of secured page are correct$")
    public void verifyAllsecuredPageTexts(){
        Assert.assertEquals(securedPage.securedPageText(), "Secure Area", "THE TEXT IS NOT CORRECT IN secured PAGE");
        Assert.assertEquals(securedPage.securedPageInfoText(), "Welcome to the Secure Area. When you are done click logout below.", "THE LONG TEXT IS NOT CORRECT IN THE SECURED PAGE");
        Assert.assertEquals(securedPage.getLogoutButtonText(), "Logout", "THE LOGOUT BUTTON TEXT IS NOT CORRECT IN THE SECURED PAGE");
    }


    @Given("^I am in the Secure Area$")
    public void iAmOnsecuredPage() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(securedPage.getsecuredPageText(), "You logged into a secure area!\n" +
                "×", "FAIL TO LOGIN");
    }

    @When("^I click on logout button$")
    public void iClickOnLogoutButton() {
        securedPage.clickOnLogoutButton();
    }


    @Then("^I verify that I loged out successfully$")
    public void iVerifyThatILogout() {
        Assert.assertEquals(loginPage.getLoginPageText(), "Login Page", "YOU ARE NOT IN THE LOGIN PAGE");
    }


    @Then("^I am loged out successfully$")
    public void iAmLogoutSuccessfully() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(securedPage.getsecuredPageText(), "You logged into a secure area!\n" +
                "×", "FAIL TO LOGIN");
        securedPage.clickOnLogoutButton();
        Assert.assertEquals(loginPage.getLoginPageText(), "Login Page", "YOU ARE NOT IN THE LOGIN PAGE");
    }


    @When("^I press the 'Back arrow'$")
    public void iPressTheBackArrow() {
        securedPage.clickOnTheBackArrow();
    }

    @Then("^I verify that I am not in the Secure Page$")
    public void iAmNotInTheSecurePage() {
        Assert.assertEquals(loginPage.loginPageInfoText(), "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.", "YOU ARE NOT IN THE 'LOGIN PAGE' OR THE LONG TEXT IS NOT CORRECT IN LOGIN PAGE");
    }


    @When("^I enter the incorrect username$")
    public void enterIncorrectUsername(){
        loginPage.enterIncorrectUsername("John");
    }


    @And("^I enter the incorrect password$")
    public void enterIncorrectPassword(){
        loginPage.enterIncorrectPassword("Doe!");
    }


    @When("^I enter incorrect \"([^\"]*)\"$")
    public void enterCredentials(int credentials){
        loginPage.enterUsernameAndPassword(credentials);
    }


    @When("^I enter \"([^\"]*)\"$")
    public void enterSqlInjection(int sql){
        loginPage.enterSqlInjection(sql);
    }

    @Then("^I verify that my password is masked$")
    public void passowrdIsMasked(){
        loginPage.enterPassword("SuperSecretPassword!");
        Assert.assertTrue(loginPage.thePasswordIsmasked());
    }


    @Then("^the logout alert text is displayed")
    public void logoutTextIsDisplayed() {
        Assert.assertEquals(securedPage.logedoutOfSecurePageConfirmation(), "You logged out of the secure area!\n" +
                "×", "THE TEXT IS NOT CORRECT AFTER LOGOUT FROM SECURE PAGE");
    }

    @And("^the logout alert text background color is green$")
    public void logoutAlertBackgroundColorIsGreen(){
        Assert.assertEquals(securedPage.flashAlertBackgroundColor(), "rgba(93, 164, 35, 1)", "THE ALERT BACKGROUND COLOR WAS NOT GREEN");
    }


    @When("^I enter data with escaped characters in the \"([^\"]*)\" field$")
    public void enterEscapeCharacters(int escape_characters){
        loginPage.enterEscapeCharacters(escape_characters);
    }


    @When("^I enter data with uppercase and space in the \"([^\"]*)\" field$")
    public void enterUppercaseData(int uppercase_data){
        loginPage.enterUppercaseData(uppercase_data);
    }


    @Then("^I verify that I am not able to login.$")
    public void iAmNotAbleToLoginWithThatPass(){
        Assert.assertEquals(loginPage.getInvalidUserText(), "Your password is invalid!\n" +
                "×", "WAS NOT THE CORRECT LABEL FOR THE Password");
    }

}


