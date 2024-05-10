#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>

int main(void)
{
  int i = 1;
  int j = -1;
  long int k = -2147483648;
  long int l;
  printf("original i = %u\n",i);
  printf("original j = %d\n",j);
  printf("original k = %ld\n",k);
  // compare i with j
  if(i > j)
    printf("i > j is true\n");
  else
    printf("i > j is false\n");
  // replace k by its absolute value and print the result
  if(k < 0)
    l = -k;
  printf("absolute value of k = %ld\n", l);
  return 0;
}
