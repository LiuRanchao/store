package com.lrchao.store.model.user;

import com.lrchao.store.model.BaseModel;

/**
 * Description: 用户信息的对象
 *
 * @author liuranchao
 * @date 15/12/25 上午9:16
 */
public class UserModel implements BaseModel {

    /**
     * 城市的ID
     */
    private long loc_id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 创建时间
     */
    private String created;

    /**
     * 小头像
     */
    private String avatar;


    public long getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(long loc_id) {
        this.loc_id = loc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public void clear() {

    }
}
