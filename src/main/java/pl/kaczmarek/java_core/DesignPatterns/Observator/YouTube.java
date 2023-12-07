package pl.kaczmarek.java_core.DesignPatterns.Observator;

public class YouTube {

    public static void main(String[] args) {

        // MANY TO ONE

        Channel sebo = new Channel();
        Channel gaba = new Channel();

        Subscriber jacek = new Subscriber("jacek");
        Subscriber jacek1 = new Subscriber("jacek1");
        Subscriber jacek2 = new Subscriber("jacek2");
        Subscriber jacek3 = new Subscriber("jacek3");
        Subscriber jacek4 = new Subscriber("jacek4");

        sebo.subscribe(jacek);
        sebo.subscribe(jacek1);
        sebo.subscribe(jacek2);
        sebo.subscribe(jacek3);
        sebo.subscribe(jacek4);


        // Why is that here?
        jacek.subscribeChannel(sebo);
        jacek1.subscribeChannel(sebo);
        jacek2.subscribeChannel(sebo);
        jacek3.subscribeChannel(sebo);
        jacek4.subscribeChannel(sebo);

        jacek4.subscribeChannel(gaba);
        gaba.subscribe(jacek);


        sebo.upload("CODELION");
        System.out.println();

        sebo.unSubscribe(jacek4);
        sebo.upload("CODELION");
        System.out.println();
        gaba.upload("HERE GABA");
    }
}
