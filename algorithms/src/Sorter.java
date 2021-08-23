public class Sorter {
    public static void bubbleSortNotebookArray(Notebook[] arr) {
        if (arr.length > 1) {
            int size = arr.length;
            boolean vasChanged;
            do {
                vasChanged = false;
                for (int i = 0; i < size - 1; i++) {
                    if (checkTwoElement(arr, i, i + 1)) {
                        changeElement(arr, i, i + 1);
                        vasChanged = true;
                    }
                }
            } while (vasChanged);
        }
    }

    public static void cocktailSort(Notebook[] arr) {
        boolean swapped;
        int size = arr.length;
        int start = 0;
        do {
            swapped = false;
            for (int i = start; i < size - 1; i++) {
                if (checkTwoElement(arr, i, i + 1)) {
                    changeElement(arr, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
            for (int i = size - 1; i > start; i--) {
                if (checkTwoElement(arr, i - 1, i)) {
                    changeElement(arr, i - 1, i);
                    swapped = true;
                }
            }
            size--;
            start++;
        } while (swapped);
    }

    public static void selectionSort(Notebook[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (checkTwoElement(arr, min, j))
                    min = j;
            }
            if (i == min)
                continue;
            changeElement(arr, i, min);
        }

    }

    public static void insertionSort(Notebook[] arr)  {
        for (int i = 1; i < arr.length; i++) {
            Notebook value = arr[i];
            int j = i - 1;
            while (j >= 0 && checkTwoElement(arr, j, i)) {
                arr[j] = arr[j+1];
                j--;
            }
            arr[j + 1] = value;
        }
    }

    private static boolean checkMan(String man1, String man2) {
        String[] manArr = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};
        int firstWight = 0;
        int secondWight = 0;
        for (int i = 0; i < manArr.length; i++) {
            if (man1.equals(manArr[i]))
                firstWight = i;
            if (man2.equals(manArr[i]))
                secondWight = i;
        }
        return firstWight > secondWight;
    }

    private static boolean checkTwoElement(Notebook[] arr, int moore, int less) {
        boolean vasChanged = false;
        if (arr[moore].getPrice() > arr[less].getPrice()) {
            vasChanged = true;
        }
        if (arr[moore].getPrice().equals(arr[less].getPrice())) {
            if (arr[moore].getRAM() > arr[less].getRAM()) {
                vasChanged = true;
            }
            if (arr[moore].getRAM().equals(arr[less].getRAM())) {
                if (checkMan(arr[moore].getMan(), arr[less].getMan())) {
                    vasChanged = true;
                }
            }
        }
        return vasChanged;
    }

    private static void changeElement(Notebook[] arr, int i, int i2) {
        Notebook notebook = arr[i];
        arr[i] = arr[i2];
        arr[i2] = notebook;
    }
}
