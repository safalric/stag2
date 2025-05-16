package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.*;

import java.util.Comparator;
import java.util.List;

public class Main3 {
    public static String emailOfBestTeacher(String department, int year) {
        String jsonTeachers = Api.getTeachersByDepartment(department);
        String jsonActions = Api.getActionsByDepartment(department, year);
        Gson gson = new Gson();


        TeachersList teachersResponse = gson.fromJson(jsonTeachers, TeachersList.class);
        List<Teacher> teachers = teachersResponse.items;


        ActionsList actionsResponse = gson.fromJson(jsonActions, ActionsList.class);
        List<Action> actions = actionsResponse.items;


        return teachers.stream()
                .max(Comparator.comparing(t -> teacherScore(t.id, actions)))
                .map(t -> t.email)
                .orElse("?");
    }

    private static long teacherScore(long teacherId, List<Action> actions) {
        return actions.stream()
                .filter(a -> a.teacherId == teacherId)
                .mapToLong(a -> a.personsCount)
                .sum();
    }
}
