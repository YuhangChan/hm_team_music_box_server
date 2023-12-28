package org.sleepy.hmmusicbox.pojo.vo.post;

import lombok.Data;
import org.sleepy.hmmusicbox.pojo.entity.ChannelEntity;
import org.sleepy.hmmusicbox.pojo.entity.ReplyEntity;

import java.util.List;

@Data
public class PostVO {
    private Long id;
    private String title;
    private String content;
    private String username;
    private List<ReplyEntity> replies;
    private ChannelEntity channel;

}
