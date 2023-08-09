/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupmaker;

import java.util.ArrayList;

public class Group {
    private int groupNum;
    private ArrayList<String> members=new ArrayList<String>();
    
    public Group(int num){
        this.groupNum=num;
    }
    public void setGroupNum(int num) { this.groupNum=num; }
    public int getNum(){return groupNum;}
    public void addMember(String member){ members.add(member); }
    public ArrayList<String> getMembers(){ return members; }
}
