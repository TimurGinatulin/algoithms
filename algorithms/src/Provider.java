import java.util.Random;

public class Provider {
    private final static Random random;

    static {
        random = new Random();
    }

    public static Notebook[] getNotebookArray(int size) {
        Notebook[] arr = new Notebook[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNotebook();
        }
        return arr;
    }

    private static Notebook getRandomNotebook() {

        Notebook notebook = new Notebook();
        notebook.setPrice(getRandomNumber(500, 2000, 100));
        notebook.setRAM(getRandomNumber(4, 16, 4));
        notebook.setMan(getRandomMan());
        return notebook;
    }

    private static String getRandomMan() {
        String[] manufactureList = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};
        return manufactureList[random.nextInt(manufactureList.length)];
    }

    private static Integer getRandomNumber(int min, int max, int diff) {
        Random random = new Random();
        return min + random.nextInt(((max - min) / diff) + 1) * diff;
    }
}
