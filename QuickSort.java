public class QuickSort {

    public static void sort(int[] array, int start, int end) {
        // verifica se o array contem mais de um elemento para ordenar
        if (start < end) {
            // particiona o array e encontra a posição do pivo
            int pivotIndex = partition(array, start, end);

            // Ordena a parte à esquerda do pivô
            sort(array, start, pivotIndex - 1);

            // Ordena a parte à direita do pivô
            sort(array, pivotIndex + 1, end);
        }
    }

    //  particionar o array em torno do pivo
    private static int partition(int[] array, int start, int end) {
        // pivô é o último elemento do array
        int pivot = array[end];

        int i = start - 1;

        // compara cada elemento com o pivo
        for (int j = start; j < end; j++) {
            // se o elemento for menor ou igual ao pivô, troca com a posição i
            if (array[j] <= pivot) {
                i++;
                // troca os elementos
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // coloca o pivô na posição correta
        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;

        // retorna a posição do pivô
        return i + 1;
    }
}
