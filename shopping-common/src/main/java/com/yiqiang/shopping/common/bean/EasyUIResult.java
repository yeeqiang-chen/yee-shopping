package com.yiqiang.shopping.common.bean;

import java.util.List;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/25 0025 16:11
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class EasyUIResult {

    /**
     * the total number pages
     */
    private Long total;

    /**
     * data of the current page
     */
    private List<?> rows;

    public EasyUIResult() {

    }

    public EasyUIResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
