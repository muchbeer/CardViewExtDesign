package muchbeer.raum.cardviewextdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    ConstraintLayout expandableView;
    Button arrowBtn;
    CardView cardView;
    GiannaBezierView mLike_listener;
    private String mColorCode = "#E74C3C";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        expandableView = findViewById(R.id.expandableView);
        arrowBtn = findViewById(R.id.arrowBtn);
        cardView = findViewById(R.id.cardView);
        mLike_listener = findViewById(R.id.heart);

final ConstraintLayout measureLayout = findViewById(R.id.measure_view);

loadGadielLikeStatus();
     /*   ViewTreeObserver vto = measureLayout.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {

                    Log.d(LOG_TAG, "tHE  is something wrong with the view measurement: ");
                    measureLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    measureLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int width  = measureLayout.getMeasuredWidth();
                int height = measureLayout.getMeasuredHeight();
                Log.d(LOG_TAG, "The width is: " +  width);
                Log.d(LOG_TAG, "tHE height is: " + height);

            }
        });*/
        // float height = getWidth
       // loadGadielLikeStatus();
        mLike_listener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This view is happening",Toast.LENGTH_SHORT).show();

            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           //     Toast.makeText(getApplicationContext(), "This view is happening",Toast.LENGTH_SHORT).show();
                Intent startTrial = new Intent(MainActivity.this, Trial_Activity.class);
                startActivity(startTrial);
            }
        });
        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });



        // Helper class for creating swipe to dismiss and drag and drop
        // functionality.
      /*  ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                        ItemTouchHelper.DOWN | ItemTouchHelper.UP,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                // Get the from and to positions.
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                // Swap the items and notify the adapter.
                Collections.swap(mMichezoData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }


            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                // Remove the item from the dataset.
                mMichezoData.remove(viewHolder.getAdapterPosition());
                // Notify the adapter.
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });


        // Attach the helper to the RecyclerView.
        helper.attachToRecyclerView(mRecyclerView);*/


    }

    private void loadGadielLikeStatus() {
        //in real life we'd lookup the selected courses module statuses from the content provider
     boolean currentStatus = true;
     mLike_listener.setmHeartModuleStatus(currentStatus);
         //   mLike_listener.setmColorCode(mColorCode);
    }

}
