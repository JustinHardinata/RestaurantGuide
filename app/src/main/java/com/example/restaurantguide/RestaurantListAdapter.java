package com.example.restaurantguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> implements Filterable  {

    private final ArrayList<Restaurant> mWordList;
    private ArrayList<Restaurant> mWordListFull;
    private LayoutInflater mInflater;
    private final String TAG = "RestaurantListAdapter";
    public static final String EXTRA_MESSAGE = "com.example.restaurantguide.MESSAGE";
    private OnNoteListener mOnNoteListener;

    public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView restaurantName;
        public final TextView restaurantType;
        public final TextView restaurantLocation;
        public final TextView restaurantRating;
        public final TextView restaurantSymbol;
        public ImageView restaurantPhoto;
        final RestaurantListAdapter mRestaurantListAdapter;
        OnNoteListener onNoteListener;



        public RestaurantViewHolder(View itemView, RestaurantListAdapter adapter, OnNoteListener onNoteListener) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.name);
            restaurantType = itemView.findViewById(R.id.type);
            restaurantLocation = itemView.findViewById(R.id.location);
            restaurantRating = itemView.findViewById(R.id.rating);
            restaurantSymbol = itemView.findViewById(R.id.symbol);
            restaurantPhoto = itemView.findViewById(R.id.photo);
            this.mRestaurantListAdapter = adapter;
            mOnNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnNoteListener.onNoteClick(getAdapterPosition());
        }

    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }

    public RestaurantListAdapter(Context context, ArrayList<Restaurant> wordList,  OnNoteListener onNoteListener) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        this.mOnNoteListener = onNoteListener;
        mWordListFull = new ArrayList<>(wordList);

    }
    @NonNull
    @Override
    public RestaurantListAdapter.RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.restaurant_list, parent, false);
        return new RestaurantViewHolder(itemView,this, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantListAdapter.RestaurantViewHolder holder, int position) {

        holder.setIsRecyclable(false);
        Restaurant mCurrent = mWordList.get(position);
        holder.restaurantName.setText(mCurrent.getName());
        holder.restaurantType.setText(mCurrent.getType());
        holder.restaurantLocation.setText(mCurrent.getLocation() + "  | ");
        holder.restaurantRating.setText(" /" + mCurrent.getRating() + " Stars");
        holder.restaurantSymbol.setText(mCurrent.getSymbol());
        holder.restaurantSymbol.setVisibility(View.INVISIBLE);
        holder.restaurantPhoto.setImageResource(mCurrent.getImageResource());

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    //sets up filter method to filter the recyclerview based on user input
    @Override
    public Filter getFilter() {
        return wordFilter;
    }
    private Filter wordFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Restaurant> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mWordListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Restaurant item : mWordListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        //adds search results onto list
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mWordList.clear();
            mWordList.addAll((List) results.values);
            notifyDataSetChanged();
        }

    };

}
