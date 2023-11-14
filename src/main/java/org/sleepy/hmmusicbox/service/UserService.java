package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.pojo.vo.user.UserVO;

public interface UserService {

    void loginByPhone(String phoneNumber, String password);

    void loginByName(String username, String password);

    void register(String username, String phoneNumber,String password);

    UserVO findByUserName(String username);

    void editInfo(String username, String name, String phoneNumber, String avatarURL);

    //TODO:获取关注获取粉丝列表？
}