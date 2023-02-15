package mk.ukim.finki.features.bootstrap;

import java.util.ArrayList;
import java.util.List;

public class RemoveUnnamedFilter implements Filter {
    @Override
    public Object run(Object input) {
        List<String> list = (List<String>) input;
        List<String[]> result = new ArrayList<>();
        for (String value : list) {
            String p[] = value.split(",");
            if (p.length == 3 || p[3].isEmpty()) {
                continue;
            }
            result.add(p);
        }
        return result;
    }
}
