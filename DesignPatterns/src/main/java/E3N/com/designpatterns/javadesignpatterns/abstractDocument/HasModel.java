package E3N.com.designpatterns.javadesignpatterns.abstractDocument;

import java.util.Optional;

public interface HasModel extends Document{
    default Optional<String> getModel(){
        return Optional.ofNullable((String) get(Property.MODEL.toString()));
    }
}
