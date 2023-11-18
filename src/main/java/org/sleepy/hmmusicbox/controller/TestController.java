package org.sleepy.hmmusicbox.controller;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.service.ChannelService;
import org.sleepy.hmmusicbox.service.MusicService;
import org.sleepy.hmmusicbox.service.PostService;
import org.sleepy.hmmusicbox.service.ReplyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor //用于自动生成带有所有非 final 和非 @NonNull 注解的成员变量的构造函数
public class TestController {
    private final MusicService musicService;
    private final ChannelService channelService;
    private final PostService postService;
    private final ReplyService replyService;

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
        channelService.addTestChannel();
        return "Test Channel.";
    }

    @GetMapping("/test/post")
    public String testPost(){
        postService.addTestPost();
        return "Test Post.";
    }

    @GetMapping("/test/reply")
    public String testReply(){
        replyService.addTestReply();
        return "Test Reply.";
    }

    @GetMapping("/test/post-reply")
    public String testPostReply(){
        postService.addTestPost();
        return "Test Post Reply.";
    }
}
