package com.qinruim.ai.zsxq;

import java.io.IOException;

/**
 * @Package： com.qinruim.ai
 * @Title: ZsxqApi
 * @Author： qrpop
 * @Date： 2023-11-06 16:46
 * @description: 知识星球api接口
 */
public interface ZsxqApi {
    void queryUnAnsweredQuestionsTopicIds() throws IOException;
}

