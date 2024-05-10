//
// Tomás Oliveira e Silva, AED, November 2021
//
// matched-parenthesis verification
//

#include <iostream>
#include "aStack.h"

using std::cout;
using std::cerr;
using std::endl;

int check_parenthesis(const char *s)
{
  aStack<int> stack;
  int i = 0;
  while(s[i] != '\0')
  {
    if(s[i] == '(' || s[i] == '[' || s[i] == '{')
      stack.push(i);
    else if(s[i] == ')' || s[i] == ']' || s[i] == '}')
    {
      if(stack.is_empty()) {
        printf("Unmatched ')' at position %d", i);
        return -1; }
      stack.pop();
    }
    else {
      if (stack.is_half_full()) {
        printf("Unmatched '(' at position %d", i);
        return -1;
      }
    }
    
    
    i++;
  }
  return stack.is_empty() == 0;
}

int main(int argc,char **argv)
{
  if(argc == 1)
  {
    cerr << "usage: " << argv[0] << " [arguments...]" << endl;
    cerr << "example: " << argv[0] << " 'abc(def)ghi' 'x)(y'" << endl;
    return 1;
  }
  for(int i = 1;i < argc;i++)
  {
    cout << argv[i] << endl;
    if(check_parenthesis(argv[i]) == 0)
      cout << "  good" << endl;
    else
      cout << "  bad" << endl;
  }
  return 0;
}
