package org.sleepy.hmmusicbox.dao;

import org.sleepy.hmmusicbox.pojo.entity.ChannelEntity;
import org.sleepy.hmmusicbox.pojo.entity.ChannelEntityDTO;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChannelDao extends JpaRepository<ChannelEntity, Long> {
    @Query("SELECT new org.sleepy.hmmusicbox.pojo.entity.ChannelEntityDTO(e.id, e.title, e.subscriberCount, e.img) from ChannelEntity e where e.title like %:title%")
    List<ChannelEntityDTO> findByTitleContaining(@Param("title") String title);
    @Query
    ChannelEntity findByIdIs(Long id);
}
