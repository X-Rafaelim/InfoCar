package com.example.infocar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class secondAdapter extends RecyclerView.Adapter<secondAdapter.model_ViewHolder> {
    private Context mContext;
    private ArrayList<ModelsCars> mList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(secondAdapter.OnItemClickListener listener){
        mListener = listener;
    }

    public secondAdapter(Context context, ArrayList<ModelsCars> list){
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public model_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.models, parent, false);
        return new model_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull model_ViewHolder holder, int position) {
        ModelsCars currentItem = mList.get(position);

        String imageUrl = currentItem.getImage();
        String model = currentItem.getModels();

        holder.mTextView.setText(model);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class model_ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView;




        public model_ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view_model);
            mTextView = itemView.findViewById(R.id.text_view_model);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }


}
