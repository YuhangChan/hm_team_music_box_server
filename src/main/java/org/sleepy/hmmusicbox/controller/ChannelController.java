package org.sleepy.hmmusicbox.controller;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelDTOVO;
import org.sleepy.hmmusicbox.pojo.vo.channel.ChannelVO;
import org.sleepy.hmmusicbox.pojo.vo.music.MusicVO;
import org.sleepy.hmmusicbox.pojo.vo.post.PostVO;
import org.sleepy.hmmusicbox.service.ChannelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
@RequestMapping("/channel")
public class ChannelController {
    private final ChannelService channelService;

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
    public void createMusic(@RequestBody ChannelVO channel) {
        channelService.addChannel(channel.getTitle());
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
    public void addPost(@RequestBody PostVO post, @PathVariable("id") Long id) {
        channelService.addPost(id, post.getTitle(), post.getContent(), post.getPosterID());
    }
}
