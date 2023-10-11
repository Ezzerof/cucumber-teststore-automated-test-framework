package teststore.chris.utils;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotToPng {
    private static final Logger logger = LogManager.getLogger(ScreenshotToPng.class);

    public static void takeScreenshot(String path, Scenario scenario, byte[] screenshot) {
        File screenshotDir = new File(path);

        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        File screenshotFile = new File(screenshotDir, scenario.getName() + "_" + now.format(formatter) + ".png");

        try (FileOutputStream fos = new FileOutputStream(screenshotFile)) {
            fos.write(screenshot);
        } catch (IOException ioException) {
            logger.error("Failed to save screenshot", ioException);
        }

    }

}
