public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        heapSort(arr);

        System.out.println("Отсортированный массив:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение начальной кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение элементов из кучи по одному и добавление их в конец отсортированной части массива
        for (int i = n - 1; i >= 0; i--) {
            // Обмен текущего корня (максимального элемента) с последним элементом массива
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Функция для преобразования поддерева с корнем в вершине i в кучу с n элементами
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализация наибольшего элемента как корня
        int leftChild = 2 * i + 1; // Левый потомок
        int rightChild = 2 * i + 2; // Правый потомок

        // Если левый потомок больше корня
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // Если правый потомок больше корня
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // Если наибольший элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно применяем heapify к поддереву
            heapify(arr, n, largest);
        }
    }
}