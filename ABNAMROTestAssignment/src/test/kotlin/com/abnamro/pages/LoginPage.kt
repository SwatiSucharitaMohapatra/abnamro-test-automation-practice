    package pages

    import org.openqa.selenium.WebElement
    import org.openqa.selenium.chrome.ChromeDriver
    import org.openqa.selenium.support.FindBy
    import org.openqa.selenium.support.PageFactory
    import utils.UtilResources


    /**
     * Page class representing the login page in the Selenium framework.
     * This class provides methods to interact with the elements on the login page,
     * such as entering username and password, clicking the login button, and handling user login.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    class LoginPage (driver: ChromeDriver): BasePage(driver) {

        // WebElements representing elements on the login page
        @FindBy(id = "username")
        private val userNameTextBox: WebElement? = null

        @FindBy(id = "password")
        private val passwordTextBox: WebElement? = null

        @FindBy(css = "i.fa-sign-in")
        private val loginButton: WebElement? = null

        @FindBy(css = "em")
        private val userNameTextElement: WebElement? = null

        @FindBy(css = "em")
        private val passwordTextElement: WebElement? = null

        // Initialize elements using PageFactory
        init {
            PageFactory.initElements(driver, this)
        }

        //TODO: Extract password mentioned from the Login screen and use in enterUserName function
        private fun getUserNameText () : String {
            return userNameTextElement?.text.toString()
        }

        //TODO: Extract password mentioned from the Login screen and use in enterPassword function
        private fun getPasswordText () : String {
            return passwordTextElement?.text.toString()
        }

        /**
         * Enters the given username into the username text box on the login page.
         *
         * @param userName The username to be entered.
         */
        private fun enterUserName (userName: String) {
            userNameTextBox?.sendKeys(userName)
        }

        /**
         * Enters the given password into the password text box on the login page.
         *
         * @param password The password to be entered.
         */
        private fun enterPassword (password: String) {
            passwordTextBox?.sendKeys(password)
        }

        /**
         * Logs in with a valid user by entering the username and password and clicking the login button.
         *
         * @return An instance of LoginSuccessPage after successful login.
         */
        fun loginWithValidUser () : LoginSuccessPage {
            enterUserName(UtilResources.getProperties("loginUserName"))
            enterPassword(UtilResources.getProperties("loginPassword"))
            loginButton?.click()
            return LoginSuccessPage(driver)
        }
    }