package muchbeer.raum.cardviewextdesign;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class GiannaBezierView extends View {
    private static final int HEART_SHAPE = 0;

    float mOutlineWidth;
    float mShapeShize;
    float mSpacing;
    Rect mModuleRectangle;

    private int mOutlineColor;
    private Paint mPaintOutline;
    private int mFillColor;
    private Paint mPaintFill;
    private int mShape;
    private float mRadius;
    private Path path;
       private Paint heart_outline_paint;

    public boolean ismHeartModuleStatus() {
        return mHeartModuleStatus;
    }

    public void setmHeartModuleStatus(boolean mHeartModuleStatus) {
        this.mHeartModuleStatus = mHeartModuleStatus;
    }

    private boolean mHeartModuleStatus;



    private static int WIDTH = 300;
    private static int HEIGHT = 100;

    public GiannaBezierView(Context context) {
        super(context);
        init(null, 0);

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
        if(isInEditMode())
            setupEditModeValues();

        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.GiannaBezierView, defStyle, 0);

        heart_outline_paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //  setUpGiannaLoveSpace();
        path = new Path();
        mOutlineColor = a.getColor(R.styleable.GiannaBezierView_outlineColor, Color.BLACK);
        mShape = a.getInt(R.styleable.GiannaBezierView_shapeSelection, HEART_SHAPE);


        a.recycle();

        mOutlineWidth = 6f;
        mShapeShize = 170f;
        mSpacing = 30f;

        mRadius = (mShapeShize - mOutlineWidth) / 2;
        mFillColor =getContext().getResources().getColor(R.color.gadiel_red);

                //mSetColor;
                //getContext().getResources().getColor(R.color.gadiel_red);
        mPaintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintFill.setStyle(Paint.Style.FILL);
        mPaintFill.setColor(mFillColor);

     //   mOutlineColor = Color.BLUE;
        mPaintOutline = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintOutline.setStrokeJoin(Paint.Join.MITER);
        mPaintOutline.setStyle(Paint.Style.STROKE);
        mPaintOutline.setStrokeWidth(mOutlineWidth);
        mPaintOutline.setColor(mOutlineColor);

    }

    private void setupEditModeValues() {
        boolean exampleHeartModuleValues;
        exampleHeartModuleValues = true;
        setmHeartModuleStatus(exampleHeartModuleValues);

    }

    private void setUpGiannaLoveSpaceSize(int width, int height) {

        int availableWidth = width - getPaddingLeft() - getPaddingRight();

        int availalbeHeight = height -getPaddingBottom() -getPaddingTop();
        mModuleRectangle = new Rect();
        int xOriginal  = 0 + getPaddingLeft();
        int yOriginal = 0 + getPaddingTop();
       /* int xShapeSize = (int) mShapeShize;
        int yShapeSize = (int) mShapeShize-65;*/

        int xShapeSize = (int) availableWidth;
        int yShapeSize = (int) availalbeHeight;
        mModuleRectangle = new Rect(xOriginal,yOriginal, yShapeSize, xShapeSize);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        heart_outline_paint.setStrokeJoin(Paint.Join.MITER);
        heart_outline_paint.setColor(Color.RED); // Change the boundary color
        heart_outline_paint.setStrokeWidth(6);
        heart_outline_paint.setStyle(Paint.Style.STROKE);

        float length = 50;

        float actualWidth=  mModuleRectangle.centerX();
        float actualHeight = mModuleRectangle.centerY();


     float xHeart = actualWidth;
     float yHeart = actualHeight;


     //   float x = 280;
      //  float y = 414;

        canvas.rotate(45,xHeart,yHeart);

       // path.moveTo(x,y);
        path.moveTo(xHeart,yHeart);
        path.lineTo(xHeart-50, yHeart);
        path.arcTo(new RectF(xHeart-length-(length/2),yHeart-length,xHeart-(length/2),yHeart),90,180);
        path.arcTo(new RectF(xHeart-length,yHeart-length-(length/2),xHeart,yHeart-(length/2)),180,180);
        path.lineTo(xHeart ,yHeart );
        path.close();

        if(mShape == HEART_SHAPE) {
            if (mHeartModuleStatus)
                canvas.drawPath(path, mPaintFill);

            canvas.drawPath(path, mPaintOutline);
            //   canvas.drawCircle(x, y, mRadius, mPaintFill);
            // canvas.drawCircle(x, y, mRadius, mPaintOutline);
        }else {
            drawCircle(canvas);
        }

    }

    private void drawCircle(Canvas canvas) {
        float x = mModuleRectangle.centerX();
        float y = mModuleRectangle.centerY();
        if (mHeartModuleStatus)
            canvas.drawCircle(x, y, mRadius, mPaintFill);

        canvas.drawCircle(x,y, mRadius, mPaintOutline);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredWidth = 0;
        int desiredHeight = 0;

        int specWidth = MeasureSpec.getSize(widthMeasureSpec);
        int availableWidth = specWidth - getPaddingLeft() - getPaddingRight();

      //  desiredWidth = (int) mShapeShize;
        desiredWidth = availableWidth;
        desiredWidth += getPaddingLeft() + getPaddingRight();

        int specHeight = MeasureSpec.getSize(heightMeasureSpec);
        int availableHeight = specHeight - getPaddingTop() - getPaddingBottom();
      //  desiredHeight = (int) mShapeShize;
        desiredHeight = availableHeight;
        desiredHeight += getPaddingTop() + getPaddingBottom();

        int width = resolveSizeAndState(desiredWidth, widthMeasureSpec, 0);
        int height = resolveSizeAndState(desiredHeight, heightMeasureSpec, 0);

        setMeasuredDimension(width, height);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_UP:
                boolean moduleIndex = findItemAtPoint(event.getX(), event.getY());
                    onHeartShapeSelected(moduleIndex);
                return true;
        }

        return super.onTouchEvent(event);

          }

    private void onHeartShapeSelected(boolean moduleIndex) {
        if(!moduleIndex)
            return;

        mHeartModuleStatus = !mHeartModuleStatus;
        invalidate();
    }

    private boolean findItemAtPoint(float x, float y) {

        boolean moduleIndex = false;
        if(mModuleRectangle.contains((int) x, (int) y)) {
            moduleIndex = true;
            
        }
        return moduleIndex;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
      //  super.onSizeChanged(w, h, oldw, oldh);

        setUpGiannaLoveSpaceSize(w, h);
    }
}
