public class QuickSort {

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            sort(array, start, pivotIndex - 1);  // Ordena a parte à esquerda
            sort(array, pivotIndex + 1, end);    // Ordena a parte à direita
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                // Troca os elementos
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Coloca o pivô na posição correta
        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        return i + 1;
    }
}
