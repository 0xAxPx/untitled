package ocp.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Animal implements Cloneable {


    /**
     * Make class immutable:
     * 1. Mark the class as final.
     * 2. Mark all the instance variables private.
     * 3. Don't define any setter methods and make fields final.
     * 4. Don't allow referenced mutable objects to be modified.
     * 5. Use a constructor to set all properties of the object, making a copy if needed.
     */


    private final List<String> animals;

    @Override
    public Object clone() {
        return new Animal(this.animals);
    }

    public Animal(List<String> animals) {
        if (Objects.isNull(animals)) {
            throw new IllegalArgumentException("Animals should be provided");
        }
        // defensive copy
        this.animals = new ArrayList<>(animals);
        //or via Cloneable interface
        //this.animals = (ArrayList) animals.clone();
    }
}


