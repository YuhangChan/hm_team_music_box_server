package org.sleepy.hmmusicbox.service.impl;

import lombok.RequiredArgsConstructor;
import org.sleepy.hmmusicbox.dao.TalkDao;
import org.sleepy.hmmusicbox.mapper.TalkMapper;
import org.sleepy.hmmusicbox.pojo.entity.TalkEntity;
import org.sleepy.hmmusicbox.pojo.vo.talk.TalkVO;
import org.sleepy.hmmusicbox.service.MusicService;
import org.sleepy.hmmusicbox.service.TalkService;
import org.sleepy.hmmusicbox.service.UserService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TalkServiceImpl implements TalkService {
    private final TalkDao talkDao;
    private final UserService userService;
    @Override
    public void talk(String input, String username) {
        TalkMapper mapper = TalkMapper.INSTANCE;
        try {
            URL url = new URL("http://10.58.0.2:6678/v1/chat/completions");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // 设置请求方法为 POST
            con.setRequestMethod("POST");

            // 设置请求头
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer some_key");

            // 启用输入输出
            con.setDoOutput(true);
            con.setDoInput(true);

            // 构建请求体数据
            String jsonInputString = "{ \"model\": \"ChatGLM3-6B\", \"max_tokens\": 2048, \"top_p\": 1, \"temperature\": 1, \"messages\": [ { \"role\": \"system\", \"content\": \"You are a helpful assistant.\" }, { \"role\": \"user\", \"content\": \"" + input + "\" } ] }";

            // 发送请求
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
//                TalkEntity talkEntity = TalkEntity.builder().content(input).sender(username).build();
                userService.addTalkHistory(username, input);
//                talkDao.save(talkEntity);
                wr.write(jsonInputString.getBytes());
            }

            // 读取响应
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
//                // 读取错误响应
//                try (BufferedReader errorIn = new BufferedReader(new InputStreamReader(con.getErrorStream()))) {
//                    String line;
//                    StringBuilder errorResponse = new StringBuilder();
//                    while ((line = errorIn.readLine()) != null) {
//                        errorResponse.append(line);
//                    }
//                    System.out.println("Error response: " + errorResponse.toString());
//                }

                con.disconnect();
                userService.addTalkHistory("ChatGLM3-6B", response.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
