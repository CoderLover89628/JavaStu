package com.zs.forInterView.string;

public class ���� {

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
    protected Nodes next; //ָ����  
    protected int data;//������  
      
    public Nodes( int data) {  
          this. data = data;  
    }  
      
    //��ʾ�˽ڵ�  
    public void display() {  
         System. out.print( data + " ");  
    }  
}  


class LinkList {  
    public Nodes first; // ����һ��ͷ���  
    private int pos = 0;// �ڵ��λ��  
 
    public LinkList() {  
          this. first = null;  
    }  
 
    // ����һ��ͷ�ڵ�  
    public void addFirstNodes( int data) {  
         Nodes node = new Nodes(data);  
         node. next = first;  
          first = node;  
    }  
 
    // ɾ��һ��ͷ���,������ͷ���  
    public Nodes deleteFirstNodes() {  
         Nodes tempNodes = first;  
          first = tempNodes. next;  
          return tempNodes;  
    }  
 
    // ������λ�ò���ڵ� ��index�ĺ������  
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
 
    // ɾ������λ�õĽڵ�  
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
 
    // ���ݽڵ��dataɾ���ڵ�(����ɾ����һ��)  
    public Nodes deleteByData( int data) {  
         Nodes current = first;  
         Nodes previous = first; //��ס��һ���ڵ�  
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
 
    // ��ʾ�����еĽڵ���Ϣ  
    public void displayAllNodess() {  
         Nodes current = first;  
          while (current != null) {  
             current.display();  
             current = current. next;  
         }  
          System. out.println();  
     }  
  
     // ����λ�ò��ҽڵ���Ϣ  
     public Nodes findByPos( int index) {  
          Nodes current = first;  
           if ( pos != index) {  
              current = current. next;  
               pos++;  
          }  
           return current;  
     }  
  
     // �������ݲ��ҽڵ���Ϣ  
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

