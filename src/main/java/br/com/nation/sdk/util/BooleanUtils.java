package br.com.nation.sdk.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class BooleanUtils {

    public static <T> void checkBoolean(boolean check, T element, Consumer<T> onTrue, Consumer<T> onFalse) {
        if (check) {
            if (onTrue != null) onTrue.accept(element);
        } else {
            if (onFalse != null) onFalse.accept(element);
        }
    }

}
