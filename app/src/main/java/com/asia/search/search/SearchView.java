package com.asia.search.search;

import java.util.List;

import roomDB.SearchModel;

interface SearchView {

    void setList(List<SearchModel> models);

    void setItem(SearchModel model);


}
