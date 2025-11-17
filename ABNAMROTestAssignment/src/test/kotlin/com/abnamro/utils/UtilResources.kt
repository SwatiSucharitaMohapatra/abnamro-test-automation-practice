    package utils

    import java.io.FileInputStream
    import java.io.IOException
    import java.util.*

    /**
     * UtilResources is a utility object for managing any utils for the tests
     */
    object UtilResources {
        // Properties object to store loaded properties
        private lateinit var properties: Properties

        /**
         * Load properties from the configuration file.
         * Note: This method is private and is automatically called when properties are requested.
         */
        private fun loadProperties(): Unit {
            try {
                properties = Properties()
                properties.load(FileInputStream("src/test/resources/config.properties"))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        /**
         * Get the value of a property from the loaded properties.
         * @param propertyName The name of the property to retrieve.
         * @return The value of the specified property as a String.
         */
        fun getProperties(properties: String): String {
            loadProperties()
            return UtilResources.properties.getProperty(properties).toString()
        }
    }
