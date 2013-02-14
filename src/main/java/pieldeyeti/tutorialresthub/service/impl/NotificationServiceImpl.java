package pieldeyeti.tutorialresthub.service.impl;

import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pieldeyeti.tutorialresthub.service.NotificationService;

@Named("notificationService")
public class NotificationServiceImpl implements NotificationService {
    protected static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Override
    public void send(String email, String message) {
        logger.info("New message for " + email + ": " + message);
    }
    
}
