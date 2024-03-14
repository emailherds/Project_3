package fitness;

/**
 * The Location enum represents the different locations of the fitness studio.
 * @author Colin Lee and Omkar Kadam
 */

public enum Location {
    BRIDGEWATER,
    EDISON,
    FRANKLIN,
    PISCATAWAY,
    SOMERVILLE,
    UNKNOWN;

    @Override
    public String toString() {
        switch (this) {
            case BRIDGEWATER:
                return "BRIDGEWATER";
            case EDISON:
                return "EDISON";
            case FRANKLIN:
                return "FRANKLIN";
            case PISCATAWAY:
                return "PISCATAWAY";
            case SOMERVILLE:
                return "SOMERVILLE";
            default:
                return "Unknown";
        }
    }
}