//顺序表，
//知识点:1.传递参数给函数时，如果要改变数据本身，那么传指针；

//如果不需要改变数据本身，那么传值
#include<stdio.h>
#define MAXSIZE 20
#define OK 1
#define ERROR 0
typedef int Status;//函数类型，其值是函数的状态代码 OK，ERROR
typedef int ElemType;//将元素的类型 定义为int 同一用ElemType表示
typedef struct 
{
    ElemType date[MAXSIZE];
    int lenth;
    /* data */
}SqList;

//获取元素
//用e返回L中第i个元素的值
Status getElem(SqList L,int i,ElemType *e){
    if(L.lenth==0||i<i||i>L.lenth){
        return ERROR;
    }
    *e=L.date[i-1];//第i个，下标i-1
    return OK;
}

//插入操作
//在表中第i个位置前插入元素e，L长度加一
Status ListInsert(SqList *L,int i,ElemType e){
    int k;
    if(L->lenth==MAXSIZE){
        return ERROR;
    }
    if(i<1||i>L->lenth+1){
        return ERROR;
    }
    if(i<=L->lenth){
        for(k=L->lenth-1;k>=i-1;k++){//从倒数第二开始往前数，到i-1位置（第i个）都忘后退一铬
            L->date[k+1]=L->date[k];

        }
    }
    L->date[i-1]=e;
    L->lenth++;
    return OK;
}

//删除：位置不合理，抛异常
//取出删除元素
//从删除元素的位置往后遍历，使后面的元素都前进一铬
//表长减一
Status ListDelete(SqList *L,int i,ElemType *e){
    int k;
    if(L->lenth==0){
        return ERROR;
    }
    if(i>L->lenth||i<1){
        return ERROR;
    }
    *e=L->date[i-1];//找到第i个元素
    if(i<L->lenth){
        for(k=i;k<L->lenth;k++){
            L->date[k-1]=L->date[k];
        }
    }
    L->lenth--;
    return OK;
}





