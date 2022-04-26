// https://blog.y-yuki.net/entry/2018/08/22/094000

// import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffle {

    // public static void main(String[] args) {
    //     int[] targetArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    //     // シャッフルする前
    //     printArray(targetArray, "No Shuffle");

    //     // シャッフル1回目
    //     shuffle(targetArray);
    //     printArray(targetArray, "Shuffle 1 ");

    //     // シャッフル2回目
    //     shuffle(targetArray);
    //     printArray(targetArray, "Shuffle 2 ");

    //     // シャッフル3回目
    //     shuffle(targetArray);
    //     printArray(targetArray, "Shuffle 3 ");
    // }

    public static void shuffle(int[] array) {
        // 配列が空か１要素ならシャッフルしようがないのので、そのままreturn
        if (array.length <= 1) {
            return;
        }

        // Fisher–Yates shuffle
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // 要素入れ替え(swap)
            int tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    // private static void printArray(int[] array, String headerComment) {
    //     System.out.printf("%s -> %s\n\n", headerComment, Arrays.toString(array));
    // }
}
