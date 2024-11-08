public class InsertionSort {

    public static void sort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int current = array[i];

            // j: posição anterior ao elemento atual
            int j = i - 1;

            // laço para encontrar a posição correta do elemento atual
            // move os elementos maiores que o 'current' uma posição à frente
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];  // desloca o elemento para a direita
                j--;  // move para o próximo elemento a esquerda
            }

            // coloca o 'current' na posição correta dentro da parte ordenada do array
            array[j + 1] = current;
        }
    }
}
