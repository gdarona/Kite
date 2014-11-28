package com.groupeseb.kite.check.impl.methods;

import com.google.common.base.Preconditions;
import com.groupeseb.kite.Json;
import com.groupeseb.kite.check.ICheckMethod;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class LengthMethod implements ICheckMethod {
    @Override
    public Boolean match(String name) {
        return name.equalsIgnoreCase("length");
    }

    @Override
    public Object apply(Object o, Json parameters) {
        Preconditions.checkNotNull(o, "Parameter of the 'length' method cannot be null!");

        Preconditions.checkArgument(
                Collection.class.isAssignableFrom(o.getClass()),
                "The input argument of 'length' must be a collection"
        );

        return ((Collection)o).size();
    }
}
