package mk.ukim.finki.features.bootstrap;


import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SplitByFilter implements Filter {
    private final String delimiter;

    @Override
    public Object run(Object input) {
        return Arrays.stream(((String)input).split(this.delimiter)).collect(Collectors.toList());
    }
}
