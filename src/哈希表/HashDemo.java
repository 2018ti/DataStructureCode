package 哈希表;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashMap;
import java.util.Scanner;

public class HashDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(4);
        while (true) {
            System.out.println("-------哈希表----------------");
            System.out.println("add: 表示向哈希表中添加元素");
            System.out.println("list: 显示哈希表中的元素");
            System.out.println("exit: 表示退出程序");
            System.out.println("find: 根据id查找员工");
            Scanner in = new Scanner(System.in);
            String input = in.next();
            switch (input) {
                case "add":
                    int id = in.nextInt();
                    String name = in.next();
                    hashTab.add(new Employee(name, id));
                    break;
                case "list":
                    hashTab.show();
                    break;
                case "find":
                    int findId=in.nextInt();
                    hashTab.findEmpById(findId);
                    break;
                case "exit":
                    return;
            }
        }
    }

    static class HashTab {
        private EmployeeLinkedList[] hashTab;
        private int size;

        public HashTab(int size) {
            hashTab = new EmployeeLinkedList[size];
            for (int i = 0; i < size; i++) {
                hashTab[i] = new EmployeeLinkedList();
            }
            this.size = size;
        }

        public void add(Employee employee) {
            hashTab[HashFun(employee.id)].add(employee);
        }

        public void show() {
            for (int i = 0; i < size; i++) {
                hashTab[i].showList(i);
            }
        }

        public int HashFun(int id) {
            return id % size;
        }

        public void findEmpById(int id){
            int LinkedListNum=id%size; //算出该id在哪条链表上
            Employee emp = hashTab[LinkedListNum].findEmpById(id);
            if(emp==null){
                System.out.println("未找到该员工");
                return;
            }
            System.out.println("该员工在第"+LinkedListNum+"上，员工id"+id);
        }
    }

    static class Employee {
        public String name;
        public int id;
        public Employee next;

        public Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    static class EmployeeLinkedList {
        public Employee head;
        public void add(Employee employee) {
            if (head == null) {
                head = employee;
            } else {
                Employee temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = employee;
            }
        }

        public void showList(int num) {
            Employee temp = head;
            if (temp == null) {
                System.out.println("第" + num + "条链表为空");
                return;
            }
            System.out.print("第" + num + "条链表为: ");
            while (temp != null) {
                System.out.print("id " + temp.id + " name:" + temp.name + "=> ");
                temp = temp.next;
            }
            System.out.println();
        }
        //根据id查找员工
        public Employee findEmpById(int id) {
            Employee temp = head;
            if (temp == null) {
                System.out.println("链表为空，没有该员工");
                return null;
            }
            while(temp!=null){
                if(temp.id==id){
                    return temp;
                }
                temp=temp.next;
            }
            return null;
        }
    }
}
