package com.liu.designpattern.strategypattern;

/**
 * @author liuzhuangyuan
 * @description
 * @date 2020/8/20 下午10:55
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategy = new ConcreteStrategyA();
        context.setStrategy(strategy);
        context.strategyMethod();

        System.out.println("-----------------");

        strategy = new ConcreteStrategyB();
        context.setStrategy(strategy);
        context.strategyMethod();

    }



}

//抽象策略类
interface Strategy {

    //策略方法
    void strategyMethod();

}

//具体策略类A
class ConcreteStrategyA implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被访问！");
    }
}


//具体策略类A
class ConcreteStrategyB implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被访问！");
    }
}


class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}

