package org.example;

public class App implements AppInterface {
    public static void main(String[] args) {

        AppInterface appProxy = (AppInterface) MeasurementProxy.create(AppInterface.class, new App());
        Service serviceProxy = (Service) MeasurementProxy.create(Service.class, new ServiceImpl());

        appProxy.method1();
        appProxy.method2();

        serviceProxy.getContacts();
    }

    @Measure(message = "duration is")
    @Override
    public void method1() {
        System.out.println("method 1 is running");
    }

    @Override
    public void method2() {
        System.out.println("method 2 is running");
    }
}
