package cn.interhorse.springboot.bjtu.controller;

import cn.interhorse.springboot.bjtu.dao.mapper.MileageDetailsMapper;
import cn.interhorse.springboot.bjtu.entity.MileageDetails;
import cn.interhorse.springboot.bjtu.entity.PageData;
import cn.interhorse.springboot.bjtu.entity.ResponseBO;
import com.github.pagehelper.PageHelper;
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
        String end = httpServletRequest.getParameter("end");
        String page = httpServletRequest.getParameter("page");
        String limit = httpServletRequest.getParameter("limit");
        String start = httpServletRequest.getParameter("start");
        int pageInt;
        int limitInt;
        if (StringUtils.isBlank(page)) {
            pageInt = 1;
        } else {
            pageInt = Integer.parseInt(page);
        }
        if (StringUtils.isBlank(limit)) {
            limitInt = 1;
        } else {
            limitInt = Integer.parseInt(limit);
        }
        if (StringUtils.isBlank(start)) {
            start = "1900";
        }

        if (StringUtils.isBlank(end)) {
            end = "2020";
        }
        int startInt = Integer.parseInt(start);
        int endInt = Integer.parseInt(end);
        PageHelper.startPage(pageInt, limitInt);
        return new ResponseBO(new PageData<>(mileageDetailsMapper.selectByYearsInterval(startInt, endInt)));
    }

    @ResponseBody
    @RequestMapping(value = "/milesInterval", method = RequestMethod.GET)
    private ResponseBO getMilesInterval(HttpServletRequest httpServletRequest) {
        String end = httpServletRequest.getParameter("end");
        String page = httpServletRequest.getParameter("page");
        String limit = httpServletRequest.getParameter("limit");
        String start = httpServletRequest.getParameter("start");
        int pageInt;
        int limitInt;
        if (StringUtils.isBlank(page)) {
            pageInt = 1;
        } else {
            pageInt = Integer.parseInt(page);
        }
        if (StringUtils.isBlank(limit)) {
            limitInt = 1;
        } else {
            limitInt = Integer.parseInt(limit);
        }
        if (StringUtils.isBlank(start)) {
            start = "0";
        }

        if (StringUtils.isBlank(end)) {
            end = "99999999";
        }
        int startInt = Integer.parseInt(start);
        int endInt = Integer.parseInt(end);
        PageHelper.startPage(pageInt, limitInt);
        return new ResponseBO(new PageData<>(mileageDetailsMapper.selectByMilesInterval(startInt, endInt)));
    }

    @ResponseBody
    @RequestMapping(value = "/timeInterval", method = RequestMethod.GET)
    private ResponseBO getTimeInterval(HttpServletRequest httpServletRequest) {
        String end = httpServletRequest.getParameter("end");
        String page = httpServletRequest.getParameter("page");
        String limit = httpServletRequest.getParameter("limit");
        String start = httpServletRequest.getParameter("start");
        int pageInt;
        int limitInt;
        if (StringUtils.isBlank(page)) {
            pageInt = 1;
        } else {
            pageInt = Integer.parseInt(page);
        }
        if (StringUtils.isBlank(limit)) {
            limitInt = 1;
        } else {
            limitInt = Integer.parseInt(limit);
        }
        if (StringUtils.isBlank(start)) {
            start = "0";
        }

        if (StringUtils.isBlank(end)) {
            end = "9999999";
        }
        int startInt = Integer.parseInt(start);
        int endInt = Integer.parseInt(end);
        PageHelper.startPage(pageInt, limitInt);
        return new ResponseBO(new PageData<>(mileageDetailsMapper.selectByTimeInterval(startInt, endInt)));
    }
}
