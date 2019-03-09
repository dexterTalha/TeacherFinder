package com.studentwelfare.teacherfinder.adapters;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.studentwelfare.teacherfinder.DataPackage.ListingGridData;
import com.studentwelfare.teacherfinder.R;
import com.studentwelfare.teacherfinder.interfaces.LoadMoreData;

import java.io.IOException;
import java.lang.annotation.Target;
import java.net.URL;
import java.util.List;

class LoadingViewHolder extends RecyclerView.ViewHolder{

    public ProgressBar progressBar;

    public LoadingViewHolder(@NonNull View itemView) {
        super(itemView);
        //progressBar = itemView.findViewById(R.id.progress);

    }
}


class ItemViewHolder extends RecyclerView.ViewHolder{
    TextView price, title, id;
    ImageView imageView;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        /*imageView = itemView.findViewById(R.id.listing_image);
        price = itemView.findViewById(R.id.listing_price);
        title = itemView.findViewById(R.id.listing_title);
        id = itemView.findViewById(R.id.list_id);*/
    }
}

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_ITEM = 0, VIEW_TYPE_LOADING = 1;
    StaggeredGridLayoutManager linearLayoutManager;
    LoadMoreData loadMoreData;
    boolean isLoading;
    Activity activity;
    List<ListingGridData> items;
    int visibleThreshHold = 10;
    int lastVisibleItem;
    int totalItemCount;
    int height=0, width;
    Bitmap bt = null;
    Target target;

    class getImg extends AsyncTask<String, String, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            //Bitmap bt = null;
            try {
                URL url = new URL(strings[0]);
                bt = BitmapFactory.decodeStream(url.openStream());

            } catch (IOException e) {
                e.printStackTrace();
            }
            return bt;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if(bitmap != null)
                height = bitmap.getHeight();
        }
    }

    public MyAdapter(RecyclerView recyclerView, Activity activity, List<ListingGridData> item) {
        this.activity = activity;
        this.items = item;

        linearLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();

                lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPositions(null)[0];

                if(!isLoading && totalItemCount <= (lastVisibleItem+visibleThreshHold)){
                    if(loadMoreData != null){
                        loadMoreData.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });

    }
    /*public int getLastVisibleItem(int[] lastVisibleItemPositions) {
        int maxSize = 0;
        for (int i = 0; i < lastVisibleItemPositions.length; i++) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i];
            }
            else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }*/

    @Override
    public int getItemViewType(int position) {
        return items.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setLoadMoreData(LoadMoreData loadMoreData) {
        this.loadMoreData = loadMoreData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       /* if(viewType == VIEW_TYPE_ITEM){
            View view = LayoutInflater.from(activity)
                    .inflate(R.layout.listing_card_layout,parent,false);
            return new ItemViewHolder(view);
        }else if(viewType == VIEW_TYPE_LOADING){
            View view = LayoutInflater.from(activity)
                    .inflate(R.layout.progress_layout,parent,false);
            return new LoadingViewHolder(view);
        }*/

        return null;
    }


    public static final String ImageURL = "";

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ItemViewHolder) {
            ListingGridData item = items.get(i);
            final ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            itemViewHolder.title.setText(item.get_title());
            itemViewHolder.price.setText(item.get_price());
            itemViewHolder.id.setText(item.getAd_id());
            new getImg().execute(ImageURL + item.get_image());


            if (height > 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
                itemViewHolder.imageView.setLayoutParams(layoutParams);
                //Toast.makeText(activity, ""+height, Toast.LENGTH_LONG).show();
            }
            /*if(item.get_image() != null) {

                Target target = new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                        float ratio = (float)bitmap.getHeight() / (float) bitmap.getWidth();
                        itemViewHolder.imageView.setHeightRatio(ratio);
                        itemViewHolder.imageView.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                        //Toast.makeText(activity, "Error ", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                };
                Picasso.get().load(Uri.parse(ImageURL + item.get_image())).into(target);


                Glide.with(activity)
                        .load(Uri.parse(ImageURL + item.get_image()))
                        .into(itemViewHolder.imageView);
            }else{
                Glide.with(activity)
                        .load(Uri.parse("android.resource://com.nixbymedia.meromitra/"+R.drawable.logo_mero_new))
                        .into(itemViewHolder.imageView);
            }
        }else if(viewHolder instanceof LoadingViewHolder){
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder)viewHolder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }*/
        }


    }
}





