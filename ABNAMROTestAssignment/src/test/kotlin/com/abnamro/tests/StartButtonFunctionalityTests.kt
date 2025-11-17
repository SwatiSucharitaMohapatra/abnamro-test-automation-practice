    package tests

    import org.junit.jupiter.api.Assertions
    import org.junit.jupiter.api.Test
    import pages.DynamicLoadingPage
    import utils.UtilResources
    import java.net.URI

    /**
     * StartButtonFunctionalityTests is a test class that extends BaseTest.
     * It contains a test case related to the functionality of a start button on a dynamic loading page.
     */
    class StartButtonFunctionalityTests : BaseTest() {

        /**
         * Test case to validate that a specific text appears after clicking the start button on a dynamic loading page.
         */
        @Test
        fun validateTextAppearAfterStartButtonClick() {
            driver.get(URI(UtilResources.getProperties("dynamicLoadingPageURL")).toString())
            val dynamicLoadingPage = DynamicLoadingPage(driver)

            dynamicLoadingPage.clickStartButton()

                Assertions.assertTrue(dynamicLoadingPage.getTextAfterStartButtonClick().
                contains(UtilResources.getProperties("textToVerify")),
                    "The generated text is not correct, actual text is "+
                            dynamicLoadingPage.getTextAfterStartButtonClick())
        }
    }