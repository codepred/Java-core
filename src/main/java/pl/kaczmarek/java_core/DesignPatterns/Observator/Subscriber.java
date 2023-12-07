package pl.kaczmarek.java_core.DesignPatterns.Observator;

public class Subscriber implements Observer {

    private String name;
    private Channel channel = new Channel();

    @Override
    public void update(){
        System.out.println(name +  "Video uploaded");
    }

    @Override
    public void subscribeChannel(Channel ch){
        channel = ch;
    }

    public Subscriber(String name) {
        super();
        this.name = name;
    }
}
