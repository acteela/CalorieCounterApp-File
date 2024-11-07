public class FoodItem {
    // Atribut untuk menyimpan 
    private String name; // nama makanan
    private int caloriesPerServing; // jumlah kalori per porsi
    private int caloriesPer100g; // jumlah kalori per 100 gram
    private double proteinPerServing; // jumlah protein per porsi
    private double proteinPer100g; // jumlah protein per 100 gram

    // Konstruktor untuk menginisialisasi objek FoodItem dengan nilai awal
    public FoodItem(String name, int caloriesPerServing, int caloriesPer100g, double proteinPerServing, double proteinPer100g) {
        this.name = name;
        this.caloriesPerServing = caloriesPerServing;
        this.caloriesPer100g = caloriesPer100g;
        this.proteinPerServing = proteinPerServing;
        this.proteinPer100g = proteinPer100g;
    }
    // Getter untuk mendapatkan nama makanan
    public String getName() {
        return name;
    }
    // Getter untuk mendapatkan jumlah kalori per porsi
    public int getCaloriesPerServing() {
        return caloriesPerServing;
    }
    // Getter untuk mendapatkan jumlah kalori per 100 gram
    public int getCaloriesPer100g() {
        return caloriesPer100g;
    }
    // Getter untuk mendapatkan jumlah protein per porsi
    public double getProteinPerServing() {
        return proteinPerServing;
    }
    // Getter untuk mendapatkan jumlah protein per 100 gram
    public double getProteinPer100g() {
        return proteinPer100g;
    }
}
