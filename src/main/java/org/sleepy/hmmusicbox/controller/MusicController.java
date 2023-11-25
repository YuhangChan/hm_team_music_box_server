package org.sleepy.hmmusicbox.controller;

import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicDTOVO;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.service.MusicService;
import org.sleepy.hmmusicbox.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
public class MusicController {
    private final MusicService musicService;
    private final UserService userService;

    @GetMapping("/search/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<MusicDTOVO> searchMusic(@PathVariable("name") String name) {
        return musicService.searchMusic(name);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public MusicVO getMusicDetail(@PathVariable("id") Long id) {
        // 如果用户登录了，则添加到TA的历史记录
        if (StpUtil.isLogin()) {
            userService.addToHistory(String.valueOf(StpUtil.getLoginId()), id);
        }
        return musicService.getMusicDetail(id);
    }
    @PostMapping(value = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMusic(@RequestBody MusicVO music) {
        musicService.addMusic(music.getName(), music.getAlbum(), music.getSinger(), music.getDetail(), music.getImageUrl());
    }

//    @DeleteMapping("/deleteAll")
//    public void deleteAll() {
//        musicService.deleteAll();
//    }

}
