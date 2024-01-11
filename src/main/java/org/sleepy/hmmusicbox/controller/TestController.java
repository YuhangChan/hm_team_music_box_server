package org.sleepy.hmmusicbox.controller;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.service.*;
import org.springframework.web.bind.annotation.*;
import cn.dev33.satoken.stp.StpUtil;

import java.io.IOException;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor //用于自动生成带有所有非 final 和非 @NonNull 注解的成员变量的构造函数
public class TestController {
    private final MusicService musicService;
    private final ChannelService channelService;
    private final PostService postService;
    private final ReplyService replyService;
    private final UserService userService;
    private final TalkService talkService;

    @GetMapping("/test")
    public MusicVO test() {
        String name = "Test Name";
        String album = "Test Album";
        String singer = "Test Singer";
        String detail = "Detail";
        String imageUrl = "https://news.walkerplus.com/article/157072/903058_615.jpg";
        musicService.addMusic(name, album, singer, detail, imageUrl);
        return musicService.getTestMusic();
    }


    @GetMapping("/test/channel")
    public String testChannel() {
//        channelService.addChannel("aaa", "www.baidu.com");
        return "Test Channel.";
    }

    @GetMapping("/test/post")
    public String testPost() {
        postService.addTestPost();
        return "Test Post.";
    }

    @GetMapping("/test/reply")
    public String testReply() {
        replyService.addTestReply();
        return "Test Reply.";
    }

    @GetMapping("/test/post-reply")
    public String testPostReply() {
        postService.addTestPostReply();
        return "Test Post Reply.";
    }

    @GetMapping("/test/music-like")
    public String testMusicLike() {
        StpUtil.checkLogin();
        userService.like(String.valueOf(StpUtil.getLoginId()), 1l);
        return "testMusicLike";
    }

    @GetMapping("/test/talk")
    public String talk() throws IOException {
        return talkService.talk("一闪一闪亮晶晶");
    }

}
