package com.weli.account.bean;

import cn.bmob.v3.BmobUser;

public class MyUser extends BmobUser {

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "image='" + image + '\'' +
                '}';
    }
}
