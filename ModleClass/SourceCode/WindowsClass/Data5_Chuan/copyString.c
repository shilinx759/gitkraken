#include "string.h"
#include "stdio.h"    
#include "stdlib.h"   
#include "math.h"  
#include "time.h"
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAXLENTH 40
typedef int Status;
typedef int ELemType;

typedef char String[MAXLENTH+1];

Status StrAssign(String T,char* chars){
    if(strlen(chars)>MAXLENTH){
        return ERROR;
    }
    else{
        T[0]=strlen(chars);
        for(int i=1;i<=strlen(chars);i++){
            T[i]=*(chars+i-1);//地址变化
        }
        return OK;
    }
}

Status StrCopy(String S,String T){
    for(int i=1;i<=S[0];i++){
        T[i]=S[i];
    }
    return OK;
}

Status StrIsEmpty(String S){
    if(S[0]==0){
        return TRUE;
    }
    else{
        return FALSE;
    }
}

Status StrComp(String s,String t){
    int i;
    for(i=1;i<=s[0]&&i<=t[0];i++){
        if(s[i]!=t[i]){
            return s[i]-t[i]; //当前字符的大小就决定了串的大小
        }
    }
    return s[0]-t[0];//
}

Status Comnect(String t,String s1,String s2){
    int i;
    if(s1[0]+s2[0]<=MAXLENTH){
        for(i=1;i<=s1[0];i++){
            t[i]=s1[i];
        }
        for(i=1;i<=s2[0];i++){
            t[s1[0]+i]=s2[i];
        }
        t[0]=s1[0]+s2[0];
        return TRUE;
    }
    else{
        for(i=1;i<=s1[0];i++){
            t[i]=s1[i];
        }
        for(i=1;i<=MAXLENTH-s1[0];i++){
            t[i+s1[0]]=s2[i];
        }
        return FALSE;
    }
}

//sub返回s中索引为pos开始的往后len个数 
Status SubString(String s,String sub,int pos,int len){
    if(pos<1||pos>s[0]||len>s[0]-pos+1||len<0){
        return ERROR;
    }
    for(int i=pos;i<=len;i++){
        sub[i]=s[pos+i-1];
    }
    sub[0]=len;
    return OK;
}
int Index(String s,String t,int pos){
    int i=pos;
    int j=1;
    while(i<=s[0]&&j<=t[0]){
        if(s[i]==t[i]){
            i++;
            j++;
        }
        else{
            i=i-j+2;
            j=1;
        }
    }
    if(j>t[0]){
        return i-t[0];
    }
    return 0;
}

int Index2(String s,String t,int pos){
    int slen=strlen(s);
    int tlen=strlen(t);
    while(pos<=slen-tlen+1){//范围要小于等于tlen的长度
        String sub=SubString(s,sub,pos,slen-tlen);
        if(StrComp(sub,t)!=0){
            pos++;
        }
        else{
            return pos;
        }
    }
    return 0;//无子串相等
}

