package com.lordgasmic.bff.session;

import com.lordgasmic.bff.session.model.SessionDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class SessionManager {

    private final SessionRepository sessionRepository;

    public SessionManager(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public SessionDetails getSessionDetails(String token) {
        return sessionRepository.findByAuthToken(token);
    }

    public String handleLogin(final SessionDetails sessionDetails) {
        String token = UUID.randomUUID().toString();

        sessionDetails.setAuthToken(token);
        sessionRepository.save(sessionDetails);

        return token;
    }

    public void handleLogout(String token) {
        sessionRepository.deleteByAuthToken(token);
    }
}
