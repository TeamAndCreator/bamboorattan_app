package com.science.bamboorattan.frame.activity.mo.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chaychan.viewlib.PowerfulEditText;
import com.orhanobut.logger.Logger;
import com.science.androidbase.mvp.Task;
import com.science.androidbase.mvp.TaskType;
import com.science.androidbase.utils.GsonUtils;
import com.science.androidbase.utils.TextUtils;
import com.science.androidbase.utils.ToastUtils;
import com.science.bamboorattan.R;
import com.science.bamboorattan.common.PresenterFactory;
import com.science.bamboorattan.frame.activity.ABaseActivity;
import com.science.bamboorattan.frame.activity.mo.adapter.PairAdapter;
import com.science.bamboorattan.frame.activity.mo.bean.Pair;
import com.science.bamboorattan.frame.activity.mo.bean.ResultBean;
import com.science.bamboorattan.frame.activity.mo.constant.GlobalConstants;
import com.science.bamboorattan.frame.activity.mo.util.BDLocationUtils;
import com.science.bamboorattan.frame.activity.mo.util.MapUtil;
import com.science.bamboorattan.frame.activity.mo.util.RequestBuildUtil;
import com.science.bamboorattan.frame.activity.mo.util.Table;
import com.science.bamboorattan.frame.activity.mo.util.TableUtil;
import com.science.bamboorattan.listener.OnItemClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class BambooInfoCollectActivity extends ABaseActivity{


    private static final int SELECT_REQUEST_CODE = 0X0010;
    private static final int SELECT_RESULT_CODE = 0X0011;
    private RecyclerView mRecyclerview;
    private PairAdapter mAdapter;
    private TextView mCatalogTv;
    private AppCompatButton mSubmitBtn;
    private Toolbar mTooblBar;
    private TextView mTitleTv;
    private TextView mSelectionTv;
    private RelativeLayout mSelectionRl;
    private List<Pair> mPairs = new ArrayList<>();
    private Table mCatalog;
    private String mCatalogValue;
    private String id;
    private PowerfulEditText mVideoEdt;
    private String mVideoPath;
    private PowerfulEditText mImageEdt;
    private String mImagePath;
    private int mMediaType;
    private String mImageName;
    private String mVideoName;
    private TextView mCatalogTime;
    private TextView mCatalogGps;
    private boolean flag;
    private static Context context;
    private RelativeLayout mTimeGps;
    private Button mLocationBtn;
    private TextView mGPSTv;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_genus_add;
    }

    @Override
    protected void getExtraParams() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        mCatalog = (Table) intent.getSerializableExtra("catalog");
    }

    @Override
    protected void initView() {
        mTooblBar = findViewById(R.id.toolbar);
        mTitleTv = findViewById(R.id.toolbar_title_mid);
        mSelectionRl = findViewById(R.id.ll_select);
        mRecyclerview = findViewById(R.id.recyclerview);
        mCatalogTv = findViewById(R.id.tv_catalog);
        mSubmitBtn = findViewById(R.id.btn_submit);
        mSelectionTv = findViewById(R.id.tv_name);
        mCatalogTime = findViewById(R.id.time_catalog);
        mCatalogGps = findViewById(R.id.gps_catalog);
        mGPSTv = findViewById(R.id.gps_info);
        mTimeGps = findViewById(R.id.time_gps);
        mLocationBtn = findViewById(R.id.btn_location);

    }

    @Override
    protected void initData() {//加载信息采集框

        setSupportActionBar(mTooblBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获取系统时间
        String date = simpleDateFormat.format(System.currentTimeMillis());
        String tableName = TableUtil.getTableName(mCatalog);
//        //定位，获得采集地点
//        BDLocationUtils bdLocationUtils = new BDLocationUtils(BambooInfoCollectActivity.this);
//        bdLocationUtils.doLocation();//开启定位

        mTitleTv.setText(String.format(getResources().getString(R.string.add_table), tableName));
        if (tableName.contains("藤")){

                if (mCatalog == Table.TGENUS) {
                    mSelectionRl.setVisibility(View.GONE);
                    mTimeGps.setVisibility(View.GONE);
                } else if (mCatalog == Table.TSPEC) {
                    mCatalogTv.setText("藤属(*必选)：");
                    mCatalogTime.setText("采集时间："+date);
                    mCatalogGps.setText("采集地点：");
                } else {
                    mCatalogTv.setText("藤种(*必选)：");
                    mTimeGps.setVisibility(View.GONE);
                }

        }else{

                if (mCatalog == Table.GENUS) {
                    mSelectionRl.setVisibility(View.GONE);
                    mTimeGps.setVisibility(View.GONE);
                } else if (mCatalog == Table.SPEC) {
                    mCatalogTv.setText("竹属(*必选)：");
                    mCatalogTime.setText("采集时间："+date);
                    mCatalogGps.setText("采集地点：");
                } else {
                    mCatalogTv.setText("竹种(*必选)：");
                    mTimeGps.setVisibility(View.GONE);
                }

        }

        mPairs.clear();
        mPairs.addAll(MapUtil.getList(mCatalog));
        mAdapter = new PairAdapter(this, R.layout.item_pair);
        mRecyclerview.setAdapter(mAdapter);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager
                    .VERTICAL, false));
        mAdapter.add(0, mPairs.size(), mPairs);

    }

    @Override
    protected void initEvent() {
        mTooblBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mSelectionRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSelectionActivity();
            }
        });

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (mCatalog == Table.SPEC) {
//                    submitVideoFile();
//                } else {
                    submitOrder();
//                }
            }
        });

        mLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BDLocationUtils bdLocationUtils = new BDLocationUtils(BambooInfoCollectActivity.this);
                bdLocationUtils.doLocation();//开启定位
                bdLocationUtils.mLocationClient.start();//开始定位
                mGPSTv.setText(GlobalConstants.ADDRESS);
            }
        });

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                if (o instanceof Pair) {
                    String des = ((Pair) o).getKey();
                    if (TextUtils.isEmpty(des)) {
                        return;
                    }
                    if (des.contains("视频")) {
                        mVideoEdt = view.findViewById(R.id.input_value);
                        mMediaType = 0;
                        Intent intent = new Intent(BambooInfoCollectActivity.this, RecordActivity
                                .class);
                        intent.putExtra("mediaType", mMediaType);
                        startActivityForResult(intent, 10086);
                    }

                    if (des.contains("图片")) {
                        mImageEdt = view.findViewById(R.id.input_value);
                        mMediaType = 1;
                        Intent intent = new Intent(BambooInfoCollectActivity.this, RecordActivity
                                .class);
                        intent.putExtra("mediaType", mMediaType);
                        startActivityForResult(intent, 10086);
                    }
                }
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });
    }

    @Override
    protected void initPermission() {

    }


    @Override
    public void onSuccess(String result, int page, Integer actionType) {
        Logger.d(result);
        try {
            ResultBean bean = GsonUtils.getInstance().transitionToBean(result, ResultBean.class);
            if (bean == null) {
                return;
            }
            if (bean.getCode() == 200) {
                ToastUtils.showLongToast(this, bean.getMsg());
                finish();
            } else {
                ToastUtils.showLongToast(this, bean.getMsg());
            }
        } catch (Exception e) {
            ToastUtils.showLongToast(this, e.getMessage());
        }
//        switch (actionType) {
//            case 0:
//                handleUploadVideo(result);
//                break;
//            case 1:
//                handleUploadImage(result);
//                break;
//            case 2:
//                handleSubmitResult(result);
//                break;
//            default:
//                break;
//        }

    }

    @Override
    public void onFailure(String error, int page, Integer actionType) {
        super.onFailure(error, page, actionType);
        Logger.d(error);
    }

    private void startSelectionActivity() {
        Intent intent = new Intent(this, SelectionActivity.class);
        intent.putExtra("catalog", mCatalog);
        intent.putExtra("catalogValue", mCatalogValue);
        startActivityForResult(intent, SELECT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SELECT_REQUEST_CODE && resultCode == SELECT_RESULT_CODE) {
            if (data != null) {
                String name = data.getStringExtra("name");
                String id = data.getStringExtra("id");
                mCatalogValue = name;
                this.id = id;
                mSelectionTv.setText(name);
                mSelectionTv.setTextColor(getResources().getColor(R.color.user_account_color));
                mSelectionTv.setTag(id);
            }
        }

        if (requestCode == 10086 && resultCode == 10000) {//摄像
            if (data != null) {
                int mediaType = data.getIntExtra("mediaType", 0);
                String url = data.getStringExtra("url");
                if (mediaType != mMediaType) {//mediaType为实际摄像过程中拍的是视频文件（0）还是照片（1），mMediaType为选择添加的是视频（0）还是照片（1）
                    if (mMediaType == 0) {//拍摄错误的处理
                        ToastUtils.showShortToast(BambooInfoCollectActivity.this, "请拍摄视频");//错误（1,0）
                    } else {
                        ToastUtils.showShortToast(BambooInfoCollectActivity.this, "请拍摄照片");//错误（0,1）
                    }
                    return;
                }
                if (mediaType == 0) {
                    if (TextUtils.isEmpty(url)) {
                        ToastUtils.showShortToast(BambooInfoCollectActivity.this, "视频保存失败");
                        return;
                    }
                    mVideoName = data.getStringExtra("fileName");
                    mVideoPath = url;
                    mVideoEdt.setText(url);
                } else {
                    if (TextUtils.isEmpty(url)) {
                        ToastUtils.showShortToast(BambooInfoCollectActivity.this, "图片保存失败");
                        return;
                    }
                    mImageName = data.getStringExtra("fileName");
                    mImagePath = url;
                    mImageEdt.setText(url);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void submitOrder() {
        Map<String, String> params = RequestBuildUtil.getRequestParams(mCatalog, id,
                mCatalogValue, mPairs);
        if (mCatalog == Table.SPEC||mCatalog == Table.TSPEC) {
//            params.put("specVidio", mVideoPath);
////            params.put("specVidioName", mVideoName);
//            params.put("specImgs", mImagePath);
        }
        String url = RequestBuildUtil.getRequestUrl(mCatalog);
        PresenterFactory.getInstance().createPresenter(this)
                .execute(new Task.TaskBuilder()
                        .setTaskType(TaskType.Method.POST)
                        .setParams(params)
                        .setUrl(url)
                        .setPage(1)
                        .setActionType(2)
                        .createTask());
    }

}
