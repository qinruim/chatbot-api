package com.qinruim.ai.zsxq.model.aggregates;

import com.alibaba.fastjson.annotation.JSONField;
import com.qinruim.ai.zsxq.model.res.ResData;

/**
 * @Author: qinrui
 * @Date 2023-11-06 20:08
 * @description: 待回答问题聚合信息
 */
public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;

    //变量名与相应的json保持一致 便于自动转换
    //或者如这里所示 手动指定匹配 否则会NPE
    @JSONField(name="resp_data")
    private ResData resData;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public ResData getResData() {
        return resData;
    }

    public void setResData(ResData resData) {
        this.resData = resData;
    }
}
