package com.science.bamboorattan.common;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2016/12/5 0005.
 */

public class UBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case DownloadManager.ACTION_DOWNLOAD_COMPLETE:
                break;
            case DownloadManager.ACTION_NOTIFICATION_CLICKED:
                Intent viewDownloadIntent = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
                viewDownloadIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(viewDownloadIntent);
                break;
            default:
                break;

        }
    }

    private void installApk(Context context, long downloadId) {
        DownloadManager dManager = (DownloadManager) context.getSystemService(Context
                .DOWNLOAD_SERVICE);
        Uri downloadFileUri = dManager.getUriForDownloadedFile(downloadId);
        if (downloadFileUri != null) {
            Logger.d("download succeed.");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //添加这一句表示对目标应用临时授权该Uri所代表的文件
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
            intent.setDataAndType(downloadFileUri, "application/vnd.android.package-archive");
            context.startActivity(intent);
        } else {
            Logger.d("download file uri is null, download failed. downloadId is " + downloadId);
        }

    }
}
