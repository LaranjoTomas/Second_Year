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

int* Append(int* array1, size_t size1, int* array2, size_t size2) {
    assert( array1 != NULL && size1 > 0);
    assert( array2 != NULL && size2 > 0);

    int* array3 = (int*) malloc((size1 + size2) * sizeof(int));
    assert( array3 != NULL);

    for (size_t i = 0; i < size1; i++) {
        array3[i] = array1[i];
    }
    for (size_t i = 0; i < size2; i++) {
        array3[size1 + i] = array2[i];
    }
    return array3;
}

int main(void)
{
    int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int b[] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    Display(Append(a, 10, b, 10), 20);
    free(Append(a, 10, b, 10));
    return 0;
}