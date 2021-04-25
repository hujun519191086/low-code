package com.github.houbb.low.code.service.service;

import com.github.houbb.low.code.dal.entity.User;
import com.github.houbb.low.code.dal.entity.po.UserPagePo;
import com.baomidou.mybatisplus.service.IService;
import com.github.houbb.web.common.dto.resp.BasePageInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Administrator
 * @since 2021-04-25
 */
public interface UserService extends IService<User> {

    /**
    * 分页查询
    * @param pageReq 请求
    * @return 结果
    */
    BasePageInfo<User> pageQueryList(UserPagePo pageReq);

}
