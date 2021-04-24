package framework.webPages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import stepdefinition.SharedSD;
import util.AllureUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BasePage extends SharedSD {

    public static void clickOn(By locator) {
        try {
            browser(locator).click();
        } catch (TimeoutException e) {
            AllureUtil.takeWebScreenshot();
            e.printStackTrace();
            throw new NoSuchElementException("Element is no found with locator " + locator.toString());
        }
    }

    public static String getText(By locator) {
        String text = null;
        try {
          text = browser(locator).getText();
        } catch (TimeoutException e) {
            AllureUtil.takeWebScreenshot();
            e.printStackTrace();
        }
        return text;
    }

    public static void sendText(By locator, String text) {
        try {
            browser(locator).sendKeys(text);
        } catch (TimeoutException e) {
            AllureUtil.takeWebScreenshot();
            e.printStackTrace();
        }
    }

    public static String getCssValue(By locator, String value) {
        String text = null;
        try {
            text = browser(locator).getCssValue(value);
        } catch (TimeoutException e) {
            AllureUtil.takeWebScreenshot();
            e.printStackTrace();
        }
        return text;
    }

    public void readExcelData(int row, int firstCellNum, int secCellNum, By usernameLocator, By passwordLocator ) throws IOException{

        File source = new File("src/test/resources/testData.xlsx");
        FileInputStream fis = new FileInputStream(source);
        XSSFWorkbook srcBook= new XSSFWorkbook(fis);
        XSSFSheet sourceSheet = srcBook.getSheetAt(0);
        XSSFRow sourceRow = sourceSheet.getRow(row);
        String username = sourceRow.getCell(firstCellNum).getStringCellValue();
        String password = sourceRow.getCell(secCellNum).getStringCellValue();
        browser(usernameLocator).sendKeys(username);
        browser(passwordLocator).sendKeys(password);
    }

    public boolean isPasswordMasked(By locator){
        try {
            if (browser(locator).getAttribute("type").equals("password")){
                return true;
            }
        } catch (TimeoutException e) {
            AllureUtil.takeWebScreenshot();
            e.printStackTrace();
        }
        return false;
    }


    public static WebElement browser(final By locator) {
        Wait<WebDriver> wait = new FluentWait<>(SharedSD.getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotFoundException.class)
                .withMessage("Webdriver waited for 30 seconds but still could not find the element" +
                        " therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }

}


