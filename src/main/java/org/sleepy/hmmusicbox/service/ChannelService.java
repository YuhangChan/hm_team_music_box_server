package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelVO;

import java.util.List;

public interface ChannelService {
    public void addTestChannel();

    public void addChannel();

    public List<ChannelVO> searchChannel(String title);

}
