package designpatterns;

import lombok.*;

import java.util.*;

public class CommandPattern {
    public static void main(String ...args){
        List<Order> orders  = Arrays.asList(new BuyOrder(new Stock(4,"Apple")),
                new BuyOrder(new Stock(100,"Tata")),
                new SellOrder(new Stock(50,"Reliance")),
                new BuyOrder(new Stock(10,"Mahindra")),
                new SellOrder(new Stock(30,"Apple")),
                new BuyOrder(new Stock(45,"TCS")));

        for(Order o: orders)
            o.execute();

    }
}
@AllArgsConstructor
class Stock{
    int unit;
    String name;
    public void buy(){
        System.out.println("Buying "+unit+" units of "+name+" shares");
    }
    public void sell(){
        System.out.println("Selling "+unit+" units of "+name+" shares");
    }
}

interface Order{
    void execute();
}
@AllArgsConstructor
class BuyOrder implements Order{
    Stock s;

    @Override
    public void execute() {
        s.buy();
    }
}
@AllArgsConstructor
class SellOrder implements Order{
    Stock s;

    @Override
    public void execute() {
        s.sell();
    }
}