package org.sleepy.hmmusicbox.controller;

import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.exception.BizException;
import org.sleepy.hmmusicbox.exception.CommonErrorType;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelDTOVO;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelVO;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.pojo.vo.post.PostVO;
import org.sleepy.hmmusicbox.service.ChannelService;
import org.sleepy.hmmusicbox.service.PostService;
import org.sleepy.hmmusicbox.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
@RequestMapping("/channel")
public class ChannelController {
    private final ChannelService channelService;
    private final PostService postService;
    private final UserService userService;


    @GetMapping("/search/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<ChannelDTOVO> searchChannel(@PathVariable("name") String name) {
        return channelService.searchChannel(name);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ChannelVO getChannelDetail(@PathVariable("id") Long id) {
        return channelService.getChannelDetail(id);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createChannel(@RequestBody ChannelVO channel) {
        channelService.addChannel(channel.getTitle(), channel.getImg());
    }

    @GetMapping("/recommend")
    @ResponseStatus(HttpStatus.FOUND)
    public List<ChannelDTOVO> recommendChannel() {
        return channelService.recommendChannel();
    }

    @GetMapping("/show")
    @ResponseStatus(HttpStatus.FOUND)
    public List<ChannelDTOVO> showChannel() {
        return channelService.showChannel();
    }

    @PostMapping("/post/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addPost(@RequestBody PostVO post, @PathVariable("id") Long id) {
        if(StpUtil.isLogin()) {
            return channelService.addPost(id, post.getTitle(), post.getContent(), StpUtil.getLoginId().toString());
        } else {
            throw new BizException(CommonErrorType.UNAUTHORIZED, "Can't post while not logged in.");
        }

    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<PostVO> showPosts(@PathVariable("id") Long id) {
        return channelService.getPosts(id);
    }
    @DeleteMapping("/deletePost/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }
}
