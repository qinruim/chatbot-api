package com.qinruim.ai;

import com.alibaba.fastjson.JSON;
import com.qinruim.ai.zsxq.IZsxqApi;
import com.qinruim.ai.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.qinruim.ai.zsxq.model.vo.Topics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author: qinrui
 * @Date 2023-11-06 20:57
 * @description: 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;
    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicIds(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResData().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId: {} text : {}",topicId,text);
        }


        //回答问题
//        Topics topic1 = topics.get(0);
//        String topicId = topic1.getTopic_id();
//        String text = topic1.getQuestion().getText();
//        String answerText = text + "的答案是： 我也不知道！";
//        logger.info("topicId: {} text : {} answerText : {}",topicId,text,answerText);
//        zsxqApi.answer(groupId,cookie,topicId,answerText,false);

    }

}
