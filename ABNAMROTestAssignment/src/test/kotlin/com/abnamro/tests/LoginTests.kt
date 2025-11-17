    package tests
    import org.junit.jupiter.api.Assertions
    import org.junit.jupiter.api.Test
    import pages.LoginPage
    import pages.LoginSuccessPage
    import utils.UtilResources
    import java.net.URI

    /**
     * LoginTests is a test class that extends BaseTest.
     * It contains test cases related to the login functionality.
     */
    class LoginTests: BaseTest() {

        /**
         * Test case to verify successful login with valid credentials.
         */
        @Test
        fun testLoginWithValidCredentials() {
            driver.get(URI(UtilResources.getProperties("loginPageURL")).toString())
            val loginPage = LoginPage(driver)

            loginPage.
                     loginWithValidUser().
                         isSuccessfullyLoggedInPageOpen().
            let {
                if (it != null) {
                    Assertions.assertTrue(it,"Login failed with login user ID")
                }
            }

        }

        /**
         * Test case to verify the presence of the success message after a successful login.
         */
        @Test
        fun testLoginSuccessMessage() {
            driver.get(URI(UtilResources.getProperties("loginPageURL")).toString())
            val loginPage = LoginPage(driver)
            loginPage.
                    loginWithValidUser().getSuccessMessage().
                            contains(
                                UtilResources.
                                    getProperties("successMessage")).
            let { Assertions.assertTrue(it, "Login Success message is wrong") }
        }

        /**
         * Test case to verify the presence of the logout button after a successful login.
         */
        @Test
        fun testLogoutButton() {
            driver.get(URI(UtilResources.getProperties("loginPageURL")).toString())
            val loginPage = LoginPage(driver)

            loginPage.loginWithValidUser()
                .isLogoutButtonPresent()?.let {
                Assertions.assertTrue(it, "Logout button not present on the screen after successful login")
            }

        }




    }