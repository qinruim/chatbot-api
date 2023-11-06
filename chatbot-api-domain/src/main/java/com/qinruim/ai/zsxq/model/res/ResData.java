package com.qinruim.ai.zsxq.model.res;

import com.qinruim.ai.zsxq.model.vo.Topics;

import java.util.List;

/**
 * @Author: qinrui
 * @Date 2023-11-06 20:10
 * @description: 响应数据
 */
public class ResData {
    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
}
