/*
顺序表 删除重复
编写算法，在一非递减的顺序表L中，删除所有值相等的多余元素。要求时间复杂度为O(n)，空间复杂度为O(1)。
*/
 
 
#include <stdio.h>
#include <stdlib.h>

 
#define ElemType int
#define MAXSIZE 20
 
struct Seqlist {
    ElemType elem[MAXSIZE];
    int last;
};
typedef struct Seqlist SeqList;
 
void delDupNum(SeqList* L){
    int min = L->elem[0];
    int tmp = L->elem[0];
    for (int i = 1; i <= L->last; i++)
    {
        if (L->elem[i] == tmp) {
            L->elem[i] = min;
        }
        else {
            tmp = L->elem[i];
        }
    }
    int p=1, q=1;
    while (q <= L->last)
    {
        if (L->elem[q] != min)
        {
            L->elem[p] = L->elem[q];
            p++;
        }
        q++;
    }
    L->last = p-1;
}
 
 
void print(const SeqList* L)
{
    int i = 0;
    for (i = 0; i <= L->last; i++)
    {
        printf("%d ", L->elem[i]);
    }
}
 
 
int main()
{
    SeqList L = { {1, 2, 3, 7, 7, 8, 8, 9, 9, 10, 10, 10, 10, 10, 10, 11},15 };//测试用例
    delDupNum(&L);
    print(&L);//打印看是否删除成功
    return 0;
}