package org.sleepy.hmmusicbox.pojo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicEntityDTO {
    private String name;
    private String album;
    private String singer;

    public MusicEntityDTO(String name, String album, String singer) {
        this.name = name;
        this.album = album;
        this.singer = singer;
    }

}
