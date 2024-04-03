import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] ves = getInfoByUser();
        int[] otsorVes = sortByMerge(ves);
        System.out.println(calculateKolvoBaidarok(otsorVes,135));
    }

    public static int[] getInfoByUser(){
        System.out.println("Введите количество людей, грузоподъёмность байдарки, а затем перечислить вес участников похода");
        Scanner scan = new Scanner(System.in);
        int kolvoChelovek = scan.nextInt();
        int gruzoPod = scan.nextInt();
        int[] vesChelovek = new int [kolvoChelovek];

        for (int i = 0; i < kolvoChelovek ; i++) {
        vesChelovek[i] = scan.nextInt();
        }
        return vesChelovek;
    }


    public static int[] mergeSortedArray(int[] m1, int[] m2) {
        int[] resultArray = new int[m1.length + m2.length];
        int pos1 = 0, pos2 = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (pos1 == m1.length) {
                resultArray[i] = m2[pos2];
                pos2++;
            } else if (pos2 == m2.length) {
                resultArray[i] = m1[pos1];
                pos1++;
            } else if (m1[pos1] < m2[pos2]) {
                resultArray[i] = m1[pos1];
                pos1++;
            } else {
                resultArray[i] = m2[pos2];
                pos2++;
            }
        }
        return resultArray;
    }

    public static int[] sortByMerge(int[] m) {
        //проверка, что массив невырожденный
        if (m == null) return null;
        if (m.length == 1) return m;
        //разбиение на два равных кусочка
        int len1=m.length / 2;
        int len2=m.length - m.length / 2;
        int[] m1 = new int[len1];
        System.arraycopy(m, 0, m1, 0, len1);
        int[] m2 = new int[len2];
        System.arraycopy(m, len1, m2, 0, len2);
        //сортировка левого и правого кусочков
        m1 = sortByMerge(m1);
        m2 = sortByMerge(m2);
        //слияние отсортированных левого и правого кусочков
        return mergeSortedArray(m1, m2);
    }

    public static int calculateKolvoBaidarok(int[] massiv, int d) {
        int vesCheloveka2 =0;
        int counter = 0;
        for (int i = 0; i < massiv.length ; i++) {
            if (massiv[i] < d){
                vesCheloveka2 +=massiv[i];
                if (vesCheloveka2> d){
                    vesCheloveka2 =0;
                counter+=2;
            }}

            if (massiv[i] >d){
                counter += massiv.length - i;
                break;
            }
        }
        return counter;
    }
}

