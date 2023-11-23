package org.sleepy.hmmusicbox.pojo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicEntityDTO {
    private Long id;
    private String name;
    private String album;
    private String singer;

    public MusicEntityDTO(Long id, String name, String album, String singer) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.singer = singer;
    }

}
