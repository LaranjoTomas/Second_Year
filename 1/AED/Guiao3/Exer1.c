#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>


void f1(int i, int j) {
    i = 1;
    j = 10;
}

void f2(int *a, int *b, int *c)
{
  *a = 100;
  *b = 1000;
  *c = 10000;
}

void swap1(int a, int b, int c) {
    int temp;
    temp = a;
    a = b;
    b = c;
    c = temp;
}

void swap2(int *a, int *b, int *c) {
    int temp = *a;
    *a = *b;
    *b = *c;
    *c = temp;
}

int main(void) {
    int x = 0;
    int y = -1;
    int z = 1;
    printf("%d %d %d \n", x, y, z);
    f2(&x, &y, &z);
    printf("%d %d %d \n", x, y, z);
    swap1(x, y, z);
    printf("%d %d %d \n", x, y, z);
    swap2(&x, &y, &z);
    printf("%d %d %d \n", x, y, z);
}