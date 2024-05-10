float xtoy(float x, int y)
{
 int i;
 float result;
 for(i=0, result=1.0; i < abs(y); i++)
 {
 if(y > 0)
 result *= x;
 else
 result /= x;
 }
 return result;
}
int abs(int val)
{
 if(val < 0)
 val = -val;
 return val;
} 

int main(void) {
    float x;
    int y;
    print_string("Introduza a base (float): ");
    x = read_float();
    print_string("Introduza o expoente (int): ");
    y = read_int();
    print_string("\nResultado: ");
    print_float(xtoy(x, y));
    return 0;
}

