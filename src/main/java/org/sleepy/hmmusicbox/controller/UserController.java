package org.sleepy.hmmusicbox.controller;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1") //我也不是太清楚加这个有什么用
public class UserController {
    private final UserService userService;

}
