package com.alibendjoudi.week_12;
import java.util.ArrayList;
import java.util.List;

class QueueFullException extends Exception {}

class QueueEmptyException extends Exception {}


class Queue<E> {
    private List<E> elements = new ArrayList<>();
    Queue() {}

    void enqueue(E element ) throws QueueFullException {
        elements.add(element);

    }

    E dequeue() throws QueueEmptyException {
        if (elements.size()==0) {
            throw new QueueEmptyException();
        }

        E returnElement = elements.get(0);
        elements.remove(0);
        return returnElement;

    }


}


public class Main {
    public static void main(String[] agrs) {
        Queue<String> strings = new Queue<>();
        try {
            strings.enqueue("Hello");
            strings.enqueue("World");
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
        } catch (QueueFullException | QueueEmptyException e) {
            e.printStackTrace();
        }

    }
}