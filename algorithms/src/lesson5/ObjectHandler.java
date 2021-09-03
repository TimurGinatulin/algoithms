package lesson5;
import java.util.LinkedList;
import java.util.List;

public class ObjectHandler {
    private List<Object> bestItems = null;
    private Integer maxW;
    private Integer bestPrice;

    public void findBestSets(List<Object> items, int maxW) {
        this.maxW = maxW;
        if (items.isEmpty())
            return;
        checkObject(items);
        for (int i = 0; i < items.size(); i++) {
            List<Object> newSet = new LinkedList<>(items);
            newSet.remove(i);
            findBestSets(newSet);
        }
        System.out.println(bestItems);
    }

    public void findBestSets(List<Object> items) {
        if (items.isEmpty())
            return;
        checkObject(items);
        for (int i = 0; i < items.size(); i++) {
            List<Object> newSet = new LinkedList<>(items);
            newSet.remove(i);
            findBestSets(newSet);
        }
    }

    private void checkObject(List<Object> items) {
        if (bestItems == null) {
            if (getTotalWidth(items) <= maxW) {
                bestItems = items;
                bestPrice = getTotalPrice(items);
            }
        } else {
            if (getTotalWidth(items) <= maxW && getTotalPrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = getTotalPrice(items);
            }
        }
    }

    private int getTotalWidth(List<Object> arr) {
        int width = 0;
        for (Object object : arr)
            width += object.getWidth();
        return width;
    }

    private int getTotalPrice(List<Object> arr) {
        int price = 0;
        for (Object object : arr)
            price += object.getPrice();
        return price;
    }
}
