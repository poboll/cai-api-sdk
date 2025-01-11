package com.caiths.caiapisdk.service.impi;

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
 * @Author: QiMu
 * @Date: 2023年09月17日 08:42
 * @Version: 1.0
 * @Description:
 */
@Slf4j
public class ApiServiceImpl extends BaseService implements ApiService {

    @Override
    public PoisonousChickenSoupResponse getPoisonousChickenSoup() throws ApiException {
        PoisonousChickenSoupRequest request = new PoisonousChickenSoupRequest();
        return request(request);
    }

    @Override
    public PoisonousChickenSoupResponse getPoisonousChickenSoup(CaiApiClient qiApiClient) throws ApiException {
        PoisonousChickenSoupRequest request = new PoisonousChickenSoupRequest();
        return request(qiApiClient, request);
    }

    @Override
    public RandomWallpaperResponse getRandomWallpaper(RandomWallpaperRequest request) throws ApiException {
        return request(request);
    }

    @Override
    public RandomWallpaperResponse getRandomWallpaper(CaiApiClient qiApiClient, RandomWallpaperRequest request) throws ApiException {
        return request(qiApiClient, request);
    }

    @Override
    public LoveResponse randomLoveTalk() throws ApiException {
        LoveRequest request = new LoveRequest();
        return request(request);
    }

    @Override
    public LoveResponse randomLoveTalk(CaiApiClient qiApiClient) throws ApiException {
        LoveRequest request = new LoveRequest();
        return request(qiApiClient, request);
    }

    @Override
    public ResultResponse horoscope(HoroscopeRequest request) throws ApiException {
        return request(request);
    }

    @Override
    public ResultResponse horoscope(CaiApiClient qiApiClient, HoroscopeRequest request) throws ApiException {
        return request(qiApiClient, request);
    }

    @Override
    public ResultResponse getIpInfo(CaiApiClient qiApiClient, IpInfoRequest request) throws ApiException {
        return request(qiApiClient, request);
    }

    @Override
    public ResultResponse getIpInfo(IpInfoRequest request) throws ApiException {
        return request(request);
    }

    @Override
    public ResultResponse getWeatherInfo(CaiApiClient qiApiClient, WeatherRequest request) throws ApiException {
        return request(qiApiClient, request);
    }

    @Override
    public ResultResponse getWeatherInfo(WeatherRequest request) throws ApiException {
        return request(request);
    }
}
