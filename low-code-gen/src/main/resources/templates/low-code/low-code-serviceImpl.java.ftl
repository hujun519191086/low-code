package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Entity}.po.${entity}PagePo;
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.github.houbb.web.common.dto.resp.BasePageInfo;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.lang.reflect.ReflectFieldUtil;

import java.lang.reflect.Field;
import java.util.List;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    /**
    * 分页查询
    *
    * @param pageReq 请求
    * @return 结果
    */
    @Override
    public BasePageInfo<${entity}> pageQueryList(${entity}PagePo pageReq) {
        Wrapper<${entity}> wrapper = buildPageQueryWrapper(pageReq);

        Page<${entity}> page = new Page<>(pageReq.getPageNum(), pageReq.getPageSize());
        page = this.selectPage(page, wrapper);
        BasePageInfo<${entity}> pageInfo = new BasePageInfo<>();
        pageInfo.setList(page.getRecords());
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }

    /**
    * 构建分页查询的 wrapper
    *
    * @param pageReq 入参对象
    * @return 结果
    */
    private Wrapper<${entity}> buildPageQueryWrapper(${entity}PagePo pageReq) {
        Wrapper<${entity}> wrapper = new EntityWrapper<>();
        List<Field> fieldList = ClassUtil.getAllFieldList(pageReq.getClass());
        for(Field field : fieldList) {
            String fieldName = field.getName();
            if("pageSize".equals(fieldName)
                || "pageNum".equals(fieldName)) {
                continue;
            }

            // 处理非空字段
            Object fieldValue = ReflectFieldUtil.getValue(field, pageReq);
            if(null == fieldValue) {
                continue;
            }
            // 字符串空过滤
            if(String.class.equals(field.getType())) {
                String text = (String) fieldValue;
                    if(StringUtil.isBlank(text)) {
                    continue;
                }
            }
            String columnName = StringUtil.camelToUnderline(fieldName);
            wrapper.eq(columnName, fieldValue);
        }

        return wrapper;
    }

}
</#if>
