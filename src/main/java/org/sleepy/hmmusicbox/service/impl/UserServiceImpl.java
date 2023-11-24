package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.MusicDao;
import org.sleepy.hmmusicbox.dao.UserDao;
import org.sleepy.hmmusicbox.exception.BizError;
import org.sleepy.hmmusicbox.exception.BizException;
import org.sleepy.hmmusicbox.exception.CommonErrorType;
import org.sleepy.hmmusicbox.mapper.MusicMapper;
import org.sleepy.hmmusicbox.pojo.entity.MusicEntity;
import org.sleepy.hmmusicbox.pojo.entity.UserEntity;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.pojo.vo.user.UserVO;
import org.sleepy.hmmusicbox.service.UserService;
import org.springframework.stereotype.Service;

import cn.dev33.satoken.secure.BCrypt;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final MusicDao musicDao;

    @Override
    public void register(String username, String phoneNumber, String password) {

        UserEntity user = userDao.findByUsername(username);
        if (user != null) {
            throw new RuntimeException("用户名已存在");
            //TODO:感觉异常类型之后细化
        }

        //我想实现注册时如果不填url和个性签名，系统默认分配，但是因为接口参数是固定的，无法用方法重载来实现。要么就写两个接口？
        String encryptedPassword = BCrypt.hashpw(password);
        userDao.save(UserEntity.builder()
                .username(username)
                .phoneNumber(phoneNumber)
                .password(encryptedPassword)
                .build());


    }

    @Override
    public void loginByPhone(String phoneNumber, String password) {
        //TODO:userDao.findByPhone
    }

    @Override
    public void loginByUserName(String username, String password) {
        UserEntity user = userDao.findByUsername(username);
        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
            throw new BizException(BizError.INVALID_CREDENTIAL);
        }
    }


    @Override
    public UserVO findByUserName(String username) {
        UserEntity user = userDao.findByUsername(username);
        return UserVO.builder()
                .username(user.getUsername())
                .phoneNumber(user.getPhoneNumber())
                .avatarURL(user.getAvatarURL())
                .profile(user.getProfile())
                .build();
    }

    @Override
    public void editInfo(String username, String name, String phoneNumber, String profile, String avatarURL) {
        UserEntity user = userDao.findByUsername(username);
        if (user == null) {
            throw new BizException(CommonErrorType.ILLEGAL_ARGUMENTS, "用户不存在");
        }
        userDao.save(user.setUsername(username).setName(name).setPhoneNumber(phoneNumber).setProfile(profile).setAvatarURL(avatarURL));
    }

    @Override
    public boolean like(String username, Long musicId) {
        UserEntity user = userDao.findByUsername(username);
        MusicEntity music = musicDao.findByIdIs(musicId);
        if (music == null) return false;

        Set<MusicEntity> likes = user.getLikes();
        likes.add(music);
        userDao.save(user);
        return true;
    }

    @Override
    public boolean unlike(String username, Long musicId) {
        UserEntity user = userDao.findByUsername(username);
        MusicEntity music = musicDao.findByIdIs(musicId);
        if (music == null) return false;

        Set<MusicEntity> likes = user.getLikes();
        if (!likes.contains(music)) return false;

        likes.remove(music);
        userDao.save(user);
        return true;
    }

    @Override
    public Set<MusicVO> getLikes(String username) {
        UserEntity user = userDao.findByUsername(username);
        return user.getLikes().stream().map(MusicMapper.INSTANCE::toMusicVO).collect(Collectors.toSet());
    }


}
