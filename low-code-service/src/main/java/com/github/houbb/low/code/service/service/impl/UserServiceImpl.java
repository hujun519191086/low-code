package com.github.houbb.low.code.service.service.impl;

import com.github.houbb.low.code.dal.entity.User;
import com.github.houbb.low.code.dal.mapper.UserMapper;
import com.github.houbb.low.code.service.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.github.houbb.web.common.dto.req.CommonPageReq;
import com.github.houbb.web.common.dto.resp.BasePageInfo;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2021-04-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

        /**
        * 分页查询
        * @param pageReq 请求
        * @return 结果
        */
        public BasePageInfo<User> pageQueryList(CommonPageReq pageReq) {
            Wrapper<User> wrapper = new EntityWrapper<>();
            Page<User> page = new Page<>(pageReq.getPageNum(), pageReq.getPageSize());
            page = this.selectPage(page, wrapper);
            BasePageInfo<User> pageInfo = new BasePageInfo<>();
            pageInfo.setList(page.getRecords());
            pageInfo.setTotal(page.getTotal());
            return pageInfo;
        }

}
