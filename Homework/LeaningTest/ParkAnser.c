#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
struct stackstruct                     /*栈的结构体*/
{
	int id;//记录车牌
	int time;//记录进入时间
	struct stackstruct *pre;
	struct stackstruct *next;
};

struct queuestruct                    /*队列的结构体*/
{
	int id;
	struct queuestruct *next;
};

struct stackstruct *stackhead1, *stackend1;
struct stackstruct *stackhead2, *stackend2;
struct queuestruct *queuehead, *queueend;
int stack1count, stack2count;                         /*栈中元素总数*/
int queuecount;                         /*队列中元素总数*/

void push(int flag, struct stackstruct *p)
{
	struct stackstruct *stack;      //临时结点
	if (flag == 0)                  /*栈1进栈操作*/
	{
		if (stack1count == 0)
		{//是第一个结点
			stackhead1 = (struct stackstruct *)malloc(sizeof(struct stackstruct));//开辟新空间
			stackhead1->id = p->id;
			stackhead1->time = p->time;
			stackhead1->next = NULL;
			stackhead1->pre = NULL;
			stackend1 = stackhead1;
		}
		else
		{
			stack = (struct stackstruct *)malloc(sizeof(struct stackstruct));
			stack->id = p->id;
			stack->time = p->time;
			stackend1->next = stack;
			stack->pre = stackend1;
			stack->next = NULL;
			stackend1 = stack;
		}
		stack1count++;//记录停车场里车位数
	}
	else if (flag == 1)               /*临时储存的栈2进栈操作*/
	{
		if (stack2count == 0)
		{
			stackhead2 = (struct stackstruct *)malloc(sizeof(struct stackstruct));
			stackhead2->id = p->id;
			stackhead2->time = p->time;
			stackhead2->next = NULL;
			stackhead2->pre = NULL;
			stackend2 = stackhead2;
		}
		else
		{
			stack = (struct stackstruct *)malloc(sizeof(struct stackstruct));
			stack->id = p->id;
			stack->time = p->time;
			stackend2->next = stack;
			stack->pre = stackend2;
			stack->next = NULL;
			stackend2 = stack;
		}
		stack2count++;
	}
}
/*
弹出一个元素，找和离开车牌相同的车，找到则输出费用，返回空，否则返回弹出的元素
*/
struct stackstruct *pop(int id, int time,int money)
{
	struct stackstruct *stack;
	stack = (struct stackstruct *)malloc(sizeof(struct stackstruct));

	if (stackend1->id != id)
	{//该元素与离开车辆不同，则单纯弹出元素
		stack->id = stackend1->id;
		stack->time = stackend1->time;
		stack->pre = stackend1->pre;
		free(stackend1);
		stackend1 = stack->pre;
		stackend1->next = NULL;
		stack1count--;
	}
	else
	{//找到离开车辆所在元素，输出车辆、费用信息
		stack->id = stackend1->id;
		stack->time = stackend1->time;
		stack->pre = stackend1->pre;
		printf("%d号汽车出停车场\n", id);
		printf("停车场停留时间: %d\n", time - stack->time);
		if((time - stack->time) > 0) printf("应该缴纳的费用(单价: %d): %d\n",money, money * (time - stack->time));
		else printf("应该缴纳的费用(单价: %d): 0\n",money);
		free(stackend1);
		if (--stack1count == 0)
			stackend1 = stackhead1 = NULL;
		else
		{
			stackend1 = stack->pre;
			stackend1->next = NULL;
		}
		stack = NULL;
	}
	return stack;
}
/*
弹出临时栈的一个元素并返回
*/
struct stackstruct *pop1()
{
	struct stackstruct *stack;
	stack = (struct stackstruct *)malloc(sizeof(struct stackstruct));

	stack->id = stackend2->id;
	stack->time = stackend2->time;
	stack->pre = stackend2->pre;
	free(stackend2);
	stackend2 = stack->pre;
	stack2count--;

	return stack;
}
/*
停车场满，入队列操作
*/
void Enqueue(struct stackstruct *p)
{
	struct queuestruct *queue;//临时结点
	if (queuecount == 0)
	{
		queuehead = (struct queuestruct *)malloc(sizeof(struct queuestruct));
		queuehead->id = p->id;
		queuehead->next = NULL;
		queueend = queuehead;
	}
	else
	{
		queue = (struct queuestruct *)malloc(sizeof(struct queuestruct));
		queue->id = p->id;
		queue->next = NULL;
		queueend->next = queue;
		queueend = queue;
	}
	queuecount++;
}
//出队列操作，返回弹出的元素
struct stackstruct *Dequeue(int time)
{
	struct stackstruct *stack;
	stack = (struct stackstruct *)malloc(sizeof(struct stackstruct));

	stack->id = queuehead->id;
	stack->time = time;
	if (--queuecount == 0)
	{
		queuehead = NULL;
		queueend = NULL;
	}
	else
		queuehead = queuehead->next;
	return stack;
}
int main()
{
	int n;//储存停车场车位
	char s;//储存进入/驶出信息
	struct stackstruct *p;//储存汽车信息
	int money;//储存单价
        printf("《停车场管理》\n");
	printf("输入停车场可停放汽车数量: ");
	scanf("%d", &n);
	getchar();
	printf("请输入停车费用单价：\n");
	scanf("%d",&money);
	getchar();
	printf("请输入车辆信息，格式：A/D,车牌，到达时刻，其中A为到达，D为离开，输入E,0,0结束\n");
	stack1count = stack2count = queuecount = 0;
	p = (struct stackstruct *)malloc(sizeof(struct stackstruct));

	while (scanf("%c,%d,%d", &s, &p->id, &p->time) != EOF)
	{
		getchar();
		if (s == 'E')
			break;
		else if (s == 'A')                /*汽车到达*/
		{
			if (stack1count < n)                 /*栈未满，进栈操作*/
			{
				push(0, p);
				printf("%d号汽车进入停车场\n", stackend1->id);
				printf("进入停车场时间: %d\n", stackend1->time);
				printf("停车位置: %d\n", stack1count);
			}
			else                                /*栈满，进队列操作*/
			{
				Enqueue(p);
				printf("%d号汽车进入便道\n", p->id);
				printf("进入便道时间: %d\n", p->time);
				printf("便道位置: %d\n", queuecount);
			}
		}
		else if (s == 'D')                /*汽车离去*/
		{
			struct stackstruct *temp;
			while ((temp = pop(p->id, p->time,money)) != NULL)
			{
				push(1, temp);//返回的元素不为空则没找到，存入临时栈中
			}//搜索到了则退出循环
			while (stack2count != 0)
			{
				push(0, pop1());//将临时栈中的元素存回停车场栈
			}
			if (queuecount != 0)
			{//便道上有等待车辆时进入停车场并计时
				push(0, Dequeue(p->time));
				printf("%d号汽车进入停车场\n", stackend1->id);
				printf("进入时刻: %d\n", stackend1->time);
				printf("停车位置: %d\n", stack1count);
			}
		}
	}
	return 0;
}

