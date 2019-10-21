package hxz.www.commonbase.view.roundView;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import hxz.www.commonbase.R;



public class RoundImageView extends AppCompatImageView {

    private int mInitXRadius;
    private int mInitYRadius;
    private int mXRadius;
    private int mYRadius;
    private boolean mRoundTopLeft = true;
    private boolean mRoundTopRight = true;
    private boolean mRoundBottomLeft = true;
    private boolean mRoundBottomRight = true;
    private int mBorderWidth;
    private ColorStateList mBorderColor = ColorStateList.valueOf(Color.WHITE);

    /**
     * @param context  context
     * @param attrs    attrs
     * @param defStyle defStyle
     */
    public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    /**
     * @param context context
     * @param attrs   attrs
     */
    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /**
     * @param context context
     */
    public RoundImageView(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView);
            mXRadius = a.getDimensionPixelSize(R.styleable.RoundImageView_rv_cornerRadius, mXRadius);
            mYRadius = a.getDimensionPixelSize(R.styleable.RoundImageView_rv_cornerRadius, mYRadius);
            mInitXRadius = mXRadius;
            mInitYRadius = mYRadius;
            mRoundTopLeft = a.getBoolean(R.styleable.RoundImageView_rv_cornerRadius_TL, mRoundTopLeft);
            mRoundTopRight = a.getBoolean(R.styleable.RoundImageView_rv_cornerRadius_TR, mRoundTopRight);
            mRoundBottomLeft = a.getBoolean(R.styleable.RoundImageView_rv_cornerRadius_BL, mRoundBottomLeft);
            mRoundBottomRight = a.getBoolean(R.styleable.RoundImageView_rv_cornerRadius_BR, mRoundBottomRight);

            mBorderWidth = a.getDimensionPixelSize(R.styleable.RoundImageView_rv_strokeWidth, mBorderWidth);
            mBorderColor = a.getColorStateList(R.styleable.RoundImageView_rv_strokeColor);
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int height = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        if (mInitXRadius == 0) {
            mXRadius = width / 2;
        }
        if (mInitYRadius == 0) {
            mYRadius = height / 2;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (!(drawable instanceof BitmapDrawable)) {
            return;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (bitmap == null) {
            return;
        }
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        RectF rect = new RectF(paddingLeft, paddingTop, width - paddingRight, height - paddingBottom);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        RectF src = new RectF(0.0f, 0.0f, bitmapWidth, bitmapHeight);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(src, rect, Matrix.ScaleToFit.CENTER);
        processScaleType(matrix, bitmapWidth, bitmapHeight, width, height);
        shader.setLocalMatrix(matrix);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
        canvas.drawRoundRect(rect, mXRadius, mYRadius, paint);

        if (mBorderWidth > 0) {
            Paint borderPaint = new Paint();
            borderPaint.setStyle(Paint.Style.STROKE);
            borderPaint.setAntiAlias(true);
            borderPaint.setColor(mBorderColor.getColorForState(getDrawableState(), Color.WHITE));
            borderPaint.setStrokeWidth(mBorderWidth);

            RectF borderRect = new RectF();
            borderRect.set(rect);
            borderRect.inset((mBorderWidth) / 2, (mBorderWidth) / 2);
            canvas.drawRoundRect(borderRect, mXRadius, mYRadius, borderPaint);
        }

        if (!mRoundTopLeft) {
            Rect rectTL = new Rect(0, 0, width / 2, height / 2);
            canvas.drawRect(rectTL, paint);
        }
        if (!mRoundTopRight) {
            Rect rectTR = new Rect(width / 2, 0, width, height / 2);
            canvas.drawRect(rectTR, paint);
        }
        if (!mRoundBottomLeft) {
            Rect rectBL = new Rect(0, height / 2, width / 2, height);
            canvas.drawRect(rectBL, paint);
        }
        if (!mRoundBottomRight) {
            Rect rectBR = new Rect(width / 2, height / 2, width, height);
            canvas.drawRect(rectBR, paint);
        }
    }

    private void processScaleType(Matrix matrix, int dwidth, int dheight, int vwidth, int vheight) {
        ScaleType scaleType = getScaleType();
        if (ScaleType.CENTER == scaleType) {
            matrix.setTranslate((int) ((vwidth - dwidth) * 0.5f + 0.5f),
                    (int) ((vheight - dheight) * 0.5f + 0.5f));
        } else if (ScaleType.CENTER_CROP == scaleType) {
            float scale;
            float dx = 0, dy = 0;

            if (dwidth * vheight > vwidth * dheight) {
                scale = (float) vheight / (float) dheight;
                dx = (vwidth - dwidth * scale) * 0.5f;
            } else {
                scale = (float) vwidth / (float) dwidth;
                dy = (vheight - dheight * scale) * 0.5f;
            }

            matrix.setScale(scale, scale);
            matrix.postTranslate((int) (dx + 0.5f), (int) (dy + 0.5f));
        } else if (ScaleType.CENTER_INSIDE == scaleType) {
            float scale;
            float dx;
            float dy;

            if (dwidth <= vwidth && dheight <= vheight) {
                scale = 1.0f;
            } else {
                scale = Math.min((float) vwidth / (float) dwidth,
                        (float) vheight / (float) dheight);
            }

            dx = (int) ((vwidth - dwidth * scale) * 0.5f + 0.5f);
            dy = (int) ((vheight - dheight * scale) * 0.5f + 0.5f);

            matrix.setScale(scale, scale);
            matrix.postTranslate(dx, dy);
        }
    }

    /**
     * 设置圆角弧度
     *
     * @param x 宽
     * @param y 高
     */
    public void setCornerRadius(int x, int y) {
        mXRadius = x;
        mYRadius = y;

        mInitXRadius = mXRadius;
        mInitYRadius = mYRadius;
        invalidate();
    }

    public void setBorderWidth(int borderWidth) {
        mBorderWidth = borderWidth;
        invalidate();
    }

    public void setBorderColor(ColorStateList borderColor) {
        mBorderColor = borderColor;
        invalidate();
    }

}
