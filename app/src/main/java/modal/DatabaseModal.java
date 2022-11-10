package modal;

public class DatabaseModal {

       int image;
     String  name,price,quantity;



        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public  String getName() {
            return name;
        }
        public  String getQuantity()
        {return quantity;}
        public void setQuantity(String quantity)
        { this.quantity=quantity;}


        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

    }

