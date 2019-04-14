package com.example.reciteword.utils;


import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

/**
 * @author hjw
 * @data 2016年9月18日下午4:42:47
 */
public class PopUpWindowUtil {

	private PopupWindow window;
	private View contentView;

	public PopUpWindowUtil() {
		super();
	}
	public PopUpWindowUtil(View contentView, int width, int height) {
		this.contentView = contentView;
		window = new PopupWindow(contentView, width, height);
		window.setFocusable(true);
		window.setTouchable(true);
		window.setOutsideTouchable(true);
		window.setBackgroundDrawable(new ColorDrawable(0x00000000));
	}
	public void showAtLocation(View parent, int gravity, int x, int y) {
		window.showAtLocation(parent, gravity, x, y);
	}
	public void showAsDropDown(View anchor, int xoff, int yoff) {
		window.showAsDropDown(anchor, xoff, yoff);
	}
	
	public void showAsDropDowmInCenter(View parent){
		int[] location = new int[2];
		parent.getLocationInWindow(location);
		contentView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		int x = location[0]+(parent.getWidth()-contentView.getMeasuredWidth())/2;
		int y = location[1]+parent.getHeight();
		showAtLocation(parent, Gravity.NO_GRAVITY, x, y);
		
	}
	public void setAnimationStyle(int animationStyle){
		window.setAnimationStyle(animationStyle);
	}
	public void dissMiss() {
		window.dismiss();

	}
	public void setOnDismissListener(final OndismissListener listener){
		if(listener!=null){
			window.setOnDismissListener(new OnDismissListener() {
				@Override
				public void onDismiss() {
					listener.onDismiss();
				}
			});
		}
	}
	
	public interface OndismissListener{
		public void onDismiss();
	}

	public int getWidth() {
		return window.getWidth();
	}
	public int getHeight(){
		return window.getHeight();
	}
}
