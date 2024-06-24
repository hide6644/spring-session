package session;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserForm implements Serializable {

    private String serverName;

    private Integer serverPort;

    private String hostName;

    private String hostAddress;

    private String sessionId;

    private Date creationTime;

    private Date lastAccessedTime;

    private Integer maxInactiveInterval;

    private Integer key;

    private String note;
}
