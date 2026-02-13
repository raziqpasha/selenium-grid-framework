package org.deploymentproject.utilities;


import io.qameta.allure.Allure;

public class AllureManager {

    public static void attachScreenshot() {
        Allure.getLifecycle().addAttachment(
                "Failure Screenshot",
                "image/png",
                "png",
                ScreenshotUtil.captureScreenshot()
        );
    }
}
