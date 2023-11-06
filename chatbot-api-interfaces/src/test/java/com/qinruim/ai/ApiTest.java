package com.qinruim.ai;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @Package： com.qinruim.ai
 * @Title: Test
 * @Author： qrpop
 * @Date： 2023-11-02 19:46
 * @description: 单元测试
 */
public class ApiTest {
    /**
     * 查询未回答的问题
     */
    @Test
    public void query_unanswered_questions() throws IOException {
        //httpClient：封装数据信息
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112818558154/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","zsxq_access_token=E5E28CF6-4D33-91BE-ED43-9DA83847B4D3_593C1DD7E6776C47; zsxqsessionid=709816cd622e1d50904e9d35cc185e12; abtest_env=product");
        get.addHeader("Content-Type","application/json; charset=UTF-8");

        //执行请求
        CloseableHttpResponse response = httpClient.execute(get);

        //若状态码是200
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            //将返回结果转成String
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    /**
     * 回答问题
     */
    @Test
    public void answer() throws IOException {
//        https://api.zsxq.com/v2/groups/51112818558154/topics?scope=unanswered_questions&count=20
        //httpClient：封装数据信息
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/588541458252884/answer");

        post.addHeader("cookie","zsxq_access_token=E5E28CF6-4D33-91BE-ED43-9DA83847B4D3_593C1DD7E6776C47; zsxqsessionid=709816cd622e1d50904e9d35cc185e12; abtest_env=product");
        post.addHeader("Content-Type","application/json; charset=UTF-8");
        //响应的json
        String paramJson = "{\"req_data\":{\"text\":\"努力向上！\\n\",\"image_ids\":[],\"silenced\":false}}";
        //封装信息
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);

        //若状态码是200
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            //将返回结果转成String
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}
