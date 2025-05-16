package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Action;
import pro1.apiDataModel.ActionsList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main6 {
    public static long idOfBestTeacher(String department, int year) {
        String json = Api.getActionsByDepartment(department, year);
        ActionsList response = new Gson().fromJson(json, ActionsList.class);
        List<Action> actions = response.items;

        Map<Long, Integer> teacherScores = new HashMap<>();
        for (Action a : actions) {
            teacherScores.put(a.teacherId, teacherScores.getOrDefault(a.teacherId, 0) + a.personsCount);
        }

        return teacherScores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1L);
    }
}
