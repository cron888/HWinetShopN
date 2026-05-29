package org.skypro.skyshop.search;

import org.skypro.skyshop.Searchable;

public class SearchEngine {
    private final Searchable[] searchableItems;
    private int itemCount = 0;

    public SearchEngine(int capacity) {
        this.searchableItems = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (itemCount < searchableItems.length) {
            searchableItems[itemCount++] = item;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < itemCount; i++) {
            Searchable item = searchableItems[i];
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[resultCount++] = item;
                if (resultCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}