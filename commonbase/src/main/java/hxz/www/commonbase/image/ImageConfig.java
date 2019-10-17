package hxz.www.commonbase.image;

import android.widget.ImageView;

/**
 * Dec: 图片配置类   常用的信息
 */
public class ImageConfig  {


    protected String url;
    protected ImageView imageView;
    protected int placeholder;//占位符
    protected int errorPic;//错误占位符


    public String getUrl() {
        return url;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getPlaceholder() {
        return placeholder;
    }

    public int getErrorPic() {
        return errorPic;
    }
}
