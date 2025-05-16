package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Action;
import pro1.apiDataModel.ActionsList;

import java.util.List;

public class Main2 {
    public static long maxPersonsCount(String department, int year) {
        String json = Api.getActionsByDepartment(department, year);
        ActionsList response = new Gson().fromJson(json, ActionsList.class);
        List<Action> actions = response.items;

        return actions.stream()
                .mapToLong(a -> a.personsCount)
                .max()
                .orElse(0);
    }
}
