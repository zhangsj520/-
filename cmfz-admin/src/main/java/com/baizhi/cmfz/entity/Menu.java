package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Menu implements Serializable {
    private Integer menuId;
    private String menuName;
    private String menuCode;
    private String menucon;
    private String menuLevel;
    private Integer menuParentId;

    public Menu() {
    }

    public Menu(Integer menuId, String menuName, String menuCode, String menucon, String menuLevel, Integer menuParentId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menucon = menucon;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menucon='" + menucon + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", menuParentId=" + menuParentId +
                '}';
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenucon() {
        return menucon;
    }

    public void setMenucon(String menucon) {
        this.menucon = menucon;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }
}
