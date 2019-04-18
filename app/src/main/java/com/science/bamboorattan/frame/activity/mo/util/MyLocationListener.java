package com.science.bamboorattan.frame.activity.mo.util;

import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.Poi;
import com.science.bamboorattan.frame.activity.mo.constant.GlobalConstants;

import java.util.List;

public class MyLocationListener implements BDLocationListener{
    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
//        double latitude = bdLocation.getLatitude();    //获取纬度信息
//        double longitude = bdLocation.getLongitude();    //获取经度信息
//        float radius = bdLocation.getRadius();    //获取定位精度，默认值为0.0f
//        String addr = bdLocation.getAddrStr();    //获取详细地址信息
//        String country = bdLocation.getCountry();    //获取国家
//        String province = bdLocation.getProvince();    //获取省份
//        String city = bdLocation.getCity();    //获取城市
//        String district = bdLocation.getDistrict();    //获取区县
//        String street = bdLocation.getStreet();
//
//        String coorType = bdLocation.getCoorType();
//        //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准
//
//        int errorCode = bdLocation.getLocType();
//        //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
        StringBuffer sb = new StringBuffer(256);

        sb.append("time : ");
        sb.append(bdLocation.getTime());    //获取定位时间

        sb.append("\nerror code : ");
        sb.append(bdLocation.getLocType());    //获取类型类型

        sb.append("\nlatitude : ");
        sb.append(bdLocation.getLatitude());    //获取纬度信息

        sb.append("\nlontitude : ");
        sb.append(bdLocation.getLongitude());    //获取经度信息

        sb.append("\nradius : ");
        sb.append(bdLocation.getRadius());    //获取定位精准度

        if (bdLocation.getLocType() == BDLocation.TypeGpsLocation){

            // GPS定位结果
            sb.append("\nspeed : ");
            sb.append(bdLocation.getSpeed());    // 单位：公里每小时

            sb.append("\nsatellite : ");
            sb.append(bdLocation.getSatelliteNumber());    //获取卫星数

            sb.append("\nheight : ");
            sb.append(bdLocation.getAltitude());    //获取海拔高度信息，单位米

            sb.append("\ndirection : ");
            sb.append(bdLocation.getDirection());    //获取方向信息，单位度

            sb.append("\naddr : ");
            sb.append(bdLocation.getAddrStr());    //获取地址信息

            sb.append("\ndescribe : ");
            sb.append("gps定位成功");

        } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation){

            // 网络定位结果
            sb.append("\naddr : ");
            sb.append(bdLocation.getAddrStr());    //获取地址信息

            sb.append("\noperationers : ");
            sb.append(bdLocation.getOperators());    //获取运营商信息

            sb.append("\ndescribe : ");
            sb.append("网络定位成功");

        } else if (bdLocation.getLocType() == BDLocation.TypeOffLineLocation) {

            // 离线定位结果
            sb.append("\ndescribe : ");
            sb.append("离线定位成功，离线定位结果也是有效的");

        } else if (bdLocation.getLocType() == BDLocation.TypeServerError) {

            sb.append("\ndescribe : ");
            sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");

        } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkException) {

            sb.append("\ndescribe : ");
            sb.append("网络不同导致定位失败，请检查网络是否通畅");

        } else if (bdLocation.getLocType() == BDLocation.TypeCriteriaException) {

            sb.append("\ndescribe : ");
            sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");

        }

        sb.append("\nlocationdescribe : ");
        sb.append(bdLocation.getLocationDescribe());    //位置语义化信息

        Log.i("BaiduLocationApiDem", sb.toString());

        //现在已经定位成功，可以将定位的数据保存下来，这里我新建的一个Const类，保存全局静态变量
        GlobalConstants.LONGITUDE = bdLocation.getLongitude();
        GlobalConstants.LATITUDE = bdLocation.getLatitude();
        GlobalConstants.ADDRESS = bdLocation.getAddrStr();
    }
}
