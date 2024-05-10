#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>
#include <assert.h>




void Display(int *a, size_t size) {
    assert( a != NULL && size > 0);

    printf("Array =[ ");
    for (size_t n = 0; n < (size -1); n++) {
        printf("%d, ", a[size -1]);
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

int main(void) {
    int a[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int *novoarray;
    size_t novosize;
    novoarray = Read(&novosize);
    Display(a, 10);
    Display(novoarray, 10);
    return 1;
}