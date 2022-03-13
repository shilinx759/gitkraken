#include<stdio.h>
#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "windows.h"
#define MAXSIZE 20
#define OK 1
#define ERROR 0
typedef int Status;//函数类型，其值是函数的状态代码 OK，ERROR
typedef int ElemType;
typedef struct DulNode
{
    ElemType data;
    struct DulNode *prior;
    struct DulNode *next;
}DulNode,*DulLinkList;

//GetElem,ListLEnth,LocateElem 与单链表一样，只需要一个方向的指针就可以
//在插入和删除时，就要改两个指针


//插入操作：
// s->prior=p;
// s->next=p->next;
// p->next->prior=s;
// p->next=s;

//删除操作;
//p->prior->next=p->next;
//p->next->prior=p->prior;
//free(p);