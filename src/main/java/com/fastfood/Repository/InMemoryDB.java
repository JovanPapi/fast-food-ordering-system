package com.fastfood.Repository;

import com.fastfood.model.Product;
import com.fastfood.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class InMemoryDB {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    private String inputFile;

    public InMemoryDB(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public void populateDB() {
        userRepository.save(new User(UUID.randomUUID().toString(), "Jovan", "Papalazoski",
                "jovan.gppapi@hotmail.com", "sabja", "078-246-005", new ArrayList<>()));

        fillBurgers();
        fillChickenAndSandwich();
        fillComboMeal();
        fillDrinks();
        fillPizzas();
    }

    public void deleteDB() {
        productRepository.deleteAll();
    }

    // FILL DB AND IMAGES FOR BURGERS
    public List<String> fillBurgerImages(String typeProduct) {
        List<String> imageFileList = new ArrayList<>();

        inputFile = "/img/" + typeProduct + "/t-mcdonalds-Big-Mac0.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Quarter-Pounder-with-Cheese.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Double-Quarter-Pounder-with-Cheese.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Quarter-Pounder-with-Cheese.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/AmigoB.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/bacon.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Cheeseburger.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Double-Cheeseburger.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Hamburger.jpg";
        imageFileList.add(inputFile);

        return imageFileList;
    }

    public void fillBurgers() {
        List<String> imageFileList = fillBurgerImages("burgers");
        List<Product> burgers = new ArrayList<Product>() {{
            add(new Product(UUID.randomUUID().toString(), "Big Mac", 100, "Mouthwatering perfection starts with two 100% pure beef " +
                    "patties and Big Mac sauce sandwiched " +
                    "between a sesame seed bun. It’s topped off with pickles, crisp shredded lettuce, " +
                    "finely chopped onion and American cheese.", "Big Mac Bun, 100% Beef Patty, " +
                    "Shredded Lettuce, Big Mac Sauce, Pickle Slices", "burger", new ArrayList<User>(), imageFileList.get(0)));

            add(new Product(UUID.randomUUID().toString(), "Quarter Pounder with Cheese", 100, "Each Quarter Pounder with Cheese burger features a " +
                    "¼ lb.* of 100% fresh beef that’s hot, deliciously juicy and cooked when you order. " +
                    "It’s seasoned with just a pinch of salt and pepper, sizzled on a flat iron grill, then topped with slivered onions, " +
                    "tangy pickles and two slices of melty cheese on a sesame seed bun.", "Quarter Pound 100% Beef Patty,  Quarter Pound Bun, " +
                    "Ketchup, Onions, Pickle Slices", "burger", new ArrayList<>(), imageFileList.get(1)));

            add(new Product(UUID.randomUUID().toString(), "Double Quarter Pounder with Cheese", 100, "Double Quarter Pounder®* with Cheese\n" +
                    "720 Cal.720 Cal.\n" +
                    "Each Double Quarter Pounder with Cheese features two quarter pound* 100% fresh " +
                    "beef burger patties that are hot, deliciously juicy and cooked when you order. " +
                    "McDonald’s beef patties are seasoned with just a pinch of salt and pepper, sizzled on a flat iron grill, " +
                    "then topped with slivered onions, " +
                    "tangy pickles and two slices of melty cheese on a sesame seed bun.", "Quarter Pound 100% Beef Patty, Quarter Pound Bun, " +
                    "Ketchup, Onions, Pickle Slices", "burger", new ArrayList<>(), imageFileList.get(2)));

            add(new Product(UUID.randomUUID().toString(), "Quarter Pounder with Cheese Deluxe", 100, "The Quarter Pounder® with Cheese Deluxe is a fresh take on a Quarter Pounder® classic burger. Crisp leaf lettuce and three Roma tomato slices top a ¼ lb.* of 100% McDonald’s fresh beef that’s hot, deliciously juicy and cooked when you order. Seasoned with just a pinch of salt and pepper and sizzled on our flat iron grill. Layered with two slices of " +
                    "melty American cheese, creamy mayo, slivered onions and tangy pickles on" +
                    " a soft, fluffy sesame seed hamburger bun.", "Big Mac Bun, 100% Beef Patty, " +
                    "Shredded Lettuce, Big Mac Sauce, Pickle Slices", "burger", new ArrayList<>(), imageFileList.get(3)));

            add(new Product(UUID.randomUUID().toString(), "AmigoDouble", 100, "A classic double burger from McDonald’s, " +
                    "the McDouble® stacks two 100% pure beef patties seasoned with just a pinch of salt and pepper. " +
                    "It’s topped with tangy pickles, chopped onions, ketchup, mustard and a slice of melty American" +
                    " cheese. It contains no artificial flavors, preservatives or" +
                    " added colors from artificial sources.* Our pickle " +
                    "contains an artificial preservative, so skip it if you like.", "Regular Bun, 100% Beef Patty, " +
                    "Onions, Big Mac Sauce, Ketchup", "burger", new ArrayList<>(), imageFileList.get(4)));

            add(new Product(UUID.randomUUID().toString(), "Quarter Pounder with Cheese Bacon", 100, "Each Quarter Pounder® with Cheese Bacon burger " +
                    "features thick-cut applewood smoked bacon atop a ¼ lb.* of 100% fresh McDonald’s beef that’s cooked when you order. " +
                    "It’s a hot, deliciously juicy bacon cheeseburger, seasoned with just a pinch of salt and pepper and sizzled on our" +
                    " flat iron grill. Layered with two slices of melty American cheese, " +
                    "slivered onions and tangy pickles on a soft, " +
                    "fluffy sesame seed hamburger bun.", "Quarter Pound 100% Beef Patty*, Quarter Pound Bun, " +
                    "Thick Cut Applewood Smoked Bacon, Ketchup, Pickle Slices", "burger", new ArrayList<>(), imageFileList.get(5)));

            add(new Product(UUID.randomUUID().toString(), "Cheeseburger", 100, "Our simple, classic cheeseburger begins " +
                    "with a 100% pure beef patty seasoned with just a pinch of salt and pepper. " +
                    "It's topped with a tangy pickle, chopped onions, ketchup, mustard, and a slice of " +
                    "melty American cheese. It contains no artificial flavors, " +
                    "preservatives or added colors from artificial sources.* Our pickle " +
                    "contains an artificial preservative, so skip it if you like.", "Regular Bun, 100% Beef Patty, " +
                    "Pasteurized Process American Cheese, Onions, Pickle Slices, Ketchup", "burger", new ArrayList<>(), imageFileList.get(6)));

            add(new Product(UUID.randomUUID().toString(), "Double Cheeseburger", 100, "The McDonald’s Double Cheeseburger " +
                    "features two 100% pure beef burger patties seasoned with just a pinch of salt and pepper." +
                    " It’s topped with tangy pickles, chopped onions, ketchup," +
                    " mustard and two slices of melty American cheese. It contains no artificial" +
                    " flavors, preservatives or added colors from artificial sources.", "Regular Bun, 100% Beef Patty, " +
                    "Ketchup, Onions, Pickle Slices", "burger", new ArrayList<>(), imageFileList.get(7)));

            add(new Product(UUID.randomUUID().toString(), "Hamburger", 100, "The original burger starts with a 100%" +
                    " pure beef patty seasoned with just a pinch of salt and pepper, " +
                    "then topped with a tangy pickle," +
                    " chopped onions, ketchup and mustard. It contains no artificial" +
                    " flavors, preservatives or added colors from artificial sources.", "Regular Bun, 100% Beef Patty, " +
                    "Ketchup, Onions, Pickle Slices, Mustard", "burger", new ArrayList<>(), imageFileList.get(8)));
        }};
        productRepository.saveAll(burgers);
    }

    // FILL DB AND IMAGES FOR PIZZAS
    public List<String> fillPizzasImage(String typeProduct) {
        List<String> imageFileList = new ArrayList<>();

        inputFile = "/img/" + typeProduct + "/capri.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/lossos.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/margherita.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/milaneza.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/oliva.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/pepperoni.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/sicilian.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/vegetarian.jpg";
        imageFileList.add(inputFile);


        return imageFileList;
    }

    public void fillPizzas(){
        List<Product> pizza = new ArrayList<Product>() {{
            List<String> imageList = fillPizzasImage("pizza");

            add(new Product(UUID.randomUUID().toString(),"Capricciosa", 100, "Very olives mixed with bacon,mushrooms,tomato sauce.",
                    "olives, bacon, mushrooms, tomato sauce","pizza",new ArrayList<>(), imageList.get(0)));
            add(new Product(UUID.randomUUID().toString(),"Lossos", 100, "Cheese,bacon,Miller & tomato sauce,Laurel leaf.",
                    "cheese, bacon, miller & tomato sauce, laurel leaf","pizza",new ArrayList<>(), imageList.get(1)));
            add(new Product(UUID.randomUUID().toString(),"Margherita", 100, "Classic mozzarella cheese & tomato sauce.",
                    "mozzarella cheese & tomato sauce","pizza",new ArrayList<>(), imageList.get(2)));
            add(new Product(UUID.randomUUID().toString(),"Milanese", 100, "Tomato sauce, salami, cheese, olives.",
                    "tomato sauce, salami, cheese, olives","pizza",new ArrayList<>(), imageList.get(3)));
            add(new Product(UUID.randomUUID().toString(),"Oliva", 100, "Oliva sauce, mozzarella, roast beef, turkey, fresh mushrooms, peppers and mixed olives.",
                    "oliva sauce, mozzarella, roast beef, turkey, fresh mushrooms, peppers","pizza",new ArrayList<>(), imageList.get(4)));
            add(new Product(UUID.randomUUID().toString(),"Pepperoni", 100, "Salami,pork beef seasoned with paprika or other chili pepper.",
                    "salami, pork beef with paprika, chilli pepper","pizza",new ArrayList<>(), imageList.get(5)));
            add(new Product(UUID.randomUUID().toString(),"Sicilian", 100, "Salami, pepperoni, italian sausage, green peppers & onions.",
                    "salami, pepperoni, italian sausage, green peppers & onions","pizza",new ArrayList<>(), imageList.get(6)));
            add(new Product(UUID.randomUUID().toString(),"Vegetarian", 100, "Fresh spinach, sweetcorn, mixed peppers, red onions & mushrooms.",
                    "fresh spinach, sweetcorn, mixed peppers, red onions, mushrooms","pizza",new ArrayList<>(), imageList.get(7)));
        }};
        productRepository.saveAll(pizza);
    }

    // FILL DB AND IMAGES FOR CHICKEN AND SANDWICH
    public List<String> fillChickenAndSandwichImages(String typeProduct) {
        List<String> imageFileList = new ArrayList<>();

        inputFile = "/img/" + typeProduct + "/Chicken-McNuggets-4pc.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Buttermilk-Crispy-Chicken-Deluxe-Sandwich.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/ChickenSandwich.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Filet-O-Fish.jpg";
        imageFileList.add(inputFile);

        return imageFileList;

    }

    public void fillChickenAndSandwich() {
        List<String> imageList = fillChickenAndSandwichImages("chicken-sand");

        List<Product> chickenAndSandwich = new ArrayList<Product>() {{
            add(new Product(UUID.randomUUID().toString(), "Chicken McNuggets", 100, "Our tender, juicy Chicken McNuggets are made " +
                    "with 100% white meat chicken and no artificial colors, " +
                    "flavors or preservatives.", "", "chickenAndSandwich", new ArrayList<>(), imageList.get(0)));

            add(new Product(UUID.randomUUID().toString(), "Buttermilk Crispy Chicken Sandwich", 100, "McDonald's Buttermilk " +
                    "Crispy Chicken Sandwich is made with all white meat chicken and no added colors. " +
                    "It's layered with crisp, green leaf lettuce and tasty tomato" +
                    " and mayonnaise and served up on a delectable artisan roll. ", "Buttermilk Crispy Chicken Fillet, Artisan Roll," +
                    "Roma Tomato, Shredded Lettuce, Mayonnaise", "chickenAndSandwich", new ArrayList<>(), imageList.get(1)));

            add(new Product(UUID.randomUUID().toString(), "Amigo Chicken", 100, "The McChicken® is a delightfully crispy " +
                    "chicken sandwich with a crispy chicken fillet topped with mayonnaise," +
                    " shredded iceberg lettuce, and served on a perfectly toasty bun.", "McChicken Patty, Regular Bun, " +
                    "Shredded Lettuce, Mayonnaise", "chickenAndSandwich", new ArrayList<>(), imageList.get(2)));

            add(new Product(UUID.randomUUID().toString(), "Filet-O-Fish", 100, "Dive into our wild-caught Filet-O-Fish®!" +
                    " Sourced from " +
                    "sustainable fisheries, topped with melty " +
                    "American cheese and creamy tartar sauce, and served" +
                    " on a soft, steamed bun.", "Fish Filet Patty, Regular Bun, Tartar Sauce, " +
                    "Pasteurized Process American Cheese Half Slice", "chickenAndSandwich", new ArrayList<>(), imageList.get(3)));
        }};
        productRepository.saveAll(chickenAndSandwich);
    }


    // FILL DB AND IMAGES FOR DRINKS
    public List<String> fillDrinkImages(String typeProduct) {
        List<String> imageFileList = new ArrayList<>();

        inputFile = "/img/" + typeProduct + "/Coca-Cola-Classic-Small.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Sprite-Small.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/fanta-orange.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Dr-Pepper-Small.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/fanta-orange.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Sprite-Small.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Iced-Tea-Large.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Iced-Tea-Large.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/fanta-orange.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Iced-Tea-Large.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Sprite-Small.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/Iced-Tea-Large.jpg";
        imageFileList.add(inputFile);

        return imageFileList;
    }

    public void fillDrinks() {
        List<String> imageList = fillDrinkImages("drinks");
        List<Product> drinks = new ArrayList<Product>() {{
            add(new Product(UUID.randomUUID().toString(), "Coca-Cola", 100, "Coca-Cola® is a refreshing McDonald's " +
                    "soda option that complements all of your menu favorites.", "", "drink", new ArrayList<>(), imageList.get(0)));

            add(new Product(UUID.randomUUID().toString(), "Small Sprite", 100, "Sprite fountain drink has a delicious " +
                    "lemon-lime taste and is available in sizes Extra Small, Small, Medium, and Large.", "", "drink",
                    new ArrayList<>(), imageList.get(1)));

            add(new Product(UUID.randomUUID().toString(), "Fanta Orange", 100, "Caffeine-free Fanta® Orange full of bubbly, " +
                    "refreshing orange flavor. Available in " +
                    "Extra Small, Small, Medium, and Large.", "", "drink", new ArrayList<>(), imageList.get(2)));

            add(new Product(UUID.randomUUID().toString(), "Dr. Pepper", 100, "This Amigo's soda option is perfect to pair" +
                    " with any of your favorite menu items. " +
                    "Available in extra small, small, medium and large for $1", "", "drink", new ArrayList<>(), imageList.get(3)));

            add(new Product(UUID.randomUUID().toString(), "Small MIX by Sprite Tropic Berry", 100, "MIX by Sprite™ Tropic Berry takes the classic," +
                    " crisp lemon-lime taste of Sprite™ " +
                    "to the next level with a tropically " +
                    "inspired blend of strawberry, orange and pineapple flavors.", "", "drink", new ArrayList<>(), imageList.get(4)));

            add(new Product(UUID.randomUUID().toString(), "Diet Coke", 100, "Icy cold Diet Coke®, with zero calories." +
                    " Fountain drink available in Extra Small, Small, Medium and Large.", "", "drink", new ArrayList<>(), imageList.get(5)));

            add(new Product(UUID.randomUUID().toString(), "Chocolate Shake", 100, "Amigo’s Chocolate Shake is a delicious chocolate " +
                    "dessert made with our creamy vanilla soft" +
                    " serve and chocolate syrup, topped with whipped topping." +
                    " Available in Small, Medium and Large.", "Vanilla Reduced Fat Ice Cream, Chocolate Shake Syrup, " +
                    "Whipped Light Cream", "drink", new ArrayList<>(), imageList.get(6)));

            add(new Product(UUID.randomUUID().toString(), "Vanilla Shake", 100, "The classic vanilla shake from McDonald’s." +
                    " It’s made with our creamy " +
                    "vanilla soft serve and topped with whipped topping " +
                    "for a cool, tasty treat. Available in small, medium, and large.", "Vanilla " +
                    "Reduced Fat Ice Cream, Whipped Light Cream", "drink", new ArrayList<>(), imageList.get(7)));

            add(new Product(UUID.randomUUID().toString(), "Strawberry Shake", 100, "Amigo’s Strawberry Shake is made with " +
                    "creamy vanilla soft serve," +
                    " blended with strawberry syrup and topped with whipped topping." +
                    " Available in Small, Medium, and Large.", "Vanilla Reduced Fat Ice Cream, Strawberry Shake Syrup, Whipped " +
                    "Light Cream", "drink", new ArrayList<>(), imageList.get(8)));

            add(new Product(UUID.randomUUID().toString(), "Hot Chocolate", 100, "Taste the delicious chocolatey flavor " +
                    "of a McCafé®Hot Chocolate. " +
                    "Hot chocolate made with steamed whole or " +
                    "nonfat milk, rich chocolate syrup and topped with " +
                    "whipped topping and chocolate drizzle.", "Whole Milk, Chocolate Syrup, Whipped Light Cream," +
                    " Chocolate Drizzle", "drink", new ArrayList<>(), imageList.get(9)));

            add(new Product(UUID.randomUUID().toString(), "Iced Tea", 100, "A refreshing drink of McDonald’s Iced Tea, freshly " +
                    "brewed with a brisk blend of orange " +
                    "pekoe and pekoe cut black tea, served ice cold. " +
                    "Available in Extra Small, Small, Medium and Large.", "", "drink", new ArrayList<>(), imageList.get(10)));

            add(new Product(UUID.randomUUID().toString(), "Sweet Tea", 100, "Amigo’s Sweet Tea is made from a briskly " +
                    "refreshing blend of orange pekoe and pekoe " +
                    "cut black tea, sweetened to perfection. Available in" +
                    " Extra Small, Small, Medium and Large.", "", "drink", new ArrayList<>(), imageList.get(11)));
        }};

        productRepository.saveAll(drinks);
    }

    //FILL DB AND IMAGES FOR COMBO MEALS
    public List<String> fillComboMealImages(String typeProduct) {
        List<String> imageFileList = new ArrayList<>();

        inputFile = "/img/" + typeProduct + "/h-mcdonalds-Big-Mac-Extra-Value-Meals.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/h-mcdonalds-2-Cheeseburger-Extra-Value-Meals.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/h-mcdonalds-Quarter-Pounder-with-Cheese-Extra-Value-Meals.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/h-mcdonalds-Double-Quarter-Pounder-with-Cheese-Extra-Value-Meals.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/h-mcdonalds-Premium-Crispy-Chicken-Classic-Extra-Value-Meals.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/h-mcdonalds-Chicken-McNuggets-10-piece-Extra-Value-Meals.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/h-mcdonalds-Filet-O-Fish-Extra-Value-Meals.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/h-mcdonalds-Egg-McMuffin-Extra-Value-Meals.jpg";
        imageFileList.add(inputFile);
        inputFile = "/img/" + typeProduct + "/h-mcdonalds-Sausage-McMuffin-with-Egg-Extra-Value-Meals.jpg";
        imageFileList.add(inputFile);

        return imageFileList;
    }

    public void fillComboMeal() {
        List<String> imageList = fillComboMealImages("combo-meal");
        List<Product> comboMeal = new ArrayList<Product>() {{
            add(new Product(UUID.randomUUID().toString(), "Big Mac Combo Meal", 100, "",
                    "", "comboMeal", new ArrayList<>(), imageList.get(0)));

            add(new Product(UUID.randomUUID().toString(), "Cheeseburger Combo Meal", 100, "",
                    "", "comboMeal", new ArrayList<>(), imageList.get(1)));

            add(new Product(UUID.randomUUID().toString(), "Quarter Pounder with Cheese Meal", 100, "",
                    "", "comboMeal", new ArrayList<>(), imageList.get(2)));

            add(new Product(UUID.randomUUID().toString(), "Double Quarter Pounder with Cheese Meal", 100, "",
                    "", "comboMeal", new ArrayList<>(), imageList.get(3)));

            add(new Product(UUID.randomUUID().toString(), "Buttermilk Crispy Chicken Sandwich Meal", 100, "",
                    "", "comboMeal", new ArrayList<>(), imageList.get(4)));

            add(new Product(UUID.randomUUID().toString(), "10 Piece Chicken Nugget Meal", 100, "",
                    "", "comboMeal", new ArrayList<>(), imageList.get(5)));

            add(new Product(UUID.randomUUID().toString(), "Fillet-O-Fish Meal", 100, "",
                    "", "comboMeal", new ArrayList<>(), imageList.get(6)));

            add(new Product(UUID.randomUUID().toString(), "Egg Muffin Meal", 100, "",
                    "", "comboMeal", new ArrayList<>(), imageList.get(7)));

            add(new Product(UUID.randomUUID().toString(), "Sausage Muffin with Egg Meal", 100, "",
                    "", "comboMeal", new ArrayList<>(), imageList.get(8)));
        }};
        productRepository.saveAll(comboMeal);
    }
}
