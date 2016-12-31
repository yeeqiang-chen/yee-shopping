package com.yiqiang.shopping.manage.pojo;

import com.yiqiang.shopping.manage.pojo.BasePojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/29 0029 1:35
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@Table(name = "tb_item_param")
public class ItemParam extends BasePojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_cat_id")
    private Long itemCatId;

    @Column(name = "param_data")
    private String paramData;

    @Transient
    private String itemCatName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getItemCatName() {
        return itemCatName;
    }

    public void setItemCatName(String itemCatName) {
        this.itemCatName = itemCatName;
    }
}
