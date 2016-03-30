package com.lrchao.store.request_handler.movie;


import com.lrchao.store.model.movie.in_theaters.InTheatersModel;
import com.lrchao.store.net.APIConstants;
import com.lrchao.store.net.resquest.RequestMethod;
import com.lrchao.store.request_handler.RequestHandler;

/**
 * Description: Movie的正在热播接口处理
 *
 * @author liuranchao
 * @date 16/1/29 下午3:21
 */
public class MovieInTheatersRH extends RequestHandler {

    @Override
    protected int bindRequestMethod() {
        return RequestMethod.GET;
    }

    @Override
    protected String bindRequestURL() {
        return APIConstants.DOUBAN_API_HOST + "v2/movie/in_theaters";
    }

    @Override
    protected Class getJsonClass() {
        return InTheatersModel.class;
    }

    @Override
    protected void onSuccess(Object obj) {
        InTheatersModel inTheatersModel = (InTheatersModel) obj;
    }



}
