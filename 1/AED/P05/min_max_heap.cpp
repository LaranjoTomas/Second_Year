//
// Tomás Laranjo, AED, November 2022
//


#ifndef _AED_min_max_
#define _AED_min_max_


#include <cassert>

template <typename T>
class aMinHeap 
{   
    private:
        int _max_size;
        int _cur_size;
        T *_heap;
    public:
        aMinHeap(int n = 1000)
        {
            assert(n >= 10 && n <= 1000000);
            _max_size = n;
            _cur_size = 0;
            _heap = new T[n];
        }
        ~aMinHeap(void) 
        { 
            delete[] _heap;
            _max_size = 0;
            _cur_size = 0;
            _heap = nullptr;
        }
        int size(void) const 
        { 
            return _cur_size; 
        }
        int max_size(void) const 
        { 
            return _max_size; 
        }
        T peek (int pos = 1) const 
        { 
            assert(pos >= 1 && pos <= _cur_size);
            return _heap[pos - 1]; 
        }
        void enqueue (T v)
        { 
            assert(_cur_size < _max_size - 1);
            int i = ++_cur_size;
            while (i > 1 && v < _heap[i/2]) 
            {
                _heap[i] = _heap[i/2];
                i /= 2;
            }
            _heap[i] = v;
        }
        void remove (int pos) 
        {
            assert(pos >= 1 && pos <= _cur_size);
            int i = pos;
            while (2 * i <= _cur_size) 
            {
                if (2 * i + 1  <= _cur_size && _heap[2 * i + 1] < _heap[2 * i + 1]) ? 2 * i + 1 : 2 * i; 
                    _heap[i] = _heap[];
                    i = j;
            }
            if (i < _cur_size) 
            {
                while (i > 1 && _heap[i/2] > _heap[_cur_size]) 
                {
                    _heap[i] = _heap[i/2];
                    i /= 2;
                }
                _heap[i] = _heap[_cur_size];
            }
            _cur_size--;
        }
        T dequeue (void)
        {
            assert(_cur_size > 0);
            T v = _heap[1];
            remove(1);
            return v;
        }
        void test_invariants(void) 
        {
            for (int i = 2; i <= _cur_size; i++) 
            {
                assert(_heap[i/2] <= _heap[i]);
            }   
            
        }
};

#endif