package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import stepdefinition.SharedSD;

public class AllureUtil {

    /**
     * This method is used to attached screenshot in Allure report
     * @param screenShot
     * @return
     */

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] attachScreenshot(byte[] screenShot) {

        return screenShot;
    }

    public static void takeWebScreenshot() {
        final byte[] screenshot = ((TakesScreenshot)SharedSD.getDriver()).getScreenshotAs(OutputType.BYTES);
        AllureUtil.attachScreenshot(screenshot);
    }

}
