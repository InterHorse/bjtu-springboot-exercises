package cn.interhorse.springboot.bjtu.controller;

import cn.interhorse.springboot.bjtu.dao.mapper.MileageDetailsMapper;
import cn.interhorse.springboot.bjtu.entity.ResponseBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * @author Yuzhe Ma
 * @date 2020/7/30
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @Resource
    private MileageDetailsMapper mileageDetailsMapper;

    @ResponseBody
    @RequestMapping(value = "/birthYearInterval", method = RequestMethod.GET)
    private ResponseBO getBirthYearInterval(HttpServletRequest httpServletRequest) {
        String start = httpServletRequest.getParameter("start");
        String end = httpServletRequest.getParameter("end");
        if (StringUtils.isBlank(start)) {
            start = "1800";
        }

        if (StringUtils.isBlank(end)) {
            start = "3000";
        }
        int startInt = Integer.parseInt(start);
        int endInt = Integer.parseInt(end);
        return new ResponseBO(mileageDetailsMapper.selectByYearsInterval(startInt, endInt));
    }

    @ResponseBody
    @RequestMapping(value = "/milesInterval", method = RequestMethod.GET)
    private ResponseBO getMilesInterval(HttpServletRequest httpServletRequest) {
        String start = httpServletRequest.getParameter("start");
        String end = httpServletRequest.getParameter("end");
        if (StringUtils.isBlank(start)) {
            start = "0";
        }

        if (StringUtils.isBlank(end)) {
            start = "99999999";
        }
        int startInt = Integer.parseInt(start);
        int endInt = Integer.parseInt(end);
        return new ResponseBO(mileageDetailsMapper.selectByMilesInterval(startInt, endInt));
    }

    @ResponseBody
    @RequestMapping(value = "/timeInterval", method = RequestMethod.GET)
    private ResponseBO getTimeInterval(HttpServletRequest httpServletRequest) {
        String start = httpServletRequest.getParameter("start");
        String end = httpServletRequest.getParameter("end");
        if (StringUtils.isBlank(start)) {
            start = "0";
        }

        if (StringUtils.isBlank(end)) {
            start = "9999999";
        }
        int startInt = Integer.parseInt(start);
        int endInt = Integer.parseInt(end);
        return new ResponseBO(mileageDetailsMapper.selectByTimeInterval(startInt, endInt));
    }
}
