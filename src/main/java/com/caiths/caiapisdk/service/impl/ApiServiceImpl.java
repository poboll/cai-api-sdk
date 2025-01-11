package com.caiths.caiapisdk.service.impl;

import com.caiths.caiapisdk.client.CaiApiClient;
import com.caiths.caiapisdk.exception.ApiException;
import com.caiths.caiapisdk.model.request.*;
import com.caiths.caiapisdk.model.response.LoveResponse;
import com.caiths.caiapisdk.model.response.PoisonousChickenSoupResponse;
import com.caiths.caiapisdk.model.response.RandomWallpaperResponse;
import com.caiths.caiapisdk.model.response.ResultResponse;
import com.caiths.caiapisdk.service.ApiService;
import com.caiths.caiapisdk.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**
 * ApiServiceImpl 类，提供具体的 API 服务实现。
 * <p>
 * 该类继承自 BaseService，并实现了 ApiService 接口，提供了获取各种内容（如：鸡汤、壁纸、爱情语录等）的方法。
 * <p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Slf4j
public class ApiServiceImpl extends BaseService implements ApiService {

    /**
     * 获取一段毒鸡汤
     *
     * @return {@link PoisonousChickenSoupResponse} 毒鸡汤响应
     * @throws ApiException 业务异常
     */
    @Override
    public PoisonousChickenSoupResponse getPoisonousChickenSoup() throws ApiException {
        PoisonousChickenSoupRequest request = new PoisonousChickenSoupRequest();
        return request(request);
    }

    /**
     * 获取一段毒鸡汤
     *
     * @param caiApiClient CaiApiClient 客户端
     * @return {@link PoisonousChickenSoupResponse} 毒鸡汤响应
     * @throws ApiException 业务异常
     */
    @Override
    public PoisonousChickenSoupResponse getPoisonousChickenSoup(CaiApiClient caiApiClient) throws ApiException {
        PoisonousChickenSoupRequest request = new PoisonousChickenSoupRequest();
        return request(caiApiClient, request);
    }

    /**
     * 获取一张随机壁纸
     *
     * @param request 随机壁纸请求
     * @return {@link RandomWallpaperResponse} 随机壁纸响应
     * @throws ApiException 业务异常
     */
    @Override
    public RandomWallpaperResponse getRandomWallpaper(RandomWallpaperRequest request) throws ApiException {
        return request(request);
    }

    /**
     * 获取一张随机壁纸
     *
     * @param caiApiClient CaiApiClient 客户端
     * @param request 随机壁纸请求
     * @return {@link RandomWallpaperResponse} 随机壁纸响应
     * @throws ApiException 业务异常
     */
    @Override
    public RandomWallpaperResponse getRandomWallpaper(CaiApiClient caiApiClient, RandomWallpaperRequest request) throws ApiException {
        return request(caiApiClient, request);
    }

    /**
     * 获取一段随机爱情语录
     *
     * @return {@link LoveResponse} 爱情语录响应
     * @throws ApiException 业务异常
     */
    @Override
    public LoveResponse randomLoveTalk() throws ApiException {
        LoveRequest request = new LoveRequest();
        return request(request);
    }

    /**
     * 获取一段随机爱情语录
     *
     * @param caiApiClient CaiApiClient 客户端
     * @return {@link LoveResponse} 爱情语录响应
     * @throws ApiException 业务异常
     */
    @Override
    public LoveResponse randomLoveTalk(CaiApiClient caiApiClient) throws ApiException {
        LoveRequest request = new LoveRequest();
        return request(caiApiClient, request);
    }

    /**
     * 获取星座运势信息
     *
     * @param request 星座运势请求
     * @return {@link ResultResponse} 星座运势响应
     * @throws ApiException 业务异常
     */
    @Override
    public ResultResponse horoscope(HoroscopeRequest request) throws ApiException {
        return request(request);
    }

    /**
     * 获取星座运势信息
     *
     * @param caiApiClient CaiApiClient 客户端
     * @param request 星座运势请求
     * @return {@link ResultResponse} 星座运势响应
     * @throws ApiException 业务异常
     */
    @Override
    public ResultResponse horoscope(CaiApiClient caiApiClient, HoroscopeRequest request) throws ApiException {
        return request(caiApiClient, request);
    }

    /**
     * 获取IP信息
     *
     * @param caiApiClient CaiApiClient 客户端
     * @param request IP信息请求
     * @return {@link ResultResponse} IP信息响应
     * @throws ApiException 业务异常
     */
    @Override
    public ResultResponse getIpInfo(CaiApiClient caiApiClient, IpInfoRequest request) throws ApiException {
        return request(caiApiClient, request);
    }

    /**
     * 获取IP信息
     *
     * @param request IP信息请求
     * @return {@link ResultResponse} IP信息响应
     * @throws ApiException 业务异常
     */
    @Override
    public ResultResponse getIpInfo(IpInfoRequest request) throws ApiException {
        return request(request);
    }

    /**
     * 获取天气信息
     *
     * @param caiApiClient CaiApiClient 客户端
     * @param request 天气信息请求
     * @return {@link ResultResponse} 天气信息响应
     * @throws ApiException 业务异常
     */
    @Override
    public ResultResponse getWeatherInfo(CaiApiClient caiApiClient, WeatherRequest request) throws ApiException {
        return request(caiApiClient, request);
    }

    /**
     * 获取天气信息
     *
     * @param request 天气信息请求
     * @return {@link ResultResponse} 天气信息响应
     * @throws ApiException 业务异常
     */
    @Override
    public ResultResponse getWeatherInfo(WeatherRequest request) throws ApiException {
        return request(request);
    }
}
