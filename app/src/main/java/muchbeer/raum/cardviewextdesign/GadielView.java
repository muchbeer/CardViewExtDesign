package muchbeer.raum.cardviewextdesign;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class GadielView extends View {
    private String mColorCode = "#1F618D"; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mGadielDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    private boolean mGainaStatusView;
    float mOutlineWidth;
    float mShapeShize;
    float spacing;

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



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        mFillColor = getContext().getResources().getColor(R.color.gadiel_red);
        mPaintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintFill.setStyle(Paint.Style.FILL);
        mPaintFill.setColor(mFillColor);

        // Draw the example drawable on top of the text.
        if (mGadielDrawable != null) {
            mGadielDrawable.setBounds(paddingLeft, paddingTop,
                    paddingLeft + contentWidth, paddingTop + contentHeight);
           // mGadielDrawable.setColorFilter();
            mFillColorDrawable = Color.parseColor(mColorCode);
            PorterDuff.Mode mMode = PorterDuff.Mode.SRC_ATOP;
           // mGadielDrawable.setColorFilter(mFillColor, PorterDuff.Mode.DST_OVER);
            mGadielDrawable.draw(canvas);
            mGadielDrawable.setColorFilter(mFillColorDrawable,mMode);
           // mGadielDrawable.

        }

    }

    public Drawable getGadielDrawable() {
        return mGadielDrawable;
    }

    public void setGadielDrawable(Drawable gadielDrawable) {
        this.mGadielDrawable = gadielDrawable;
    }


     /**
     * Gets the example color attribute value.
     *
     * @return The example color attribute value.
     */
    public int getExampleColor() {
        return mExampleColor;
    }

    /**
     * Sets the view's example color attribute value. In the example view, this color
     * is the font color.
     *
     * @param exampleColor The example color attribute value to use.
     */
    public void setExampleColor(int exampleColor) {
        mExampleColor = exampleColor;
       // invalidateTextPaintAndMeasurements();
    }

    /**
     * Gets the example dimension attribute value.
     *
     * @return The example dimension attribute value.
     */
    public float getExampleDimension() {
        return mExampleDimension;
    }

    /**
     * Sets the view's example dimension attribute value. In the example view, this dimension
     * is the font size.
     *
     * @param exampleDimension The example dimension attribute value to use.
     */
    public void setExampleDimension(float exampleDimension) {
        mExampleDimension = exampleDimension;
     //   invalidateTextPaintAndMeasurements();
    }


}
