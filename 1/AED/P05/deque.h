//
// Tomás Oliveira e Silva, AED, November 2021
//
// Generic deque implementation based on a circular buffer
//

#ifndef _AED_deque_
#define _AED_deque_

#include <cassert>

template <typename T>
class deque {
  private:
    int max_size; // maximum stack size
    int cur_size; // current stack size
    T *data;      // the stack data (stored in an array)

    int head; // index of the head element
    int tail; // index of the tail element
  private:
    int increment_index(int i) { return (i + 1 < max_size) ? i + 1 : 0; }
    int decrement_index ( int i) { return (i - 1 >= 0) ? i - 1 : max_size - 1; }

  public:
    deque(int n = 100)
    {
      assert(n >= 10 && n <= 1000000);
      max_size = n;
      cur_size = 0;
      data = new T[n];
      head = 1;
      tail = 0;

    }
    ~deque(void)
    {
      delete[] data;
      max_size = 0;
      cur_size = 0;
      data = nullptr;
      head = 0;
      tail = 0;
    }
    
    void clear(void)
    {
      cur_size = 0;
      head = 1;
      tail = 0;
    }
    int size(void) const
    {
      return cur_size;

    }
    int is_full(void) const
    {
      return (cur_size == max_size) ? 1 : 0;
    }
    int is_empty(void) const
    {
      return (cur_size == 0) ? 1 : 0;
    }
    void insert_at_head(T v)
    {
      assert(cur_size < max_size);
      head = decrement_index(head);
      data[head] = v;
      cur_size++;
    }
    T remove_head(void)
    {
      assert(cur_size > 0);
      int v = head;
      head = increment_index(head);
      cur_size--;
      return data[v];
    }
    T peek_head(void)
    {
      assert(cur_size > 0);
      return data[head];
    }
    void insert_at_tail(T v)
    {
      assert(cur_size < max_size);
      tail = increment_index(tail);
      data[tail] = v;
      cur_size++;
    }
    T remove_tail(void)
    {
      assert(cur_size > 0);
      int v = tail;
      tail = decrement_index(tail);
      cur_size--;
      return data[v];
    }
    T peek_tail(void)
    {
      assert(cur_size > 0);
      return data[tail];
    }
};

#endif
