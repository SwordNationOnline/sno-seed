package br.com.nation.sdk.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class EnumUtils {

    @SuppressWarnings("rawtypes")
    public static String[] transform(Enum... enums) {
        return Arrays.stream(enums).map(Enum::toString).collect(Collectors.toCollection(LinkedHashSet::new)).toArray(new String[]{});
    }

}
