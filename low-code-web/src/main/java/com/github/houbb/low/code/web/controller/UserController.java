package com.github.houbb.low.code.web.controller;

import com.github.houbb.auto.log.annotation.AutoLog;
import com.github.houbb.auto.log.annotation.TraceId;
import com.github.houbb.web.common.dto.resp.BaseResp;
import com.github.houbb.web.common.dto.resp.BasePageInfo;
import com.github.houbb.web.common.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.houbb.low.code.service.service.UserService;
import com.github.houbb.low.code.dal.entity.User;
import com.github.houbb.low.code.dal.entity.po.UserPagePo;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author binbin.hou
 * @since 2021-04-25
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

    /**
    * 添加元素
    * @param entity 实体
    * @return 结果
    */
    @RequestMapping("/add")
    @ResponseBody
    public BaseResp add(@RequestBody final User entity) {
        entityService.insert(entity);

        return RespUtil.success();
    }

    /**
    * 编辑
    * @param entity 实体
    * @return 结果
    */
    @RequestMapping("/edit")
    @ResponseBody
    public BaseResp edit(final User entity) {
        entityService.updateById(entity);

        return RespUtil.success();
    }

    /**
    * 删除
    * @param id 实体
    * @return 结果
    */
    @RequestMapping("/remove/{id}")
    @ResponseBody
    public BaseResp remove(@PathVariable final Integer id) {
        entityService.deleteById(id);
        return RespUtil.success();
    }

    /**
    * 列表
    * @param pageReq 入参
    * @return 结果
    */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResp list(@RequestBody UserPagePo pageReq) {
        BasePageInfo<User> pageInfo = entityService.pageQueryList(pageReq);
        return RespUtil.of(pageInfo);
    }

}
