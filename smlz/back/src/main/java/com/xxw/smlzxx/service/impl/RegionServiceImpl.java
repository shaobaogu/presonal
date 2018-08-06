package com.xxw.smlzxx.service.impl;

import com.xxw.smlzxx.entity.Region;
import com.xxw.smlzxx.repository.RegionRepository;
import com.xxw.smlzxx.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getRegionList(){
        List<Region> regionList = new ArrayList<Region>();
        regionList = regionRepository.findAll();
        return regionList;
    }

    public List<Region> getLevelOne(Integer level){
        List<Region> regionList = new ArrayList<Region>();
        regionList = regionRepository.findByLevel(level);
        return regionList;
    }

    public List<Region> getType(String type){
        List<Region> regions = new ArrayList<Region>();
        regions = regionRepository.findByType(type);
        return regions;
    }

    public Region getCurrenRegion(Integer id){
        return regionRepository.findOne(id);
    }

    public Region saveRegion(Region region){
        return regionRepository.save(region);
    }

    public void delRegion(Integer id){
        regionRepository.deleteById(id);
    }
}
