package microsoft;

public class Message {

    int x;
    int y;


}

class CarBuilder {

    private Message message;

    public CarBuilder() {
        this.message = new Message();
    }

    public CarBuilder setX(int x) {
        this.message.x = x;
        return this;
    }

    public CarBuilder setY(int y) {
        this.message.y = y;
        return this;
    }

    public Message build() {
        return this.message;
    }
}
