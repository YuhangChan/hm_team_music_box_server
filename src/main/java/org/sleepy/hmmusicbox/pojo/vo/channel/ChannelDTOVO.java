package org.sleepy.hmmusicbox.pojo.vo.channel;

import lombok.Data;

import java.net.URL;

@Data
public class ChannelDTOVO {
    private Long id;
    private String title;
    private int subscriberCount;
    private URL url;
}
