package com.qinruim.ai.zsxq.model.aggregates;

import com.qinruim.ai.zsxq.model.res.ResData;

/**
 * @Author: qinrui
 * @Date 2023-11-06 20:08
 * @description: 待回答问题聚合信息
 */
public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;
    private ResData resp_data;  //变量名与相应的json保持一致 便于自动转换

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public ResData getResp_data() {
        return resp_data;
    }

    public void setResp_data(ResData resp_data) {
        this.resp_data = resp_data;
    }
}
