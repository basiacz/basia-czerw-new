package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class Onion extends AbstractPizzaOrderDecorator {

    public Onion(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", onion";
    }
}