package org.sleepy.hmmusicbox.controller;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.pojo.vo.talk.TalkVO;
import org.sleepy.hmmusicbox.service.*;
import org.springframework.http.HttpStatus;
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

    @PostMapping(value = "/test/talk",consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String talk(@RequestBody TalkVO talkVO) throws IOException {
        return "\"Roar\"是Katy Perry的一首充满力量感和鼓舞人心的流行歌曲，有着明快的节奏和易于记忆的副歌。以下是几首风格或氛围与\"Roar\"相似的英文歌曲推荐：\n" +
                "\n" +
                "1. **Firework** - Katy Perry\n" +
                "   同样来自Katy Perry，这首歌同样以其积极向上的歌词和强有力的旋律而著称。\n" +
                "\n" +
                "2. **Domino** - Jessie J\n" +
                "   节奏感强烈，旋律抓耳，Jessie J的嗓音爆发力十足，适合喜欢\"Roar\"那种节奏和能量的听众。\n" +
                "\n" +
                "3. **I Really Like You** - Carly Rae Jepsen\n" +
                "   这首歌节奏欢快，副歌部分朗朗上口，具有很强的感染力。\n" +
                "\n" +
                "4. **Fight Song** - Rachel Platten\n" +
                "   一首激励人心的独立女性之歌，带有强烈的自我肯定和坚韧不拔的情感表达。\n" +
                "\n" +
                "5. **Stronger (What Doesn't Kill You)** - Kelly Clarkson\n" +
                "   具有强大动力和自我提升主题的流行曲目，节奏激昂且副歌部分极具震撼力。\n" +
                "\n" +
                "6. **Break Free** - Ariana Grande ft. Zedd\n" +
                "   这首电子舞曲风的歌曲充满了活力和自信，非常适合想要释放自我、展现力量的时刻。\n" +
                "\n" +
                "7. **Can't Hold Us** - Macklemore & Ryan Lewis ft. Ray Dalton\n" +
                "   节奏快速且鼓舞人心，展现了克服挑战和勇往直前的精神。\n" +
                "\n" +
                "8. **Brave** - Sara Bareilles\n" +
                "   歌曲传递出勇敢表达自我的信息，其旋律和节奏都充满正能。\n" +
                "\n" +
                "以上这些歌曲在情感表达、音乐节奏以及带给听者的正面情绪上与\"Roar\"有异曲同工之处。";
    }

}
