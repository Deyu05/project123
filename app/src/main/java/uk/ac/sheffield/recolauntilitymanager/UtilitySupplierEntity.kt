package uk.ac.sheffield.recolauntilitymanager

/**
 * Stores information about a utility supplier stored in
 * the database
 */
data class UtilitySupplierEntity(
    val type : UtilityType,
    val name : String,
    val contactDetails : String
)
