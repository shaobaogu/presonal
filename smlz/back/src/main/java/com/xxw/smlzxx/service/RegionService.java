package com.xxw.smlzxx.service;

import com.xxw.smlzxx.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> getRegionList();
    List<Region> getLevelOne(Integer level);
    List<Region> getType(String type);
    Region getCurrenRegion(Integer id);
    Region saveRegion(Region region);
    void delRegion(Integer id);
}
