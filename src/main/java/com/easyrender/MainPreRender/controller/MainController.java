package com.easyrender.MainPreRender.controller;

import com.easyrender.MainPreRender.model.CacheDataModel;
import com.easyrender.MainPreRender.services.ManageWebsiteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sites")
public class MainController {

    @Autowired
    public ManageWebsiteDataService manageWebsiteDataService;

    @PostMapping("/fetch")
    public ResponseEntity<?> fetch(@RequestParam String websiteDomain, @RequestParam String websiteUrl) {
        String pageSource = null;
        try{
            CacheDataModel cachedWebsiteData = manageWebsiteDataService.fetchFromCache(websiteDomain, websiteUrl);
            pageSource = (null == cachedWebsiteData) ? manageWebsiteDataService.renderWebsite(websiteUrl, websiteDomain) : cachedWebsiteData.getPageSource();
            if(null == pageSource){
                throw new RuntimeException();
            }
        } catch (Exception ex){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pageSource);
    }
}
