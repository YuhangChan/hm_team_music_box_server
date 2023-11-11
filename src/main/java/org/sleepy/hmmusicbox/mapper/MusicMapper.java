package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.entity.MusicEntity;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;

@Mapper
public interface MusicMapper {
    MusicMapper INSTANCE = Mappers.getMapper(MusicMapper.class);

    MusicVO toMusicVO(MusicEntity musicEntity);
}
