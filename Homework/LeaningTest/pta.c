#include<stdio.h>
#include "stdio.h"
#include "stdlib.h"
#include "string.h"

typedef int ElemType;
typedef struct Node{
    ElemType data;
    struct Node *next;
}Node;
typedef struct Node *LinkList;

void creatList(LinkList *l,int n){
    LinkList p,r;
    int i;
    *l=(LinkList)malloc(sizeof(Node));
    r=*l;
    for(i=0;i<n;i++){
        p=(LinkList)malloc(sizeof(Node));
        p->data=i+1;
        r->next=p;
        r=p;
    }
    r->next=NULL;    
}

int  GetElem(LinkList L,int i,ElemType *e)
{
	int j;
	LinkList p;		/* 声明一结点p */
	p = L->next;		/* 让p指向链表L的第一个结点 */
	j = 1;		/*  j为计数器 */
	while (p && j<i)  /* p不为空或者计数器j还没有等于i时，循环继续 */
	{   
		p = p->next;  /* 让p指向下一个结点 */
		++j;
	}
	// if ( !p || j>i ) 
	// 	return ERROR;  /*  第i个元素不存在 */
	*e = p->data;   /*  取第i个元素的数据 */
	return *e;
}
int  InitList(LinkList *L) 
{ 
    *L=(LinkList)malloc(sizeof(Node)); /* 产生头结点,并使L指向此头结点 */
    if(!(*L)) /* 存储分配失败 */
             return -1;
    (*L)->next=NULL; /* 指针域为空 */

   return 0;
}
int ListLength(LinkList L)
{
    int i=0;
    LinkList p=L->next; /* p指向第一个结点 */
    while(p)                        
    {
        i++;
        p=p->next;
    }
    return i;
}

int  InsertListTail(LinkList *L,ElemType e) 
{
	LinkList p,newnode;

	                    /* 初始化随机数种子 */
	//*L = (LinkList)malloc(sizeof(Node)); /* L为整个线性表 */
    // if((*L)==NULL){
	//    return -1;           
    // }                        /* r为指向尾部的结点 */
	// for (i=0; i<n; i++) 
	// {
   
            newnode= (Node *)malloc(sizeof(Node)); /*  生成新结点 */
            if(newnode==NULL){
                return -1;
            }
            newnode->data = e; 
            p=(*L)->next;
            while(p!=NULL){
                p=p->next;
            }
           
            
            p=newnode;
            
         
                      /*  随机生成100以内的数字 */
                                  /* 将表尾终端结点的指针指向新结点 */
                                       /* 将当前的新结点定义为表尾终端结点 */
        return 0;
	                    /* 表示当前链表结束 */
}



void ListInsert(LinkList *l,ElemType e,int i){
    int j;
    LinkList p,s;
    p=*l;
    j=1;
    while(p&&j<i){
        p=p->next;
        ++j;
    }
 
    s=(LinkList)malloc(sizeof(Node));
    s->data=e;
    s->next=p;
    p=s;
}

int  deleList(LinkList *l,int i,ElemType *e){
    int j;
    LinkList p,q;
    p=*l;
    j=1;
    while(p->next &&j<i){
        p=p->next;
        ++j;
    }
    if(!(p->next)||j>i){
        return -1;
    }
    q=p->next;
    p->next=q->next;
    *e=q->data;
    free(q);
    return 0;
}

int main(){
    int N,M;
    LinkList list;
    InitList(&list);
    char type,ch;
    ElemType e;
    int nextNum;
    scanf("%d %d",&N,&M);
     int j=0;
    
    while(j<M){
        ch=getchar();
        scanf("%c",&type);
        if(type=='I'){
            scanf(" %d",&e);
           InsertListTail(&list,e);
        }
        else if(type=='T'){
             scanf(" %d %d",&e,&nextNum);
            ListInsert(&list,e,nextNum);
        }
        else if(type=='L'){
            int delnum;
            scanf(" %d",&delnum);
            deleList(&list,delnum,&e);
        }
        else{
            return 0;
        }
        j++;
    }
    LinkList p;
    p=list->next;
    while(p){
        printf("%d ",p->data);
        p=p->next;
    }
    printf("%d",ListLength(list));
    return 0;
  
   
    
}