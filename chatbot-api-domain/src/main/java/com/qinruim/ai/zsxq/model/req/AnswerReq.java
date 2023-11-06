package com.qinruim.ai.zsxq.model.req;

/**
 * @Author: qinrui
 * @Date 2023-11-06 20:34
 * @description: 请求问答接口信息
 */
public class AnswerReq {
    private ReqData reqData;

    public AnswerReq(ReqData reqData) {
        this.reqData = reqData;
    }

    public ReqData getReqData() {
        return reqData;
    }

    public void setReqData(ReqData reqData) {
        this.reqData = reqData;
    }
}
