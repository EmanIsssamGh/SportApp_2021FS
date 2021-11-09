package edu.cs.birzeit.androidAssignment_1;

public class Item {


    private String ItemName;
    private int Price ;
    private String Rating;
    private String ItemsRemaining;
    private String Description;
    private String Category;
    private int Image;


    public Item(String itemName, int price, String rating, String itemsRemaining, String description, String category, int image) {
        ItemName = itemName;
        Price = price;
        Rating = rating;
        ItemsRemaining = itemsRemaining;
        Description = description;
        Image = image;
        Category = category;

    }

    public String getItemName() {
        return ItemName;
    }
    public int getPrice() {
        return Price;
    }

    public String getRating() {
        return Rating;
    }

    public String getItemsRemaining() {
        return ItemsRemaining;
    }
    public String getDescription() {
        return Description;
    }

    public String getCategory() {
        return Category;
    }

    public int getImage() {
        return Image;
    }



    public String toString() {
        return ItemName + " " + Price + " " + Rating + " " + ItemsRemaining + " " + Description + " " + Category + ""+ Image + "";
    }
}
