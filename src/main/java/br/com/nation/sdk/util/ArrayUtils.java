package br.com.nation.sdk.util;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@RequiredArgsConstructor
public final class ArrayUtils {

    public static Object[] merge(Set<Object> arraySet, Object[] array, Object[] arrayToMerge) {
        arraySet.addAll(Arrays.asList(array));
        arraySet.addAll(Arrays.asList(arrayToMerge));
        return arraySet.toArray();
    }

    public static Object[] merge(Object[] array, Object[] arrayToMerge) {
        return merge(new HashSet<>(), array, arrayToMerge);
    }

    public static Object[] linkedMerge(Object[] array, Object[] arrayToMerge) {
        return merge(new LinkedHashSet<>(), array, arrayToMerge);
    }

}
