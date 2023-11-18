package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.ChannelDao;
import org.sleepy.hmmusicbox.pojo.entity.ChannelEntity;
import org.sleepy.hmmusicbox.service.ChannelService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {
    private final ChannelDao channelDao;
    @Override
    public void addTestChannel() {
        ChannelEntity channelEntity = ChannelEntity.builder().title("Test").build();
        channelDao.save(channelEntity);
    }
}
