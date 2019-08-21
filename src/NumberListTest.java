import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumberListTest {
    public static void main(String[] args) {
        File file = new File("liczby.txt");

        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            List<Integer> list = new ArrayList<>();
            String line = null;

            while ((line = br.readLine()) != null) {
                list.add(Integer.valueOf(line));
            }

            List<Integer> sortedList = sort(list);

            for (int i = 0; i < list.size(); ) {
                int counter = countQuantity(list.get(i), list);
                System.out.println(sortedList.get(i) + " liczba wystąpień " + counter);
                i += counter;
            }

        } catch (IOException ex) {
            System.out.println("Błąd pliku");
        }
    }

    private static List<Integer> sort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                Integer n = list.get(j);
                if (list.get(j) > list.get(j + 1)) {
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, n);
                }
            }
        }
        return list;
    }

    private static int countQuantity(Integer element, List<Integer> list) {
        int counter = 0;

        for (Integer integer : list) {
            if (element.equals(integer)) {
                counter++;
            }
        }
        return counter;
    }
}



