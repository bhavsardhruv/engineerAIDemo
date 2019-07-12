package com.anthesis.assignment.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    @SerializedName("hits")
    private List<HitsItem> hits;

    @SerializedName("hitsPerPage")
    private int hitsPerPage;

    @SerializedName("processingTimeMS")
    private int processingTimeMS;

    @SerializedName("query")
    private String query;

    @SerializedName("nbHits")
    private int nbHits;

    @SerializedName("page")
    private int page;

    @SerializedName("params")
    private String params;

    @SerializedName("nbPages")
    private int nbPages;

    @SerializedName("exhaustiveNbHits")
    private boolean exhaustiveNbHits;

    public List<HitsItem> getHits() {
        return hits;
    }

    public void setHits(List<HitsItem> hits) {
        this.hits = hits;
    }

    public int getHitsPerPage() {
        return hitsPerPage;
    }

    public void setHitsPerPage(int hitsPerPage) {
        this.hitsPerPage = hitsPerPage;
    }

    public int getProcessingTimeMS() {
        return processingTimeMS;
    }

    public void setProcessingTimeMS(int processingTimeMS) {
        this.processingTimeMS = processingTimeMS;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getNbHits() {
        return nbHits;
    }

    public void setNbHits(int nbHits) {
        this.nbHits = nbHits;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public boolean isExhaustiveNbHits() {
        return exhaustiveNbHits;
    }

    public void setExhaustiveNbHits(boolean exhaustiveNbHits) {
        this.exhaustiveNbHits = exhaustiveNbHits;
    }

    @Override
    public String toString() {
        return
                "Response{" +
                        "hits = '" + hits + '\'' +
                        ",hitsPerPage = '" + hitsPerPage + '\'' +
                        ",processingTimeMS = '" + processingTimeMS + '\'' +
                        ",query = '" + query + '\'' +
                        ",nbHits = '" + nbHits + '\'' +
                        ",page = '" + page + '\'' +
                        ",params = '" + params + '\'' +
                        ",nbPages = '" + nbPages + '\'' +
                        ",exhaustiveNbHits = '" + exhaustiveNbHits + '\'' +
                        "}";
    }
}