package com.lrchao.store.model.movie;

import com.lrchao.store.model.BaseModel;

/**
 * Description: 电影的基类对象
 *
 * @author liuranchao
 * @date 16/1/31 下午2:11
 */
public class MovieModel implements BaseModel{

    /**
     * 电影的ID
     */
    private int id;

    /**
     * 标题
     */
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void clear() {

    }
}
