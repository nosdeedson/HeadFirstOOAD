package E3N.com.designpatterns.javadesignpatterns.abstractDocument;

import java.util.Map;

public class Car extends AbstractDocument implements HasPrice, HasParts, HasModel{
    public Car(Map<String, Object> properties) {
        super(properties);
    }
}
