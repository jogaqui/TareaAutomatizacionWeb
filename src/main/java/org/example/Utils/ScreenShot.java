package org.example.Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {

    public static String captureScreenshot(WebDriver driver, String folder, String screenName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotPath = System.getProperty("user.dir") + folder + File.separator + "/evidencia_" + getCurrentDateTime() + "_" + screenName + ".png";

        try {
            FileHandler.copy(src, new File(screenShotPath));
        } catch (IOException e) {
            System.out.println("unable to capture screenshot" + e.getMessage());
        }
        return screenShotPath;
    }

    public static String getCurrentDateTime() {
        DateFormat customFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date currenDate = new Date();
        return customFormat.format(currenDate);
    }

    public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
        return basePath + "/" + path;
    }

    public static void createFolder(String FolderName) {
        String newFolderName = getResourcePath(FolderName);
        File f1 = new File(newFolderName);
        f1.mkdirs();
    }
}
