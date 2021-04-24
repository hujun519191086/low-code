package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.github.houbb.web.common.dto.req.CommonPageReq;
import com.github.houbb.web.common.dto.resp.BasePageInfo;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
    * 分页查询
    * @param pageReq 请求
    * @return 结果
    */
    BasePageInfo<${entity}> pageQueryList(CommonPageReq pageReq);

}
</#if>
