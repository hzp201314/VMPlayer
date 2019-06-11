package com.hzp.vmplayer.fragment.homepage;

import com.hzp.vmplayer.BasePresenter;
import com.hzp.vmplayer.BaseView;
import com.hzp.vmplayer.bean.VideoBean;

import java.util.List;

/**
 * Created by wschun on 2016/9/30.
 */

public interface HomeContract {


    interface  Presenter extends BasePresenter {


    }

    interface View extends BaseView<Presenter> {
        void setData(List<VideoBean> lists);
        void setError(String msg);
    }

}
