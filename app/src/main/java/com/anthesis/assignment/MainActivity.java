package com.anthesis.assignment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anthesis.assignment.adapter.DataAdapter;
import com.anthesis.assignment.model2.Hint;
import com.anthesis.assignment.model2.HitsItem;
import com.anthesis.assignment.utils.MySharedConfig;
import com.anthesis.assignment.utils.PaginationAdapterCallback;
import com.anthesis.assignment.utils.PaginationScrollListener;
import com.anthesis.assignment.utils.Request;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PaginationAdapterCallback {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerview;
    private List<HitsItem> responseArrayList;
    private DataAdapter adapter;
    private static final int PAGE_START = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int TOTAL_PAGES;
    private int currentPage = PAGE_START;
    LinearLayoutManager linearLayoutManager;
    public TextView total_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseArrayList = new ArrayList<>();
        init();

    }

    private void init() {
        recyclerview = findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(linearLayoutManager);
        adapter = new DataAdapter(MainActivity.this);
        recyclerview.setAdapter(adapter);

        total_selected=findViewById(R.id.total_selected);
        new MySharedConfig(MainActivity.this).setTotal("0");

        setTotal();
        currentPage=0;
        getFirstPageList();
        loadSwipeRefresh();
        loadPageRefresh();
    }
    private void loadSwipeRefresh(){
        final SwipeRefreshLayout swipeRefresh=findViewById(R.id.swipeRefresh);
        swipeRefresh.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_green_dark, android.R.color.holo_blue_dark);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isLoading = false;
                isLastPage = false;
                currentPage=0;
                getFirstPageList();
                swipeRefresh.setRefreshing(false);
            }
        });
    }
    private void loadPageRefresh(){
        recyclerview.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;
                getNextPageList();
            }

            @Override
            public int getTotalPageCount() {
                return TOTAL_PAGES;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
    }
    public void setTotal(){
        MySharedConfig sharedConfig=new MySharedConfig(MainActivity.this);
        total_selected.setText(sharedConfig.getTotal());
    }
    private void getFirstPageList() {
        try {
            Request.create()
                    .getData("story",currentPage)
                    .enqueue(new Callback<Hint>() {
                        @Override
                        public void onResponse(Call<Hint> call, Response<Hint> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getHits().size() > 0) {
                                    for (int i=0;i<response.body().getHits().size();i++) {
                                        responseArrayList = response.body().getHits();
                                        adapter.clear();
                                        adapter.addAll(responseArrayList);
                                        adapter.notifyDataSetChanged();
                                    }

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Hint> call, Throwable t) {
                            Log.e(TAG, "Model Mismatch: " + t.getMessage());
                        }
                    });


        } catch (Exception e) {
            Log.e(TAG, "Country GetDataError: " + e.getMessage());
        }
    }
    private void getNextPageList() {
        try {
            Request.create()
                    .getData("story",currentPage)
                    .enqueue(new Callback<Hint>() {
                        @Override
                        public void onResponse(Call<Hint> call, Response<Hint> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getHits().size() > 0) {
                                    for (int i=0;i<response.body().getHits().size();i++) {
                                        responseArrayList = response.body().getHits();
                                        adapter.addAll(responseArrayList);
                                    }

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Hint> call, Throwable t) {
                            Log.e(TAG, "Model Mismatch: " + t.getMessage());
                        }
                    });


        } catch (Exception e) {
            Log.e(TAG, "Country GetDataError: " + e.getMessage());
        }
    }

    @Override
    public void retryPageLoad() {
        getFirstPageList();
    }
}
