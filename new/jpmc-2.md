Top n on add

import java.util.*;

class User {
    int id;
    int amount;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + id;
        result = 31 * result + amount;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && amount == user.amount;
    }
}

class TopUsers {
    Map<Integer, User> map = new HashMap<>();
    NavigableSet<User> set = new TreeSet<>(Comparator.comparingInt(User::getAmount).reversed());

    public boolean add(int userId, int amount) {
        int prevAmount = 0;
        if (map.containsKey(userId)) {
            User prev = map.get(userId);
            set.remove(prev);
            prevAmount = prev.amount;
        }

        User user = new User(userId, amount + prevAmount);
        map.put(userId, user);
        set.add(user);

        if (set.size() > 100) {
            set.pollLast();
        }
        return set.contains(user);
    }
}




LRU

// Create a map
// Create a array
// Every addition check 

class LRU{
    static class Node{
        int val;
        Node prev;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    Map<Integer, Node> userMap = new HashMap<>();
    Node head = new Node(0);
    Node tail = new Node(0);
    int cap;
    
    LRU(int cap){
        this.cap = cap;
        head.next = tail;
        tail.prev = head;
    }


    void add(int user){
        computeAndAdd(user);
        if(userMap.size() > cap){
            removeLast();
        }
    }

    void computeAndAdd(int user){
        if(userMap.containsKey(user)){
            Node node = userMap.get(user);
            userMap.remove(user);
            removeNode(node);
        }
        Node node = new Node(user);
        insertFirst(node);
    }

    void removeNode(Node node){
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
    }

    void removeLast(){
        Node node = tail.prev;
        Node p = node.prev;
        p.next = tail;
        tail.prev = p;
        userMap.remove(node.val);
    }

    void insertFirst(Node node){
        Node previous = head.next;
        node.prev = head;
        head.next = node;
        node.next = previous;
        previous.prev = node;
    }
}