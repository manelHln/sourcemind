package org.example.registration.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 * - Try volatile
 * - Guard with synchronized method
 * - Guard with synchronized block
 * - Use AtomicInteger for counter
 * - Use Reentrant lock
 * - Use ExecutorService for sending email
 */

public class RegistrationService {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationService.class);

    private final int limit;
    private int count;

    public RegistrationService(int limit) {
        this.limit = limit;
    }

    boolean register() {
        logger.info("Serving with thread " + Thread.currentThread().getName());

        // Important condition check
        if (isLimitReached()) {
            return false;
        }

        logger.info("Registering the user");

        // Important data update
        count++;

        logger.info("User is successfully registered");
        logger.info("Now we will send an email to the user");

        // Follow-up stuff
        sendEmail();

        return true;
    }

    int count() {
        return count;
    }

    private boolean isLimitReached() {
        return count == limit;
    }

    private void sendEmail() {
        // This is going to take some time...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Email is sent");
    }
}
