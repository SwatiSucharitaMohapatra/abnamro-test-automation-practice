    package tests
    import org.junit.jupiter.api.AfterEach
    import utils.UtilResources
    import org.junit.jupiter.api.BeforeEach
    import org.openqa.selenium.chrome.ChromeDriver
    import java.util.concurrent.TimeUnit

    /**
     * BaseTest is an abstract class that serves as the foundation for all test classes in the project.
     * It encapsulates common setup and teardown logic that is shared among multiple test cases.
     * Test classes should extend this base class to inherit the common testing infrastructure.
     */
    abstract class BaseTest {

        // Declaration of the ChromeDriver variable
        protected lateinit var driver: ChromeDriver

        @BeforeEach
        /**
         * * Setup method to be executed before each test.
        * This method initializes the ChromeDriver, configures system properties, and sets up common browser settings.
        */
        fun setup() {
            // Configure system properties for the ChromeDriver
            System.setProperty(
                UtilResources.getProperties("nameDriver"),
                UtilResources.getProperties("pathDriver") + UtilResources.getProperties("exeDriver"))

            // Initialize ChromeDriver instance
            driver =  ChromeDriver()

            // Set implicit wait and maximize the window
            driver.manage()?.let {
                it.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
                it.window()?.maximize()
            }
        }

        @AfterEach
        /**
         * Teardown method to be executed after each test.
         * This method closes the browser window and performs any necessary cleanup.
         */
        fun driverClose() {
            // Close the browser window
            driver.quit();
        }

    }