package uk.ac.sheffield.recolauntilitymanager.ui.navigation

/**
 * An Enum to represent the current screen the app is on
 */
enum class ScreenName {
    PROPERTIES, PAYMENTS, MAP, SUPPLIERS, NEW_PROPERTY, VIEW_PROPERTY;

    /**
     * Formats the screen name so all words start with a capital letter
     * and are in lowercase, and underscores are replaced with spaces.
     * @return [String] Nicely formatted [ScreenName]
     */
    override fun toString() : String {
        return name[0] + name.substring(1).lowercase()
            .replace("_[a-z]".toRegex()) { ' ' + it.value.last().uppercase() }

    }

    companion object {
        /**
         * Returns the default navigation screen - the home screen - that
         * should be loaded when launching the app
         * @return The screen used as the app's home page
         */
        fun default() : ScreenName {
            return PROPERTIES
        }
    }
}
