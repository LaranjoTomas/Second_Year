#include <stdio.h>

int F_vi(int n) {
    return (n < 2 ) ? n : F_vi(n - 1) + F_vi(n - 2);
}

int main(void) {
    int n;
    scanf("%d", &n);
    for (int i = 0; i <= n; i++){
        printf("%d ", F_vi(i));
    }
    printf("\n");
    return 0;
}