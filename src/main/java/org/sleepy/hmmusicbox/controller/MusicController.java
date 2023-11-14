package org.sleepy.hmmusicbox.controller;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicDetailVO;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
public class MusicController {
    private final MusicService musicService;

    @GetMapping("/music/search/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<MusicVO> searchMusic(@PathVariable("name") String name) {
        return musicService.searchMusic(name);
    }

    @GetMapping("music/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public MusicDetailVO getMusicDetail(@PathVariable("id") Long id) {
        return musicService.getMusicDetail(id);
    }
    @PostMapping(value = "/music/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMusic(@RequestBody MusicVO music, @RequestBody MusicDetailVO musicDetail) {
        musicService.addMusic(music.getName(), music.getAlbum(), music.getSinger());
        // TODO:add music detail with id
    }

}
