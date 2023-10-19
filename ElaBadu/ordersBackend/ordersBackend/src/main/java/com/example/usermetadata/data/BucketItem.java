package com.example.usermetadata.data;

public class BucketItem {
    private String id;
    private String title;
    private String image;
    private double price;
    private int rating;

    public BucketItem(String id, String title, String image, double price, int rating) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.price = price;
        this.rating = rating;
    }

    public BucketItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BucketItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
