package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.entity.ChannelEntityDTO;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelDTOVO;

@Mapper
public interface ChannelDTOMapper {
    ChannelDTOMapper INSTANCE = Mappers.getMapper(ChannelDTOMapper.class);

    ChannelDTOVO toChannelDTOVO(ChannelEntityDTO channelEntityDTO);
}
