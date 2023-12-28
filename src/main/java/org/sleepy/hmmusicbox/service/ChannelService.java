package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelDTOVO;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelVO;
import org.sleepy.hmmusicbox.pojo.vo.post.PostVO;

import java.net.URL;
import java.util.List;

public interface ChannelService {
    public void addTestChannel();

    public void addChannel(String title, URL img);

    public List<ChannelDTOVO> searchChannel(String title);

    public ChannelVO getChannelDetail(Long id);

    public List<ChannelDTOVO> recommendChannel();

    public List<ChannelDTOVO> showChannel();

    public Long addPost(Long id, String title, String content, String username);

    public List<PostVO> getPosts(Long id);



}
