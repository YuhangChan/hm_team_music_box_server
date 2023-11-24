package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.pojo.vo.user.UserVO;

public interface UserService {

    void loginByPhone(String phoneNumber, String password);

    void loginByUserName(String username, String password);

    void register(String username, String phoneNumber,String password);

    UserVO findByUserName(String username);

    void editInfo(String username, String name, String phoneNumber, String profile,String avatarURL);

    boolean like(String username, Long musicId);

    boolean unlike(String username, Long musicId);
    //TODO:获取关注获取粉丝列表？
}