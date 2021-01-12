package com.zhanglisheng.canal.deploy;

/**
 * @description:
 * @author: zhanglisheng
 * @create: 2021-01-11 14:54
 */
public class TbCommodityInfo {


    private String id;
    private String intervene_type;
    private String intervene_type_name;
    private String create_time;
    private String update_time;
    private String redirect_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntervene_type() {
        return intervene_type;
    }

    public void setIntervene_type(String intervene_type) {
        this.intervene_type = intervene_type;
    }

    public String getIntervene_type_name() {
        return intervene_type_name;
    }

    public void setIntervene_type_name(String intervene_type_name) {
        this.intervene_type_name = intervene_type_name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }
}