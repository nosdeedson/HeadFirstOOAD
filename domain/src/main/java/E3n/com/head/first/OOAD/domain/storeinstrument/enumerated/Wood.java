package E3n.com.head.first.OOAD.domain.storeinstrument.enumerated;

public enum Wood {

    INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

    @Override
    public String toString() {
        switch (this){
            case ALDER -> {
                return "Alder";
            }
            case CEDAR -> {
                return "Cedar";
            }
            case MAPLE -> {
                return "Maple";
            }
            case COCOBOLO -> {
                return "Cocobolo";
            }
            case MAHOGANY -> {
                return "Mahogany";
            }
            case ADIRONDACK -> {
                return "Adirondack";
            }
            case INDIAN_ROSEWOOD -> {
                return "Indian rose wood";
            }
            case BRAZILIAN_ROSEWOOD -> {
                return "Brazilian rose wood";
            }
            default -> {
                return "Sitka";
            }
        }
    }
}
