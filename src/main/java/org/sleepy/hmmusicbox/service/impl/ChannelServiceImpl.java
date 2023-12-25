package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.ChannelDao;
import org.sleepy.hmmusicbox.mapper.ChannelDTOMapper;
import org.sleepy.hmmusicbox.mapper.ChannelMapper;
import org.sleepy.hmmusicbox.pojo.entity.ChannelEntity;
import org.sleepy.hmmusicbox.pojo.entity.ChannelEntityDTO;
import org.sleepy.hmmusicbox.pojo.entity.PostEntity;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelDTOVO;
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
    public List<ChannelDTOVO> searchChannel(String title) {
        ChannelDTOMapper mapper = ChannelDTOMapper.INSTANCE;
        List<ChannelEntityDTO> searchResult = channelDao.findByTitleContaining(title);
        List<ChannelDTOVO> list = new ArrayList<>();
        for(ChannelEntityDTO channelEntityDTO : searchResult) {
            list.add(mapper.toChannelDTOVO(channelEntityDTO));
        }
        return list;
    }

    @Override
    public ChannelVO getChannelDetail(Long id) {
        ChannelMapper mapper = ChannelMapper.INSTANCE;
        ChannelEntity result = channelDao.findByIdIs(id);
        return mapper.toChannelVO(result);
    }

    @Override
    public List<ChannelDTOVO> recommendChannel() {
        ChannelDTOMapper mapper = ChannelDTOMapper.INSTANCE;
        List<ChannelEntityDTO> searchResult = channelDao.findByTitleContaining("a");
        List<ChannelDTOVO> list = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            list.add(mapper.toChannelDTOVO(searchResult.get(0)));
        }
        return list;
    }

    @Override
    public List<ChannelDTOVO> showChannel() {
        ChannelDTOMapper mapper = ChannelDTOMapper.INSTANCE;
        List<ChannelEntityDTO> searchResult = channelDao.findByTitleContaining("a");
        List<ChannelDTOVO> list = new ArrayList<>();
        for(int i = 0; i < 15; i++) {
            list.add(mapper.toChannelDTOVO(searchResult.get(0)));
        }
        return list;
    }
    @Override
    public void addPost(Long id, String title, String content, Long userId) {
        ChannelEntity channel = channelDao.findByIdIs(id);
        PostEntity post = PostEntity.builder().posterID(userId).content(content).title(title).replies(new ArrayList<>()).build();
        channel.getPosts().add(post);
        post.setChannel(channel);
        channelDao.save(channel);
    }
}
