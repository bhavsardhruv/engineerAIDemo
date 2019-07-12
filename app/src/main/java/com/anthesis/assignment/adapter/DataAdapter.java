package com.anthesis.assignment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.anthesis.assignment.MainActivity;
import com.anthesis.assignment.R;
import com.anthesis.assignment.model2.HitsItem;
import com.anthesis.assignment.utils.MySharedConfig;
import com.anthesis.assignment.utils.PaginationAdapterCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    //    List<HitsItem> arrayList;
    private int lastPosition = -1;
    private List<HitsItem> HitsItems;
    private Context context;
    private boolean isLoadingAdded = false;
    private boolean retryPageLoad = false;
    private MySharedConfig mySharedConfig;
    private PaginationAdapterCallback mCallback;
    private String errorMsg;
    private boolean checked = false;

    public DataAdapter(Context context) {
        this.context = context;
        this.mCallback = (PaginationAdapterCallback) context;
        HitsItems = new ArrayList<>();
        mySharedConfig = new MySharedConfig(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.layout_single_item, viewGroup, false);
                viewHolder = new MyViewHolder(viewItem);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.item_progress, viewGroup, false);
                viewHolder = new LoadingVH(viewLoading);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder myViewHolder, final int i) {
        final HitsItem item = HitsItems.get(i);
        switch (getItemViewType(i)) {
            case ITEM:
                final MyViewHolder houseVH = (MyViewHolder) myViewHolder;
                houseVH.txt_title.setText(item.getTitle());
                houseVH.txt_date.setText(item.getCreatedAt());
                houseVH.select_switch.setTag(i);
                houseVH.select_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if (isChecked) {
                            mySharedConfig.setTotal(String.valueOf(Integer.parseInt(mySharedConfig.getTotal()) + 1));
                        } else {
                            if (Integer.parseInt(mySharedConfig.getTotal()) != 0) {
                                mySharedConfig.setTotal(String.valueOf(Integer.parseInt(mySharedConfig.getTotal()) - 1));
                            }
                        }
                        ((MainActivity) context).setTotal();
                    }
                });

//            case LOADING:
//                LoadingVH loadingVH = (LoadingVH) myViewHolder;
//                if (retryPageLoad) {
//                    loadingVH.mErrorLayout.setVisibility(View.VISIBLE);
//                    loadingVH.mErrorTxt.setText(
//                            errorMsg != null ?
//                                    errorMsg :
//                                    "Unknown Error");
//
//                } else {
//                    loadingVH.mErrorLayout.setVisibility(View.GONE);
//                }
//                break;
        }
    }

    @Override
    public int getItemCount() {
        return HitsItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == HitsItems.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    public void add(HitsItem r) {
        HitsItems.add(r);
        notifyItemInserted(HitsItems.size() - 1);
    }

    public void addAll(List<HitsItem> h_list) {
        for (HitsItem HitsItem : h_list) {
            add(HitsItem);
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new HitsItem());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;
        int position = HitsItems.size() - 1;
        HitsItem HitsItem = getItem(position);
        if (HitsItem != null) {
            HitsItems.remove(position);
            notifyItemRemoved(position);
        }
    }

    public HitsItem getItem(int position) {
        return HitsItems.get(position);
    }

    public void remove(HitsItem r) {
        int position = HitsItems.indexOf(r);
        if (position > -1) {
            HitsItems.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public void showRetry(boolean show, @Nullable String errorMsg) {
        retryPageLoad = show;
        notifyItemChanged(HitsItems.size() - 1);

        if (errorMsg != null) this.errorMsg = errorMsg;
    }

    public String getDateCurrentTimeZone(long timestamp) {
        try {
            Calendar calendar = Calendar.getInstance();
            TimeZone tz = TimeZone.getDefault();
            calendar.setTimeInMillis(timestamp * 1000);
            calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date currenTimeZone = (Date) calendar.getTime();
            return sdf.format(currenTimeZone);
        } catch (Exception e) {
        }
        return "";
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_title, txt_date;
        private Switch select_switch;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_title = (itemView).findViewById(R.id.txt_title);
            txt_date = (itemView).findViewById(R.id.txt_date);
            select_switch = (itemView).findViewById(R.id.select_switch);
//            select_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    if (isChecked) {
//
//                        mySharedConfig.setTotal(String.valueOf(Integer.parseInt(mySharedConfig.getTotal()) + 1));
//                    } else {
//                        if (Integer.parseInt(mySharedConfig.getTotal()) != 0) {
//                            mySharedConfig.setTotal(String.valueOf(Integer.parseInt(mySharedConfig.getTotal()) - 1));
//                        }
//                    }
//                    ((MainActivity)context).setTotal();
//                }
//            });
        }
    }

    protected class LoadingVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ProgressBar mProgressBar;
        private ImageButton mRetryBtn;
        private TextView mErrorTxt;
        private LinearLayout mErrorLayout;

        public LoadingVH(View itemView) {
            super(itemView);
//            mProgressBar = (ProgressBar) itemView.findViewById(R.id.loadmore_progress);
            mRetryBtn = (ImageButton) itemView.findViewById(R.id.loadmore_retry);
            mErrorTxt = (TextView) itemView.findViewById(R.id.loadmore_errortxt);
            mErrorLayout = (LinearLayout) itemView.findViewById(R.id.loadmore_errorlayout);

            mRetryBtn.setOnClickListener(this);
            mErrorLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.loadmore_retry:
                case R.id.loadmore_errorlayout:
                    showRetry(false, null);
                    mCallback.retryPageLoad();
                    break;
            }
        }
    }
}