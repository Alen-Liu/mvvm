package com.example.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author 刘伦
 * @date 2018/9/25
 */

public class CollectionUtils {
    /**
     * get size of a Array safely
     *
     * @param objects   a array
     * @return          it's length
     */
    public static int sizeOf(Object[] objects) {
        return objects == null ? 0 : objects.length;
    }

    /**
     * get size of a Collection safely.
     *
     * @param collection    a Collection
     * @return              size of the collection
     */
    public static int sizeOf(Collection collection) {
        return collection == null ? 0: collection.size();
    }


    /**
     * @param collection a collection, see java.util.Collection
     * @return whether the collection is empty
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    /**
     * @param map a map, see java.util.Map
     * @return whether the map is empty
     */
    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    /**
     * join list, element of the two lists should have the same parent class
     *
     * @param c1  fist list
     * @param c2  second list
     * @param <R> result list element type
     * @param <T1> first list element type
     * @param <T2> second list element type
     * @return a new ArrayList contains all the elements
     */
    public static <R, T1 extends R, T2 extends R> List<? extends R> join(List<T1> c1, List<T2> c2) {
        if (c1 == null && c2 == null) {
            return null;
        } else if (c1 == null) {
            return c2;
        } else if (c2 == null) {
            return c1;
        } else {
            List<R> result = new ArrayList<>(c1.size() + c2.size());
            result.addAll(c1);
            result.addAll(c2);
            return result;
        }
    }

    public static <T> boolean equal(List<T> l1, List<T> l2, Comparator<T> comparator) {
        if (l1 == l2) {
            return true;
        }
        if (l1 == null || l2 == null || l1.size() != l2.size()) {
            return false;
        }
        for (int i=0; i<l1.size(); i++) {
            boolean isFind = false;
            for(int j=0; j<l2.size(); j++) {
                if(comparator.compare(l1.get(i), l2.get(j)) == 0) {
                    isFind = true;
                }
            }
            if(!isFind) {
                return false;
            }
        }
        return true;
    }
}
