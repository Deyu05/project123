package uk.ac.sheffield.recolauntilitymanager

/**
 * Data class to store information about a tenant. Only an initial class
 * for previews and not connected to a database.
 */
data class TenantEntity(
    val name : String,
    val email : String,
    val note : String,
    val property : PropertyEntity
)
