package com.easyrender.MainPreRender.services;

import com.easyrender.MainPreRender.model.CacheDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageWebsiteDataService {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private RenderService renderService;


    public CacheDataModel fetchFromCache(String websiteDomain, String websiteUrl) {
        CacheDataModel websiteData = cacheService.fetchFromDb(websiteDomain, websiteUrl);
        return websiteData;
    }

    public String renderWebsite(String websiteUrl, String websiteDomain) {
        return renderService.getPageSource(websiteUrl, websiteDomain);
    }
}
