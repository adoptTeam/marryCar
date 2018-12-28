package com.example.huaile.marrycarrent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class DingdanPageActivity extends AppCompatActivity {
        private static final String EXTRA_DINGDAN_ID="com.bignerdranch.android.criminalintent.dingdan_id";
        private ViewPager mViewPager;

        private List<Dingdan> mDingdans;
        public static Intent newIntent(Context packageContext, UUID dingdanId){
            Intent intent=new Intent(packageContext,DingdanPageActivity.class);
            intent.putExtra(EXTRA_DINGDAN_ID,dingdanId);
            return intent;
        }
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dingdan_page);
            mViewPager=(ViewPager)findViewById(R.id.activity_dingdan_pager_view_pager);


            UUID crimeId=(UUID)getIntent().getSerializableExtra(EXTRA_DINGDAN_ID);
            mDingdans=DingdanLab.get(this).getDingdans();
            FragmentManager fragmentManager=getSupportFragmentManager();
            mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
                @Override
                public Fragment getItem(int position) {
                    Dingdan dingdan= mDingdans.get(position);
                    return DingdanFragment.newInstance(dingdan.getId());
                }

                @Override
                public int getCount() {
                    return mDingdans.size();
                }
            });
            for (int i=0;i<mDingdans.size();i++){
                if(mDingdans.get(i).getId().equals(crimeId)){
                    mViewPager.setCurrentItem(i);
                }
            }
        }
    }
