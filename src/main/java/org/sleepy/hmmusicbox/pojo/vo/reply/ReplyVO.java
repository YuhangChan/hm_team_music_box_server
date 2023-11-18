package org.sleepy.hmmusicbox.pojo.vo.reply;

import lombok.Data;

@Data
public class ReplyVO {
    private Long id;
    private Long replierID;
    private String content;
    private int floor;
}
