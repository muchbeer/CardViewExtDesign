package muchbeer.raum.cardviewextdesign;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class GadielView extends View {
    private String mColorCode = "#1F618D"; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mGadielDrawable;



    private boolean mGainaStatusView;
    float mOutlineWidth;
    float mShapeShize;
    float mSpacing;
    Rect mModuleRectangle;

    private int mOutlineColor;
    private Paint mPaintOutline;
    private int mFillColor;
    private Paint mPaintFill;

    Paint paint;
    Path path;
    private int mFillColorDrawable;

    public GadielView(Context context) {
        super(context);
        init(null, 0);
    }

    public GadielView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GadielView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.GiannaBezierView, defStyle, 0);

        if (a.hasValue(R.styleable.GiannaBezierView_gadielDrawable)) {
            mGadielDrawable = a.getDrawable(
                    R.styleable.GiannaBezierView_gadielDrawable);
            mGadielDrawable.setCallback(this);
        }


        a.recycle();


    }

    private void setupModuleRectangles() {

        mModuleRectangle = new Rect();
        int xOriginal  = 0;
        int yOriginal = 0;
        int xShapeSize = (int) mShapeShize;

        mModuleRectangle = new Rect(xOriginal,yOriginal, xShapeSize, xShapeSize);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;



        // Draw the example drawable on top of the text.
        if (mGadielDrawable != null) {
            mGadielDrawable.setBounds(paddingLeft, paddingTop,
                    paddingLeft + contentWidth, paddingTop + contentHeight);
           // mGadielDrawable.setColorFilter();
            mFillColorDrawable = Color.parseColor(mColorCode);
            PorterDuff.Mode mMode = PorterDuff.Mode.SRC_ATOP;
            // mGadielDrawable.setColorFilter(mFillColorDrawable,mMode);

            mGadielDrawable.draw(canvas);
            mGadielDrawable.setTint(mFillColor);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
               // drawable.setColorFilter(new BlendModeColorFilter(color, BlendMode.SRC_ATOP));
             //   mGadielDrawable.setColorFilter(new BlendModeColorFilter(mFillColor),BlendMode.SRC_ATOP);

            } else {
                //drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
               // mGadielDrawable.setColorFilter(mFillColorDrawable,mMode);

            }

           // mGadielDrawable.clearColorFilter();
          //  clearColorFilter();
            //mGadielDrawable.setTint();
           // mGadielDrawable.

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    return true;
                case MotionEvent.ACTION_UP:
                    return true;
            }

        return super.onTouchEvent(event);
    }

    public Drawable getGadielDrawable() {
        return mGadielDrawable;
    }

    public void setGadielDrawable(Drawable gadielDrawable) {
        this.mGadielDrawable = gadielDrawable;
    }

    public String getmColorCode() {
        return mColorCode;
    }

    public void setmColorCode(String mColorCode) {
        this.mColorCode = mColorCode;
    }
}
