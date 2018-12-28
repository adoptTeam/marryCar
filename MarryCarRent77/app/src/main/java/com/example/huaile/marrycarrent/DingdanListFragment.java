package com.example.huaile.marrycarrent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class DingdanListFragment extends Fragment {

    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";

    private RecyclerView mDingdanRecyclerView;
    private DingdanAdapter mAdapter;
    private boolean mSubtitleVisible;
    private Button  mDimgdanButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dingdan_list, container, false);

        mDingdanRecyclerView = (RecyclerView) view
                .findViewById(R.id.dingdan_recycler_view);
        mDingdanRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (savedInstanceState != null) {
            mSubtitleVisible = savedInstanceState.getBoolean(SAVED_SUBTITLE_VISIBLE);
        }

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE, mSubtitleVisible);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_dingdan_list, menu);

        MenuItem subtitleItem = menu.findItem(R.id.menu_item_show_subtitle);
        if (mSubtitleVisible) {
            subtitleItem.setTitle(R.string.hide_subtitle);
        } else {
            subtitleItem.setTitle(R.string.show_subtitle);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_dingdan:
               Dingdan dingdan = new Dingdan();
              DingdanLab.get(getActivity()).addDingdan(dingdan);
                Intent intent = DingdanPageActivity.newIntent(getActivity(), dingdan.getId());
                startActivity(intent);
                return true;
            case R.id.menu_item_show_subtitle:
                mSubtitleVisible = !mSubtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateSubtitle() {
        DingdanLab dingdanLab = DingdanLab.get(getActivity());
        int dingdanCount = dingdanLab.getDingdans().size();
        String subtitle = getString(R.string.subtitle_fformat, dingdanCount);

        if (!mSubtitleVisible) {
            subtitle = null;
        }

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    private void updateUI() {
        DingdanLab dingdanLab = DingdanLab.get(getActivity());
        List<Dingdan> dingdans = dingdanLab.getDingdans();

        if (mAdapter == null) {
            mAdapter = new DingdanAdapter(dingdans);
            mDingdanRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setDingdans(dingdans);
            mAdapter.notifyDataSetChanged();
        }

        updateSubtitle();
    }

    private class DingdanHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        private Dingdan mDingdan;

        public DingdanHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_dingdan_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_dingdan_date_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_dingdan_solved_check_box);
        }

        public void bindDingdan(Dingdan dingdan) {
           mDingdan = dingdan;
            mTitleTextView.setText(mDingdan.getTitle());
            mDateTextView.setText(mDingdan.getDate().toString());
            mSolvedCheckBox.setChecked(mDingdan.isSolved());
        }

        @Override
        public void onClick(View v) {
            Intent intent = DingdanPageActivity.newIntent(getActivity(), mDingdan.getId());
            startActivity(intent);
        }
    }

    private class DingdanAdapter extends RecyclerView.Adapter<DingdanHolder> {

        private List<Dingdan> mDingdans;

        public DingdanAdapter(List<Dingdan> dingdans) {mDingdans= dingdans;}

        @Override
        public DingdanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_dingdan, parent, false);
            return new DingdanHolder(view);

        }

        @Override
        public void onBindViewHolder(DingdanHolder holder, int position) {
            Dingdan dingdan = mDingdans.get(position);
            holder.bindDingdan(dingdan);
        }

        @Override
        public int getItemCount() {
            return mDingdans.size();
        }

        public void setDingdans(List<Dingdan> dingdans) {
            mDingdans = dingdans;
        }
    }
}
