public class BubbleSort {

    public static void sort(int[] array) {
        int length = array.length;

        // laço externo que percorre o array n-1 vezes
        for (int i = 0; i < length - 1; i++) {

            // laço interno que percorre o array até o último elemento não ordenado
            for (int j = 0; j < length - i - 1; j++) {

                // compara o elemento atual com o próximo
                if (array[j] > array[j + 1]) {
                    // se o elemento atual for maior, troca os dois elementos
                    int temp = array[j];        // armazena o valor do elemento atual
                    array[j] = array[j + 1];    // substitui o elemento atual pelo próximo
                    array[j + 1] = temp;        // substitui o próximo elemento pelo valor armazenado
                }
            }
        }
    }
}
