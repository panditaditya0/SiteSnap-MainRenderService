package com.easyrender.MainPreRender.services;

import com.easyrender.MainPreRender.model.CacheDataModel;

public interface CacheService {
    <T> T fetchFromDb(String websiteDomain, String websiteUrl);

    <T> boolean updateFromDb(T data);

    <T> boolean deleteFromDb(T data);

    <T> boolean existsFromDb(T data);

    <T> T loadFromDb(T data);
}
