#include "stdio.h"
#include <stdlib.h>
struct Node
{
    int data;
    struct Node * next;
};
int main()
{
    int N,c,d,M,i=0,k=0,j;
    char type;
    struct Node * head,*newnode,*L,*L1,*L3;
    scanf("%d",&N);//数据数量
    j=N;//记录n个数
    head=(struct Node *)malloc(sizeof(struct Node));
    head->next=NULL;//第一个结点为空
    
    scanf("%d",&M);//m个操作
    while(M>0)
    {
        getchar();

        scanf("%c",&type);//操作指示符
        if(type=='I'||type=='C')//插入操作
        {
            if(type=='I'){
                scanf("%d",&d);
                newnode=(struct Node *)malloc(sizeof(struct Node));//新节点
                newnode->data=d;//赋值
                L=head->next;//指向第一个结点
                if(L==NULL){//插入第一个结点
                    k++;
                    newnode->next=head->next;
                    head->next=newnode;
                    L=newnode;
                }
                else {
                    while(L->next!=NULL)//从第一个结点遍历链表
                    {
                        
                        L=L->next;
                    }
                    k++;//结点数++
                    L->next=newnode;//新节点指向该结点的后继结点
                    newnode->next=NULL;
                    newnode->data=d;//赋值
                    L=newnode;
                }
            }
           
            if(type=='C'){
                L=head->next;
                scanf("%d %d",&d,&c);
                newnode=(struct Node *)malloc(sizeof(struct Node));//新节点
                newnode->data=d;//赋值
                if(c==1){
                    newnode->next=head->next;
                    head->next=newnode;
                    L=newnode;
                    k++;
                }

                else if(c>0&&c<=j+k)//j+K=老结点+新建结点数
                {
                    
                    while(L!=NULL)//从第一个结点遍历链表
                    {
                        
                        i++;//记录到第几个了
                        if(i==c-1)//找到了
                            break;
                        
                        L=L->next;
                    }
                    newnode->next=L->next;//新节点指向该结点的后继结点
                    newnode->data=d;//赋值
                    L->next=newnode;
                    L=newnode;//新节点变为新的后继节点
                        k++;//长度加一
                        i=0;//归零，下次重新查找
                }
            }
        }
        if(type=='L')//删除
        {
            scanf("%d",&d);
            L=head; 
            L1=L->next; 
           while(L1!=NULL){
               if(L1->data==d){
                   L->next=L1->next;
                   free(L1);
                   break;
               }
                L=L1;
                L1=L1->next;
              
           }
        }
        M--;
    }
    L3=head->next;
    while(L3!=NULL)
    {
        printf("%d ",L3->data);
        L3=L3->next;
    }
    return 0;
}