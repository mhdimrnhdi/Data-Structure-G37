
package assignment;

class Node<T>{
    T data;
    Node next;
    
    Node(T data){
        this.data =data;
    }
    public T getdata(){
    return data;
    }
    public Node getNext(){
        return next;
    }
    public void setdata(T data){
        this.data=data;
    }
    public void setNext(Node next){
        this.next=next;
    }
    public String toString(){
        return "Data: "+this.data;
    }
}
   
public class SystemBLL<T>{
     Node<T> head;
    //LIFO linkedlist
    public void insertAtHead(T data){
        Node newNode = new Node(data);
        newNode.setNext(head);
        this.head=newNode;
    }
     // FIFO linkedlist
    public void insertAtTail(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }
    public void insert(T data){
        Node newNode = new Node(data);
        if(head==null){
            this.head=newNode;
        }
        else{
            Node current = head;
            while(current.getNext()!=null){
                current=current.getNext();
            }
            current.setNext(newNode);
        }
    }
   //LIFO and FIFO delete
    public T deleteAtHead() {
    if (head != null) {
        Node<T> temp = head;
        head = head.getNext();
        temp.setNext(null);  // Ensure the removed node doesn't reference the rest of the list
        return temp.getdata();
        }
    return null; // Return null if the list was empty
    }
   //unused deleteAtTail and delete but useful method to have in LL
    public T deleteAtTail() {
    if (head == null) {
        throw new IllegalStateException("List is empty");
    }
    if (head.getNext() == null) {
        T data = head.getdata();
        head = null;
        return data;
    }
    Node<T> current = head;
    Node<T> previous = null;
    while (current.getNext() != null) {
        previous = current;
        current = current.getNext();
    }
    previous.setNext(null);
    return current.getdata(); // Explicitly cast to type T
    }

    public void delete(T data){
        if(head==null){
            throw new IllegalStateException("List is empty");
        }
        if(head.getdata().equals(data)){
            head=head.getNext();
            return;
        }
        Node<T> current = head;
        Node<T> previous=null;
        while(current!=null && !current.getdata().equals(data)){
            previous=current;
            current=current.getNext();
        }
        if(current==null){
            System.out.println(data+" does not exist");
        }
        previous.setNext(current.getNext());
        // Update pointers to skip the node
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    @Override
    public String toString(){
        String result ="";
        Node current = head;
        while(current !=null){
            result +=current.toString()+" ";
            current= current.getNext();
        }
        return result;
    }
    
}
