package com.example.mgkan.hackathon_lost_pets.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mgkan on 2016-08-03.
 */
public class PetResponse {
  @SerializedName("page")
  private int page;
  @SerializedName("results")
  private List<Pet> results;
  @SerializedName("total_results")
  private int totalResults;
  @SerializedName("total_pages")
  private int totalPages;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public List<Pet> getResults() {
    return results;
  }

  public void setResults(List<Pet> results) {
    this.results = results;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(int totalResults) {
    this.totalResults = totalResults;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }
}
