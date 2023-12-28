package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.ReplyDao;
import org.sleepy.hmmusicbox.pojo.entity.ReplyEntity;
import org.sleepy.hmmusicbox.service.ReplyService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReplyDao replyDao;
    @Override
    public void addTestReply() {
        ReplyEntity replyEntity = ReplyEntity.builder().content("Test Content.").build();
        replyDao.save(replyEntity);
    }

    @Override
    public void deleteReply(Long id) {
        replyDao.deleteById(id);
    }
}
