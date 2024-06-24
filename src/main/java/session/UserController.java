package session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class UserController {

    @GetMapping("/websession")
    public Mono<UserForm> getSession(WebSession session) {
        session.getAttributes().putIfAbsent("key", 0);
        session.getAttributes().putIfAbsent("note", "Hi!");

        var userForm = new UserForm();
        userForm.setKey((Integer) session.getAttributes().get("key"));
        userForm.setNote((String) session.getAttributes().get("note"));

        return Mono.just(userForm);
    }

    @GetMapping("/websession/test")
    public Mono<UserForm> testWebSessionByParam(@RequestParam(value = "key") Integer key,
            @RequestParam(value = "note") String note, WebSession session) {
        session.getAttributes().put("key", key);
        session.getAttributes().put("note", note);

        var userForm = new UserForm();
        userForm.setKey((Integer) session.getAttributes().get("key"));
        userForm.setNote((String) session.getAttributes().get("note"));

        return Mono.just(userForm);
    }
}
