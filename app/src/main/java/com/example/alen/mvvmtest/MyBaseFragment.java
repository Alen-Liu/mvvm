package com.example.alen.mvvmtest;


import android.support.v4.app.Fragment;

import com.example.alen.mvvmtest.app.MyApplication;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author 刘伦
 * @date 2018/9/17
 */

public class MyBaseFragment extends Fragment {
    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = MyApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
