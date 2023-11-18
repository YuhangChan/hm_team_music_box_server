package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.entity.ReplyEntity;
import org.sleepy.hmmusicbox.pojo.vo.reply.ReplyVO;

@Mapper
public interface ReplyMapper {
    ReplyMapper INSTANCE = Mappers.getMapper(ReplyMapper.class);

    ReplyVO toReplyVO(ReplyEntity replyEntity);
}
