package org.sleepy.hmmusicbox.pojo.vo.reply;

import lombok.Data;
import org.sleepy.hmmusicbox.pojo.entity.PostEntity;

@Data
public class ReplyVO {
    private Long id;
    private Long replierID;
    private String content;
//    private int floor;
    private PostEntity post;
}
