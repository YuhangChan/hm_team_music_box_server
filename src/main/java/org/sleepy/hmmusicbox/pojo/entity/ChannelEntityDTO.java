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
    private URL url;
    private ChannelEntityDTO(String title, int subscriberCount, URL url) {
        this.title = title;
        this.subscriberCount = subscriberCount;
        this.url = url;
    }
}
