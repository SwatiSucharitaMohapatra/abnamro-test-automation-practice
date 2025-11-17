    package pages
    import org.openqa.selenium.WebElement
    import org.openqa.selenium.chrome.ChromeDriver
    import org.openqa.selenium.support.ui.ExpectedConditions
    import org.openqa.selenium.support.ui.WebDriverWait

    /**
     * Base class for page objects in the Selenium framework.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    abstract class BasePage(protected val driver: ChromeDriver) {

        /**
         * Waits for the visibility of a web element on the page.
         * This method uses the WebDriverWait to wait for a specified maximum time until the given element becomes visible.
         * @param element The WebElement to wait for visibility.
         */
       fun waitForVisibility(element: WebElement?) {
            WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(element))
        }
    }