package com.qinruim.ai.zsxq.model.req;

/**
 * @Author: qinrui
 * @Date 2023-11-06 20:34
 * @description: 请求问答接口信息
 */
public class AnswerReq {
    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }
}
