#include<stdio.h>
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

