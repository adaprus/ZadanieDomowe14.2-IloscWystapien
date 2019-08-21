import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NumberListTest {
    public static void main(String[] args) {
        File file = new File("liczby.txt");

        try {
            List<NumberOccur> list = new ArrayList<>();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            while ((line = br.readLine()) != null) {
                if (ifContains(line, list) == -1) {
                    list.add(new NumberOccur(Integer.valueOf(line)));
                } else {
                    int index = ifContains(line, list);
                    list.get(index).setCountOccur(list.get(index).getCountOccur() + 1);
                }
            }

            for (NumberOccur number : sort(list)) {
                System.out.print(number);
            }
        } catch (IOException ex) {
            System.out.println("Błąd pliku");
        }
    }

    private static int ifContains(String line, List<NumberOccur> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumber() == Integer.valueOf(line)) {
                return i;
            }
        }
        return -1;
    }

    private static List<NumberOccur> sort(List<NumberOccur> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                NumberOccur n = list.get(j);
                if (list.get(j).getNumber() > list.get(j + 1).getNumber()) {
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, n);
                }
            }
        }
        return list;
    }
}

