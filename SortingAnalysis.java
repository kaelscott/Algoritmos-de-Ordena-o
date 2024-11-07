import java.io.*;
import java.util.*;

public class SortingAnalysis {
    public static void main(String[] args) {
        // Pasta onde os arquivos CSV estão localizados
        String dataDir = "dados/";

        // Tipos de dados a serem analisados
        String[] dataTypes = {"aleatorio", "crescente", "decrescente"};

        // Tamanhos de entrada a serem analisados
        int[] dataSizes = {100, 1000, 10000};

        // Imprimir cabeçalho antes de realizar os testes
        System.out.println("Resultados da Análise de Desempenho:");
        System.out.println("=======================================================");
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Algoritmo", "Tipo", "Tamanho", "Tempo (ns)");
        System.out.println("-------------------------------------------------------");

        // Executar testes para cada tipo e tamanho de dados
        for (String dataType : dataTypes) {
            for (int dataSize : dataSizes) {
                String filename = dataDir + dataType + "_" + dataSize + ".csv";
                int[] data = readDataFromFile(filename);
                if (data != null) {
                    runSortingTests(data, dataType, dataSize);
                }
            }
        }
    }

    private static int[] readDataFromFile(String filename) {
        try {
            List<Integer> numbers = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int value = Integer.parseInt(line.trim());
                    numbers.add(value);
                } catch (NumberFormatException e) {

                }
            }
            reader.close();
            return numbers.stream().mapToInt(Integer::intValue).toArray();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo " + filename);
            return null;
        }
    }


    private static void runSortingTests(int[] data, String dataType, int dataSize) {
        // Bubble Sort
        int[] bubbleData = data.clone();
        long bubbleStartTime = System.nanoTime();
        BubbleSort.sort(bubbleData);
        long bubbleEndTime = System.nanoTime();
        printResult("Bubble Sort", dataType, dataSize, bubbleEndTime - bubbleStartTime);

        // Insertion Sort
        int[] insertionData = data.clone();
        long insertionStartTime = System.nanoTime();
        InsertionSort.sort(insertionData);
        long insertionEndTime = System.nanoTime();
        printResult("Insertion Sort", dataType, dataSize, insertionEndTime - insertionStartTime);

        // Quick Sort
        int[] quickData = data.clone();
        long quickStartTime = System.nanoTime();
        QuickSort.sort(quickData, 0, quickData.length - 1);
        long quickEndTime = System.nanoTime();
        printResult("Quick Sort", dataType, dataSize, quickEndTime - quickStartTime);
    }

    private static void printResult(String algorithm, String dataType, int dataSize, long time) {
        System.out.printf("%-15s %-15s %-15d %-15d%n", algorithm, dataType, dataSize, time);
    }
}