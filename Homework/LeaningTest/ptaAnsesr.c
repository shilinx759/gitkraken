#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include <stdlib.h>
struct Node
{
    int data;
    struct Node* next;
};
int main()
{
    int N, c, d, M, i = 0, k = 0, j;
    char type;
    struct Node* head, * newnode, * L, * L1, * L3;
    scanf("%d", &N);//数据数量
    j = N;//记录n个数
    head = (struct Node*)malloc(sizeof(struct Node));
    head->next = NULL;//第一个结点为空
 
    scanf("%d", &M);//m个操作
    while (M > 0)
    {
        getchar();
 
        scanf("%c", &type);//操作指示符
        if (type == 'I') //插入队尾
        {
            scanf("%d", &d);
            newnode = (struct Node*)malloc(sizeof(struct Node));//新节点
            newnode->data = d;//赋值
            L = head;//指向第一个结点
            //找到最后一个节点，并把新节点插入最后一个节点后面
            while (L->next)
                L = L->next;
            L->next = newnode;
            newnode->next = NULL;
 
        }
        else if (type == 'C') //插入编号为c的前面
        {
            L = head;
            scanf("%d %d", &d, &c);
            newnode = (struct Node*)malloc(sizeof(struct Node));//新节点
            newnode->data = d;//赋值
            newnode->next = NULL;
            //查找编号为c的节点的前一个节点
            while (L->next->data != c)
                L = L->next;
            if (L)
            {
                newnode->next = L->next;
                L->next = newnode;
            }
        }
        else if (type == 'L')//删除
        {
            scanf("%d", &d);
            L = head;
            L1 = L->next;
            while (L1 != NULL) {
                if (L1->data == d) {
                    L->next = L1->next;
                    free(L1);
                    break;
                }
                L = L1;
                L1 = L1->next;
 
            }
        }
        M--;
    }
    L3 = head->next;
    while (L3 != NULL)
    {
        printf("%d ", L3->data);
        L3 = L3->next;
    }
    return 0;
}
 
// 4 4
// I 1
// I 2
// C 3 2
// C 4 1
// 在清华举办美食节的某一天的早上10点钟，
// 有N个人试图去生煎包处排队，10点前发生了M个事件，事件大概分为以下4种

// 有人从队尾进入队伍
// 有人插队
// 有人等不及了从队伍中离开
// 要求10点钟时整个队伍的情况

// 输入格式:
// 输入第一行有两个用空格隔开的数N，M
// 接下来有M行，按时间先后顺序每行表述一个事件
// I x：表示编号为x的人从队尾进入队伍
// C x y:表示编号为x的人插队，排在y前一位
// L x：表示编号为x的人从队伍中离开（这个人有可能还会回来）
// 我们保证同一时刻队伍里不会出现两个编号相同的人，
// 也不会让没有进入队伍的人离开队伍且数据合法。
// 输出格式:
// 输出1行，表示队首到队尾所有人的编号，用空格隔开；
// 如果队伍没有人输出“Bai Ren Zhan”（不含引号