package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.ChannelEntity;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelDao extends JpaRepository<ChannelEntity, Long> {
}
