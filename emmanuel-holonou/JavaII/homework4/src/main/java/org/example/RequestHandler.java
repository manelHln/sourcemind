package org.example;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class RequestHandler implements Handler {
    protected int availableSlots = 10;
    @Override
    public void handle(@NotNull Context context) throws Exception {
        synchronized (this) {
            if (availableSlots <= 0) {
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
