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
import com.science.bamboorattan.frame.activity.mo.BamRattanFragment;
import com.science.bamboorattan.frame.activity.mo.PersonalFragment;


/**
 *
 */
public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private IndexFragment housFragement;
    private BamRattanFragment bamRattanFragment;
    private PersonalFragment personalFragment;
    private RadioGroup main_radiogroup;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private RadioButton main_rab_house;
    private RadioButton main_rab_bamrattan;
    private RadioButton main_rab_personal;

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
        main_rab_bamrattan = findViewById(R.id.main_rab_bamrattan);
        main_rab_personal = findViewById(R.id.main_rab_personal);
        main_rab_house.setTextColor(this.getResources().getColor(R.color.abc_press));
    }

    private void initFragment() {

        housFragement = new IndexFragment();
        bamRattanFragment = new BamRattanFragment();
        personalFragment = new PersonalFragment();
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
                main_rab_personal.setTextColor(this.getResources().getColor(R.color.abc_normal));
                main_rab_bamrattan.setTextColor(this.getResources().getColor(R.color.abc_normal));
                break;
            case R.id.main_rab_bamrattan:
                replaceFragment(bamRattanFragment);
                main_rab_bamrattan.setTextColor(this.getResources().getColor(R.color.abc_press));
                main_rab_personal.setTextColor(this.getResources().getColor(R.color.abc_normal));
                main_rab_house.setTextColor(this.getResources().getColor(R.color.abc_normal));
                break;
            case R.id.main_rab_personal:
                replaceFragment(personalFragment);
                main_rab_personal.setTextColor(this.getResources().getColor(R.color.abc_press));
                main_rab_bamrattan.setTextColor(this.getResources().getColor(R.color.abc_normal));
                main_rab_house.setTextColor(this.getResources().getColor(R.color.abc_normal));
                break;
            default:
                break;
        }
    }


}