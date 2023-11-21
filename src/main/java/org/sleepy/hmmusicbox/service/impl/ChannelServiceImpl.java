package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.ChannelDao;
import org.sleepy.hmmusicbox.mapper.ChannelMapper;
import org.sleepy.hmmusicbox.pojo.entity.ChannelEntity;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelVO;
import org.sleepy.hmmusicbox.service.ChannelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {
    private final ChannelDao channelDao;
    @Override
    public void addTestChannel() {
        ChannelEntity channelEntity = ChannelEntity.builder().title("Test").build();
        channelDao.save(channelEntity);
    }

    @Override
    public void addChannel(String title){
        ChannelEntity channelEntity = ChannelEntity.builder().title(title).subscriberCount(0).build();
        channelDao.save(channelEntity);
    }


    @Override
    public List<ChannelVO> searchChannel(String title) {
        ChannelMapper mapper = ChannelMapper.INSTANCE;
        List<ChannelEntity> searchResult = channelDao.findByTitleContaining(title);
        List<ChannelVO> list = new ArrayList<>();
        for(ChannelEntity channelEntity : searchResult) {
            list.add(mapper.toChannelVO(channelEntity));
        }
        return list;
    }
}
