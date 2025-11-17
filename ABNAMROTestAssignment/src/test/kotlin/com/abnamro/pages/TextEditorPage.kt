    package pages

    import org.openqa.selenium.Keys
    import org.openqa.selenium.WebElement
    import org.openqa.selenium.chrome.ChromeDriver
    import org.openqa.selenium.support.FindBy
    import org.openqa.selenium.support.PageFactory

    /**
     * Page class representing the text editor page in the Selenium framework.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    class TextEditorPage(driver: ChromeDriver): BasePage(driver) {

        //All the elements of the Page
        @FindBy(id = "tinymce")
        private val textArea: WebElement? = null

        @FindBy(id = "mce_0_ifr")
        private val iFrame: WebElement? =null

        @FindBy(css = "button[title='Bold']")
        private val boldButton: WebElement? = null

        init {
            PageFactory.initElements(driver, this)
        }

        /**
         * Switches to the iFrame
         */
        private fun switchToiFrame() {
            driver.switchTo().frame(iFrame)
        }

        /**
         * Enters text in the text area.
         *
         * @param textToEnter The text to be entered.
         */
        fun enterTextInTextArea(textToEnter: String) {
            switchToiFrame()
            textArea?.clear()
            textArea?.sendKeys(textToEnter)
        }

        /**
         * Formats the text to bold.
         */
        fun formatTextToBold() {
            textArea?.sendKeys(Keys.chord(Keys.COMMAND, "a"))
            driver.switchTo().defaultContent()
            boldButton?.click()
        }

        /**
         * Gets the expected formatted text based on the entered text.
         *
         * @param enteredText The text entered in the text area.
         * @return The expected formatted text.
         */
        fun getExpectedFormattedText(enteredText: String): String {
            return "<p><strong>$enteredText</strong></p>"
        }

        /**
         * Gets the actual formatted text from the text area.
         *
         * @return The actual formatted text.
         */
        fun getActualFormattedText(): String? {
           driver.switchTo().frame(iFrame)
            return textArea?.getAttribute("innerHTML")
        }


    }