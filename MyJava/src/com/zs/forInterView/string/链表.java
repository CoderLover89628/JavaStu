package com.zs.forInterView.string;

public class 链表 {

	public static void main(String[] args) {

		LinkList linkList = new LinkList();  
        linkList.addFirstNodes(20);  
        linkList.addFirstNodes(21);  
        linkList.addFirstNodes(19);  
         //19,21,20  
        linkList.add(1, 22); //19,22,21,20  
        linkList.add(2, 23); //19,22,23,21,20  
        linkList.add(3, 99); //19,22,23,99,21,20  
        linkList.displayAllNodess();  
//      Nodes node = linkList.deleteFirstNodes();  
//      System.out.println("node : " + node.data);  
//      linkList.displayAllNodess();  
//      node = linkList.deleteByPos(2);  
//      System.out.println("node : " + node.data);  
//      linkList.displayAllNodess();  
//      linkList.deleteFirstNodes();  
        Nodes node = linkList.deleteByData(19);  
//      Nodes node = linkList.deleteByPos(0);  
        System. out.println( "node : " + node. data);  
        linkList.displayAllNodess();  
        Nodes node1 = linkList.findByPos(0);  
        System. out.println( "node1: " + node1. data);  
        Nodes node2 = linkList.findByData(22);  
        System. out.println( "node2: " + node2. data); 

	}

}

class Nodes {  
    protected Nodes next; //指针域  
    protected int data;//数据域  
      
    public Nodes( int data) {  
          this. data = data;  
    }  
      
    //显示此节点  
    public void display() {  
         System. out.print( data + " ");  
    }  
}  


class LinkList {  
    public Nodes first; // 定义一个头结点  
    private int pos = 0;// 节点的位置  
 
    public LinkList() {  
          this. first = null;  
    }  
 
    // 插入一个头节点  
    public void addFirstNodes( int data) {  
         Nodes node = new Nodes(data);  
         node. next = first;  
          first = node;  
    }  
 
    // 删除一个头结点,并返回头结点  
    public Nodes deleteFirstNodes() {  
         Nodes tempNodes = first;  
          first = tempNodes. next;  
          return tempNodes;  
    }  
 
    // 在任意位置插入节点 在index的后面插入  
    public void add(int index, int data) {  
         Nodes node = new Nodes(data);  
         Nodes current = first;  
         Nodes previous = first;  
          while ( pos != index) {  
             previous = current;  
             current = current. next;  
              pos++;  
         }  
         node. next = current;  
         previous. next = node;  
          pos = 0;  
    }  
 
    // 删除任意位置的节点  
    public Nodes deleteByPos( int index) {  
         Nodes current = first;  
         Nodes previous = first;  
          while ( pos != index) {  
              pos++;  
             previous = current;  
             current = current. next;  
         }  
          if(current == first) {  
              first = first. next;  
         } else {  
              pos = 0;  
             previous. next = current. next;  
         }  
          return current;  
    }  
 
    // 根据节点的data删除节点(仅仅删除第一个)  
    public Nodes deleteByData( int data) {  
         Nodes current = first;  
         Nodes previous = first; //记住上一个节点  
          while (current. data != data) {  
              if (current. next == null) {  
                   return null;  
             }  
             previous = current;  
             current = current. next;  
         }  
          if(current == first) {  
              first = first. next;  
         } else {  
             previous. next = current. next;  
         }  
          return current;  
    }  
 
    // 显示出所有的节点信息  
    public void displayAllNodess() {  
         Nodes current = first;  
          while (current != null) {  
             current.display();  
             current = current. next;  
         }  
          System. out.println();  
     }  
  
     // 根据位置查找节点信息  
     public Nodes findByPos( int index) {  
          Nodes current = first;  
           if ( pos != index) {  
              current = current. next;  
               pos++;  
          }  
           return current;  
     }  
  
     // 根据数据查找节点信息  
     public Nodes findByData( int data) {  
          Nodes current = first;  
           while (current. data != data) {  
               if (current. next == null)  
                    return null;  
              current = current. next;  
          }  
           return current;  
     }  
}  

