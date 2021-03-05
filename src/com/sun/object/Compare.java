package com.sun.object;

public class Compare {
    /**
     * 比较两个对象的大小
     */
    private String firstName;
    private String lastName;
    public Compare(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public static boolean test(Compare a,Compare b){
        if (b.firstName.compareTo(a.firstName)>0) {
            return true;
        }else if (b.firstName.compareTo(a.firstName)==0&&a.lastName.compareTo(b.lastName)>=0){
            return  true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        Compare a=new Compare("sun","b");
        Compare b=new Compare("sun","bb");
        System.out.println(test(a,b));
    }

}
