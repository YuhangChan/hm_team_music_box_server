package org.sleepy.hmmusicbox.pojo.vo.user;

import lombok.Builder;
import lombok.Data;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;

import java.util.Set;

@Data
@Builder
public class UserVO {
    private Long id;
    private String username;
    private String password;
    private String phoneNumber;
    private String avatarURL;
    private String profile;
    private Set<MusicVO> likes;

}
