package com.skillsharehub.Model;

public class CategoryModel {

    String name;
    boolean selected;

    public CategoryModel(String name, boolean selected) {
        this.name = name;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}