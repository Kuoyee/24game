package com.example.test;

import java.util.ArrayList;
import java.util.List;

public class check {
    private List<String> answerlist;
    private String s[];
    List<Integer> choose_list;

    public List<String> calculate_answer(List<Integer> list){
        answerlist=new ArrayList<String>();
        s=new String[7];
        choose_list=list;
        s[0]="(("+list.get(0).toString();
        s[2]=list.get(1).toString()+")";
        s[4]=list.get(2).toString()+")";
        s[6]=list.get(3).toString();
        dfs(0,choose_list.get(0));
        if(answerlist.isEmpty()){
            answerlist.add("no answer!!!!");
        }
        return answerlist;
    }


    public void dfs(int pos,int sum){
        if(pos>=3){
            if(sum==24){
                String temp="";
                for(int i=0;i<7;i++){
                    temp+=s[i];
                }
                answerlist.add(temp);
            }
            return;
        }
        for(int i=0;i<4;i++){
            if(i==0){
                s[pos*2+1]="+";
                dfs(pos+1,sum+choose_list.get(pos+1));
            }
            if(i==1){
                s[pos*2+1]="-";
                dfs(pos+1,sum-choose_list.get(pos+1));
            }
            if(i==2){
                s[pos*2+1]="*";
                dfs(pos+1,sum*choose_list.get(pos+1));
            }
            if(i==3) {
                if(sum%choose_list.get(pos + 1)==0){
                    s[pos * 2 + 1] = "/";
                    dfs(pos + 1, sum /choose_list.get(pos + 1));
                }
            }
        }
    }


}
