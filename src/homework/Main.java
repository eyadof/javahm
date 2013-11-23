package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Product c1 = new Product(1,60,1,"p1");
        Product c2 = new Product(1,55,1,"p1");
        System.out.println(c1.equals(c2));
        ArrayList<Product> a = new ArrayList<Product>();
        a.add(c1);
        a.add(c2);
        System.out.println(a.toString());
        Collections.sort(a);
        System.out.println(a.toString());
    }
}

class Variables{
    static int classVariable;
    int instanceVariable;

    public static void  main (String[] args){
        int localVariable;
        Variables t = new Variables();
        System.out.println(t.instanceVariable);
        System.out.println("Hello, World");
    }
}

class myMath{
    static Scanner input = new Scanner(System.in);
    public static void area (){
        System.out.println("Enter some radius to calculate its area: ");
        int r = input.nextInt();
        double area = Math.PI * Math.pow(r,2);
        System.out.println("your area is: " + Double.toString(area));

    }
    private static int myRandom(int min, int max){
        double t = Math.random() * max  + min;
        return (int)t;
    }

    public static void throwDice(){
        System.out.println("How many time you want to throw your dice?");
        int i= 0 ,num = input.nextInt();
        while (i < num){
            int diceNum = myRandom(1,6);
            System.out.println(diceNum);
            i++;
        }
    }
}

class Product implements Comparable<Product> {
    private int productID, price,quantity;
    private String productName;

    public int getProductID(){
        return productID;
    }

    public int getPrice(){
        return  price;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductID(int newPID){
        this.productID = newPID;
    }

    public void setPrice(int newPrice){
        this.price = newPrice;
    }

    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }

    public void setProductName(String name){
        this.productName = name;
    }

    public Product(int PID, String name){
        setProductID(PID);
        setProductName(name);
    }

    public Product(int PID,int price, int quant, String name){
        this(PID,name);
        this.setPrice(price);
        this.setQuantity(quant);
    }

    public boolean equals(Product p2){
        if ((this.price == p2.getPrice()) && (this.quantity == p2.getQuantity())
                && this.productID == p2.getProductID() && (this.productName == p2.getProductName()) ){
            return true;
        }
        else
            return false;
    }

    @Override public int compareTo(Product p2){
        final int BEFORE = -1;
        final int EQUAL  = 0;
        final int AFTER  = 1;
        if(this.price == p2.getPrice()){
            return EQUAL;
        }
        else if (this.price > p2.getPrice()){
            return AFTER;
        }
        else
            return BEFORE;
    }
}

class ProductStore{
    static int count;
    private ArrayList<Product> products = new ArrayList<Product>();

    ProductStore(){
        count++;
    }

    public void addProduct(int Price, int quant, int PID, String name){
        Product t = new Product(PID,Price,quant,name);
        this.products.add(t);
    }

    public void addProduct(Product p){
        this.products.add(p);
    }

    public Product getProductAtIndex(int index){
        return this.products.get(index);
    }

    public void sort(){
        Collections.sort(this.products);
    }

    public int productName(){
        return this.products.size();
    }

    public static int getInstanceCount(){
        return count;
    }
}