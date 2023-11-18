package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.PostDao;
import org.sleepy.hmmusicbox.dao.ReplyDao;
import org.sleepy.hmmusicbox.pojo.entity.PostEntity;
import org.sleepy.hmmusicbox.pojo.entity.ReplyEntity;
import org.sleepy.hmmusicbox.service.PostService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDao postDao;
    private final ReplyDao replyDao;

    @Override
    public void addTestPost() {
        PostEntity postEntity = PostEntity.builder().title("Test").content("Test Content.").posterID(1L).build();
        postDao.save(postEntity);
    }

    @Override
    public void addTestPostReply() {
        PostEntity postEntity = postDao.findById(1L).get();
        ReplyEntity replyEntity = ReplyEntity.builder().content("Test Content.").replierID(1L).floor(1).build();

        postEntity.getReplies().add(replyEntity);
        postDao.save(postEntity);
    }
}
