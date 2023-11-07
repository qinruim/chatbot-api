package com.qinruim.ai.zsxq.service;

import com.alibaba.fastjson.JSON;
import com.qinruim.ai.zsxq.IZsxqApi;
import com.qinruim.ai.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.qinruim.ai.zsxq.model.req.AnswerReq;
import com.qinruim.ai.zsxq.model.req.ReqData;
import com.qinruim.ai.zsxq.model.res.AnswerRes;
import net.sf.json.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author: qinrui
 * @Date 2023-11-06 20:15
 * @description:
 */
@Service
public class ZsxqApi implements IZsxqApi {
    private Logger logger = LoggerFactory.getLogger(ZsxqApi.class);

    @Override
    public UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicIds(String groupId, String cookie) throws IOException {
        //httpClient：封装数据信息
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/" + groupId +"/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie",cookie);
        get.addHeader("Content-Type","application/json; charset=UTF-8");

        //执行请求
        CloseableHttpResponse response = httpClient.execute(get);

        //若状态码是200
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            //将返回结果由实体转成jsonString
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("拉取提问数据。 groupId：{} jsonStr: {}",groupId,jsonStr);
            //json转成指定对象
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = JSON.parseObject(jsonStr, UnAnsweredQuestionsAggregates.class);
            return unAnsweredQuestionsAggregates;
        }else {
            throw new RuntimeException("queryUnAnsweredQuestionsTopicIds err code is : " + response.getStatusLine().getStatusCode());
        }
    }

    @Override
    public boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException {
        //httpClient：封装数据信息
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/" + topicId + "/answer");

        post.addHeader("cookie",cookie);
        post.addHeader("Content-Type","application/json; charset=UTF-8");
        post.addHeader("user-agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Mobile Safari/537.36 Edg/119.0.0.0");

        //封装请求信息为json，再转成实体
        AnswerReq answerReq = new AnswerReq(new ReqData(text,silenced));
        String paramJson = JSONObject.fromObject(answerReq).toString();
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));

        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        //若状态码是200
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            //将返回结果转成String
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("回答问题结果。 groupId：{} topicId : {} jsonStr: {}",groupId,topicId,jsonStr);
            AnswerRes answerRes = JSON.parseObject(jsonStr, AnswerRes.class);
            return answerRes.isSucceeded();
        }else {
            throw new RuntimeException("answer err code is : " + response.getStatusLine().getStatusCode());
        }
    }
}
