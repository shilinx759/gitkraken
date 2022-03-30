#include <stdio.h>
#include<stdlib.h>

typedef struct Node{
    int data;
    struct Node *next;
}Node;

typedef struct Node *LinkList;

int main(){
    LinkList head,newnode,tear,find;
    int n,m,tem,begin,end,x;
    head=(LinkList)malloc(sizeof(Node));
    head->next=NULL;
    tear=head;
    scanf("%d %d",&n,&m);
    for(int i=0;i<n;i++){
        scanf("%d",&tem);
        newnode=(LinkList)malloc(sizeof(Node));
        newnode->data=tem;
        newnode->next=tear->next;
        tear->next=newnode;
        tear=newnode;
    }
    while(m){
        scanf("%d %d %d",&begin,&end,&x);
        find=head;
        int i=0;
        while(i<begin){
            find=find->next;
            i++;
        }//find begin
        while(i<=end){
            find->data+=x;
            find=find->next;
            i++;
        }
        m--;
    }

    find=head->next;
    int j=0;
    while(find!=NULL){
        if(j==0){
            printf("%d",find->data);
        }
        else{
            printf(" %d",find->data);
        }
        find=find->next;
        j++;
    }

    return 0;
}