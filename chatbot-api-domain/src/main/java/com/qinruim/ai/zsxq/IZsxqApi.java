package com.qinruim.ai.zsxq;

import com.qinruim.ai.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @Package： com.qinruim.ai
 * @Title: ZsxqApi
 * @Author： qrpop
 * @Date： 2023-11-06 16:46
 * @description: 知识星球api接口
 */
public interface IZsxqApi {
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicIds(String groupId,String cookie) throws IOException;
    boolean answer(String groupId,String cookie,String topicId,String text,boolean silenced) throws IOException;
}

