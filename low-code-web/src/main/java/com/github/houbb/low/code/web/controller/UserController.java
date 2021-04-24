package com.github.houbb.low.code.web.controller;

import com.github.houbb.auto.log.annotation.AutoLog;
import com.github.houbb.auto.log.annotation.TraceId;
import com.github.houbb.web.common.dto.req.CommonPageReq;
import com.github.houbb.web.common.dto.resp.BaseResp;
import com.github.houbb.web.common.dto.resp.BasePageInfo;
import com.github.houbb.web.common.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import com.github.houbb.low.code.service.service.UserService;
import com.github.houbb.low.code.dal.entity.User;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Administrator
 * @since 2021-04-24
 */
@Controller
@RequestMapping("/user")
@TraceId
@AutoLog
public class UserController {


    @Autowired
    private UserService entityService;

    /**
    * 首页
    */
    @RequestMapping("/index")
    public String index() {
    return "user/index";
    }

    @RequestMapping("/add")
    @ResponseBody
    public BaseResp add(@RequestBody final User entity) {
        entityService.insert(entity);

        return RespUtil.success();
    }

    @RequestMapping("/edit")
    @ResponseBody
    public BaseResp edit(final User entity) {
        entityService.updateById(entity);

        return RespUtil.success();
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public BaseResp remove(@PathVariable final Integer id) {
        entityService.deleteById(id);
        return RespUtil.success();
    }

    @RequestMapping("/list")
    @ResponseBody
    public BaseResp list(@RequestBody CommonPageReq pageReq) {
        BasePageInfo<User> pageInfo = entityService.pageQueryList(pageReq);
        return RespUtil.of(pageInfo);
    }

}
