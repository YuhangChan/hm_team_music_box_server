package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.ChannelDao;
import org.sleepy.hmmusicbox.dao.PostDao;
import org.sleepy.hmmusicbox.mapper.ChannelDTOMapper;
import org.sleepy.hmmusicbox.mapper.ChannelMapper;
import org.sleepy.hmmusicbox.mapper.PostMapper;
import org.sleepy.hmmusicbox.pojo.entity.ChannelEntity;
import org.sleepy.hmmusicbox.pojo.entity.ChannelEntityDTO;
import org.sleepy.hmmusicbox.pojo.entity.PostEntity;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelDTOVO;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelVO;
import org.sleepy.hmmusicbox.pojo.vo.post.PostVO;
import org.sleepy.hmmusicbox.service.ChannelService;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {
    private final ChannelDao channelDao;
    private final PostDao postDao;
    @Override
    public void addTestChannel() {
        ChannelEntity channelEntity = ChannelEntity.builder().title("Test").build();
        channelDao.save(channelEntity);
    }

    @Override
    public void addChannel(String title, URL img){
        ChannelEntity channelEntity = ChannelEntity.builder().title(title).img(img).subscriberCount(0).build();
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
        List<ChannelEntityDTO> searchResult = channelDao.findAllDetails();
        List<ChannelDTOVO> list = new ArrayList<>();
        for(int i = 0; i < searchResult.size(); i++) {
            list.add(mapper.toChannelDTOVO(searchResult.get(i)));
        }
        return list;
    }

    @Override
    public List<ChannelDTOVO> showChannel() {
        ChannelDTOMapper mapper = ChannelDTOMapper.INSTANCE;
        List<ChannelEntityDTO> searchResult = channelDao.findAllDetails();
        List<ChannelDTOVO> list = new ArrayList<>();
        for (ChannelEntityDTO channelEntityDTO : searchResult) {
            list.add(mapper.toChannelDTOVO(channelEntityDTO));
        }
        return list;
    }
    @Override
    public Long addPost(Long id, String title, String content, Long userId) {
        ChannelEntity channel = channelDao.findByIdIs(id);
        PostEntity post = PostEntity.builder().posterID(userId).content(content).title(title).replies(new ArrayList<>()).build();
        channel.getPosts().add(post);
        post.setChannel(channel);
        channelDao.save(channel);
        return post.getId();
    }

    @Override
    public List<PostVO> getPosts(Long id) {
        ChannelEntity channel = channelDao.findByIdIs(id);
        PostMapper postMapper = PostMapper.INSTANCE;
        List<PostEntity> posts = channel.getPosts();
        List<PostVO> postVOS = new ArrayList<>();
        for (PostEntity post: posts) {
            postVOS.add(postMapper.toPostVO(post));
        }
        return postVOS;
    }

}
