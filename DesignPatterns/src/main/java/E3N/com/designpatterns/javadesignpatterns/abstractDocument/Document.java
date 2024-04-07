package E3N.com.designpatterns.javadesignpatterns.abstractDocument;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Document {

    Void put(final String key, final Object value);
    Object get(final String key);
    <T> Stream<T>  children(final String key, Function<Map<String, Object>, T> constructor);
}
