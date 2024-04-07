package E3N.com.designpatterns.javadesignpatterns.abstractDocument;

import java.util.Map;

public class Part extends AbstractDocument implements HasModel, HasPrice, HasType{
    public Part(Map<String, Object> properties) {
        super(properties);
    }
}
