package uk.ac.sheffield.recolauntilitymanager

/**
 * Enum to store the types a utility supplier can be/supply
 */
enum class UtilityType {
    ELECTRICITY, GAS, WATER, BROADBAND;

    override fun toString(): String {
        return name[0] + name.substring(1).lowercase()
    }
}