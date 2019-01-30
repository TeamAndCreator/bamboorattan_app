package com.science.bamboorattan.frame.activity.mo.cameraview;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**

 */
public class ImageUtil {
    /*
    旋转图片
     */
    public static Bitmap getRotateBitmap(Bitmap bitmap, float rotateDegree) {
        Matrix matrix = new Matrix();
        matrix.setRotate(rotateDegree);
        Bitmap rotateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        return rotateBitmap;
    }
}
