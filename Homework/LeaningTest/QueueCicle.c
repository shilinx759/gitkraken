#include<stdio.h>
#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "windows.h"
#define MAXSIZE 20
#define OK 1
#define ERROR 0
typedef int QElemType;
typedef int Status;

typedef struct
{
    int data[MAXSIZE];
    int front;
    int rear;
}SqQueue;

Status InitQueue(SqQueue *Q){
    Q->front=Q->rear;
    return OK;
}

int  QueLenth(SqQueue Q){
    return (Q.rear-Q.front+MAXSIZE)%MAXSIZE; 
}

Status InQueue(SqQueue *Q,QElemType e){
    if((Q->rear+1)%MAXSIZE==Q->front){
        return ERROR;
    }
    Q->rear=e;
    Q->rear=(Q->rear+1)%MAXSIZE;//if reach last area,return to fist
    return OK;
}

Status OutQueue(SqQueue *Q,QElemType *e){
    if(Q->front==Q->rear){
        return ERROR;
    }
    *e=Q->front;
    Q->front=(Q->front+1)%MAXSIZE;
    return OK;
}

typedef struct QNode{
    QElemType data;
    struct QNode *next;
}QNode,*QNodePtr;

typedef struct {
    QNodePtr front,rear;
}LinkQueue;

Status EnQueue(LinkQueue *lq,QElemType e){
    QNodePtr s=(QNodePtr)malloc(sizeof(QNode));
    if(!s){
        return ERROR;
    }
    // s=lq->rear;
    // s->data=e;
    // s->next=NULL;
    // lq->rear=s;
    // return OK;
    s->data=e;
    s->next=NULL;
    lq->rear->next=s;
    lq->rear=s;

    return OK;
}

Status DeleQueue(LinkQueue *lq,QElemType *e){
    if(lq->front==lq->rear){
        return ERROR;
    }
    QNodePtr p;
    p=lq->front->next;
    *e=p->data;
    lq->front->next=p->next;
    if(lq->rear==p){
        lq->rear=lq->front;//删除的是尾部，则尾指针指向头节点
    }
    free(p);
    return OK;
}