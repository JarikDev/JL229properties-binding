package com;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main {
    public static void main(String[] args) {
        int i;
        Integer integer;
        IntegerProperty integerProperty = new SimpleIntegerProperty(5);
        IntegerProperty integerProperty2 = new ReadOnlyIntegerWrapper(5);
        IntegerBinding integerBinding=new IntegerBinding() {
            {
                super.bind(integerProperty,integerProperty2);
            }
            @Override
            protected int computeValue() {
                return integerProperty.get()+integerProperty2.get();
            }
        };
        System.out.println(integerBinding.get());
        integerProperty.set(2);
        System.out.println(integerBinding.get());
        System.out.println(integerProperty.add(integerProperty2));
         integerProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("new Value = "+newValue);
            }
        });
        integerProperty.bindBidirectional(integerProperty2);
        integerProperty2.set(4);
        System.out.println(integerProperty2);

        integerProperty.set(6);
        System.out.println(integerProperty.get());
        boolean bool;
        Boolean boole;
        SimpleBooleanProperty simpleBooleanProperty;
        StringProperty stringProperty;




    }
}

class User {
    StringProperty stringProperty = new SimpleStringProperty("Jarik");

    public String getStringProperty() {
        return stringProperty.get();
    }

    public StringProperty stringPropertyProperty() {
        return stringProperty;
    }

    public void setStringProperty(String stringProperty) {
        this.stringProperty.set(stringProperty);
    }
}

