package br.com.nation.sdk.database.sql.execution;

import br.com.nation.SAOSeed;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@RequiredArgsConstructor
public final class SQLExecution<T> {

    private final Supplier<T> supplier;

    public CompletableFuture<T> async() {
        CompletableFuture<T> completable = new CompletableFuture<>();
        Bukkit.getScheduler().runTaskAsynchronously(SAOSeed.getInstance(), () -> completable.complete(supplier.get()));
        return completable;
    }

    public T sync() {
        return supplier.get();
    }

}
