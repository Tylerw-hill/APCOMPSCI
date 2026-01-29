package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Selection Sort!!!");
         for (int i = 0; i < input.length; i++) { //goest through each term
            int smallest = i;
            for (int v = 0; v < input.length; v++){ // this is the part that looks through term and compares to another 
                
                if(input[v] > input[smallest]){
                    smallest = v;
                }
           }
           int temp = input[smallest];
           input[smallest] = input[i];
           input[i] = temp;
        }
    }
}
