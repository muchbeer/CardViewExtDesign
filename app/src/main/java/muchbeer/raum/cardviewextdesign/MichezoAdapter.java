package muchbeer.raum.cardviewextdesign;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MichezoAdapter extends RecyclerView.Adapter<MichezoAdapter.MichezoViewHolder> {

    private static final String LOG_TAG = MichezoAdapter.class.getSimpleName();
    // Member variables.
    private ArrayList<Michezo> mMichezoData;
    private Context mContext;

    public MichezoAdapter(ArrayList<Michezo> mMichezoData, Context mContext) {
        this.mMichezoData = mMichezoData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MichezoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MichezoViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MichezoViewHolder holder, int position) {
        // Get current sport.
        Michezo currentSport = mMichezoData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mMichezoData.size();
    }

    public class MichezoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;

        //Expandable adapter
        ConstraintLayout expandableView;
        Button arrowBtn;
        CardView cardView;


        public MichezoViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mSportsImage = itemView.findViewById(R.id.sportsImage);


            //expandable item
            expandableView = itemView.findViewById(R.id.expandableView);
            arrowBtn = itemView.findViewById(R.id.arrowBtn);
            cardView = itemView.findViewById(R.id.cardView);

            // Set the OnClickListener to the entire view.
         //   itemView.setOnClickListener(this);
            arrowBtn.setOnClickListener(this);

        }
       public void bindTo(Michezo currentSport){
            // Populate the textviews with data.
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());

            // Load the images into the ImageView using the Glide library.
            Glide.with(mContext).load(
                    currentSport.getImageResource()).into(mSportsImage);
        }

        @Override
        public void onClick(View v) {
            Michezo currentSport = mMichezoData.get(getAdapterPosition());
            Log.d(LOG_TAG, "The name of the sport is :"+ currentSport.getInfo());

            if (expandableView.getVisibility()==View.GONE){
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                expandableView.setVisibility(View.VISIBLE);
                arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
            } else {
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                expandableView.setVisibility(View.GONE);
                arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            }
                  /*  Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentSport.getTitle());
            detailIntent.putExtra("image_resource",
                    currentSport.getImageResource());
            mContext.startActivity(detailIntent);*/
        }
    }
}
