package com.caiths.caiapisdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.caiths.caiapisdk.utils.SignUtil;
import com.caiths.caiapisdk.model.User;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CaiApiClient {
    private String accessKey;
    private String secretKey;

    public static final String GATEWAY_HOST = "http://localhost:8123";

    // 通过 User 对象构造 CaiApiClient
    public CaiApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    // 用户调用的 GET 请求方法
    public String getNameByGet(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.get(GATEWAY_HOST+"/api/name/get", paramMap);
        System.out.println(result);
        return result;
    }

    // 用户调用的 POST 请求方法
    public String getNameByPost( String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.post(GATEWAY_HOST+"/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    // 用户调用的发送带签名信息的 POST 请求方法
    public String getUserNameByPost( User user) throws UnsupportedEncodingException {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST+"/api/name/user/")
                .addHeaders(getHeaderMap(json))
                .body(json)//将json字符设置为请求体
                .execute();//请求执行返回是respone对象
        System.out.println(httpResponse.getStatus());
        String result =httpResponse.body();
        System.out.println(result);
        return result;
    }

    // 自动生成签名和头部信息
    private Map<String, String> getHeaderMap(String body) throws UnsupportedEncodingException {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        hashMap.put("sign", SignUtil.genSign(body, secretKey));
        hashMap.put("body", URLEncoder.encode(body, StandardCharsets.UTF_8.name()));
        hashMap.put("nonce", RandomUtil.randomNumbers(5));
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        // 打印生成的头部信息，确保 accessKey 被正确加入
        // System.out.println("Generated Headers: " + hashMap);
        return hashMap;
    }
}
