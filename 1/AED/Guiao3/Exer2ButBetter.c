#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

void Display(int *a, size_t size) {
    assert( a != NULL && size > 0);

    printf("Array = [ ");
    for (size_t i = 0; i < (size - 1); i++) {
        printf("%d, ", a[i]);
    }
    printf("%d ]\n", a[size -1]);
}

void readArray(int *a, size_t size) {
    assert( a != NULL && size > 0);

    for (size_t i = 0; i < size; i++) {
        printf("Enter a[%lld]: ", i);
        scanf("%d", &a[i]);
    }
}

int main(int argc, char const *argv[])
{
    int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Display(a, 10);
    readArray(a, 10);
    Display(a, 10);
    return 0;
}