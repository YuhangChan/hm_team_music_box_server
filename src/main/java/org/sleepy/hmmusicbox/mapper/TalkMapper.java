package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.vo.talk.TalkVO;

@Mapper
public interface TalkMapper {
    TalkMapper INSTANCE = Mappers.getMapper(TalkMapper.class);

    TalkVO toTalkVO(TalkEntity talkEntity);
}
