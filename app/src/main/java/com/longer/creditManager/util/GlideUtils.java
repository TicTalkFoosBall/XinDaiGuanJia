//package com.longer.creditManager.util;
//
//import android.content.Context;
//import android.net.Uri;
//import android.widget.ImageView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//
//import com.bumptech.glide.request.RequestListener;
//import com.bumptech.glide.request.target.Target;
//
//import com.longer.creditManager.MyApplication;
//import com.longer.creditManager.R;
//
//
//import java.io.File;
//
//
///**
// * C r e a t e d b y h p o n  2 0 1 7 / 2 / 8 .
// */
//
//public class GlideUtils {
//
//    private Context context;
//
//    public GlideUtils(Context context) {
//        this.context = context;
//    }
//
//    private GlideUtils() {
//
//    }
//
//    /**
//     * 加载图片
//     *
//     * @param url
//     * @param imageView
//     */
//    public static void loadImageCenterCrop(Context context,String url, ImageView imageView) {
//        Glide.with(context)
//                .load(url)
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .dontAnimate()
//                .into(imageView);
//    }
//    public static void loadImageCenterCrop(Context context,int url, ImageView imageView) {
//        Glide.with(context)
//                .load(url)
//                .into(imageView);
//    }
//
////    public static void loadImageNormal(String url, ImageView imageView) {
////        Glide.with(MyApplication.get()).load(resolveUrl(url)).into(imageView);
////    }
//
////    public static void loadImageNormalWithListener(String url, GlideDrawableImageViewTarget glideDrawableImageViewTarget) {
////        Glide.with(MyApplication.get()).load(url).into(glideDrawableImageViewTarget);
////    }
//
//    /**
//     *  加 载 验 证 码
//     *
//     * @param url
//     * @param imageView
//     */
//    public static void loadVerificationCode(String url, ImageView imageView) {
//        Glide.with(MyApplication.get())
//                .load(Uri.parse(url))
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .skipMemoryCache(true)
//                .centerCrop()
//                .listener(new RequestListener<Uri, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, Uri model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, Uri model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//
//                        return false;
//                    }
//                })
//                .into(imageView);
//    }
//
//    public static void loadImageNormalMultiImageView(String url, final ImageView imageView) {
//        Glide.with(MyApplication.get())
//                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
////                .listener(new RequestListener<String, GlideDrawable>() {
////                    @Override
////                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
////                        return false;
////                    }
////
////                    @Override
////                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
////                        if (imageView == null) {
////                            return false;
////                        }
////                        if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
////                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
////                        }
////                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
////                        int vw = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
////                        float scale = (float) vw / (float) resource.getIntrinsicWidth();
////                        int vh = Math.round(resource.getIntrinsicHeight() * scale);
////                        params.height = vh + imageView.getPaddingTop() + imageView.getPaddingBottom();
////                        imageView.setLayoutParams(params);
////                        return false;
////                    }
////                })
//                .into(imageView);
//    }
//
//    public static void loadImageCenterCropUri(Uri uri, ImageView imageView) {
//        Glide.with(MyApplication.get())
//                .load(uri)
//                .centerCrop()
//                .into(imageView);
//    }
//
//    public static void loadImageFromFile(File uploadImgFile, ImageView ivFoodImage) {
//        Glide.with(MyApplication.get()).load(uploadImgFile).into(ivFoodImage);
//    }
////    public static String resolveUrl(String url) {
////        if (url == null)
////            return "";
////        if (url.startsWith("http:")) {
////            return url;
////        } else {
////            return HttpManager.get().BASE_IMAGE_URL + (url.startsWith("/") ? url : "/" + url);
////        }
////    }
//}
