package com.davidgjm.cloud.lbs.amap.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AmapOutputJsonFilterImpl implements AmapOutputJsonFilter {

    @Override
    public String filter(String json, Supplier<Set<String>> whitelistProvider) {
        if (json == null || json.trim().isEmpty()
                || !json.contains("[]")
                || whitelistProvider == null) {
            return json;
        } else {
            Set<String> fieldNames = whitelistProvider.get();
            if (fieldNames == null || fieldNames.isEmpty()) {
                log.warn("No field names found from the provider");
                return json;
            }

            fieldNames = fieldNames.stream()
                    .filter(s -> s != null && !s.trim().isEmpty())
                    .collect(Collectors.toSet());
            StringBuffer sb = new StringBuffer();

            Pattern pattern = Pattern.compile("\"(\\w+)\":(\\[])", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(json);
            while (matcher.find()) {
                String field = matcher.group(1);
                if (!fieldNames.contains(field)) {
                    matcher.appendReplacement(sb, "\"$1\":\"\"");
                }
            }
            matcher.appendTail(sb);
            sb.trimToSize();
            return sb.toString();
        }
    }

}
