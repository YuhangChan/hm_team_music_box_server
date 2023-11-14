package org.sleepy.hmmusicbox.controller;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
public class SearchController {
    private final MusicService musicService;

    @GetMapping("/music/search/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<MusicVO> searchMusic(@PathVariable("name") String name) {
        return musicService.searchMusic(name);
    }
}
