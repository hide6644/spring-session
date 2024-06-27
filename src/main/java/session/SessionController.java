package session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class SessionController {

    @GetMapping("/websession")
    public Mono<SessionForm> getSession(WebSession session) {
        session.getAttributes().putIfAbsent("key", 0);
        session.getAttributes().putIfAbsent("note", "Nothing!");

        var sessionForm = new SessionForm();
        sessionForm.setSessionId(session.getId());
        sessionForm.setCreationTime(session.getCreationTime().toString());
        sessionForm.setLastAccessedTime(session.getLastAccessTime().toString());
        sessionForm.setMaxIdleTime(session.getMaxIdleTime().toString());
        sessionForm.setKey((Integer) session.getAttributes().get("key"));
        sessionForm.setNote((String) session.getAttributes().get("note"));

        return Mono.just(sessionForm);
    }

    @GetMapping("/websession/test")
    public Mono<SessionForm> testWebSessionByParam(@RequestParam(value = "key") Integer key,
            @RequestParam(value = "note") String note, WebSession session) {
        session.getAttributes().put("key", key);
        session.getAttributes().put("note", note);

        var sessionForm = new SessionForm();
        sessionForm.setSessionId(session.getId());
        sessionForm.setCreationTime(session.getCreationTime().toString());
        sessionForm.setLastAccessedTime(session.getLastAccessTime().toString());
        sessionForm.setMaxIdleTime(session.getMaxIdleTime().toString());
        sessionForm.setKey((Integer) session.getAttributes().get("key"));
        sessionForm.setNote((String) session.getAttributes().get("note"));

        return Mono.just(sessionForm);
    }
}
