package com.example.reciteword.bean;

import java.io.Serializable;

/**
 * Created by psylife00 on 2017/5/11.
 */

public class UserBean implements Serializable {

    boolean keepInfo;       //是否保存密码

    private String username;    //用户名
    private String password; //密码
    private boolean isVoiceOpen;   //是否开启声音


    private String true_name;
    private String stamp_class;
    private String sch_id;  //	学校id
    private String cids;
    private String sex;
    private String user_sgp;
    private String desc;
    private String is_master;
    private String teacher_id;  //用户id
    private String role;        //角色id
    private String main_class;
    private String img_url;     //头像
    private String logo_url;    //修改头像成功 的 返回地址

    private String num;         //消息未读数

    private String mobile;      //手机号
    private String t_code; //小思 账号

    private String show_tj;     //0不显示 1 显示  推荐徽章


    private String is_school_edition;       //1 新版校本 0老版普通



    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTrue_name() {
        return true_name;
    }

    public void setTrue_name(String true_name) {
        this.true_name = true_name;
    }

    public String getStamp_class() {
        return stamp_class;
    }

    public void setStamp_class(String stamp_class) {
        this.stamp_class = stamp_class;
    }

    public String getSch_id() {
        return sch_id;
    }

    public void setSch_id(String sch_id) {
        this.sch_id = sch_id;
    }

    public String getCids() {
        return cids;
    }

    public void setCids(String cids) {
        this.cids = cids;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUser_sgp() {
        return user_sgp;
    }

    public void setUser_sgp(String user_sgp) {
        this.user_sgp = user_sgp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIs_master() {
        return is_master;
    }

    public void setIs_master(String is_master) {
        this.is_master = is_master;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMain_class() {
        return main_class;
    }

    public void setMain_class(String main_class) {
        this.main_class = main_class;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public boolean isKeepInfo() {
        return keepInfo;
    }

    public void setKeepInfo(boolean keepInfo) {
        this.keepInfo = keepInfo;
    }

    public String getT_code() {
        return t_code;
    }

    public void setT_code(String t_code) {
        this.t_code = t_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVoiceOpen() {
        return isVoiceOpen;
    }

    public void setVoiceOpen(boolean voiceOpen) {
        isVoiceOpen = voiceOpen;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getShow_tj() {
        return show_tj;
    }

    public void setShow_tj(String show_tj) {
        this.show_tj = show_tj;
    }

    public String getIs_school_edition() {
        return is_school_edition;
    }

    public void setIs_school_edition(String is_school_edition) {
        this.is_school_edition = is_school_edition;
    }
}
