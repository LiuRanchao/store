package com.lrchao.store.model.movie.in_theaters;

import com.lrchao.store.model.BaseModel;
import com.lrchao.store.model.movie.MovieModel;

import java.util.List;

/**
 * Description: 正在热播的返回数据
 *
 * @author liuranchao
 * @date 16/1/31 下午2:11
 */
public class InTheatersModel implements BaseModel{

    /**
     * 返回的数量
     */
    private int count;

    /**
     * 起始的
     */
    private int start;

    /**
     * 总数
     */
    private int total;

    /**
     * 标题 e.g. title	String	正在上映的电影-北京
     */
    private String title;

    private List<MovieModel> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MovieModel> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieModel> subjects) {
        this.subjects = subjects;
    }

    @Override
    public void clear() {
        if (getSubjects() != null && getSubjects().size() > 0) {
            for (MovieModel movieModel : getSubjects()) {
                movieModel.clear();
            }
            getSubjects().clear();
        }
    }
}
