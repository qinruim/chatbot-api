package com.qinruim.ai.zsxq.model.aggregates;

import com.qinruim.ai.zsxq.model.req.ReqData;
import com.qinruim.ai.zsxq.model.res.ResData;

/**
 * @Author: qinrui
 * @Date 2023-11-06 20:08
 * @description: 待回答问题聚合信息
 */
public class UnAnsweredQuestionsAggregates {
    private boolean succeed;
    private ResData resData;

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public ResData getResData() {
        return resData;
    }

    public void setResData(ResData resData) {
        this.resData = resData;
    }
}
