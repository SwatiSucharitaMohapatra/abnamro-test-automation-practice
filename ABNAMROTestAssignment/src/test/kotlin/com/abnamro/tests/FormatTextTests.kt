    package tests

    import org.junit.jupiter.api.Assertions
    import org.junit.jupiter.api.Test
    import pages.TextEditorPage
    import utils.UtilResources
    import java.net.URI

    /**
     * FormatTextTests is a test class that extends BaseTest.
     * It contains test cases related to the formatting of text in a text editor.
     */
    class FormatTextTests: BaseTest() {

        /**
         * Test case to verify the formatting of entered text in a text editor.
         */
        @Test
        fun testFormattingOfEnteredText() {
            driver.get(URI(UtilResources.getProperties("textEditorTestURL")).toString())

            val textToEnter = UtilResources.getProperties("yourTextToEnter")

            val textEditorPage = TextEditorPage(driver)
            textEditorPage.
            enterTextInTextArea(textToEnter)

            textEditorPage.formatTextToBold()

            Assertions.
                    assertEquals(textEditorPage.getExpectedFormattedText(textToEnter),
                        textEditorPage.getActualFormattedText())
        }
    }