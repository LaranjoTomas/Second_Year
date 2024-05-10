//
// Tomás Oliveira e Silva, AED, November 2021
//
// Generic queue (First In First Out) implementation based on an linked list
//

#ifndef _AED_lQueue_
#define _AED_lQueue_

#include <cassert>
#include "sList.h"

template <typename T>
class lQueue
{ 
  public:
    sList<T> l;
  private:
    
  public:
    lQueue(void)
    {
    }
    ~lQueue(void)
    {
    }
    void clear(void)
    {
    }
    int size(void) const
    {
      return l.size();
    }
    int is_full(void) const
    {
      return 0;
    }
    int is_empty(void) const
    {
      return l.size() == 0;
    }
    void enqueue(T &v)
    {
      l.insert_after(v);
    }


    T dequeue(void)
    {
      assert(l.size() > 0);
      l.move(0);
      T v = l.value();
      l.remove();
      return v;
    }
    T peek(void)
    {
      assert(l.size() > 0);
      l.move(0);
      T v = l.value();
      return v;
    }
};

#endif
