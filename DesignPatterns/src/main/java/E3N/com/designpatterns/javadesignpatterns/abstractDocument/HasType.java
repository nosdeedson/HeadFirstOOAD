package E3N.com.designpatterns.javadesignpatterns.abstractDocument;

import java.util.Optional;

public interface HasType extends Document{
    default Optional<String> getType(){
        return  Optional.ofNullable((String) get(Property.TYPE.toString()));
    }
}
