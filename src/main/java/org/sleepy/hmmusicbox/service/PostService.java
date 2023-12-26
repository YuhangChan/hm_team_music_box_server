package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.pojo.vo.reply.ReplyVO;

import java.util.List;

public interface PostService {
    public void addTestPost();
    public void addTestPostReply();
    public void addReply(Long postID, Long replierID, String content);
    public List<ReplyVO> showReply(Long id);

    public void deletePost(Long id);
}
