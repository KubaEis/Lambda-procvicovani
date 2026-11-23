import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ProcviceniLambdy {
    public static void main(String[] args) {
        List<String> jmena = List.of("Kuba", "Dan", "Lukáš", "", "Kuba", "Míša");
        List<Integer> body = List.of(2, 3, 4, 6, 5, 7, 3);
        delkyJmen(jmena);
        //delkyJmen(List.of());
        dvaSeznamy();
        ulozHodnotu();
        pocetVRozsahu(body);
    }

    static void delkyJmen(List<String> jmena) {
        String prefix = "K";
        Predicate<String> startsK = s -> s.startsWith(prefix);
        Consumer<String> print = s -> System.out.println(s.length());
        for (String name : jmena) {
            if (startsK.test(name)) {
                print.accept(name);
            }
        }
        System.out.println("-----------------");
        // TODO Vyber jména, která začínají na prefix, a vypiš jejich délky.
    }

    static void dvaSeznamy() {
        Supplier<List<String>> s = ArrayList::new;
        List<String> list1 = s.get();
        List<String> list2 = s.get();
        list1.add("Ondra");
        list2.add("Vasek");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("-----------------");
        // TODO Vytvoř přes Supplier dvě samostatné soupisky a vypiš je.
    }

    static void ulozHodnotu() {
        // Předloha k opravě.
        int limit = 2;
        limit++;
        int finalLimit = limit;
        Runnable vypis = () -> System.out.println(finalLimit);
        limit++;
        vypis.run();
        System.out.println("-----------------");
    }

    static void pocetVRozsahu(List<Integer> body) {
        int minimum = 3;
        int maximum = 6;
        Predicate<Integer> alesponMinimum = hodnota -> hodnota >= minimum;
        Predicate<Integer> alesponMaximum = hodnota -> hodnota <= maximum;
        Predicate<Integer> vIntervalu = alesponMinimum.and(alesponMaximum);

        int pocet = 0;
        for (Integer i : body){
            if (vIntervalu.test(i)) {
                pocet++;
            }
        }
        System.out.println(pocet);
        System.out.println("-----------------");
        // TODO Slož podmínky a vypiš počet hodnot v intervalu.
    }
}
