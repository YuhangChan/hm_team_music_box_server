package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.entity.ChannelEntity;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelVO;

@Mapper
public interface ChannelMapper {
    ChannelMapper INSTANCE  = Mappers.getMapper(ChannelMapper.class);

    ChannelVO toChannelVO(ChannelEntity channelEntity);
}
