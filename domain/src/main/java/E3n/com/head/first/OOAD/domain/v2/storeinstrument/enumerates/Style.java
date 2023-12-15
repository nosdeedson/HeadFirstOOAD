package E3n.com.head.first.OOAD.domain.v2.storeinstrument.enumerates;

public enum Style {

    A, F;

    @Override
    public String toString() {
        switch (this){
            case A -> {
                return "a";
            }
            default -> {
                return "b";
            }
        }
    }
}
