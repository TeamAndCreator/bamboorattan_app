package com.science.bamboorattan.frame.activity.mo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.science.androidbase.utils.DensityUtils;
import com.science.bamboorattan.R;
import com.science.bamboorattan.frame.activity.mo.activity.BambooInfoCollectActivity;
import com.science.bamboorattan.frame.activity.mo.activity.OptionActivity;
import com.science.bamboorattan.frame.activity.mo.util.Table;

/***
 *
 */
public class IndexFragment extends Fragment implements View.OnClickListener {
    private LinearLayout collect_zhu;
    private LinearLayout collect_shu;
    private LinearLayout collect_cai;
    private Dialog bottomDialog;
    private TextView tvSayHi;
    private TextView tvBriberyMoney;
    private TextView tvCancel;
    private Context mContext;
    private TextView toolbarTitle;
    private Toolbar toolbar;
    private View fakeStatusBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        mContext = getContext();
        View view = inflater.inflate(R.layout.index, null);
        collect_zhu = view.findViewById(R.id.collect_zhu);
        collect_cai = view.findViewById(R.id.collect_cai);
        collect_shu = view.findViewById(R.id.collect_shu);
        toolbarTitle = view.findViewById(R.id.toolbar_title);
        toolbar = view.findViewById(R.id.toolbar);
        fakeStatusBar = view.findViewById(R.id.fake_status_bar);
        initData();
        initBottomDialog();
        initEvent();
        return view;
    }

    private void initData() {
        fakeStatusBar.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        toolbarTitle.setText("主页");
    }

    private void initEvent() {
        collect_cai.setOnClickListener(this);
        collect_zhu.setOnClickListener(this);
        collect_shu.setOnClickListener(this);

        tvSayHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomDialog != null) {
                    bottomDialog.dismiss();
                }
                Intent intent = new Intent(mContext, BambooInfoCollectActivity.class);
                intent.putExtra("catalog", Table.GENUS);
                startActivity(intent);
            }
        });

        tvBriberyMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomDialog != null) {
                    bottomDialog.dismiss();
                }
                Intent intent = new Intent(mContext, BambooInfoCollectActivity.class);
                intent.putExtra("catalog", Table.SPEC);
                startActivity(intent);
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomDialog != null) {
                    bottomDialog.dismiss();
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        switch (id) {
            case R.id.collect_zhu:
                if (bottomDialog != null) {
                    bottomDialog.show();
                }
                break;
            case R.id.collect_cai:
                intent = new Intent(mContext, OptionActivity.class);
                intent.putExtra("type", 0);
                startActivity(intent);
                break;
            case R.id.collect_shu:
                intent = new Intent(getActivity(), OptionActivity.class);
                intent.putExtra("type", 1);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void initBottomDialog() {
        bottomDialog = new Dialog(mContext, R.style.BottomDialog);
        View dialogContentView = LayoutInflater.from(mContext).inflate(R.layout
                .dialog_content_circle, null);
        tvSayHi = dialogContentView.findViewById(R.id.tv_say_hi);
        tvBriberyMoney = dialogContentView.findViewById(R.id.tv_bribery_money);
        tvCancel = dialogContentView.findViewById(R.id.tv_cancle);
        bottomDialog.setContentView(dialogContentView);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) dialogContentView
                .getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels - DensityUtils.dp2px(mContext,
                16f);
        params.bottomMargin = DensityUtils.dp2px(mContext, 8f);
        dialogContentView.setLayoutParams(params);
        if (bottomDialog.getWindow() != null) {
            bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
            bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        }
    }
}
