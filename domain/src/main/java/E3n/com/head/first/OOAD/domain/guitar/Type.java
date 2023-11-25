package E3n.com.head.first.OOAD.domain.guitar;

public enum Type {
    ACOUSTIC, ELECTRIC;

    @Override
    public String toString() {
        switch (this){
            case ACOUSTIC -> {
                return  "Acoustic";
            }
            case ELECTRIC -> {
                return "Electric";
            }
            default -> {
                return "error";
            }
        }
    }
}
