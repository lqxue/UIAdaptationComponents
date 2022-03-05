package com.workleshuadailypreview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.workleshuadailypreview.enitity.IThumbViewInfo;
import com.workleshuadailypreview.loader.ItemLongClickListener;
import com.workleshuadailypreview.loader.VideoClickListener;
import com.workleshuadailypreview.view.BasePhotoFragment;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lqx on 2017/9/12.

 */

public final class GPreviewBuilder {
    private Activity mContext;
    private Intent intent;
    private Class className;
    private VideoClickListener videoClickListener;
    private ItemLongClickListener itemLongClickListener;

    private GPreviewBuilder(@NonNull Activity activity) {
        mContext = activity;
        intent = new Intent();
    }

    /***
     * 设置开始启动预览
     * @param activity  启动
     *@return GPreviewBuilder
     * **/
    public static GPreviewBuilder from(@NonNull Activity activity) {
        return new GPreviewBuilder(activity);
    }

    /***
     * 设置开始启动预览
     * @param fragment  启动
     *@return GPreviewBuilder
     * **/
    public static GPreviewBuilder from(@NonNull Fragment fragment) {
        return new GPreviewBuilder(fragment.getActivity());
    }

    /****
     *自定义预览activity 类名
     * @param className   继承GPreviewActivity
     *@return GPreviewBuilder
     * **/
    public GPreviewBuilder to(@NonNull Class className) {
        this.className = className;
        intent.setClass(mContext, className);
        return this;
    }
    /****
     *自定义预览activity 类名  方便自定义数据。
     * @param className 继承GPreviewActivity
     * @param bundle 需携带的参数
     *@return GPreviewBuilder
     * **/
    public GPreviewBuilder to(@NonNull Class className,@NonNull Bundle bundle) {
        this.className = className;
        intent.setClass(mContext, className);
        intent.putExtras(bundle);
        return this;
    }
    /***
     * 设置数据源
     * @param imgUrls 数据
     *@param   <T>    你的实体类类型
     * @return GPreviewBuilder
     * **/
    public <T extends IThumbViewInfo> GPreviewBuilder setData(@NonNull ArrayList<T> imgUrls) {
        intent.putExtra("imagePaths", imgUrls);
        return this;
    }

    /***
     * 设置单个数据源
     * @param imgUrl 数据
     *@param   <E>    你的实体类类型
     * @return GPreviewBuilder
     * **/
    public <E extends IThumbViewInfo> GPreviewBuilder setSingleData(@NonNull E imgUrl) {
        ArrayList arrayList = new ArrayList<Serializable>();
        arrayList.add(imgUrl);
        intent.putParcelableArrayListExtra("imagePaths", arrayList);
        return this;
    }

    /***
     * 设置数据源
     * @param className 你的Fragment类
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setUserFragment(@NonNull Class<? extends BasePhotoFragment> className) {
        intent.putExtra("className", className);
        return this;
    }

    /***
     * 设置默认索引
     * @param currentIndex 数据
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setCurrentIndex(int currentIndex) {
        intent.putExtra("position", currentIndex);
        return this;
    }

    /***
     * 设置指示器类型
     * @param indicatorType 枚举
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setType(@NonNull IndicatorType indicatorType) {
        intent.putExtra("type", indicatorType);
        return this;
    }

    /***
     * @deprecated  use {@link #isDisableDrag(boolean) }
     * 设置图片禁用拖拽返回
     * @param isDrag  true  可以 false 默认 true
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setDrag(boolean isDrag) {
        intent.putExtra("isDrag", isDrag);
        return this;
    }
    /***
     * 设置图片禁用拖拽返回
     * @param isDrag  true  可以 false 默认 true
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder isDisableDrag(boolean isDrag) {
        intent.putExtra("isDrag", isDrag);
        return this;
    }

    /***
     * 设置图片禁用拖拽返回
     * @param isDrag  true  可以 false 默认 true
     * @param sensitivity   sensitivity MAX_TRANS_SCALE 的值来控制灵敏度。
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder isDisableDrag(boolean isDrag, float sensitivity) {
        intent.putExtra("isDrag", isDrag);
        intent.putExtra("sensitivity", sensitivity);
        return this;
    }

    /***
     * @deprecated  use {@link #isDisableDrag(boolean,float) }
     * 设置图片禁用拖拽返回
     * @param isDrag  true  可以 false 默认 true
     * @param sensitivity   sensitivity MAX_TRANS_SCALE 的值来控制灵敏度。
     * @return GPreviewBuilder
     *
     * **/
    public GPreviewBuilder setDrag(boolean isDrag, float sensitivity) {
        intent.putExtra("isDrag", isDrag);
        intent.putExtra("sensitivity", sensitivity);
        return this;
    }

    /***
     * 是否设置为一张图片时 显示指示器  默认显示
     * @param isShow   true  显示 false 不显示
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setSingleShowType(boolean isShow) {
        intent.putExtra("isShow", isShow);
        return this;
    }

    /***
     * 设置超出内容点击退出（黑色区域）
     * @param isSingleFling  true  可以 false
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setSingleFling(boolean isSingleFling) {
        intent.putExtra("isSingleFling", isSingleFling);
        return this;
    }

    /***
     *  设置动画的时长
     * @param setDuration  单位毫秒
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setDuration(int setDuration) {
        intent.putExtra("duration", setDuration);
        return this;
    }
    /***
     *  设置是否全屏
     * @param isFullscreen  单位毫秒
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setFullscreen(boolean isFullscreen) {
        intent.putExtra("isFullscreen", isFullscreen);
        return this;
    }
    /***
     *  设置只有图片没有放大或者的缩小状态触退出
     * @param isScale    true false
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setIsScale(boolean isScale) {
        intent.putExtra("isScale", isScale);
        return this;
    }
    /***
     *  设置是视频点击播放回调
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setOnVideoPlayerListener(VideoClickListener listener) {
        this.videoClickListener = listener;
        return this;
    }

    /***
     *  设置图片长按
     * @return GPreviewBuilder
     * **/
    public GPreviewBuilder setOnItemLongClickListener(ItemLongClickListener listener) {
        this.itemLongClickListener = listener;
        return this;
    }

    /***
     * 启动
     * **/
    public void start() {
        if (className == null) {
            intent.setClass(mContext, GPreviewActivity.class);
        } else {
            intent.setClass(mContext, className);
        }
        BasePhotoFragment.listener=videoClickListener;
        BasePhotoFragment.itemLongClickListener=itemLongClickListener;
        mContext.startActivity(intent);
        mContext.overridePendingTransition(0, 0);
        intent = null;
        mContext = null;
    }

    /***
     * 指示器类型
     * ***/
    public enum IndicatorType {
        Dot, Number
    }
}
