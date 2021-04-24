package com.github.houbb.low.code.web.controller;//import com.github.houbb.auto.log.annotation.AutoLog;
//import com.github.houbb.auto.log.annotation.TraceId;
//import com.github.houbb.web.common.dto.req.CommonPageReq;
//import com.github.houbb.web.common.dto.resp.BaseResp;
//import com.github.houbb.web.common.util.RespUtil;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.validation.Valid;
//
///**
// * <p>
// * 用户表 前端控制器
// * </p>
// *
// * @author binbin.hou
// * @since 2020-09-18
// */
//@Controller
//@RequestMapping("/user")
//@TraceId
//@AutoLog
//public class UserController2 {
//
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    /**
//     * 首页
//     * @return 首页地址
//     * @since 0.0.5
//     */
//    @RequestMapping("/index")
//    public String index() {
//        return "user/index";
//    }
//
//    @RequestMapping("/add")
//    @ResponseBody
//    public BaseResp add(@Valid @RequestBody final User user) {
//        userService.insert(user);
//
//        return RespUtil.success();
//    }
//
//    @RequestMapping("/edit")
//    @ResponseBody
//    public BaseResp edit(@Valid final User user) {
//        userService.updateById(user);
//
//        return RespUtil.success();
//    }
//
//    @RequestMapping("/remove/{userId}")
//    @ResponseBody
//    public BaseResp remove(@PathVariable final String userId) {
//        userService.deleteByUserIdTx(userId);
//        return RespUtil.success();
//    }
//
//    @RequestMapping("/list")
//    @ResponseBody
//    public BaseResp list(@RequestBody CommonPageReq pageReq) {
//        BasePageInfo<User> pageInfo = userService.pageQueryList(pageReq);
//        return RespUtil.of(pageInfo);
//    }
//
//}
//
