public class Passenger {
    private String name;
    private Integer money;

    public Passenger(String name, Integer money){
        this.name = name;
        this.money = money;
    }

    public String getName(){
        return name;
    }

    public int getMoney(){
        return money;
    }

    public void buyTicket(){
        money -= 5;
    }
}
