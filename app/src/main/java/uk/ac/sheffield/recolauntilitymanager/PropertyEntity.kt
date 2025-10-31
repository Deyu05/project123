package uk.ac.sheffield.recolauntilitymanager

/**
 * Stores information about a property. Only an initial implementation
 * and currently isn't attached to a database.
 */
data class PropertyEntity(
    val addressLineOne: String,
    val addressRemainer: String,
    val image: Int,
    val numTenants: Int,
    val geoLocation: String,
    val note: String
)
