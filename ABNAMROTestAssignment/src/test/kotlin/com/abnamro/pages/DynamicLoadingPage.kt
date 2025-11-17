        package pages

        import org.openqa.selenium.WebElement
        import org.openqa.selenium.chrome.ChromeDriver
        import org.openqa.selenium.support.FindBy
        import org.openqa.selenium.support.PageFactory

        /**
         * This Page class representing the page in the Selenium framework.
         *
         * @param driver The WebDriver instance used to interact with the browser.
         */
        class DynamicLoadingPage (driver: ChromeDriver): BasePage(driver) {

            // WebElement representing the "Start" button on the page
            @FindBy(xpath = "//*[@id=\"start\"]/button")
            private val startButton: WebElement? = null

            // WebElement representing the text that appears after clicking the "Start" button
            @FindBy(id = "finish")
            private val helloWorldText: WebElement? = null


            // Initialize elements using PageFactory
            init {
                PageFactory.initElements(driver, this)
            }

            /**
             * Clicks the "Start" button on the page.
             */
            fun clickStartButton () {
                startButton?.click()
            }

            /**
             * Waits until the "Hello World!" text is visible on the page.
             */
           private fun waitUntilTextLoading () {
                waitForVisibility(helloWorldText)
           }

            /**
             * Gets the text that appears after clicking the "Start" button.
             *
             * @return The text displayed after clicking the "Start" button.
             */
            fun getTextAfterStartButtonClick(): String {
                waitUntilTextLoading()
                return helloWorldText?.text.toString()
            }


        }