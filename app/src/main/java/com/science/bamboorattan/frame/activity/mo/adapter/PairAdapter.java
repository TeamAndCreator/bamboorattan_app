package com.science.bamboorattan.frame.activity.mo.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.EditText;

import com.science.androidbase.utils.TextUtils;
import com.science.bamboorattan.R;
import com.science.bamboorattan.adapter.RecyclerViewAdapter;
import com.science.bamboorattan.adapter.ViewHolder;
import com.science.bamboorattan.frame.activity.mo.bean.Pair;
import com.chaychan.viewlib.PowerfulEditText;

/**
 * @author Admin
 * @date 2017/4/7
 */

public class PairAdapter extends RecyclerViewAdapter<Pair> {


    public PairAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, Pair pair) {
        if (pair == null) {
            return;
        }
        if (TextUtils.isEmpty(pair.getKey())) {
            return;
        }
        holder.setText(R.id.tv_title, pair.getKey());
        if (!TextUtils.isEmpty(pair.getUnit())) {
            holder.setText(R.id.tv_value, pair.getUnit());
        }
        if (pair.getKey().contains("视频")) {
            holder.setVisible(R.id.tv_value, false);
            ((EditText) holder.getView(R.id.input_value)).setHint("请拍摄要上传的视频");
            holder.getView(R.id.input_value).setEnabled(false);
            holder.setVisible(R.id.iv_checked, true);
        }
        if (pair.getKey().contains("图片")) {
            holder.setVisible(R.id.tv_value, false);
            ((EditText) holder.getView(R.id.input_value)).setHint("请拍摄要上传的图片");
            holder.getView(R.id.input_value).setEnabled(false);
            holder.setVisible(R.id.iv_checked, true);
        }
    }

    @Override
    protected void setOnListener(ViewGroup parent, final ViewHolder viewHolder, int viewType) {
        super.setOnListener(parent, viewHolder, viewType);

        PowerfulEditText editText = viewHolder.getConvertView().findViewById(R.id.input_value);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int index = viewHolder.getLayoutPosition();
                if (index < 0 || index >= getItemCount()) {
                    return;
                }
                Pair pair = mDatas.get(index);
                if (pair == null) {
                    return;
                }
                pair.setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
