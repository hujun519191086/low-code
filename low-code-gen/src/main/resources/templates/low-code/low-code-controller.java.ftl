package ${package.Controller};

import com.github.houbb.auto.log.annotation.AutoLog;
import com.github.houbb.auto.log.annotation.TraceId;
import com.github.houbb.web.common.dto.req.CommonPageReq;
import com.github.houbb.web.common.dto.resp.BaseResp;
import com.github.houbb.web.common.dto.resp.BasePageInfo;
import com.github.houbb.web.common.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
        <#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
@TraceId
@AutoLog
public class ${table.controllerName} {

    @Autowired
    private ${table.serviceName} entityService;

    /**
    * 首页
    */
    @RequestMapping("/index")
    public String index() {
    return "${table.name}/index";
    }

    @RequestMapping("/add")
    @ResponseBody
    public BaseResp add(@RequestBody final ${entity} entity) {
        entityService.insert(entity);

        return RespUtil.success();
    }

    @RequestMapping("/edit")
    @ResponseBody
    public BaseResp edit(final ${entity} entity) {
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
        BasePageInfo<${entity}> pageInfo = entityService.pageQueryList(pageReq);
        return RespUtil.of(pageInfo);
    }

}
</#if>
</#if>