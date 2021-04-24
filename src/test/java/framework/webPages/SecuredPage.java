package framework.webPages;

import org.openqa.selenium.By;

public class SecuredPage extends BasePage {

    private By dataAlertNotification = By.xpath("//div[@id='flash']");
    private By securedPageText = By.xpath("//*[text()=' Secure Area']");
    private By informativeText = By.className("subheader");
    private By logoutButton = By.xpath("//*[text()=' Logout']");

    public String getsecuredPageText(){
       return getText(dataAlertNotification);
    }

    public String flashAlertBackgroundColor(){
       return getCssValue(dataAlertNotification, "background-color");
    }

    public String flashAlertTextColor(){
       return getCssValue(dataAlertNotification, "color");
    }

    public String securedPageText(){
        return getText(securedPageText);
    }

    public String securedPageInfoText(){
        return getText(informativeText);
    }

    public void clickOnLogoutButton() {
        clickOn(logoutButton);
    }

    public String getLogoutButtonText(){
        return getText(logoutButton);
    }

    public String logedoutOfSecurePageConfirmation(){
        return getText(dataAlertNotification);
    }


}




