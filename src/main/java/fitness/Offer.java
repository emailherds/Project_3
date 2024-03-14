package fitness;
/**
 * Represents different offers for fitness classes.
 * @author Omkar Kadam and Colin Lee
 */
public enum Offer {
    PILATES,
    SPINNING,
    CARDIO,
    UNKNOWN;

    @Override
    public String toString() {
        switch (this) {
            case PILATES:
                return "PILATES";
            case SPINNING:
                return "SPINNING";
            case CARDIO:
                return "CARDIO";
            default:
                return "Unknown";
        }
    }
}