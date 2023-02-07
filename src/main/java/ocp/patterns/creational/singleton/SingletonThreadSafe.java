package ocp.patterns.creational.singleton;

import java.util.Objects;

public class SingletonThreadSafe {

    private static volatile SingletonThreadSafe instance;

    private final String value;

    public String getValue() {
        return value;
    }

    private SingletonThreadSafe(String value) {
        this.value = value;
    }

    public static SingletonThreadSafe getInstance(String value) {
        if (Objects.nonNull(instance)) {
            return instance;
        } else {
            synchronized (SingletonThreadSafe.class) {
                if (Objects.isNull(instance)) {
                    instance = new SingletonThreadSafe(value);
                }
            }
        }
        return instance;
    }
}
