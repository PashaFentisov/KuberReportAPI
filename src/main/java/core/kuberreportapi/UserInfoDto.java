package core.kuberreportapi;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserInfoDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
}
