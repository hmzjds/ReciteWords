package com.example.reciteword.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ImageUtils {
	public static Bitmap zoomImg(Bitmap src, int newWidth, int newHeight) {
		int width = src.getWidth();
		int height = src.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap dst = Bitmap.createBitmap(src, 0, 0, width, height, matrix, true);
		return dst;
	}

	public static void bindView(final ImageView view, String pathName) {
		int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		view.measure(widthMeasureSpec, heightMeasureSpec);

		int width = view.getMeasuredWidth();
		int height = view.getMeasuredHeight();
		 Bitmap bitmap = BitmapFactory.decodeFile(pathName);
		 if(bitmap!=null){
		 Bitmap dst = zoomImg(bitmap, width, height);
		 bitmap.recycle();
		 view.setImageBitmap(dst);
		 }
	}

}
