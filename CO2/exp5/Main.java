
class Main {
    public static void main(String[] args) {
        // Sorting an array of strings in alphabetical order
        String[] a = { "dhoni", "virat", "rohit", "DK", "gill", "sachin" };

        // Sorting the array using a simple bubble sort algorithm
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].toLowerCase().compareTo(a[j].toLowerCase()) > 0) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("Sorted array in alphabetical order:");
        // Displaying the sorted array
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}