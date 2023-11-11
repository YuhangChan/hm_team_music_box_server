package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.entity.PostEntity;
import org.sleepy.hmmusicbox.pojo.vo.post.PostVO;

public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostVO toPostVO(PostEntity postEntity);
}
