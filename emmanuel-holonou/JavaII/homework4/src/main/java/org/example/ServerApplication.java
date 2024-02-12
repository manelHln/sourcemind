package org.example;
import io.javalin.Javalin;

public class ServerApplication {

    private static ServerApplication instance;
    Javalin app;

    public static ServerApplication getInstance(){
        if(instance == null){
            return instance = new ServerApplication();
        }
        return instance;
    }

    public ServerApplication (){
        app = Javalin.create();
    }
}
