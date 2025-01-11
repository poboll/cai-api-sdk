package com.caiths.caiapisdk.service;

import cn.hutool.http.HttpResponse;
import com.caiths.caiapisdk.client.CaiApiClient;
import com.caiths.caiapisdk.exception.ApiException;
import com.caiths.caiapisdk.model.request.*;
import com.caiths.caiapisdk.model.response.LoveResponse;
import com.caiths.caiapisdk.model.response.PoisonousChickenSoupResponse;
import com.caiths.caiapisdk.model.response.RandomWallpaperResponse;
import com.caiths.caiapisdk.model.response.ResultResponse;

/**
 * ApiService 接口，定义与 API 交互的核心方法。
 * <p>
 * 提供了与第三方 API 的通用请求方法及特定功能的实现，如获取毒鸡汤、随机壁纸等功能。
 * <p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
public interface ApiService {

    /**
     * 通用请求
     *
     * @param request 请求参数
     * @param <O>     请求参数的类型
     * @param <T>     响应数据的类型，必须继承 {@link ResultResponse}
     * @return {@link T} 返回泛型结果对象
     * @throws ApiException 业务异常
     */
    <O, T extends ResultResponse> T request(BaseRequest<O, T> request) throws ApiException;

    /**
     * 通用请求
     *
     * @param caiApiClient CaiApiClient 客户端
     * @param request      请求参数
     * @param <O>          请求参数的类型
     * @param <T>          响应数据的类型，必须继承 {@link ResultResponse}
     * @return {@link T} 返回泛型结果对象
     * @throws ApiException 业务异常
     */
    <O, T extends ResultResponse> T request(CaiApiClient caiApiClient, BaseRequest<O, T> request) throws ApiException;

    /**
     * 随机毒鸡汤
     *
     * @return {@link PoisonousChickenSoupResponse}
     * @throws ApiException 业务异常
     */
    PoisonousChickenSoupResponse getPoisonousChickenSoup() throws ApiException;

    /**
     * 喝毒鸡汤
     *
     * @param caiApiClient CaiApiClient 客户端
     * @return {@link PoisonousChickenSoupResponse}
     * @throws ApiException 业务异常
     */
    PoisonousChickenSoupResponse getPoisonousChickenSoup(CaiApiClient caiApiClient) throws ApiException;

    /**
     * 获取随机壁纸
     *
     * @param request 请求参数
     * @return {@link RandomWallpaperResponse}
     * @throws ApiException 业务异常
     */
    RandomWallpaperResponse getRandomWallpaper(RandomWallpaperRequest request) throws ApiException;

    /**
     * 获取随机壁纸
     *
     * @param caiApiClient CaiApiClient 客户端
     * @param request      请求参数
     * @return {@link RandomWallpaperResponse}
     * @throws ApiException 业务异常
     */
    RandomWallpaperResponse getRandomWallpaper(CaiApiClient caiApiClient, RandomWallpaperRequest request) throws ApiException;

    /**
     * 随意情话
     *
     * @return {@link LoveResponse}
     * @throws ApiException 业务异常
     */
    LoveResponse randomLoveTalk() throws ApiException;

    /**
     * 随意情话
     *
     * @param caiApiClient CaiApiClient 客户端
     * @return {@link LoveResponse}
     * @throws ApiException 业务异常
     */
    LoveResponse randomLoveTalk(CaiApiClient caiApiClient) throws ApiException;

    /**
     * 星座运势
     *
     * @param request 请求参数
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse horoscope(HoroscopeRequest request) throws ApiException;

    /**
     * 星座运势
     *
     * @param caiApiClient CaiApiClient 客户端
     * @param request      请求参数
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse horoscope(CaiApiClient caiApiClient, HoroscopeRequest request) throws ApiException;

    /**
     * 获取 IP 信息
     *
     * @param caiApiClient CaiApiClient 客户端
     * @param request      请求参数
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse getIpInfo(CaiApiClient caiApiClient, IpInfoRequest request) throws ApiException;

    /**
     * 获取 IP 信息
     *
     * @param request 请求参数
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse getIpInfo(IpInfoRequest request) throws ApiException;

    /**
     * 获取天气信息
     *
     * @param caiApiClient CaiApiClient 客户端
     * @param request      请求参数
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse getWeatherInfo(CaiApiClient caiApiClient, WeatherRequest request) throws ApiException;

    /**
     * 获取天气信息
     *
     * @param request 请求参数
     * @return {@link ResultResponse}
     * @throws ApiException 业务异常
     */
    ResultResponse getWeatherInfo(WeatherRequest request) throws ApiException;
}
