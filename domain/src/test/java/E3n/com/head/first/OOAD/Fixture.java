package E3n.com.head.first.OOAD;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Builder;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Type;
import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.Wood;
import com.github.javafaker.Faker;

import java.util.UUID;

public class Fixture {

    private static final Faker FAKER = new Faker();

    public static String serialNumber(){
        return UUID.randomUUID().toString();
    }

    public static double price(){
        return FAKER.options().option(3000.0, 1800.0, 1000.0, 2000.0, 2500.0);
    }

    public static String model(){
        return FAKER.options().option(FAKER.name().firstName());
    }

    public static Type type(){
        return FAKER.options().option(Type.values());
    }

    public static Builder builder(){
        return FAKER.options().option(Builder.values());
    }

    public static Wood wood(){
        return FAKER.options().option(Wood.values());
    }
}
