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
    private LinearLayout collect_bamrattan;
    private LinearLayout collect_form;
    private LinearLayout collect_property;
    private LinearLayout t_collect_bamrattan;
    private LinearLayout t_collect_form;
    private LinearLayout t_collect_property;
    private Dialog bottomDialog;
    private Dialog bottomRattanDialog;
    private TextView tvGenus;
    private TextView tvSpec;
    private TextView tvCancel;
    private TextView tvRattanGenus;
    private TextView tvRattanSpec;
    private TextView tvRattanCancel;
    private Context mContext;
    private TextView toolbarTitle;
    private Toolbar toolbar;
    private View fakeStatusBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        mContext = getContext();
        View view = inflater.inflate(R.layout.index, null);
        collect_bamrattan = view.findViewById(R.id.collect_bamrattan);
        collect_form = view.findViewById(R.id.collect_form);
        collect_property = view.findViewById(R.id.collect_property);
        t_collect_bamrattan = view.findViewById(R.id.t_collect_bamrattan);
        t_collect_form = view.findViewById(R.id.t_collect_form);
        t_collect_property = view.findViewById(R.id.t_collect_property);
        toolbarTitle = view.findViewById(R.id.toolbar_title);
        toolbar = view.findViewById(R.id.toolbar);
        fakeStatusBar = view.findViewById(R.id.fake_status_bar);
        initData();
        initBottomDialog();
        rattanBottomDialog();
        initEvent();
        return view;
    }

    private void initData() {
        fakeStatusBar.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        toolbarTitle.setText("主页");
    }

    private void initEvent() {
        collect_bamrattan.setOnClickListener(this);
        collect_form.setOnClickListener(this);
        collect_property.setOnClickListener(this);
        t_collect_bamrattan.setOnClickListener(this);
        t_collect_property.setOnClickListener(this);
        t_collect_form.setOnClickListener(this);

        tvGenus.setOnClickListener(new View.OnClickListener() {
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

        tvSpec.setOnClickListener(new View.OnClickListener() {
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

        tvRattanGenus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomRattanDialog != null) {
                    bottomRattanDialog.dismiss();
                }
                Intent intent = new Intent(mContext, BambooInfoCollectActivity.class);
                intent.putExtra("catalog", Table.TGENUS);
                startActivity(intent);
            }
        });

        tvRattanSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomRattanDialog != null) {
                    bottomRattanDialog.dismiss();
                }
                Intent intent = new Intent(mContext, BambooInfoCollectActivity.class);
                intent.putExtra("catalog", Table.TSPEC);
                startActivity(intent);
            }
        });

        tvRattanCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomRattanDialog != null) {
                    bottomRattanDialog.dismiss();
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        switch (id) {
            case R.id.collect_bamrattan:
                if (bottomDialog != null) {
                    bottomDialog.show();
                }
                break;
            case R.id.t_collect_bamrattan:
                if (bottomRattanDialog != null) {
                    bottomRattanDialog.show();
                }
                break;
            case R.id.collect_form:
                intent = new Intent(mContext, OptionActivity.class);
                intent.putExtra("type", 0);
                startActivity(intent);
                break;
            case R.id.collect_property:
                intent = new Intent(getActivity(), OptionActivity.class);
                intent.putExtra("type", 1);
                startActivity(intent);
                break;
//            case R.id.t_collect_form:
//                intent = new Intent(mContext, OptionActivity.class);
//                intent.putExtra("type", 2);
//                startActivity(intent);
//                break;
            case R.id.t_collect_property:
                intent = new Intent(getActivity(), OptionActivity.class);
                intent.putExtra("type", 3);
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
        tvGenus = dialogContentView.findViewById(R.id.tv_genus);
        tvSpec = dialogContentView.findViewById(R.id.tv_spec);
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
/**
 * 藤信息采集对话框
 */
    private void rattanBottomDialog() {
        bottomRattanDialog = new Dialog(mContext, R.style.BottomDialog);
        View dialogContentView = LayoutInflater.from(mContext).inflate(R.layout
                .rattan_dialog_content_circle, null);
        tvRattanGenus = dialogContentView.findViewById(R.id.tv_rattan_genus);
        tvRattanSpec = dialogContentView.findViewById(R.id.tv_rattan_spec);
        tvRattanCancel = dialogContentView.findViewById(R.id.tv_rattan_cancle);
        bottomRattanDialog.setContentView(dialogContentView);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) dialogContentView
                .getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels - DensityUtils.dp2px(mContext,
                16f);
        params.bottomMargin = DensityUtils.dp2px(mContext, 8f);
        dialogContentView.setLayoutParams(params);
        if (bottomRattanDialog.getWindow() != null) {
            bottomRattanDialog.getWindow().setGravity(Gravity.BOTTOM);
            bottomRattanDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        }
    }
}
