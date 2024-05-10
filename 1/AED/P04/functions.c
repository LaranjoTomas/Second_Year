//
// Tomás Oliveira e Silva, AED, October 2021
//
// the functions for the first exercise of class P.04
// (for a given positive value of n, find a formula for the return value of each function)
//

#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>

int f1(int n)
{
  int i,r=0;

  for(i = 1;i <= n;i++)
    r += 1;
  return r;
}

int f2(int n)
{
  int i,j,r=0;

  for(i = 1;i <= n;i++)
    for(j = 1;j <= i;j++)
      r += 1;
  return r;
}

int f3(int n)
{
  int i,j,r=0;

  for(i = 1;i <= n;i++)
    for(j = 1;j <= n;j++)
      r += 1;
  return r;
}

int f4(int n)
{
  int i,r=0;

  for(i = 1;i <= n;i++)
    r += i;
  return r;
}

int f5(int n)
{
  int i,j,r=0;

  for(i = 1;i <= n;i++)
    for(j = i;j <= n;j++)
      r += 1;
  return r;
}

int f6(int n)
{
  int i,j,r=0;

  for(i = 1;i <= n;i++)
    for(j = 1;j <= i;j++)
      r += j;
  return r;
}

void do_it(int n)
{

  std::cout << " n f1(n) f2(n) f3(n) f4(n) f5(n) f6(n)\n"
            << "---------------------------------------- \n";
  for(int i = 1;i <= n;i++)
  {
    std::cout << std::setw(2) << i
              << " "
              << std::setw(4) << f1(i) 
              << " "
              << std::setw(4) << f2(i)
              << " "
              << std::setw(4) << f3(i)
              << " "
              << std::setw(4) << f4(i)
              << std::endl;
  }
}
int main(void)
{
  do_it(int 10);
}
