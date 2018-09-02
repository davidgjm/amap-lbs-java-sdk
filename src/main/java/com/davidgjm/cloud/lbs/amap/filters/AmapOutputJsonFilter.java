package com.davidgjm.cloud.lbs.amap.filters;

import java.util.Set;
import java.util.function.Supplier;

@FunctionalInterface
public interface AmapOutputJsonFilter {
    String filter(String json, Supplier<Set<String>> whitelistProvider);

}
