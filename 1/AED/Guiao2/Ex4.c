#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void PrintArray(char s[], int a[], size_t n){
    printf("%s", s);
    for (size_t i = 0; i < n; i++){
        printf("%d ", a[i]);
    }
    printf("\n");
}

void CumulativeSum(int a[], int b[], size_t n){
    b[0] = a[0];
    for (size_t i = 1; i < n; i++){
        b[i] = b[i-1] + a[i];
    }
}

int main(void) {
    int a[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int b[10];
    size_t n = sizeof(a)/sizeof(a[0]);
    PrintArray("a: ", a, n);
    CumulativeSum(a, b, n);
    PrintArray("b: ", b, n);
    return 0;
}

