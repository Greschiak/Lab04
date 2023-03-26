import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner wprowadzanie = new Scanner(System.in);
        int NumerZadania;
        do{
            System.out.print("\n----------------------------------------------------------------------------------\n");
            System.out.print("Wybierz numer zadania\n");
            System.out.print("1. Program obliczający sumę i średnią elementów tablicy\n");
            System.out.print("2. Co drugi element tablicy\n");
            System.out.print("3. Zamiana na wielkie litery\n");
            System.out.print("4. Wypisywanie od tylu\n");
            System.out.print("5. Wypisywanie liczb z tablicy rosnaca\n");
            System.out.print("6. Silnie z liczb\n");
            System.out.print("7. Czy tablice sa takie same?\n");
            System.out.print("0. Zakoncz dzialanie programu\n");
            NumerZadania = wprowadzanie.nextInt();
            wprowadzanie.nextLine(); //dla zadania 4 potrzebne
            switch (NumerZadania) {
                case 1:
                    zadanie1.zadanie();
                    break;
                case 2:
                    zadanie2.zadanie();
                    break;
                case 3:
                    zadanie3.zadanie();
                    break;
                case 4:
                    zadanie4.zadanie(wprowadzanie);
                    break;
                case 5:
                    zadanie5.zadanie(wprowadzanie);
                    break;
                case 6:
                    zadanie6.zadanie(wprowadzanie);
                    break;
                case 7:
                    zadanie7.zadanie(wprowadzanie);
                    break;
                case 0:
                    System.out.println("koniec programu.");
                    break;
                default:
                    System.out.println("Nieprawidłowy numer zadania.");
                    break;
            }
        }while(NumerZadania !=0);

    }
}
class zadanie1{
    public static void zadanie(){
        int[] array = returnArray();
        viewArray(array);
        sum(array);
        avarage(array);
    }
    public static int RandInt(){
        Random rand = new Random();
        int liczba = rand.nextInt(34)-9;
        return liczba;
    }
    public static int[] returnArray(){
        final int arrLen =6;
        int[] arrayInt = new int[arrLen];
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i]= RandInt();
        }
        return arrayInt;
    }
    public static int sum(int[] array){
        int suma =0;
        for (int i = 0; i < array.length; i++) {
            suma+=array[i];
        }
        System.out.println("Suma "+suma);
        return suma;
    }
    public static double avarage(int[] array){
        double avarage = (double)sum(array)/ array.length;
        System.out.println("Srednia: "+avarage);
        return avarage;
    }
    public static void viewArray(int[] array){
        System.out.print("Elementy tablicy: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
class zadanie2{
    public static void zadanie(){
        int[] ParzystaTablica = {1,2,3,4,5,6,7,8,9,10};
        int[] NieparzytaTablica = {1,2,3,4,5,6,7,8,9};
        System.out.println("Co drugi element parzystej tablicy: ");
        for (int i = 0; i < ParzystaTablica.length; i=i+2) {
            System.out.println(ParzystaTablica[i]);
        }
        System.out.println("Co drugi element Nieparzystej tablicy: ");
        for (int i = 0; i < NieparzytaTablica.length; i=i+2) {
            System.out.println(NieparzytaTablica[i]);
        }

    }
}
class zadanie3{
    public static void zadanie(){
        String[] Slowa = {"ala","ma","kota"};
        System.out.println("Zamienione na duze: ");
        for (String item : Slowa) {
            System.out.println(item.toUpperCase());
        }
    }

}
class zadanie4{
    public static void zadanie(Scanner wprowadzadzanie){
        String[] Slowa = new String[5];
        System.out.println("Wprowadz 5 slow: ");
        for (int i = 0; i < 5; i++) {
            Slowa[i]=wprowadzadzanie.nextLine();
            Slowa[i]= odwrocona(Slowa[i]);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Slowa[i]);
        }
    }
    public static String odwrocona(String Slowo1){
        String Slowo_odwrocone = "";
        for (int i= Slowo1.length()-1; i >= 0; i--) {
            Slowo_odwrocone = Slowo_odwrocone  +Slowo1.charAt(i);
        }
        return Slowo_odwrocone;
    }


}
class zadanie5 {
    public static void zadanie(Scanner wprowadzanie) {
        int[] Liczby = new int[8];
        System.out.println("Podaj 8 liczb:");
        for (int i = 0; i < Liczby.length; i++) {
            Liczby[i] = wprowadzanie.nextInt();
        }
        sortowanie(Liczby);
        System.out.println("Posortowane 8 liczb:");
        for (int i = 0; i < Liczby.length; i++) {
            System.out.println(Liczby[i]);
        }

    }
        public static int[] sortowanie(int[] tablica) {
            int temp;
            for (int i = 0; i < tablica.length-1; i++) {
                for (int j = 0; j < tablica.length-1; j++) {
                    if (tablica[j] > tablica[j + 1]) {
                        temp = tablica[j];
                        tablica[j] = tablica[j + 1];
                        tablica[j + 1] = temp;
                    }
                }

        }
            return tablica;
        }
}
class zadanie6{
    public static void zadanie(Scanner wprowadzanie){
        int[] Liczby = new int[5];
        int[] Wynik = new int[5];
        for (int i = 0; i < Liczby.length; i++) {
            System.out.print("Podaj liczbe nr." +(i+1)+": " );
            Liczby[i] = wprowadzanie.nextInt();
        }
        for (int i = 0; i < Liczby.length; i++) {
            Wynik[i]= silnia(Liczby[i]);
        }
        wypisz(Wynik);

    }
    public static int silnia(int silnia){
        int wynik =1;
        for (int i = 1; i <= silnia; i++) {
                wynik = wynik * i;
            }
        return wynik;
    }
    public static void wypisz(int[] wyniki){
        for (int i = 0; i < wyniki.length; i++) {
            System.out.println(wyniki[i]);
        }
    }
}
class zadanie7{
    public static void zadanie(Scanner wprowadzanie) {
        String[] tablica1 = {"Ala", "ma", "kota", "i", "psa"};
        String[] tablica2 = {"Ala", "ma", "kota", "i", "psa"};
        if (CzyTakieSame(tablica1, tablica2)) {
            System.out.println("Tablice sa takie same");
        } else {
            System.out.println("Tablice nie sa takie same");
        }
    }

    public static boolean CzyTakieSame(String[] tablica1, String[] tablica2) {

        for (int i = 0; i < tablica1.length; i++) {
            if (!tablica1[i].equals(tablica2[i])) {
                return false;
            }
        }
        return true;
    }
}