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

public class principalAdapter extends RecyclerView.Adapter<principalAdapter.EViewHolder> {
    private Context mContext;
    private ArrayList<BrandsCars> mList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public principalAdapter(Context context, ArrayList<BrandsCars> list){
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public EViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.brands, parent, false);
        return new EViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EViewHolder holder, int position) {
        BrandsCars currentItem = mList.get(position);

        String imageUrl = currentItem.getImage();
        String brand = currentItem.getBrand_name();

        holder.mTextView.setText(brand);

        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class EViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView;

        public EViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view_brand);
            mTextView = itemView.findViewById(R.id.text_view_brand);

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
