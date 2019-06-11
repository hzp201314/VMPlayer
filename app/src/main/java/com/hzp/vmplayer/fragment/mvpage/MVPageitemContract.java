package com.hzp.vmplayer.fragment.mvpage;

import com.hzp.vmplayer.BasePresenter;
import com.hzp.vmplayer.BaseView;
import com.hzp.vmplayer.bean.VideoBean;


import java.util.List;

/**
 * Created by wschun on 2016/10/1.
 */

public interface MVPageitemContract {
    interface Presenter extends BasePresenter {

      void   getData(int moffest, int size, String areaCode);
    }

    interface View extends BaseView<Presenter> {

        void setData(List<VideoBean> videoBeanList);
        void setError(String msg);

    }
}
