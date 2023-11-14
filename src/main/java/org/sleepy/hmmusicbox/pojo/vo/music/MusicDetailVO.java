package org.sleepy.hmmusicbox.pojo.vo.music;

import lombok.Data;

import java.net.URL;

@Data
public class MusicDetailVO {
    private Long id;
    private String detail;
    private URL imageUrl;
}
