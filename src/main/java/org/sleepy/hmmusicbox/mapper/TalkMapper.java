package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.entity.ReplyEntity;
import org.sleepy.hmmusicbox.pojo.entity.TalkEntity;
import org.sleepy.hmmusicbox.pojo.vo.reply.ReplyVO;
import org.sleepy.hmmusicbox.pojo.vo.talk.TalkVO;

@Mapper
public interface TalkMapper {
    TalkMapper INSTANCE = Mappers.getMapper(TalkMapper.class);

    TalkVO toTalkVO(TalkEntity talkEntity);
}
