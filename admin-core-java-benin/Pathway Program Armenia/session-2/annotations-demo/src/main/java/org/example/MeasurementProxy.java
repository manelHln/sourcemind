package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MeasurementProxy implements InvocationHandler {

    private Object original;

    public static Object create(Class<?> interfaceType, Object originalObject) {
        return Proxy.newProxyInstance(
                originalObject.getClass().getClassLoader(),
                new Class[]{interfaceType},
                new MeasurementProxy(originalObject)
        );
    }

    private MeasurementProxy(Object originalObject) {
        original = originalObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        boolean annotation = false;
        for (Method originalMethod : original.getClass().getDeclaredMethods()) {
            if (originalMethod.getAnnotation(Measure.class) != null && method.getName().equals(originalMethod.getName())) {
                annotation = true;
                break;
            }
        }

        if (!annotation) {
            return method.invoke(original, args);
        }

        // Measuring functionality
        long now = System.nanoTime();
        Object result = method.invoke(original, args);
        System.out.println("Runtime " + (System.nanoTime() - now) + " ns");
        return result;
    }
}
