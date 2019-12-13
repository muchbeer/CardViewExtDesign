package muchbeer.raum.cardviewextdesign;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class GiannaBezierView extends View {
    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;


    private Path path;
    private int mFillColor;
    private Paint paint;

    public GiannaBezierView(Context context) {
        super(context);
        init(null, 0);
        path = new Path();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public GiannaBezierView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GiannaBezierView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {


        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.GiannaBezierView, defStyle, 0);


        mFillColor = getContext().getResources().getColor(R.color.gianna_nice);

        setUpGiannaLoveSpace();

        a.recycle();



    }

    private void setUpGiannaLoveSpace() {

     /*   mModuleRectangles = new Rect();
        int x =getPaddingLeft () + (int) spacing;
         int y = getPaddingTop();

         mModuleRectangles = new Rect(x, y, x + (int) mShapeShize, (int) mShapeShize );
*/

    }


    private void invalidateTextPaintAndMeasurements() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Fill the canvas with background color
        canvas.drawColor(Color.WHITE);
        paint.setShader(null);

       // float width = getContext().getResources().getDimension(R.dimen.heart_width);
      //  float height = getContext().getResources().getDimension(R.dimen.heart_height);

        float width = 20;
        float height = 50;
        // Starting point
        path.moveTo(width / 2, height / 5);

        // Upper left path
        path.cubicTo(5 * width / 14, 0,
                0, height / 15,
                width / 28, 2 * height / 5);

        // Lower left path
        path.cubicTo(width / 14, 2 * height / 3,
                3 * width / 7, 5 * height / 6,
                width / 2, height);

        // Lower right path
        path.cubicTo(4 * width / 7, 5 * height / 6,
                13 * width / 14, 2 * height / 3,
                27 * width / 28, 2 * height / 5);

        // Upper right path
        path.cubicTo(width, height / 15,
                9 * width / 14, 0,
                width / 2, height / 5);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);

    }




}
