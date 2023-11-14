package org.sleepy.hmmusicbox.service;

import org.sleepy.hmmusicbox.controller.PostController;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.pojo.vo.post.PostVO;
import org.sleepy.hmmusicbox.pojo.vo.user.UserVO;

import java.util.List;

public interface PostService {
    public void addPost(String title, UserVO user, String content);


    public List<PostVO> searchPost(String name);
}
