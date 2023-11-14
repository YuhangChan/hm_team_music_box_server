package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.entity.MusicDetailEntity;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicDetailVO;

@Mapper
public interface MusicDetailMapper {
    MusicDetailMapper INSTANCE = Mappers.getMapper(MusicDetailMapper.class);
    MusicDetailVO toMusicDetailVO(MusicDetailEntity musicDetailEntity);
}

