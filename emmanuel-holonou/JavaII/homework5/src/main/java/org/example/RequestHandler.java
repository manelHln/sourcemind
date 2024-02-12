package org.example;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class RequestHandler implements Handler {
    protected int availableSlots = 10;
    static boolean finished = false;
    static Object lock = new Object();
    @Override
    public void handle(@NotNull Context context) throws Exception {
        synchronized (lock) {
            if (availableSlots <= 0) {
                finished = true;
                context.status(400);
                context.result("Fail");
                return;
            }
            context.status(200);
            context.result("Success ");
            availableSlots--;
        }
    }
}
