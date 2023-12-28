package org.sleepy.hmmusicbox.pojo.entity;

public class UserEntityDTO {
    private Long id;
    private String username;
    private String avatarURL;
    private String profile;

    public UserEntityDTO(Long id, String username, String avatarURL, String profile) {
        this.id = id;
        this.username = username;
        this.avatarURL = avatarURL;
        this.profile = profile;
    }
}
