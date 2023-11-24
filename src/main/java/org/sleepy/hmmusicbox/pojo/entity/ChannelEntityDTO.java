package org.sleepy.hmmusicbox.pojo.entity;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class ChannelEntityDTO {
    private Long id;
    private String title;
    private int subscriberCount;
    private URL img;
    private ChannelEntityDTO(Long id, String title, int subscriberCount, URL img) {
        this.id = id;
        this.title = title;
        this.subscriberCount = subscriberCount;
        this.img = img;
    }
}
