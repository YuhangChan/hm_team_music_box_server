package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelDTOVO;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelVO;

import java.util.List;

public interface ChannelService {
    public void addTestChannel();

    public void addChannel(String title);

    public List<ChannelDTOVO> searchChannel(String title);

    public ChannelVO getChannelDetail(Long id);

    public List<ChannelDTOVO> recommendChannel();

    public List<ChannelDTOVO> showChannel();

}
