package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.Teacher;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;
import java.util.List;

public class Main4 {
    public static void printShortestEmails(String department, int count) {
        String json = Api.getTeachersByDepartment(department);
        TeachersList response = new Gson().fromJson(json, TeachersList.class);
        List<Teacher> teachers = response.items;

        teachers.stream()
                .filter(t -> t.email != null)
                .sorted(Comparator.comparing(t -> t.email.length()))
                .limit(count)
                .forEach(t -> System.out.println(t.email));
    }
}
