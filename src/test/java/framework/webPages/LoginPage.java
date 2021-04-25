package framework.webPages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By loginPageText = By.xpath("//*[text()='Login Page']");
    private By usernameLabel = By.xpath("//input[@id='username']/preceding-sibling::label");
    private By passwordLabel = By.xpath("//input[@id='password']/preceding-sibling::label");
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.xpath("//*[text()=' Login']");
    private By invalidUserText = By.id("flash");
    private By dataAlertNotification = By.xpath("//div[@class='flash error']");
    private By LoginPageText = By.xpath("//h2[text()='Login Page']");
    private By informativeText = By.className("subheader");

    public String getLoginPageText(){
       return getText(loginPageText);
    }

    public String getUsernameLabel(){
       return getText(usernameLabel);
    }

    public String getPasswordLabel(){
        return getText(passwordLabel);
    }

    public void enterUsername(String text) {
        sendText(username, text);
    }

    public void enterPassword(String text) {
        sendText(password, text);
    }

    public void clickOnLoginButton() {
        clickOn(loginButton);
    }

    public String getInvalidUserText(){
        return getText(invalidUserText);
    }

    public String flashAlertBackgroundColor(){
        return getCssValue(dataAlertNotification, "background-color");
    }

    public String flashAlertTextColor(){
        return getCssValue(dataAlertNotification, "color");
    }

    public String loginPageText(){
        return getText(LoginPageText);
    }

    public String loginPageInfoText(){
        return getText(informativeText);
    }

    public String getLoginButtonText(){
        return getText(loginButton);
    }


    public void enterIncorrectUsername(String text) {
        sendText(username, text);
    }

    public void enterIncorrectPassword(String text) {
        sendText(password, text);
    }

    public void enterUsernameAndPassword(int rowNumber) {
        try {
            readExcelData(rowNumber,0, 1, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void enterSqlInjection(int rowNumber) {
        try {
            readExcelData(rowNumber,2, 3,username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void enterEscapeCharacters(int rowNumber) {
        try {
            readExcelData(rowNumber,4, 5,username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void enterUppercaseData(int rowNumber) {
        try {
            readExcelData(rowNumber,6, 7,username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean thePasswordIsmasked(){
        return isPasswordMasked(password);
    }

}




