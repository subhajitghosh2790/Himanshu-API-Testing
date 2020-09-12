package utility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.filter.TokenFilter;

public class PropertyBasedIgnoreFilter extends TokenFilter {

    protected Set<String> ignoreProperties;

    public PropertyBasedIgnoreFilter(String... properties) {
        ignoreProperties = new HashSet<>(Arrays.asList(properties));
    }

    @Override
    public TokenFilter includeProperty(String name) {
        if (ignoreProperties.contains(name)) {
            return null;
        }
        return INCLUDE_ALL;
    }
}