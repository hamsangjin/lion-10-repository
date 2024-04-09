import java.util.ArrayList;
import java.util.List;
//topic은 주체이자 객체
interface Subject { //옵저버들을 등록, 해제하고 상태 변경을 알리는 메서드
    public void register(Observer obj); //옵저버 등록
    public void unregister(Observer obj); //옵저버 해제
    public void notifyObservers(); //등록된 모든 옵저버들에게 상태 변경을 알림
    public Object getUpdate(Observer obj); //특정 옵저버가 필요로 하는 업데이트 정보를 얻음
}

interface Observer { //topic으로부터 상태 변경에 대한 알림을 받음
    public void update(); //topic으로부터 상태 변경 알림을 받고 처리
}

class Topic implements Subject { //subject 인터페이스 구현,topic 의 상태를 변경하고 등록된 옵저버들에게 알림
    private List<Observer> observers;
    private String message;

    public Topic() {
        this.observers = new ArrayList<>();
        this.message = "";
    }

    @Override
    public void register(Observer obj) {
        if (!observers.contains(obj)) observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(Observer::update);
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("Message sended to Topic: " + msg);
        this.message = msg;
        notifyObservers();
    }
}

class TopicSubscriber implements Observer {//topic으로부터 업데이트를 받아 처리
    private String name;
    private Subject topic;

    public TopicSubscriber(String name, Subject topic) {
        this.name = name;
        this.topic = topic;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        System.out.println(name + ":: got message >> " + msg);
    }
}

public class HelloWorld3 {
    public static void main(String[] args) {
        Topic topic = new Topic(); // Topic 인스턴스를 생성하고 옵저버들을 등록한 후, topic 의 상태를 변경하여 등록된 옵저버들에게 알림
        Observer a = new TopicSubscriber("a", topic); //옵저버를 선언할 때 해당 이름과 어떠한 토픽의 옵저버가 될 것인지 정함
        Observer b = new TopicSubscriber("b", topic); //3개의 옵저버들
        Observer c = new TopicSubscriber("c", topic);
        topic.register(a);
        topic.register(b);
        topic.register(c);

        topic.postMessage("amumu is op champion!!");//topic 의 상태를 변경합니다. 이로 인해 등록된 옵저버들에게 상태 변경이 알림으로 전달
    }
}