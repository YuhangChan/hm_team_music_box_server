package org.sleepy.hmmusicbox.pojo.vo.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTOVO {
    private Long id;
    private String username;
    private String avatarURL;
    private String profile;
}
