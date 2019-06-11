package com.hzp.vmplayer.fragment.mvpage;

import com.hzp.vmplayer.BasePresenter;
import com.hzp.vmplayer.BaseView;
import com.hzp.vmplayer.bean.AreaBean;
import java.util.List;

/**
 * Created by wschun on 2016/10/1.
 */

public interface MVPageContract {
    interface Presenter extends BasePresenter {}

    interface View extends BaseView<Presenter> {
        void setData(List<AreaBean> areaBeanArrayList);
        void setError(String msg);

    }
}
