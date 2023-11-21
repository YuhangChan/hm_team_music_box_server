package org.sleepy.hmmusicbox.pojo.vo.channel;

import lombok.Data;
import org.sleepy.hmmusicbox.pojo.entity.PostEntity;

import java.util.List;

@Data
public class ChannelVO {
    private Long id;
    private String title;
//    private List<PostEntity> postIDs;
    private int subscriberCount;
}
