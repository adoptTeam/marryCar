package com.example.huaile.marrycarrent;

import android.support.v4.app.Fragment;

/**
 * Created by 屹强 on 2016/10/23.
 */
public class DingdanListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new DingdanListFragment();
    }
}
