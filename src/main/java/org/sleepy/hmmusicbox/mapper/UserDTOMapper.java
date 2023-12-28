package org.sleepy.hmmusicbox.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sleepy.hmmusicbox.pojo.entity.UserEntityDTO;
import org.sleepy.hmmusicbox.pojo.vo.user.UserDTOVO;

@Mapper
public interface UserDTOMapper {
    UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);
    UserDTOVO toUserDTOVO(UserEntityDTO userEntityDTO);
}
