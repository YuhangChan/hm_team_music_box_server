package org.sleepy.hmmusicbox.controller;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.service.MusicService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor //用于自动生成带有所有非 final 和非 @NonNull 注解的成员变量的构造函数
public class TestController {
    private final MusicService musicService;

    @GetMapping("/test")
    public String test() {

        String name = "Test Name";
        String album = "Test Album";
        String singer = "Test Singer";
        musicService.addMusic(name, album, singer);
        String name1 = "Test Name1";
        String album1 = "Test Album1";
        String singer1 = "Test Singer1";
        musicService.addMusic(name, album, singer);
        String name2 = "Test Name2";
        String album2 = "Test Album2";
        String singer2 = "Test Singer2";
        musicService.addMusic(name, album, singer);
        return "hello9";
    }
}
