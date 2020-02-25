package Example3;

class TestBuilder  {
  
    public static void main(String[] args) {
       
       HouseBuilder one = new OneStoryHouse("2 bedrooms, 2.5 baths, 2-car garage, 1500 sqft");
       HouseBuilder two = new TwoStoryHouse("4 bedrooms, 4 baths, 3-car garage, 5000 sqft");

       WorkShop shop = new WorkShop();
       shop.construct(one);
       shop.construct(two);
    
   
       System.out.println("Check house building progress: \n");
       System.out.println(one.showProgress());
       System.out.println(two.showProgress());
   }
}