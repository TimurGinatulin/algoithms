import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Notebook[] notebooks = Provider.getNotebookArray(40 *1000);
        Timer.start();
        Sorter.bubbleSortNotebookArray(notebooks);
        Timer.stop();
        notebooks = Provider.getNotebookArray(40 * 1000);
        Timer.start();
        Sorter.cocktailSort(notebooks);
        Timer.stop();
        notebooks = Provider.getNotebookArray(40*1000);
        Timer.start();
        Sorter.selectionSort(notebooks);
        Timer.stop();
        notebooks = Provider.getNotebookArray(40*1000);
        Timer.start();
        Sorter.insertionSort(notebooks);
        Timer.stop();
//        for (Notebook o : notebooks) {
//            System.out.println(o.toString());
//        }
    }
}
