#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>
#include <assert.h>



void Display(int *a, size_t size) {
    assert( a != NULL && size > 0);

    printf("Array =[ ");
    for (size_t n = 0; n < (size -1); n++) {
        printf("%d, ", a[n]);
    }
    printf("%d ]\n", a[size -1]);
}


int* Read(size_t* size) {
   assert(size != NULL);

    size_t n;
    printf("Array size (> 0): ");
    scanf("%zu", &n);
    assert(n > 0);
    
    int* array = malloc(n * sizeof(int));
    if (array == NULL) {
        *size = 0;
        return NULL;
    }

    *size = n;
    return array;
}



int* Append(int* array1, size_t size1, int* array2, size_t size2) {
    assert(array1 != NULL && array2 != NULL);
    assert(size1 > 0 && size2 > 0);

    size_t n = size1+ size2;

    int* result = (int*) malloc(n * sizeof(int));
    assert(result != NULL);

    for (size_t i= 0; i < size1; i++) {
        result[i] = array1[i];
    }

    for (size_t i = 0; i < size2; i++) {
        result[size1 + i] = array2[i];
    }

    return result;
}


int main(void) {
    int a[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    //int b[] = { 1, 2, 3, 4, 5, 6, 7, 9, 8, 10, 11, 12 };
    int c[] = {1};
    Display(Append(a, 12, c, 1), 13);
    free(Append(a, 12, c, 1));
    return 0;
}