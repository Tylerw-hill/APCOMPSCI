package sorting;

public class InsertionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Insertion Sort!!!");
         for (int i = 0; i < input.length - 1; i++) {
            while(input[i+1] > input[i]){
                int temp = input[i + 1];
                input[i + 1] = input[i];
                input[i] = temp;
            }
        }
    }

}
