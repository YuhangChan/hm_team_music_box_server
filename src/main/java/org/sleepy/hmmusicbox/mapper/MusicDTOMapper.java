package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.entity.MusicEntityDTO;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicDTOVO;
@Mapper
public interface MusicDTOMapper {
    MusicDTOMapper INSTANCE = Mappers.getMapper(MusicDTOMapper.class);

    MusicDTOVO musicDTOVO(MusicEntityDTO musicEntityDTO);
}
