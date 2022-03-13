#include<stdio.h>
#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "windows.h"
#define MAXSIZE 20
#define OK 1
#define ERROR 0
typedef int Status;//函数类型，其值是函数的状态代码 OK，ERROR
typedef int ElemType;//将元素的类型 定义为int 同一用ElemType表示
typedef struct Node
{
    ElemType data;
    struct Node *next;
    
}Node;
typedef struct Node *LinkList;//定义Linklist，是一个结构类型的指针
//结点a： p是指向结点a的指针，a的数据域 p->data,指针域p->next;
//下一个结点b ，数据域p->next->data,p->可以看成整体，是一个指向b结点的指针

//读取
//思路：
//声明一个指针p指向链表的第一个结点，初始化j从1开始
//当j<i时，就遍历链表，让p的指针后移，不断指向下一个结点，j累加
//若到链表末尾p为空，说明第i个结点不存在
//否则查找成功，用e返回第i个元素的数据
Status getElem(LinkList L,int i,ElemType *e){
    LinkList p;
    p=L->next;//p指向第一个结点
    int j=1;//计数器，到i时跳出循环
    while (p && j<i)
    {
        p=p->next;//不停的指向下一个结点
        ++j;
    }//到了第i个后跳出循环返回值
    if(!p||j>i){
        return ERROR;
    }

    *e=p->data;
    return OK;
    
}

//第i个数据插入结点的插入思路
//声明一指针p指向链表头节点，初始化j从1开始
//j小于i时，就遍历链表，让p的指针不断指向下一节点，j++
//若到链表尾p为空，则说明第i个结点不存在
//否则查找成功，在系统生成一个空结点s
//将数据元素e赋值给s-》data
//单链表的插入标准语句s->next=p->next;p->next=s;
//返回成功
Status ListInsert(LinkList *L,int i,ElemType e){
    int j;
    LinkList p,s;
    p=*L;//指向头结点
    j=1;
   while (p && j<i){//寻找第i个结点
       p=p->next;
       ++j;
   }
   if(!p||j>i){
       return ERROR;//第i个元素不存在
   }
   s=(LinkList)malloc(sizeof(Node));//生成新节点
   s->data=e;
   s->next=p->next;//将p的后继结点赋值给s的后继
   p->next=s;
   return OK;
}

//删除第i个数据结点的算法思路
//声明一指针p指向链表表头结点，初始化j从1开始
//当j小于i时，遍历链表 ，让p不断指向协议节点，j累加
//若链表末尾p为空，则说明第i个结点不存在
//否则查找成功，将欲删除的结点p->next赋值给q
//单链表的删除标准语句，p->next=q->next
//将q结点中的数据赋给e，作为返回
//释放q结点
//返回成功
Status deleteLinkList(LinkList *L,int i,ElemType *e){
    int j;
    LinkList p,q;
    j=1;
    while (p && j<i){
        p=p->next;
        ++j;
    }
    if(!(p->next)||j>i){
        return ERROR;
    }
    q=p->next;
    
    p->next=q->next;//将q的后继值赋给p的后继值
    *e=q->data;//将q结点中的数据给e
    free(q);//系统回收此节点
    return OK;
}


//整表创建
//声明指针p和计数变量i
//初始化一空链表
//让L的头结点的指针指向NULL，
//循环：
    //生成一新结点赋值给p
    //随机生成一数字赋值给p的数据域
    //将p插入到头节点与前一新节点之间

//随机产生n个元素的值，建立代表头结点的单链表（头插法）
//新结点始终在第一
void CreatListHead(LinkList *L,int n){
    LinkList p;
    int i;
    srand(time(0));//初始化随机数种子
    *L=(LinkList)malloc(sizeof(Node));
    (*L)->next= NULL;//带头结点的链表
    for(i=0;i<n;i++){
        p=(LinkList)malloc(sizeof(Node));
        p->data=rand()%100+1;//随机生成100以内的数
        p->next=(*L)->next;
        (*L)->next=p->next;//插入到表头
    }
}

//尾插法
void CreatListTail(LinkList *L,int n){
    LinkList p,r;//r为指向尾结点的变量
    int i;
    *L=(LinkList)malloc(sizeof(Node));
    //(*L)->next=NULL;
    r=*L;//r为指向尾部的结点，此时的尾部就是头结点
    srand(time(0));
    for(i=0;i<n;i++){
        p=(LinkList)malloc(sizeof(Node));
        p->data=rand()%100+1;
        r->next=p;//将尾结点指向新结点
        r=p;//更新尾结点为当前新结点
    }
    r->next=NULL;//本链表结束
}

//整链表的删除
//申明指针p和q
//将第一个结点赋值给p
//循环：
    //将下一节点赋值给q
    //释放p
    //将q赋值给p
Status ClearList(LinkList *L){
    LinkList q,p;
    p=(*L)->next;//(*L)->next就是指向第一个结点
    while(p){
        q=p->next;
        free(p);
        p=q;
    }
    (*L)->next=NULL;
    return OK;
}

// int main(){
//     LinkList list;
//     int n=10;
//     ElemType e;
//     CreatListHead(list,n);
//     printf("ok\n");
//     for(int i=0;i<n;i++){
//         getElem(list,i,&e);
//         printf("%d ",e);
//     }
//     ClearList(list);
//     printf("clear");
// }