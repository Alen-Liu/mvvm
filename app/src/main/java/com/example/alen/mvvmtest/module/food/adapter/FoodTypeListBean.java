package com.example.alen.mvvmtest.module.food.adapter;

/**
 * @author 刘伦
 * @date 2018/9/21
 *
 * 食物列表  双层列表 整合类
 */

public class FoodTypeListBean {
    public static final int TYPE_GROUP = 0;
    public static final int TYPE_ITEM = 1;
    /**
     * 父Id
     */
    private String parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 分类id
     */
    private String id;
    /**
     * 类型
     */
    private int type;

    /**
     * 是否隐藏二级菜单
     */
    private boolean hiddChild;

    public FoodTypeListBean(String parentId, String name, String id, int type) {
        this.parentId = parentId;
        this.name = name;
        this.id = id;
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isHiddChild() {
        return hiddChild;
    }

    public void setHiddChild(boolean hiddChild) {
        this.hiddChild = hiddChild;
    }
}
