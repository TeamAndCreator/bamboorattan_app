package com.science.bamboorattan.frame.activity.mo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.science.bamboorattan.R;
import com.science.bamboorattan.frame.activity.mo.IndexFragment;
import com.science.bamboorattan.frame.activity.mo.MineFragment;
import com.science.bamboorattan.frame.activity.mo.ZhuFragment;


/**
 *
 */
public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private IndexFragment housFragement;
    private MineFragment mineFragment;
    private ZhuFragment certificFragment;
    private RadioGroup main_radiogroup;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private RadioButton main_rab_house;
    private RadioButton main_rab_mine;
    private RadioButton main_rab_certific;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
        initFragment();
        initView();
    }

    private void initView() {
        main_radiogroup = findViewById(R.id.main_radiogroup);
        main_radiogroup.setOnCheckedChangeListener(this);
        main_rab_house = findViewById(R.id.main_rab_house);
        main_rab_mine = findViewById(R.id.main_rab_mine);
        main_rab_certific = findViewById(R.id.main_rab_certific);
        main_rab_house.setTextColor(this.getResources().getColor(R.color.abc_press));
    }

    private void initFragment() {

        housFragement = new IndexFragment();
        mineFragment = new MineFragment();
        certificFragment = new ZhuFragment();
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.main_linear, housFragement);
        transaction.commit();

    }


    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_linear, fragment);
        transaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_rab_house:
                replaceFragment(housFragement);
                main_rab_house.setTextColor(this.getResources().getColor(R.color.abc_press));
                main_rab_certific.setTextColor(this.getResources().getColor(R.color.abc_normal));
                main_rab_mine.setTextColor(this.getResources().getColor(R.color.abc_normal));
                break;
            case R.id.main_rab_mine:
                replaceFragment(mineFragment);
                main_rab_mine.setTextColor(this.getResources().getColor(R.color.abc_press));
                main_rab_certific.setTextColor(this.getResources().getColor(R.color.abc_normal));
                main_rab_house.setTextColor(this.getResources().getColor(R.color.abc_normal));
                break;
            case R.id.main_rab_certific:
                replaceFragment(certificFragment);
                main_rab_certific.setTextColor(this.getResources().getColor(R.color.abc_press));
                main_rab_mine.setTextColor(this.getResources().getColor(R.color.abc_normal));
                main_rab_house.setTextColor(this.getResources().getColor(R.color.abc_normal));
                break;
            default:
                break;
        }
    }


}