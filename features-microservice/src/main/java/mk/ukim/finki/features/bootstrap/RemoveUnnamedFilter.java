package mk.ukim.finki.features.bootstrap;

import java.util.ArrayList;
import java.util.List;

public class RemoveUnnamedFilter implements Filter {
    @Override
    public Object run(Object input) {
        List<String> list = (List<String>) input;
        List<String[]> result = new ArrayList<>();
        for (String value : list) {
            String[] parts = value.split(",");
            if (parts.length == 3 || parts[3].isEmpty()) {
                continue;
            }
            result.add(parts);
        }
        return result;
    }
}
