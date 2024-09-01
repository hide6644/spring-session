package session;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SessionForm implements Serializable {

    private String executedServerName;

    private String executedServerIp;

    private String sessionId;

    private String creationTime;

    private String lastAccessedTime;

    private String maxIdleTime;

    private Integer key;

    private String note;
}
