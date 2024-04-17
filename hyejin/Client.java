package DesignPattern;

import java.util.*;

// 요소를 나타내는 클래스
class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// 메뉴를 관리하는 클래스
class Menu {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public Iterator<MenuItem> iterator() {
        return new MenuIterator(items);
    }
}

// 이터레이터 인터페이스
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// 메뉴를 순회하는 이터레이터 클래스
class MenuIterator implements Iterator<MenuItem> {
    private List<MenuItem> items;
    private int position;

    public MenuIterator(List<MenuItem> items) {
        this.items = items;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new RuntimeException("No more elements");
        }
        MenuItem menuItem = items.get(position);
        position++;
        return menuItem;
    }
}

// 클라이언트
public class Client {
    public static void main(String[] args) {
        // 메뉴 생성
        Menu menu = new Menu();
        menu.addItem(new MenuItem("치즈버거", 5.99));
        menu.addItem(new MenuItem("감자튀김", 2.49));
        menu.addItem(new MenuItem("콜라", 1.50));

        // 이터레이터를 통해 메뉴 항목 출력
        Iterator<MenuItem> iterator = menu.iterator();
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println("메뉴: " + menuItem.getName() + ", 가격: $" + menuItem.getPrice());
        }
    }
}
