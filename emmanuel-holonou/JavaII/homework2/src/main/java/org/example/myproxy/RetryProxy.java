package org.example.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RetryProxy implements InvocationHandler {
    private Object target;
    private int retryLimit;
    private String retryMessage;

    public static Object createProxy(Object target, int retryLimit, String retryMessage) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new RetryProxy(target, retryLimit, retryMessage)
        );
    }

    private RetryProxy(Object target, int retryLimit, String retryMessage) {
        this.target = target;
        this.retryLimit = retryLimit;
        this.retryMessage = retryMessage;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int retryCount = 0;
        while (retryCount < retryLimit) {
            try {
                return method.invoke(target, args);
            } catch (Exception e) {
                retryCount++;
                if (retryCount < retryLimit) {
                    System.out.println("Retry attempt #" + retryCount);
                } else {
                    throw new Exception(retryMessage);
                }
            }
        }
        throw new Exception("Retry limit exceeded");
    }
}

