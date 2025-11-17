    package pages
    import org.openqa.selenium.JavascriptExecutor
    import org.openqa.selenium.WebElement
    import org.openqa.selenium.chrome.ChromeDriver
    import org.openqa.selenium.support.FindBy
    import org.openqa.selenium.support.PageFactory
    import org.openqa.selenium.support.ui.WebDriverWait

    /**
     * Page class representing the login success page in the Selenium framework.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    class LoginSuccessPage(driver: ChromeDriver): BasePage(driver) {

        //All the elements of Login Success Page
         @FindBy(id = "flash")
         private val successMessage: WebElement? = null

        @FindBy(css = "a.button")
        private val logoutButton: WebElement? = null

        init {
            PageFactory.initElements(driver, this)
        }

        /**
         * Waits until the page is fully loaded.
         */
        private fun waitForPageLoad() {
            WebDriverWait(driver, 30).until<Boolean> {
                (driver as JavascriptExecutor).executeScript(
                    "return document.readyState"
                ) == "complete"
            }
        }

        /**
         * Checks if the successfully logged-in page is open.
         *
         * @return true if the page is open; false otherwise.
         */
        fun isSuccessfullyLoggedInPageOpen(): Boolean? {
            waitForPageLoad()
            return successMessage?.isDisplayed
        }

        /**
         * Gets the success message displayed on the page.
         *
         * @return The success message as a String.
         */
        fun getSuccessMessage(): String {
            return successMessage?.text.toString()
        }

        /**
         * Checks if the logout button is present on the page.
         *
         * @return true if the logout button is present; false otherwise.
         */
        fun isLogoutButtonPresent(): Boolean? {
            return  logoutButton?.isDisplayed
        }

    }