import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {

    static final int ANZAHL_ELEMENTE = 100;

    @FunctionalInterface
    static interface Teilbar {
        boolean operate(int zahl);
    }


    public static void main(String[] args) throws Exception {
    
    int[] intsArray = new int[ANZAHL_ELEMENTE];
    createNumbers(intsArray);

    //Array kopieren
    int [] intsArrayFilled = Arrays.copyOf(intsArray, App.ANZAHL_ELEMENTE);

    List<Integer> intsList = new ArrayList<>(ANZAHL_ELEMENTE);
    createNumbers(intsList);

    List<Integer> intsListFilled = intsList.stream().collect(Collectors.toList());

    System.out.println(intsArray.length);

    //System.out.println(intsArrayFilled.length);
    //System.out.println(intsListFilled.size());

    //vergleicht referenzen
    System.out.println(intsArrayFilled == intsArray);

    //vergleicht Inhalt
    System.out.println(Arrays.equals(intsArray, intsArrayFilled));

    int[] intsDurch3 = numbersDividable3(intsArrayFilled);
    List<Integer> intsDurch2 = numbersDividable2(intsListFilled);

    // länge deer Liste ausgeben
    System.out.println(intsDurch3.length);

    // Inhalt Array ausgeben
    Arrays.stream(intsDurch3).forEach(s -> System.out.print(s + " "));

    //Inhalt Liste ausgeben
    System.out.println(intsDurch2.toString());

    // List mit List-Methode: removeIf
    createNumbers(intsList);
    System.out.println();
    Stoppuhr.start();
    intsList.removeIf(i -> i % 3 != 0);
    Stoppuhr.stop("List-Methode: removeIf");

    Teilbar intsDurch3Function = (i) -> i%3==0;
    Teilbar intsDurch4Function = (i) -> i%4==0;

    intsDurch3 = teileIntsDurchWithFunction(intsArray, intsDurch3Function);

    }

    static int[] teileIntsDurchWithFunction(int[] ints, Teilbar function) {
        return Arrays.stream(ints).filter(i -> function.operate(i)).toArray();
    }

    static int[] numbersDividable3(int[] ints) {
        
        return Arrays.stream(ints).filter(i -> i%3==0).toArray();
        
    }

    static List<Integer> numbersDividable2(List<Integer> ints) {

        return ints.stream().filter(i -> i%2==0).toList();
    }

    static void createNumbers(int[] ints) {
        Stoppuhr.start();

        Random random = new Random();

        for (var i = 0; i < App.ANZAHL_ELEMENTE; i++)
            ints[i] = random.nextInt(App.ANZAHL_ELEMENTE) + 1;
        Stoppuhr.stop("createIntsArray");
    }

    static void createNumbers(List<Integer> ints){
        Stoppuhr.start();

        Random random = new Random();

        for (var i = 0; i < App.ANZAHL_ELEMENTE; i++)
            ints.add(random.nextInt(App.ANZAHL_ELEMENTE) + 1);
        Stoppuhr.stop("createIntsList");
    }

}


// Schulaufgabe
    /*  4 aufagen 50 Punkte
        3 Aufgaben laufen mit Tests
        1 Aufgabe Swing
        (1 Aufgabe Listenmanipualtion Liste mit Parameterfunktionen reduzieren)
        kein Theorieteil
    */