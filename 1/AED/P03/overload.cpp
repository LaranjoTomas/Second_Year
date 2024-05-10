//
// Tomás Oliveira e Silva, AED, October 2021
//
// example of function overloading (same function name, different argument numbers and/or data types)
//

#include <iostream>

using std::cout; // make this symbol from the std namespace directly visible

void show(const int i)
{
  cout << "int: "
       << i
       << std::endl;
}

void show(const double d)
{
  cout << "double: "
       << d
       << std::endl;
}

void show(const char *s,const char *h = "string: ") // second argument with default value
{
  cout << h
       << s
       << std::endl;
}

void show (const char a)
{
  cout << "char: "
       << a
       << std::endl;
}

void show (const int a[], const int n){
  cout << "array: ";
  for (int i = 0; i < n; i++){
    cout << a[i] << " ";
  }
  cout << std::endl;
}



int main(void)
{
  show(1.0);
  show("hello");
  show(-3);
  show("John","name: ");
  show('a');
  int a[] = {1,2,3,4,5};
  show(a, 5);
  return 0;
}
