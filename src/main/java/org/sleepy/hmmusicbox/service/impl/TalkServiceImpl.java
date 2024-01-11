package org.sleepy.hmmusicbox.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
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
import java.io.IOException;
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
    public String talk(String input) throws IOException {
//        1、创建HttpClient对象
        HttpClient httpClient = HttpClientBuilder.create().build();
//        2、创建请求方式的实例
        HttpPost httpPost = new HttpPost("http://10.58.0.2:6678/v1/chat/completions");
//        3、添加请求参数(设置请求和传输超时时间)
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
//        设置请求参数
        String prompt = "下面几首是我喜欢的歌，你能给我推荐更多吗？";
        input = prompt + input;
        String jsonInputString = "{ \"model\": \"ChatGLM3-6B\", \"max_tokens\": 2048, \"top_p\": 1, \"temperature\": 1, \"messages\": [ { \"role\": \"user\", \"content\": \"" + input + "\" } ] }";
        httpPost.setEntity(new StringEntity(jsonInputString, "UTF-8"));
//        4、发送Http请求
        HttpResponse response = httpClient.execute(httpPost);
//        5、获取返回的内容
        String result = null;
        int statusCode = response.getStatusLine().getStatusCode();
        if (200 == statusCode) {
            result = EntityUtils.toString(response.getEntity());
        } else {
            return null;
        }
//        6、释放资源
        httpPost.abort();
        httpClient.getConnectionManager().shutdown();
        JSONObject object = JSONObject.parseObject(result);
        return object.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .get("content").toString();
    }

}
