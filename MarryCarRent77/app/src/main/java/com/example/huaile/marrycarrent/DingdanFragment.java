package com.example.huaile.marrycarrent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;

public class DingdanFragment extends Fragment {

    private static final String ARG_DINGDAN_ID = "dingdan_id";
    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE = 0;
    private Button  mDimgdanButton;
    private Dingdan mDingdan;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckbox;

    public static DingdanFragment newInstance(UUID dingdanId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DINGDAN_ID, dingdanId);

        DingdanFragment fragment = new DingdanFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID dingdanId = (UUID) getArguments().getSerializable(ARG_DINGDAN_ID);
       mDingdan = DingdanLab.get(getActivity()).getDingdan(dingdanId);
    }

    @Override
    public void onPause() {
        super.onPause();

       DingdanLab.get(getActivity())
                .updateDingdan(mDingdan);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dingdan, container, false);

        mTitleField = (EditText) v.findViewById(R.id.dingdan_title);
        mTitleField.setText(mDingdan.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               mDingdan.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button) v.findViewById(R.id.dingdan_date);
        updateDate();
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment
                        .newInstance(mDingdan.getDate());
                dialog.setTargetFragment(DingdanFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });

        mSolvedCheckbox = (CheckBox) v.findViewById(R.id.dingdan_solved);
        mSolvedCheckbox.setChecked(mDingdan.isSolved());
        mSolvedCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               mDingdan.setSolved(isChecked);
            }
        });

        return v;


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;

        }

        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
           mDingdan.setDate(date);
            updateDate();
        }
    }

    private void updateDate() {
        mDateButton.setText(mDingdan.getDate().toString());
    }
}
