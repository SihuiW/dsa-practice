interface Observer {
    void notify(String itemName);
}

class Customer implements Observer {
    private String name;
    private int notifications;

    public Customer(String name) {
        this.name = name;
        this.notifications = 0;
    }

    public void notify(String itemName) {
        this.notifications += 1;
    }

    public int countNotifications() {
        return this.notifications;
    }
}

class OnlineStoreItem {
    private List<Observer> list = new ArrayList<>();
    private String itemName;
    private int stock;

    public OnlineStoreItem(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public void subscribe(Observer observer) {
        list.add(observer);
    }

    public void unsubscribe(Observer observer) {
        list.remove(observer);
    }

    public void updateStock(int newStock) {
        if(stock == 0 && newStock > 0) {
            this.stock = newStock;
            for(Observer ob: list) {
                ob.notify(itemName);
            }
        } else {
            this.stock = newStock;
        }
    }
}
