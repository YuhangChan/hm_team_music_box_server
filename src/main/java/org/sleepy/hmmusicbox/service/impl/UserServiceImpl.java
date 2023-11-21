package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.UserDao;
import org.sleepy.hmmusicbox.exception.BizError;
import org.sleepy.hmmusicbox.exception.BizException;
import org.sleepy.hmmusicbox.exception.CommonErrorType;
import org.sleepy.hmmusicbox.pojo.entity.UserEntity;
import org.sleepy.hmmusicbox.pojo.vo.user.UserVO;
import org.sleepy.hmmusicbox.service.UserService;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl {
//    private final UserDao userDao;
//
//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    @Override
//    public void register(String username, String phoneNumber, String password) {
//
//        UserEntity user = userDao.findByUsername(username);
//        if (user != null) {
//            throw new RuntimeException("用户名已存在");
//            //TODO:感觉异常类型之后细化
//        }
//
//        //我想实现注册时如果不填url和个性签名，系统默认分配，但是因为接口参数是固定的，无法用方法重载来实现。要么就写两个接口？
//        String encryptedPassword = passwordEncoder.encode(password);
//        userDao.save(UserEntity.builder()
//                .username(username)
//                .phoneNumber(phoneNumber)
//                .password(encryptedPassword)
//                .build());
//
//
//    }
//
//    @Override
//    public void loginByPhone(String phoneNumber, String password) {
//        //TODO:userDao.findByPhone
//    }
//
//    @Override
//    public void loginByUserName(String username, String password) {
//        UserEntity user = userDao.findByUsername(username);
//        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
//            throw new BizException(BizError.INVALID_CREDENTIAL);
//        }
//    }
//
//
//    @Override
//    public UserVO findByUserName(String username) {
//        UserEntity user=userDao.findByUsername(username);
//        return UserVO.builder()
//                .username(user.getUsername())
//                .phoneNumber(user.getPhoneNumber())
//                .avatarURL(user.getAvatarURL())
//                .profile(user.getProfile())
//                .build();
//    }
//
//    @Override
//    public void editInfo(String username, String name, String phoneNumber,String profile, String avatarURL) {
//        UserEntity user = userDao.findByUsername(username);
//        if(user == null){
//            throw new BizException(CommonErrorType.ILLEGAL_ARGUMENTS, "用户不存在");
//        }
//        userDao.save(user.setUsername(username).setName(name).setPhoneNumber(phoneNumber).setProfile(profile).setAvatarURL(avatarURL));
//    }
}
