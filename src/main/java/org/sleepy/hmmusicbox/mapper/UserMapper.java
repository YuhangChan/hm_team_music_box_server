package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.entity.UserEntity;
import org.sleepy.hmmusicbox.pojo.vo.user.UserVO;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserVO toUserVO(UserEntity userEntity);
}