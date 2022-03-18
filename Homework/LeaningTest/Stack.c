#define MAXSIZE 30
#define OK 1
#define ERROR 0;
typedef int SElemType;
typedef int Status;
typedef struct
{   
    SElemType data[MAXSIZE];
    int top
    /* data */
}SqStack;

Status Push(SqStack *S,SElemType e){
    if(S->top==MAXSIZE-1){
        return ERROR;
    }
    S->top++;
    S->data[S->top]=e;
    return OK;

}


Status Pop(SqStack *S,SElemType *e){
    if(S->top==-1){
        return ERROR;
    }
    *e=S->data[S->top];
    S->top--;
    return OK;
}



