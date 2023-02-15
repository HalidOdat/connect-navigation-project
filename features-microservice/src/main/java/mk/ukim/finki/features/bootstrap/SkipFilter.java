package mk.ukim.finki.features.bootstrap;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SkipFilter implements Filter {
    private final int count;

    @Override
    public Object run(Object input) {
        List<String> list = (List<String>) input;
        return list.stream().skip(this.count).collect(Collectors.toList());
    }
}
