package org.sleepy.hmmusicbox.pojo.vo.channel;

import lombok.Data;
import org.sleepy.hmmusicbox.pojo.entity.PostEntity;
import org.sleepy.hmmusicbox.pojo.vo.post.PostVO;

import java.net.URL;
import java.util.List;

@Data
public class ChannelVO {
    private Long id;
    private String title;
    private int subscriberCount;
    private URL img;
    private List<PostVO> posts;
}
