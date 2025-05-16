package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Action;
import pro1.apiDataModel.ActionsList;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main5 {
    public static String roomsSummary(String department, int year) {
        String json = Api.getActionsByDepartment(department, year);
        ActionsList response = new Gson().fromJson(json, ActionsList.class);
        List<Action> actions = response.items;

        return actions.stream()
                .map(a -> a.room)
                .filter(Objects::nonNull)
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
    }
}
