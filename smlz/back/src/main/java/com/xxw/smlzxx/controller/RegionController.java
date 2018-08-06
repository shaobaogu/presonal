package com.xxw.smlzxx.controller;

import com.xxw.smlzxx.entity.Region;
import com.xxw.smlzxx.service.RegionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class RegionController {
    @Autowired
    private Region region;
    @Resource
    private RegionService regionService;

    @GetMapping("/get-regions")
    @ApiOperation(value = "获取信息列表")
    public List<Region> getRegionList(){
        return regionService.getRegionList();
    }

    @GetMapping("/get-region/{id}")
    @ApiOperation(value = "根据Id获取某个值")
    public Region getRegionOne(@PathVariable("id") Integer id){
        return regionService.getCurrenRegion(id);
    }

    @GetMapping("/get-level/{level}")
    @ApiOperation(value = "获取省行政区域")
    public List<Region> getLevelOne(@PathVariable("level") Integer level){
        return regionService.getLevelOne(level);
    }

    @GetMapping("/get-type")
    @ApiOperation(value = "分别获取省市县")
    public List<Region> geType(@RequestParam("type") String type){
        return regionService.getType(type);
    }

    @PostMapping("/save-region")
    @ApiOperation(value = "保存地址信息")
    public String saveRegion(Region region){
        regionService.saveRegion(region);
        return "保存成功";
    }

    @DeleteMapping("/del-region/{id}")
    @ApiOperation(value = "删除信息")
    public String deleteRegion(@PathVariable("id") Integer id){
        regionService.delRegion(id);
        return "删除成功";
    }
}
