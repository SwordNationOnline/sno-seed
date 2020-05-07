package br.com.nation.sdk.inventory.paginator;

import java.util.*;

public class Paginator<T> extends Vector<T> {

    private final int pageSize;

    public Paginator(int pageSize, T... objects) {
        this(pageSize, Arrays.asList(objects));
    }

    public Paginator(int pageSize, Collection<T> objects) {
        this.pageSize = pageSize; addAll(objects);
    }

    public int totalPages() {
        return (int) Math.ceil((double) size() / pageSize);
    }


    public boolean exists(int page) {
        if (page < 0) {
            return false;
        }

        if (page > totalPages()) {
            return false;
        }

        try {
            List<T> list = this.getPage(page);

            if (list == null || list.isEmpty()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<T> getPage(int page) {
        if (page < 0 || page >= totalPages()) {
            return null;
        }

        List<T> objects = new ArrayList<>();

        int min = page * pageSize;
        int max = ((page * pageSize) + pageSize);

        if (max > size()) max = size();

        for (int i = min; max > i; i++) {
            objects.add(get(i));
        }

        return objects;
    }
}
