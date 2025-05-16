package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.*;
import pro1.Api;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main7 {
    public static String specializationDeadlines(int year) {
        String json = Api.getSpecializations(year);
        Gson gson = new Gson();

        SpecializationsList response = gson.fromJson(json, SpecializationsList.class);
        List<Specialization> specializations = response.items;

        Set<String> uniqueDates = new HashSet<>();
        for (Specialization s : specializations) {
            if (s.eprDeadlinePrihlaska != null && s.eprDeadlinePrihlaska.value != null) {
                uniqueDates.add(s.eprDeadlinePrihlaska.value);
            }
        }

        List<String> sortedDates = new ArrayList<>(uniqueDates);
        sortedDates.sort((d1, d2) -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy");
                return sdf.parse(d1).compareTo(sdf.parse(d2));
            } catch (Exception e) {
                return 0;
            }
        });

        return String.join(",", sortedDates);
    }
}
