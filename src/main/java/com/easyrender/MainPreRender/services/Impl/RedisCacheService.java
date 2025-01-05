package com.easyrender.MainPreRender.services.Impl;

import com.easyrender.MainPreRender.model.CacheDataModel;
import com.easyrender.MainPreRender.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RedisCacheService implements CacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public <T> T fetchFromDb(String websiteDomain, String websiteUrl) {
        HashOperations<String, String, CacheDataModel> hashOperations = redisTemplate.opsForHash();
        Object redisOutput = hashOperations.get(websiteDomain, websiteUrl);
        return (T) objectMapper.convertValue(redisOutput, CacheDataModel.class);
    }

    @Override
    public <T> boolean updateFromDb(T data) {
        return false;
    }

    @Override
    public <T> boolean deleteFromDb(T data) {
        return false;
    }

    @Override
    public <T> boolean existsFromDb(T data) {
        return false;
    }

    @Override
    public <T> T loadFromDb(T data) {
        return null;
    }
}
