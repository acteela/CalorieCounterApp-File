import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalorieCounterApp {
    // List untuk menyimpan objek FoodItem
    private static List<FoodItem> foodItems = new ArrayList<>();
    private static int dailyCalorieGoal; // Menyimpan tujuan kalori harian
    private static int age; // Menyimpan umur pengguna
    private static double weight; // Berat badan dalam kg
    private static double height; // Tinggi badan dalam cm
    private static String gender; // Jenis kelamin ("Pria" atau "Wanita")
    private static String activityLevel; // Level aktivitas pengguna

    // Blok statis untuk menginisialisasi daftar makanan
    static {
         // Menambahkan objek FoodItem ke dalam list beserta jumlah protein dan kalorinya
        foodItems.add(new FoodItem("Nasi", 200, 130, 4.0, 2.6));
        foodItems.add(new FoodItem("Ayam Goreng", 250, 320, 25.0, 29.0));
        foodItems.add(new FoodItem("Sayur Sawi", 50, 20, 2.0, 1.6));
        foodItems.add(new FoodItem("Ikan Bakar", 150, 160, 20.0, 22.0));
        foodItems.add(new FoodItem("Kentang Goreng", 300, 312, 3.0, 2.0));
        foodItems.add(new FoodItem("Apel", 95, 52, 0.5, 0.3));
        foodItems.add(new FoodItem("Sate Ayam", 210, 190, 20.0, 27.0));
        foodItems.add(new FoodItem("Tempe Goreng", 160, 192, 16.0, 18.0));
        foodItems.add(new FoodItem("Tahu Goreng", 100, 120, 10.0, 11.0));
        foodItems.add(new FoodItem("Soto Ayam", 150, 50, 10.0, 12.0));
        foodItems.add(new FoodItem("Gado-Gado", 250, 190, 10.0, 9.0));
        foodItems.add(new FoodItem("Nasi Goreng", 350, 180, 12.0, 10.0));
        foodItems.add(new FoodItem("Mie Goreng", 400, 270, 10.0, 8.0));
        foodItems.add(new FoodItem("Bakso", 180, 150, 10.0, 12.0));
        foodItems.add(new FoodItem("Rendang", 300, 270, 25.0, 28.0));
        foodItems.add(new FoodItem("Telur Rebus", 70, 155, 6.0, 13.0));
        foodItems.add(new FoodItem("Sup Ayam", 120, 50, 8.0, 10.0));
        foodItems.add(new FoodItem("Lontong", 180, 110, 5.0, 4.0));
        foodItems.add(new FoodItem("Es Teh Manis", 90, 35, 0.0, 0.0));
        foodItems.add(new FoodItem("Teh Tawar", 0, 0, 0.0, 0.0));
        foodItems.add(new FoodItem("Es Krim", 200, 207, 3.0, 2.0));
        foodItems.add(new FoodItem("Roti Tawar", 80, 265, 2.0, 8.0));
        foodItems.add(new FoodItem("Pizza", 285, 266, 12.0, 11.0));
        foodItems.add(new FoodItem("Burger", 354, 295, 18.0, 17.0));
        foodItems.add(new FoodItem("Spaghetti", 221, 157, 7.0, 5.0));
        foodItems.add(new FoodItem("Bubur Ayam", 250, 40, 10.0, 6.0));
        foodItems.add(new FoodItem("Susu Full Cream", 150, 61, 8.0, 3.0));
        foodItems.add(new FoodItem("Jus Jeruk", 112, 45, 1.0, 0.5));
        foodItems.add(new FoodItem("Air Mineral", 0, 0, 0.0, 0.0));
        foodItems.add(new FoodItem("Salad Buah", 120, 80, 1.0, 1.0));
        foodItems.add(new FoodItem("Oatmeal", 150, 68, 6.0, 3.0));
        foodItems.add(new FoodItem("Tumis Kangkung", 100, 30, 4.0, 2.5));
        foodItems.add(new FoodItem("Ayam Bakar", 220, 195, 26.0, 30.0));
        foodItems.add(new FoodItem("Udang Goreng", 190, 240, 20.0, 24.0));
        foodItems.add(new FoodItem("Kebab", 275, 300, 20.0, 25.0));
        foodItems.add(new FoodItem("Nugget Ayam", 190, 250, 10.0, 12.0));
        foodItems.add(new FoodItem("Pisang Goreng", 170, 220, 2.0, 1.0));
        foodItems.add(new FoodItem("Sushi", 150, 130, 7.0, 6.0));
        foodItems.add(new FoodItem("Cappuccino", 130, 77, 3.0, 2.0));
        foodItems.add(new FoodItem("Kopi Hitam", 5, 2, 0.3, 0.2));
        foodItems.add(new FoodItem("Martabak Manis", 600, 400, 8.0, 5.0));
        foodItems.add(new FoodItem("Coklat", 150, 546, 2.0, 6.0));
        foodItems.add(new FoodItem("Keripik Kentang", 150, 536, 3.0, 2.0));
    }

    // Fungsi untuk menyetel data pengguna seperti usia, berat, tinggi, gender, dan level aktivitas
    public static void setUserData(int userAge, double userWeight, double userHeight, String userGender, String userActivityLevel) {
        age = userAge;
        weight = userWeight;
        height = userHeight;
        gender = userGender;
        activityLevel = userActivityLevel;
    }

    // Fungsi untuk menghitung dan menyetel tujuan kalori harian pengguna (dailyCalorieGoal)
    public static void calculateAndSetDailyCalorieGoal() {
        double bmr; // Basal Metabolic Rate (BMR)

        // Menghitung BMR berdasarkan jenis kelamin
        if (gender.equalsIgnoreCase("Pria")) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        // Mengalikan BMR dengan faktor aktivitas untuk menghitung kebutuhan kalori harian
        switch (activityLevel.toLowerCase()) {
            case "kurang aktif":
                bmr *= 1.2;
                break;
            case "sedikit aktif":
                bmr *= 1.375;
                break;
            case "aktif":
                bmr *= 1.55;
                break;
            case "sangat aktif":
                bmr *= 1.725;
                break;
            default:
                System.out.println("Level aktif tidak valid, pilih kurang aktif");
                bmr *= 1.2;
        }

        // Mengonversi BMR ke dalam integer untuk mendapatkan kalori harian
        dailyCalorieGoal = (int) bmr;
        System.out.printf("\nRecommended daily calorie intake: %d calories.\n", dailyCalorieGoal);
    }

    // Fungsi untuk mencari makanan berdasarkan kata kunci yang diberikan
    private static FoodItem findFoodByKeyword(String keyword) {
        for (FoodItem foodItem : foodItems) {
            // Mencari nama makanan yang cocok dengan kata kunci
            if (foodItem.getName().toLowerCase().contains(keyword.toLowerCase())) {
                return foodItem;
            }
        }
        return null; // Mengembalikan null jika tidak ada makanan yang ditemukan
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Isi data dibawah untuk menghitung BMR anda =======");

        // Input dan validasi usia pengguna
        int age = 0;
        while (true) {
            System.out.print("\nBerapa Usia Anda: ");
            age = scanner.nextInt();
            if (age > 0 && age <= 120) break; // Validasi usia antara 1 dan 120
            System.out.println("Usia tidak valid. Masukkan usia antara 1 dan 120.");
        }

        // Input dan validasi berat badan pengguna
        double weight = 0;
        while (true) {
            System.out.print("Berapa Berat Badan Anda (kg): ");
            weight = scanner.nextDouble();
            if (weight > 0 && weight <= 300) break; // Validasi berat antara 1 dan 300 kg
            System.out.println("Berat badan tidak valid. Masukkan berat antara 1 dan 300 kg.");
        }

        // Input dan validasi tinggi badan pengguna
        double height = 0;
        while (true) {
            System.out.print("Berapa Tinggi Badan Anda (cm): ");
            height = scanner.nextDouble();
            if (height > 30 && height <= 250) break; // Validasi tinggi antara 30 dan 250 cm
            System.out.println("Tinggi badan tidak valid. Masukkan tinggi antara 30 dan 250 cm.");
        }

        // Input jenis kelamin
        scanner.nextLine(); // Membersihkan newline dari input sebelumnya
        String gender;
        while (true) {
            System.out.print("Pria/ Wanita: ");
            gender = scanner.nextLine().toLowerCase();
            if (gender.equals("pria") || gender.equals("wanita")) break; // Validasi input gender
            System.out.println("Gender tidak valid. Masukkan 'Pria' atau 'Wanita'.");
        }

        // Input level aktivitas
        System.out.print("\nMasukkan Level Keaktifan anda\n(kurang aktif, sedikit aktif, aktif, sangat aktif): ");
        activityLevel = scanner.nextLine();

        // Set data pengguna dan hitung kebutuhan kalori harian
        setUserData(age, weight, height, gender, activityLevel);
        calculateAndSetDailyCalorieGoal();

        String input;
        int totalCalories = 0; // Menyimpan total kalori dari makanan yang dikonsumsi
        double totalProtein = 0; // Menyimpan total protein dari makanan yang dikonsumsi

        System.out.println("\n=========== Aplikasi Penghitung Kalori Makanan ===========\n");

        // Loop untuk memasukkan makanan dan menghitung kalori setiap makanan yang dikonsumsi
        while (true) {
            System.out.print("\nMasukkan nama makanan! atau 'done': ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break; // Berhenti jika pengguna mengetik 'done'
            }

            // Memproses input makanan, menghitung kalori dan protein untuk tiap makanan
            String[] foodItemsArray = input.split(",");
            for (String item : foodItemsArray) {
                item = item.trim();
                FoodItem foodItem = findFoodByKeyword(item);

                if (foodItem != null) {
                    System.out.println("\nSatu porsi " + foodItem.getName() + ": " + foodItem.getCaloriesPerServing() + " kalori, " + foodItem.getProteinPerServing() + " gram protein.");

                    // Memilih untuk input per porsi atau per gram
                    System.out.print("Per Porsi/ Per Gram? (1/2): ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        System.out.print("Masukkan jumlah porsi untuk " + foodItem.getName() + ": ");
                        int servings = scanner.nextInt();
                        scanner.nextLine();

                        // Hitung kalori dan protein berdasarkan jumlah porsi
                        int calories = foodItem.getCaloriesPerServing() * servings;
                        double protein = foodItem.getProteinPerServing() * servings;
                        totalCalories += calories;
                        totalProtein += protein;

                        System.out.printf("\nKalori dari %d porsi %s: %d kalori, %.1f gram protein.\n", servings, foodItem.getName(), calories, protein);
                    } else if (choice == 2) {
                        System.out.print("Masukkan berat (gram) untuk " + foodItem.getName() + ": ");
                        double weightInGrams = scanner.nextDouble();
                        scanner.nextLine();

                        // Hitung kalori dan protein berdasarkan berat gram
                        double calories = (weightInGrams / 100) * foodItem.getCaloriesPer100g();
                        double protein = (weightInGrams / 100) * foodItem.getProteinPer100g();
                        totalCalories += calories;
                        totalProtein += protein;

                        System.out.printf("\nKalori dari %.0f gram %s: %.1f kalori, %.1f gram protein.\n", weightInGrams, foodItem.getName(), calories, protein);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                } else {
                    System.out.println("Makanan '" + item + "' tidak ditemukan dalam daftar.");
                }
            }
        }

        // Menampilkan hasil total kalori dan protein yang telah dikonsumsi
        System.out.println("\n================ Total Kalori dan Protein ================");
        System.out.printf("Kebutuhan kalori harian Anda: %d kalori.\n", dailyCalorieGoal);
        System.out.printf("Total kalori yang dikonsumsi: %d kalori.\n", totalCalories);
        System.out.printf("Total protein yang dikonsumsi: %.1f gram.\n", totalProtein);

        // Menampilkan rekomendasi berdasarkan total kalori harian
        if (totalCalories > dailyCalorieGoal) {
            System.out.println("Anda telah melebihi kebutuhan kalori harian.");
        } else if (totalCalories < dailyCalorieGoal) {
            int calorieRemaining = dailyCalorieGoal - totalCalories;
            System.out.printf("Kebutuhan kalori harian tersisa: %d kalori.\n", calorieRemaining);
        } else {
            System.out.println("Anda telah memenuhi kebutuhan kalori harian dengan tepat.");
        }
        
    System.out.println("==========================================================");
    scanner.close();
    }
}

