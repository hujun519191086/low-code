package ${package.Entity}.po;

import ${package.Entity}.${entity};

/**
 * <p>
 * ${table.comment}-分页查询对象
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
public class ${entity}PagePo extends ${entity} {

    /**
    * 分页大小
    */
    private Integer pageSize;

    /**
    * 当前页码
    */
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "${entity}PagePo{" +
        "pageSize=" + pageSize +
        ", pageNum=" + pageNum +
        "} " + super.toString();
    }

}